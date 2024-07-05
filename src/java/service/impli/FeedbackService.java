/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli;

import dao.IFeedbackDAO;
import dao.impli.FeedbackDAO;
import java.util.List;
import model.FeedbackModel;
import service.IFeedbackService;

/**
 *
 * @author Nguyen Quang Hau
 */
public class FeedbackService implements IFeedbackService {

    private IFeedbackDAO feedbackDAO = new FeedbackDAO();

//    public static void main(String[] args) {
//        FeedbackService f = new FeedbackService();
//        System.out.println(f.findAll(1).get(0).getCustomerModel().getAvatar());
//    }
    @Override
    public Integer countTotal(long roomNo) {
        return feedbackDAO.countTotal(roomNo);
    }

    @Override
    public List<FeedbackModel> findWithLimit(long roomNo, int offset, int fetch) {
        return feedbackDAO.findWithLimit(roomNo, offset, fetch);
    }

    @Override
    public FeedbackModel findBY(long id) {
        return feedbackDAO.findBy(id);
    }

    @Override
    public long insert(FeedbackModel feedbackModel) {
        return feedbackDAO.insert(feedbackModel);
    }

    @Override
    public boolean delete(long feedbackID) {
        return feedbackDAO.delete(feedbackID);
    }

}
