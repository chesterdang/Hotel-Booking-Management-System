/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impli.supplier;

import dao.IFeedbackDAO;
import dao.impli.FeedbackDAO;
import java.util.List;
import model.FeedbackModel;
import service.supplier.IFeedbackServiceSupplier;

/**
 *
 * @author ADMIN
 */
public class FeedbackServiceSupplier implements IFeedbackServiceSupplier{
    private IFeedbackDAO feedbackDAO = new FeedbackDAO();
    @Override
    public List<FeedbackModel> getAllFeedback(long roomNo, long supplierId) {
        return feedbackDAO.findAllBy(roomNo, supplierId);
    }
    
    public static void main(String[] args) {
        FeedbackServiceSupplier feedbackService = new FeedbackServiceSupplier();
        List<FeedbackModel> list = feedbackService.getAllFeedback(4, 4);
        for (FeedbackModel feedbackModel : list) {
            System.out.println(list);
        }
    }
    
}
