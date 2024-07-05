/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.Admin;

import dao.IFeedbackDAO;
import dao.impli.FeedbackDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.FeedbackModel;
import service.Admin.IFeedbackService;

/**
 *
 * @author quandba
 */
public class FeedbackService implements IFeedbackService{
     public IFeedbackDAO feedbackDAO = new FeedbackDAO() ;
    @Override
    public List<FeedbackModel> finaAll() {
        return feedbackDAO.finaAll();
    }

    @Override
    public List<FeedbackModel> findBB(List<FeedbackModel> f) {
        List<FeedbackModel> listfb  = new ArrayList<>();
        List<String> listbb = new ArrayList<>();
        listbb.add("chemnhau");
        listbb.add("gietnhau");
        listbb.add("chientranh");

        for (FeedbackModel fb : f) {
            for (String str : listbb) {
                if (fb.getContent().contains(str)) {
                    listfb.add(fb);
                }
            }
            
        }

        return listfb;
       
    }

    @Override
    public FeedbackModel findBy(long id) {
       return feedbackDAO.findBy(id);
    }
    
  
    
     public static void main(String[] args) {
        IFeedbackService iFeedbackService = new FeedbackService();
        for (FeedbackModel arg : iFeedbackService.findBB(iFeedbackService.finaAll())) {
            System.out.println(arg.toString());
        }
    }

   

    @Override
    public boolean deleteFeedback(long id) {
       return  feedbackDAO.feedbackModel(id);
    }
    
    
    
    @Override
    public int getTotalFeedback(String where) {
        return feedbackDAO.getTotalFeedback(where);
    }

    @Override
    public List<FeedbackModel> pagingListFeedback(String column,String ASCorDESC,int index, int quantityPerPage,String where) {
        return feedbackDAO.pagingListFeedback(column, ASCorDESC, index, quantityPerPage, where);

    }

    @Override
    public boolean delete(long id) {
        return feedbackDAO.delete(id);
    }

      @Override
    public boolean unlock(long id) {
        return feedbackDAO.unlock(id);
    }

    @Override
    public List<FeedbackModel> searchBy(String str, String column) {
       return feedbackDAO.searchBy(str, column);
    }
    
    @Override
    public List<FeedbackModel> pagingListFeedback(String column, String ASCorDESC, int index, int quantityPerPage, String where, ArrayList<String> listbb) {
        return  feedbackDAO.pagingListFeedback(column, ASCorDESC, index, quantityPerPage, where, listbb);
    }
}
