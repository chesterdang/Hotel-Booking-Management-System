/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mapping;
import java.sql.*;
/**
 *
 * @author Nguyen Quang Hau
 */
public interface IRowMapping<T> {
    T mapRow(ResultSet rs);
}
