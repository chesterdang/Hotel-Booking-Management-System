/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import model.Contract;

/**
 *
 * @author danhv
 */
public interface IContractDAO {
    List<Contract> findAllPending(long supplierID);
    Map<String,Integer> countContractRoomType(long supplierID,long hotelID, long customerID, Timestamp bookingTime);
    Boolean updateStatus(short action, long hotelID, long customerID, Timestamp bookingTime);
    List<Contract> findAllAccepted(long supplierID);
    List<Contract> findAllDeclined(long supplierID);
    List<Contract> findAllDone(long supplierID);
}
