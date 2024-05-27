/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import controllers.ClienteDAO;

/**
 *
 * @author Rique
 */
public class ClienteExcluir {
    public static void main(String[] args){
        ClienteDAO dao = new ClienteDAO();
        System.out.println(dao.excluir(150));
                
    }
}
