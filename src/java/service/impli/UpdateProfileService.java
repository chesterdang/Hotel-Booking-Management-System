/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import java.util.Random;
import service.IUpdateProfileService;

/**
 *
 * @author HI
 */
public class UpdateProfileService implements IUpdateProfileService{
    
    @Override
    public String addRandomSuffixToFilename(String filename) {
        Random random = new Random();

        // Chuỗi chứa ký tự có thể tạo ra chuỗi ngẫu nhiên
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Tạo chuỗi ngẫu nhiên có độ dài 10 ký tự
        StringBuilder randomSuffix = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomSuffix.append(characters.charAt(randomIndex));
        }

        String newFilename = filename.substring(0, filename.lastIndexOf('.')) + "_" + randomSuffix.toString() + filename.substring(filename.lastIndexOf('.'));
        

        return newFilename;
    }

    @Override
    public boolean samePassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }
    
    public static void main(String[] args) {
        System.out.println(new UpdateProfileService().addRandomSuffixToFilename("abc.jpg"));
    }
    
}
