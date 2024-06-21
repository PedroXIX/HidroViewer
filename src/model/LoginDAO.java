/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import application.main.Main;
import java.sql.SQLException;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import services.BD;

/**
 * Classe responsável por fornecer o método relativo ao ato de logar no sistema
 * @author Pedro
 */
public class LoginDAO {
    private static String sql, men;
    private static BD bd = new BD();
    
    /**
     * Método que faz a autenticação por meio do CPF e senha
     * @param cpf - cpf do usuário
     * @param senha - senha do usuário
     */
    public static void logar(String cpf, String senha){
		if (bd.getConnection()) {
			sql = "select*from FUNCIONARIO where CPF_FUNCIONARIO like ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1,"%"+cpf+"%");
				bd.rs = bd.st.executeQuery();
                                bd.rs.next();
                                String CPF_FUNCIONARIO = bd.rs.getString("CPF_FUNCIONARIO");
                                String SENHA_FUNCIONARIO= bd.rs.getString("SENHA_FUNCIONARIO");
                                
                                if((cpf == null ? CPF_FUNCIONARIO == null : cpf.equals(CPF_FUNCIONARIO)) && (senha == null ? SENHA_FUNCIONARIO == null : senha.equals(SENHA_FUNCIONARIO))){
                                    int cod = bd.rs.getInt("COD_FUNCIONARIO");
                                    String nome = bd.rs.getString("NOME_FUNCIONARIO");
                                    String email = bd.rs.getString("EMAIL_FUNCIONARIO");
                                    String telefone = bd.rs.getString("TELEFONE_FUNCIONARIO");
                                    Funcionario funcionario = new Funcionario(cod,nome,cpf,senha,email,telefone);
                                    Main.main.setFuncionario(funcionario);
                                    Main.main.showMainForm();
                                }
                                else
                                {	                           
                                    MessageAlerts.getInstance().showMessage("Erro no login","Login ou Senha não correspondendte com a base de dados!", MessageAlerts.MessageType.ERROR, MessageAlerts.CLOSED_OPTION, new PopupCallbackAction() {
                                     @Override
                                        public  void action(PopupController pc, int i) {
                                            if (i == MessageAlerts.OK_OPTION) {
                                                System.out.println("Click ok");
                                            }
                                        }
                                    });   
                                }
			} 
			catch (SQLException e) {
                                  System.out.println(e);
			}
			finally {
				bd.close();
			}
		}
    } 
}
