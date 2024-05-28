/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import controllers.ClienteDAO;
import models.Cliente;

/**
 *
 * @author Rique
 */
public class ClienteInserir {
    
    public static void main(String[] args){
    
        Cliente c = new Cliente(150, "88", "douglas", "123@gmail", "12345678900");
        ClienteDAO dao = new ClienteDAO();
        //System.out.println(dao.salvar(c));
        
        System.out.println(dao.atualizar(c));
    
    }
}
