/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static controllers.BaseController.bd;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class Graficos extends BaseController {

    public static String sql = "SELECT DATENAME(MM,DATA_LEITURA) AS 'mes' FROM LEITURA WHERE MONTH(DATA_LEITURA) = MONTH(GETDATE()) - ? AND YEAR(DATA_LEITURA) = YEAR(GETDATE())";
    public static String nomeMes, men;

    public static String mes(int mes) {
        if (bd.getConnection()) {
            try {
                switch (mes) {
                    case 1 -> {
                        bd.st = bd.con.prepareStatement(sql);
                        bd.st.setString(1, "0");
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        nomeMes = bd.rs.getString("MES");

                        return nomeMes;
                    }
                    case 2 -> {
                        bd.st = bd.con.prepareStatement(sql);
                        bd.st.setString(1, "1");
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        nomeMes = bd.rs.getString("MES");

                        return nomeMes;
                    }

                    case 3 -> {
                        bd.st = bd.con.prepareStatement(sql);
                        bd.st.setString(1, "2");
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        nomeMes = bd.rs.getString("MES");

                        return nomeMes;
                    }
                    case 4 -> {
                        bd.st = bd.con.prepareStatement(sql);
                        bd.st.setString(1, "3");
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        nomeMes = bd.rs.getString("MES");
                        
                        return nomeMes;
                    }
                    case 5 -> {
                        bd.st = bd.con.prepareStatement(sql);
                        bd.st.setString(1, "4");
                        bd.rs = bd.st.executeQuery();
                        bd.rs.next();

                        nomeMes = bd.rs.getString("MES");

                        return nomeMes;
                    }
                    default -> {
                        return null;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                bd.close();
            }
        }
        return null;
    }
}
