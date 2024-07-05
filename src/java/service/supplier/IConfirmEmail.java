/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

/**
 *
 * @author danhv
 */
public interface IConfirmEmail {
    Boolean sendMail(String email, String header, String text); 
}
