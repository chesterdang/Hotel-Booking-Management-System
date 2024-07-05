/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

/**
 *
 * @author danhv
 */
public interface IReport {
       int totalBooking (long id);
       int availableRoom(long id);
       int roomCollection(long id);
       java.math.BigDecimal income(long id);
}
