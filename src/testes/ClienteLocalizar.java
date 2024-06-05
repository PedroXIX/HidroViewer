/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import controllers.ClienteDAO;
import controllers.Cliente;

/**
 *
 * @author Rique
 */
public class ClienteLocalizar {
    
    public static void main(String[] args){
        
        ClienteDAO dao = new ClienteDAO();
        Cliente c = dao.localizar(60);
        if(c != null){
            System.out.println(c.toString());
        }
        else{
            System.out.println("Produto não localizado!");
        }
    }
}
