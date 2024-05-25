/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import application.main.Main;
import java.sql.SQLException;
import models.FuncionarioModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

/**
 *
 * @author Pedro
 */
public class LoginController extends BaseController {
    
    public void logar(String cpf, String senha){
		if (bd.getConnection()) {
			String sql = "select*from FUNCIONARIO where CPF_FUNCIONARIO like ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1,"%"+cpf+"%");
				bd.rs = bd.st.executeQuery();
                                bd.rs.next();
                                String CPF_FUNCIONARIO = bd.rs.getString("CPF_FUNCIONARIO");
                                String SENHA_FUNCIONARIO= bd.rs.getString("SENHA_FUNCIONARIO");
                                
                                
//                                System.out.println(CPF_FUNCIONARIO+" "+ SENHA_FUNCIONARIO);
//                                System.out.println(user+ " "+senha);
                                
                                if((cpf == null ? CPF_FUNCIONARIO == null : cpf.equals(CPF_FUNCIONARIO)) && (senha == null ? SENHA_FUNCIONARIO == null : senha.equals(SENHA_FUNCIONARIO))){
                                    int cod = bd.rs.getInt("COD_FUNCIONARIO");
                                    String nome = bd.rs.getString("NOME_FUNCIONARIO");
                                    String email = bd.rs.getString("EMAIL_FUNCIONARIO");
                                    String telefone = bd.rs.getString("TELEFONE_FUNCIONARIO");
                                    FuncionarioModel funcionario = new FuncionarioModel(cod,nome,cpf,senha,email,telefone);
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
