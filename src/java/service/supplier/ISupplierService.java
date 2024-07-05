/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import model.SupplierModel;

/**
 *
 * @author MaiGiang
 */
public interface ISupplierService {
    SupplierModel getSuplierBy(long id);
    boolean updateSupplierProfile(String fullname, String dob, String email,String phone,String address,String filename, long id);
    boolean updatePassword(String password, long id);
}
