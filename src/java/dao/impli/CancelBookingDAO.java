/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.ICancelBookingDAO;
import java.sql.Timestamp;
import java.util.List;
import mapping.impli.CancelBookingMapping;
import model.CancelBookingModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class CancelBookingDAO extends AbstractModel implements ICancelBookingDAO {

    @Override
    public CancelBookingModel findBy(long id) {
        String sql = "SELECT * FROM CancelBooking WHERE id = ?";
        List<CancelBookingModel> list = query(sql, new CancelBookingMapping(), id);
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<CancelBookingModel> findCancelBooking(long customerId, int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CancelBooking ");
        sql.append("WHERE customerID = ? and (status = 2 or status = 6) ");
        sql.append("ORDER BY createdDate DESC ");
        sql.append("OFFSET ? ROWS ");
        sql.append("FETCH next ? ROWS ONLY");
        return query(sql.toString(), new CancelBookingMapping(), customerId, offset, fetch);
    }

    @Override
    public Integer countCancelBooking(long customerId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) FROM CancelBooking ");
        sql.append("WHERE customerID = ? and (status = 2 or status = 6) ");
        return countRows(sql.toString(),customerId);
    }

    @Override
    public void insert(long cusId, long bookingId, String content, Timestamp createdDate, short status) {
        StringBuilder sql = new StringBuilder("INSERT INTO CancelBooking (customerID, bookingid, content, createdDate, status)");
        sql.append("VALUES (?,?,?,?,?)");
        insert(sql.toString(), cusId, bookingId, content, createdDate, status);
    }

}
