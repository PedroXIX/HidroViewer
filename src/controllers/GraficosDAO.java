/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static controllers.BaseDAO.bd;
import java.sql.SQLException;
import java.util.Date;

/**
 * Classe responsável por intermediar a relação entre o banco de dados e o
 * ConsumoForm
 *
 * @author Pedro
 */
public class GraficosDAO extends BaseDAO {

    public static String sql, nomeMes, nomeAno;
    public static double consumoMes, consumoAno;
    public static int qtdMes;
    public static Date data;

    /**
     * Método que retorna a quantidade de meses de acordo com o ano atual
     *
     * @return - quantidade de meses
     */
    public static int qtdMes() {
        if (bd.getConnection()) {
            String sql = "SELECT COUNT(DISTINCT DATENAME(MM,DATA_LEITURA))  AS 'QTD_MESES' FROM LEITURA WHERE YEAR(DATA_LEITURA) = YEAR(GETDATE())";
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
}
