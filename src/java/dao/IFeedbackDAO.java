/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.FeedbackModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IFeedbackDAO {

    FeedbackModel findBy(long id);

    List<FeedbackModel> findAll(long roomNo);

    List<FeedbackModel> findWithLimit(long roomNo, int offset, int fetch);

    Integer countTotal(long roomNo);

    long insert(FeedbackModel feedbackModel);

    boolean delete(long feedbackID);

    List<FeedbackModel> finaAll();

    List<FeedbackModel> findAllBy(long roomNo, long supplierId);

    boolean feedbackModel(long id);

    List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where);

    int getTotalFeedback(String where);

    boolean unlock(Long id);

    List<FeedbackModel> searchBy(String sth, String column);
    
    List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where , ArrayList<String> listbb) ;
    
}
