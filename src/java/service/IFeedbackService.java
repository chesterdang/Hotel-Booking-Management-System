/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.FeedbackModel;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IFeedbackService {
    Integer countTotal(long roomNo);
    FeedbackModel findBY(long id);
    List<FeedbackModel> findWithLimit(long roomNo,int offset, int fetch);
    long insert(FeedbackModel feedbackModel);
    boolean delete(long feedbackID);
}
