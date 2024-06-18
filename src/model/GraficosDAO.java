/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.util.Date;
import raven.chart.data.pie.DefaultPieDataset;
import raven.chart.line.LineChart;
import services.BD;

/**
 * Classe responsável por intermediar a relação entre o banco de dados e o
 * ConsumoForm
 *
 * @author Pedro
 */
public class GraficosDAO {

    public static String sql, nomeMes, nomeAno;
    public static double consumoMes, consumoAno;
    public static int qtdMes;
    public static Date data;
    public static LineChart lineChart;
    private static BD bd = new BD();

    /**
     * Método que retorna a quantidade de meses de acordo com o ano atual
     *
     * @return - quantidade de meses
     */
    public static int qtdMes() {
        if (bd.getConnection()) {
           sql = "SELECT COUNT(DISTINCT DATENAME(MM,DATA_LEITURA))  AS 'QTD_MESES' FROM LEITURA WHERE YEAR(DATA_LEITURA) = YEAR(GETDATE())";
            try {
                bd.st = bd.con.prepareStatement(sql);
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                qtdMes = bd.rs.getInt("QTD_MESES");

                return qtdMes;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return 0;
    }
    /**
     * Método que retorna a data completa de acordo com o mês informad
     * @param mes - valor inteiro que indica o mês a ser buscado, mes = 1 
     * @return 
     */
    public static Date mesData(int mes) {
        sql = "SELECT DATA_LEITURA AS 'DATA' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE()) GROUP BY DATA_LEITURA";
        if (bd.getConnection()) {
            try {
                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + mes + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                data = bd.rs.getDate("DATA");

                return data;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }

    /**
     * Método de que devolve o nome do mês de acordo com a ordem do mês inserida
     *
     * @param mes - valor inteiro que indica o mês a ser buscado, mes = 1
     * equivale ao atual
     * @return
     */
    public static String mes(int mes) {
        sql = "SELECT DATENAME(MM,DATA_LEITURA) AS 'MES' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE()) GROUP BY DATENAME(MM,DATA_LEITURA)";
        if (bd.getConnection()) {
            try {
                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + mes + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                nomeMes = bd.rs.getString("MES");

                return nomeMes;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }

    /**
     * Método que devolve o valor do consumo de acordo com o mês
     *
     * @param mes - valor inteiro que indica o mês a ser buscado, mes = 1
     * equivale ao atual
     * @return
     */
    public static Double mesConsumo(int mes) {
        sql = "SELECT SUM(CONSUMO) AS 'CONSUMO_MES' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE())";
        if (bd.getConnection()) {
            try {

                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + mes + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                consumoMes = bd.rs.getDouble("CONSUMO_MES");

                return consumoMes;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }
    
    /**
     * Método que devolve o valor do consumo de acordo com o mês e ano
     *
     * @param mes - valor inteiro que indica o mês a ser buscado, mes = 1
     * @param ano - valor inteiro que indica o ano a ser buscado, ano = 1
     * equivale ao atual
     * @return
     */
    public static Double mesConsumo(int mes, int ano) {
        sql = "SELECT SUM(CONSUMO) AS 'CONSUMO_MES' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE())-?";
        if (bd.getConnection()) {
            try {

                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + mes + "");
                bd.st.setString(2, "" + ano + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                consumoMes = bd.rs.getDouble("CONSUMO_MES");

                return consumoMes;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }
    

    public static Double estacaoConsumo(int mes) {
        sql = "SELECT SUM(CONSUMO) AS 'CONSUMO_MES' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE())";
        if (bd.getConnection()) {
            try {
                switch (mes) {
                    case 0:
                        sql = "SELECT SUM(CONSUMO) AS 'VERAO' FROM LEITURA WHERE((MONTH(DATA_LEITURA) = 12 AND DAY(DATA_LEITURA) >= 21) OR (MONTH(DATA_LEITURA) <= 3 AND DAY(DATA_LEITURA) < 21)) AND YEAR(DATA_LEITURA) = YEAR(GETDATE()) - 1";
                        bd.st = bd.con.prepareStatement(sql);
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        consumoMes = bd.rs.getDouble("VERAO");

                        return consumoMes;
                    case 1:
                        sql = "SELECT SUM(CONSUMO) AS 'OUTONO' FROM LEITURA WHERE((MONTH(DATA_LEITURA) = 3 AND DAY(DATA_LEITURA) >= 21) OR (MONTH(DATA_LEITURA) <= 6 AND DAY(DATA_LEITURA) < 21)) AND YEAR(DATA_LEITURA) = YEAR(GETDATE()) - 1";
                        bd.st = bd.con.prepareStatement(sql);
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        consumoMes = bd.rs.getDouble("OUTONO");

                        return consumoMes;
                    case 2:
                        sql = "SELECT SUM(CONSUMO) AS 'INVERNO' FROM LEITURA WHERE((MONTH(DATA_LEITURA) = 6 AND DAY(DATA_LEITURA) >= 21) OR (MONTH(DATA_LEITURA) <= 9 AND DAY(DATA_LEITURA) < 23)) AND YEAR(DATA_LEITURA) = YEAR(GETDATE()) - 1";
                        bd.st = bd.con.prepareStatement(sql);
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        consumoMes = bd.rs.getDouble("INVERNO");

                        return consumoMes;
                    case 3:
                        sql = "SELECT SUM(CONSUMO) AS 'PRIMAVERA' FROM  LEITURA WHERE ((MONTH(DATA_LEITURA) = 9 AND DAY(DATA_LEITURA) >= 23) OR (MONTH(DATA_LEITURA) = 10) OR (MONTH(DATA_LEITURA) = 11) OR (MONTH(DATA_LEITURA) = 12 AND DAY(DATA_LEITURA) < 21) AND YEAR(DATA_LEITURA) = YEAR(GETDATE()));";
                        bd.st = bd.con.prepareStatement(sql);
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        consumoMes = bd.rs.getDouble("PRIMAVERA");

                        return consumoMes;
                    default:
                        return 0.0;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }

    /**
     * Método de que devolve o numero do ano de acordo com a ordem do ano
     * inserida
     *
     * @param ano - valor inteiro que indica o ano a ser buscado, ano = 1
     * equivale ao atual
     * @return
     */
    public static String ano(int ano) {
        sql = "SELECT YEAR(DATA_LEITURA) AS 'ANO' FROM LEITURA WHERE YEAR(DATA_LEITURA) = YEAR(GETDATE()) - ? GROUP BY YEAR(DATA_LEITURA)";
        if (bd.getConnection()) {
            try {
                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + ano + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                nomeAno = bd.rs.getString("ANO");

                return nomeAno;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }

    /**
     * Método que devolve o valor do consumo de acordo com o ano
     *
     * @param ano - valor inteiro que indica o ano a ser buscado, ano = 1
     * equivale ao atual
     * @return
     */
    public static Double anoConsumo(int ano) {
        sql = "SELECT SUM(CONSUMO) AS 'CONSUMO_ANO' FROM LEITURA WHERE YEAR(DATA_LEITURA) = YEAR(GETDATE()) - ?";
        if (bd.getConnection()) {
            try {

                bd.st = bd.con.prepareStatement(sql);
                bd.st.setString(1, "" + ano + "");
                bd.rs = bd.st.executeQuery();
                bd.rs.next();

                consumoAno = bd.rs.getDouble("CONSUMO_ANO");

                return consumoAno;
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }
    
    /**
     * Método que determina os dados do gráfico mensal
     *
     * @return - conjunto de dados que alimentarão o gráfico
     */
    public static DefaultPieDataset createDataMes() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.mes(0) + " (Atual)", GraficosDAO.mesConsumo(0));
        dataset.addValue(GraficosDAO.mes(1), GraficosDAO.mesConsumo(1));
        dataset.addValue(GraficosDAO.mes(2), GraficosDAO.mesConsumo(2));
        dataset.addValue(GraficosDAO.mes(3), GraficosDAO.mesConsumo(3));
        dataset.addValue(GraficosDAO.mes(4), GraficosDAO.mesConsumo(4));
        return dataset;
    }

    /**
     * Método que determina os dados do gráfico anual
     *
     * @return - conjunto de dados que alimentarão o gráfico
     */
    public static DefaultPieDataset createDataAno() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.ano(1), GraficosDAO.anoConsumo(1));
        dataset.addValue(GraficosDAO.ano(2), GraficosDAO.anoConsumo(2));
        dataset.addValue(GraficosDAO.ano(3), GraficosDAO.anoConsumo(3));
        dataset.addValue(GraficosDAO.ano(4), GraficosDAO.anoConsumo(4));
        dataset.addValue(GraficosDAO.ano(5), GraficosDAO.anoConsumo(5));
        return dataset;
    }

    /**
     * Método que determina os dados do gráfico sazonal
     *
     * @return - conjunto de dados que alimentarão o gráfico
     */
    public static DefaultPieDataset createPieDataEstacao() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue("Verão", GraficosDAO.estacaoConsumo(0));
        dataset.addValue("Outono", GraficosDAO.estacaoConsumo(1));
        dataset.addValue("Inverno", GraficosDAO.estacaoConsumo(2));
        dataset.addValue("Primavera", GraficosDAO.estacaoConsumo(3));
        return dataset;
    }


}