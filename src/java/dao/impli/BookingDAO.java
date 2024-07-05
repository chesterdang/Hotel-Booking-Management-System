/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IBookingDAO;
import java.sql.Timestamp;
import java.util.List;
import mapping.impli.BookingMapping;
import model.BookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class BookingDAO extends AbstractModel implements IBookingDAO {

    @Override
    public BookingModel findBy(long id) {
        String sql = "SELECT * FROM Booking WHERE id = ?";
        List<BookingModel> list = query(sql, new BookingMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }

//    public static void main(String[] args) {
//        BookingDAO b = new BookingDAO();
//        for (BookingModel arg : b.findHistoryBooking(1, 0, 10)) {
//            System.out.println(arg.toString());
//        }
//    }
    
    @Override
    public boolean findBy(long cusId, long roomNo) {
        String sql = "SELECT * FROM Booking WHERE customerID = ? and roomNo = ? and (status = 3 or status = 7)";
        List<BookingModel> list = query(sql, new BookingMapping(), cusId, roomNo);
        return !(list.isEmpty());
    }
    
    @Override
    public List<BookingModel> findBooking(long customerId, int offset, int fetch, short status1, short status2) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Booking ");
        sql.append("WHERE customerID = ? and (status = ? or status = ?) ");
        sql.append("ORDER BY bookingTime DESC ");
        sql.append("OFFSET ? ROWS ");
        sql.append("FETCH next ? ROWS ONLY");
        return query(sql.toString(), new BookingMapping(), customerId, status1, status2, offset, fetch);
    }

    @Override
    public Integer countBooking(long customerId, short status1, short status2) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM Booking ");
        sql.append("WHERE customerID = ? and (status = ? or status = ?) ");
        return countRows(sql.toString(),customerId, status1, status2 );
    }
    
//    public static void main(String[] args) {
//        BookingDAO bo = new BookingDAO();
//        System.out.println(bo.countBooking(1, (short)3, (short)7));
//        for (BookingModel booking : bo.findBooking(1, 0, 10, (short)3, (short)7)) {
//            System.out.println(booking.toString());
//        }
//    }

    @Override
    public void insert(BookingModel bookingModel) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Booking (hotelID, customerID, roomNo, bookingTime, arrivalTime, departureTime, numAdults, numChilds, specialReq, status) ");
        sql.append("VALUES (?,?,?,?,?,?,?,?,?,?)");
        insert(sql.toString(), bookingModel.getHotelModel().getId(), bookingModel.getCustomerModel().getId(), bookingModel.getRoomModel().getRoomNo(),
        bookingModel.getBookingTime(), bookingModel.getArrivalTime(), bookingModel.getDepartureTime(), bookingModel.getNumAdults(), bookingModel.getNumChilds(), bookingModel.getSpecialReq(), 0);
    }
    
     @Override
    public boolean updateStatus(int action, long id) {
        String sql = "UPDATE dbo.Booking SET status = ? WHERE id = ?";
        return update(sql, action, id);
    }
    
    

    @Override
    public List<BookingModel> findAllPending(long id) {
        String sql = "SELECT dbo.Booking.*\n" +
"FROM dbo.Booking, dbo.Supplier, dbo.Hotel\n" +
"WHERE dbo.Supplier.hotelId = Hotel.id AND dbo.Hotel.id = Booking.hotelID AND dbo.Supplier.id = ? AND dbo.Booking.status = 0";
        List<BookingModel> list = query(sql, new BookingMapping(), id);
        return list;
    }
    
    

    @Override
    public int count(long id) {
        String sql ="SELECT COUNT(dbo.Booking.id) \n" +
"FROM dbo.Booking,dbo.Supplier\n" +
"WHERE dbo.Booking.hotelID = dbo.Supplier.hotelId AND Supplier.hotelId=?";
        return countRows(sql, id);
    }
    
   

    

    @Override
    public int availableRoom(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BookingModel> findAllAccepted(long id) {
        String sql = "SELECT dbo.Booking.*\n" +
"FROM dbo.Booking, dbo.Supplier, dbo.Hotel\n" +
"WHERE dbo.Supplier.hotelId = Hotel.id AND dbo.Hotel.id = Booking.hotelID AND dbo.Supplier.id = ? AND dbo.Booking.status = 1";
        List<BookingModel> list = query(sql, new BookingMapping(), id);
        return list;
    }
    
   

    @Override
    public List<BookingModel> findAllDeclined(long id) {
        String sql = "SELECT dbo.Booking.*\n" +
"FROM dbo.Booking, dbo.Supplier, dbo.Hotel\n" +
"WHERE dbo.Supplier.hotelId = Hotel.id AND dbo.Hotel.id = Booking.hotelID AND dbo.Supplier.id = ? AND dbo.Booking.status = 2";
        List<BookingModel> list = query(sql, new BookingMapping(), id);
        return list;
    }

    @Override
    public List<BookingModel> findAllDoned(long id) {
          String sql = "SELECT dbo.Booking.*\n" +
"FROM dbo.Booking, dbo.Supplier, dbo.Hotel\n" +
"WHERE dbo.Supplier.hotelId = Hotel.id AND dbo.Hotel.id = Booking.hotelID AND dbo.Supplier.id = ? AND dbo.Booking.status = 3";
        List<BookingModel> list = query(sql, new BookingMapping(), id);
        return list;
    }

    @Override
    public BookingModel findByBookingTime(Timestamp bookingTime, long hotelId) {
        String sql = "SELECT * FROM Booking WHERE bookingTime = ? AND hotelID = ?";
         List<BookingModel> list =  query(sql, new BookingMapping(), bookingTime, hotelId);
        return  (list.isEmpty())?null:list.get(0);
    }
    

}
