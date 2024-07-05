/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IHotelDAO;
import dao.IRoomDAO;
import java.util.List;
import mapping.impli.HotelMapping;
import model.HotelModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class HotelDAO extends AbstractModel implements IHotelDAO {

    private IRoomDAO roomDAO = new RoomDAO();

    @Override

    public HotelModel findBy(long id) {
        HotelModel hotelModel = getHotel(id);
        if (hotelModel != null) {
            hotelModel.setRooms(roomDAO.getRoomsListFromHotel(id));
        }
        return hotelModel;

    }

    @Override
    // using for roomDAO, use findBy instead of this function
    public HotelModel getHotel(long id) {
        String sql = "SELECT * FROM Hotel WHERE id = ?";
        List<HotelModel> list = query(sql, new HotelMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }

    public static void main(String[] args) {
        HotelDAO hotel = new HotelDAO();
        System.out.println(hotel.findBy(1));
    }
    
    @Override
    public HotelModel getHotelBy(long supplierId) {
        String sql = "SELECT *\n"
                + "FROM Hotel\n"
                + "WHERE id IN (SELECT hotelId FROM Supplier WHERE id = ?)";
        List<HotelModel> list = query(sql, new HotelMapping(), supplierId);
        return (list.isEmpty()) ? null : list.get(0);
    }
    
     @Override
    public Long insertHotel(String name, String address, String postcode, int numRoom, String phone, Double starRating) {
        String sql = "INSERT INTO Hotel( name, address, postcode, numRooms, phone, starRating)" 
                + "VALUES (?,? ,?, ?,?,?)";
        return insert(sql, name, address, postcode, numRoom, phone, starRating);
    }
    

}
