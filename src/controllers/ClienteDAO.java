/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import services.BD;
import java.sql.SQLException;
import models.Cliente;

/**
 *
 * @author Rique
 */
public class ClienteDAO {
    
    private String sql, men;
    private BD bd;
    
    public ClienteDAO(){
        bd = new BD();
    }
    
    /**
     * Realiza a gravação de um cliente no banco de dados
     * @param cliente - cliente a ser salvo
     * @return - mensagem informando o status da execução
     */
    public String salvar(Cliente cliente){
        
        sql = "insert into cliente values (?, ?, ?, ?, ?)";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,cliente.getCodCliente());
            bd.st.setString(2,cliente.getCpfCliente());
             bd.st.setString(3,cliente.getNomeCliente());
            bd.st.setString(4,cliente.getEmailCliente());
            bd.st.setString(5,cliente.getTelefoneCliente());
            bd.st.executeUpdate();
            men = "Cliente com cpf " + cliente.getCpfCliente() + " inserido com sucesso!";
        }
        catch(SQLException e){
            men = "Falha! Verifique se o cliente já está cadastrado!  Ou se os dados inseridos estão corretos " + e.toString();
        }
        finally{
            bd.close();
        }
        
        return men;
    }
    
    public String atualizar(Cliente cliente){
        
        sql = "update cliente set cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, telefone_cliente = ? where cod_cliente = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(5,cliente.getCodCliente());
            bd.st.setString(1,cliente.getCpfCliente());
            bd.st.setString(2,cliente.getEmailCliente());
            bd.st.setString(3,cliente.getNomeCliente());
            bd.st.setString(4,cliente.getTelefoneCliente());
            bd.st.executeUpdate();
            men = "Cliente com código " + cliente.getCodCliente() + " atualizado com sucesso!";
        }
        catch(SQLException e){
            men = "Falha: " + e.toString();
        }
        finally{
            bd.close();
        }
        
        return men;
    
    }
    
    /**
     * Exclui um cliente com base em seu código
     * @param codigo = coódigo do cliente a ser excluido
     * @return - mensagem com status da operação
     */
    public String excluir(int codigo){
        sql = "delete from cliente where cod_cliente = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,codigo);
            int n = bd.st.executeUpdate();
            if(n == 1){
                men = "Cliente excluído com sucesso!";
            }
            else{
                men = "Cliente não encontrado!";
            }
            
        }
        catch(SQLException e){
            men = "Falha: " + e.toString();
        }
        finally{
            bd.close();
        }
        
        return men;
    }
    
    /**
     * Localiza um cliente a partir de seu código
     * @param codigo - código do cliente a ser localizado
     * @return - o cliente pesquisado como um objeto ou null caso não encontrado
     */
    public Cliente localizar(int codigo){
        Cliente c = new Cliente();
        sql = "select * from cliente where cod_cliente = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,codigo);
            bd.rs = bd.st.executeQuery();
            
            if(bd.rs.next()){
                c.setCodCliente(bd.rs.getInt(1));
                c.setCpfCliente(bd.rs.getString(2));
                c.setNomeCliente(bd.rs.getString(3));
                c.setEmailCliente(bd.rs.getString(4));
                c.setTelefoneCliente(bd.rs.getString(5));
            }
            else{
                c = null;
            }
        }
        catch(SQLException e){
            c = null;
        }
        finally{
            bd.close();
        }
        
        return c;
    }
}
