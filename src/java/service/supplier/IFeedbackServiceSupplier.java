/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.supplier;

import java.util.List;
import model.FeedbackModel;

/**
 *
 * @author ADMIN
 */
public interface IFeedbackServiceSupplier {
    List<FeedbackModel> getAllFeedback(long roomNo, long supplierId);
}
