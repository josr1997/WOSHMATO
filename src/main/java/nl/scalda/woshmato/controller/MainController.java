/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.controller;

import java.util.UUID;
import static com.opensymphony.xwork2.Action.*;
import org.apache.struts.action.Action;

/**
 *
 * @author kevin
 */
public class MainController extends Action{
    
    public String execute(){
        return SUCCESS; 
    }
    
    
    //random key voor  sql
    public static void main(String args[]) {
        UUID a = UUID.randomUUID();
        System.out.println("UUID = " + a.toString());
    }
    
}
