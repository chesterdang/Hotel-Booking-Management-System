/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping.impli;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.IRowMapping;
import model.Contract;

/**
 *
 * @author danhv
 */
public class ContractMapping implements IRowMapping<Contract> {

  

    @Override
    public Contract mapRow(ResultSet rs) {
        Contract cm = new Contract();
        try {
            cm.setCount(rs.getInt("count"));
            cm.setCustomerId(rs.getLong("customerID"));
            cm.setHotelId(rs.getLong("hotelID"));
            cm.setBookingTime(rs.getTimestamp("bookingTime"));
        } catch (SQLException ex) {
            Logger.getLogger(ContractMapping.class.getName()).log(Level.SEVERE, null, ex);
            cm = null;
        }
        return cm;
    }
    
}
