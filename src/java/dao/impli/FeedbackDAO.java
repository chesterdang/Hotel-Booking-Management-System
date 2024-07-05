/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impli;

import dao.IFeedbackDAO;
import java.util.ArrayList;
import java.util.List;
import mapping.impli.FeedbackMapping;
import model.FeedbackModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public class FeedbackDAO extends AbstractModel implements IFeedbackDAO{

    @Override
    public FeedbackModel findBy(long id) {
         String sql = "SELECT * FROM feedback WHERE id = ?";
         List<FeedbackModel> list =  query(sql, new FeedbackMapping(), id);
        return  (list.isEmpty())?null:list.get(0);
    }

    @Override
    public List<FeedbackModel> findAll(long roomNo) {
        String sql = "SELECT * FROM feedback WHERE roomNo = ?";
        return query(sql, new FeedbackMapping(), roomNo);
    }

    @Override
    public List<FeedbackModel> findWithLimit(long roomNo,int offset, int fetch) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Feedback ");
        sql.append("WHERE roomNo = ? and status != 0 ");
        sql.append("ORDER BY createdDate DESC ");
        sql.append("OFFSET ? ROWS ");
        sql.append("FETCH next ? ROWS ONLY");
        return query(sql.toString(), new FeedbackMapping(), roomNo,offset,fetch);
    }

    @Override
    public Integer countTotal(long roomNo) {
        String sql = "SELECT COUNT(*) FROM Feedback WHERE roomNo = ? and status = 1";
        return countRows(sql,roomNo);
    }
    
    @Override
    public long insert(FeedbackModel feedbackModel) {
        String sql = "INSERT INTO Feedback (customerID, roomNo, createdDate, content, status) VALUES (?, ?, ?, ?, ?)";
        return insert(sql, feedbackModel.getCustomerModel().getId(), 
                feedbackModel.getRoomModel().getRoomNo(), feedbackModel.getCreatedDate(),
                feedbackModel.getContent(), feedbackModel.getStatus());
    }

    @Override
    public boolean delete(long feedbackID) {
        String sql = "UPDATE feedback SET status = 0 where id = ?";
        return update(sql, feedbackID);
    }
    
    @Override
    public List<FeedbackModel> finaAll() {
         String sql = "SELECT * FROM Feedback";
        return query(sql, new FeedbackMapping());
    }
    
     @Override
    public List<FeedbackModel> findAllBy(long roomNo, long supplierId) {
        String sql = "SELECT f.*\n"
                + "FROM feedback f\n"
                + "INNER JOIN Room r ON f.roomNo = r.roomNo\n"
                + "INNER JOIN Hotel h ON r.hotelID = h.id\n"
                + "INNER JOIN Supplier s ON h.id = s.hotelId\n"
                + "WHERE f.roomNo = ? AND s.id = ?;";
        return query(sql, new FeedbackMapping(),roomNo, supplierId);
    }
    
    
      @Override
    public boolean feedbackModel(long id) {
        String sql = "Update  FROM feedbackWHERE id = ?";
        return update(sql, id);
        
        
    }
    
    
    
    @Override
    public List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where) {
        String sql = "select * from feedback "+where+ "\n"
                + "order by " + column + " " + ASCorDESC +" \n"
                + " offset ? Rows fetch next " + quantityPerPage + " rows only;";
        return query(sql, new FeedbackMapping(), (index - 1) * quantityPerPage);

    }

    @Override
    public int getTotalFeedback(String where) {
        String sql = "SELECT COUNT(*)  FROM feedback "+where;
        return countRows(sql);
    }


    @Override
    public boolean unlock(Long id) {
        String sql = "Update feedback set status = 1 where id =?";
        return update(sql, id);
    }
    
//    @Override
//    public boolean delete(Long id) {
//        String sql ="Update feedback set status = 0 where id =?";
//       return update(sql, id);
//    }

    @Override
    public List<FeedbackModel> searchBy(String sth, String column) {
        String sql = "select * from feedback where " + column + " like ?;";
        return query(sql, new FeedbackMapping(), "%" + sth + "%");
    }
    
      @Override
    public List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where, ArrayList<String> listbb) {
        String sql2 = "";
        String sql = "select * from feedback \n";
        if (!listbb.isEmpty()) {
            for (String string : listbb) {
                if (sql2 == "") {
                    sql2 = "LIKE " + "'%" + string + "%'";
                } else {
                    sql2 = sql2 + " OR content LIKE " + "'%" + string + "%'";
                }
            }
            sql = sql + "Where content " + sql2 + " " + where ;
        }

        String sql1 = " order by " + column + " " + ASCorDESC + " \n"
                + " offset ? Rows fetch next " + quantityPerPage + " rows only;";
        sql = sql + sql1;
        return query(sql, new FeedbackMapping(), (index - 1) * quantityPerPage);

    }
}
