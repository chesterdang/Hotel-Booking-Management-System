/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.ManageFavRoomModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IManageFavRoomDAO {
    ManageFavRoomModel findBy(long id);
}
