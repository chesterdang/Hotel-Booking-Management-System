/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.RoleModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IRoleDAO {
    RoleModel findBy(String code);
}
