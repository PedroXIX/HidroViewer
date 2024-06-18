/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import services.BD;
import java.sql.SQLException;

/**
 * Classe responsável por realizar interações com o banco de dados referente a entidade Leitura
 * @author Rique
 */
public class LeituraDAO {
    
    private String sql, men;
    private BD bd;
    
    public LeituraDAO(){
        bd = new BD();
    }
    
    /**
     * Realiza a gravação de uma Leitura no banco de dados
     * @param leitura - Leitura que será gravada no banco de dados
     * @return - Mensagem informando o status da operação
     */
    public String salvar(Leitura leitura){
        
        sql = "insert into leitura values (?, ?, ?, ?, ?, ?, ?)";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,leitura.getCodLeitura());
            bd.st.setInt(2, leitura.getCodHidrometro());
            bd.st.setDate(3, leitura.getDataLeitura());
             bd.st.setDouble(4,leitura.getLeituraAnterior());
            bd.st.setDouble(5,leitura.getLeituraAtual());
            bd.st.setDouble(6,leitura.getConsumo());
            bd.st.setDouble(7,leitura.getMediaConsumo());
            
            bd.st.executeUpdate();
            men = "Leitura  " + leitura.getCodLeitura() + " inserido com sucesso!";
        }
        catch(SQLException e){
            men = "Falha! Verifique se a leitura já está cadastrada!  Ou se os dados inseridos estão corretos " + e.toString();
        }
        finally{
            bd.close();
        }
        
        return men;
    }
    
    /**
     * Realiza o update das informações da leitura no banco de dados
     * @param leitura - Leitura que terá seus dados atualizados
     * @return 
     */
    public String atualizar(Leitura leitura){
        
        sql = "update leitura set cod_hidrometro = ?, data_leitura = ?, leitura_anterior = ?, leitura_atual = ?, consumo = ?, media_consumo = ? where cod_leitura = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(7,leitura.getCodLeitura());
            bd.st.setInt(1, leitura.getCodHidrometro());
            bd.st.setDate(2, leitura.getDataLeitura());
            bd.st.setDouble(3,leitura.getLeituraAnterior());
            bd.st.setDouble(4,leitura.getLeituraAtual());
            bd.st.setDouble(5,leitura.getConsumo());
            bd.st.setDouble(6,leitura.getMediaConsumo());
            bd.st.executeUpdate();
            men = "Leitura com código " + leitura.getCodLeitura() + " atualizada com sucesso!";
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
     * Exclui uma Leitura com base em seu código
     * @param codigo - coódigo da Leitura a ser excluido
     * @return - mensagem com status da operação
     */
    public String excluir(int codigo){
        sql = "delete from leitura where cod_leitura = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,codigo);
            int n = bd.st.executeUpdate();
            if(n == 1){
                men = "Leitura excluída com sucesso!";
            }
            else{
                men = "Leitura não encontrada!";
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
     * Localiza uma Leitura a partir de seu código
     * @param codigo - código da Leitura a ser localizado
     * @return - a Leitura pesquisado como um objeto ou null caso não encontrado
     */
    public Leitura localizar(int codigo){
        Leitura l = new Leitura();
        sql = "select * from leitura where cod_leitura = ?";
        
        try{
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1,codigo);
            bd.rs = bd.st.executeQuery();
            
            if(bd.rs.next()){
                l.setCodLeitura(bd.rs.getInt(1));
                l.setCodHidrometro(bd.rs.getInt(2));
                l.setDataLeitura(bd.rs.getDate(3));
                l.setLeituraAnterior(bd.rs.getDouble(4));
                l.setLeituraAtual(bd.rs.getDouble(5));
                l.setConsumo(bd.rs.getDouble(6));
                l.setMediaConsumo(bd.rs.getDouble(7));
            }
            else{
                l = null;
            }
        }
        catch(SQLException e){
            l = null;
        }
        finally{
            bd.close();
        }
        
        return l;
    }
}
