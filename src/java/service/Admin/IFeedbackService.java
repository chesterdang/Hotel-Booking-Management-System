/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Admin;

import java.util.ArrayList;
import java.util.List;
import model.FeedbackModel;

/**
 *
 * @author quandba
 */
public interface IFeedbackService {
    List<FeedbackModel> finaAll  ();
    
    FeedbackModel  findBy(long id);
    
    List<FeedbackModel> findBB  (List<FeedbackModel>  f);
    
    boolean deleteFeedback (long id); 
    
    int getTotalFeedback(String where);
    
    List<FeedbackModel> searchBy(String str, String column);

    List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage,String where);
    
     List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where , ArrayList<String> listbb);


    boolean delete(long id);
    boolean unlock(long id);
}
