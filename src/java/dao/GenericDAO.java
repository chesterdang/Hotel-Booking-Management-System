/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.HashMap;
import java.util.List;
import mapping.IRowMapping;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface GenericDAO{
   <T> List<T> query(String sql, IRowMapping mapper, Object... parameters);
   boolean update(String sql, Object... parameters);
   Long insert(String sql, Object... parameters);
   int countRows(String sql, Object... parameters);
   HashMap<Integer, Integer> numberHashMap (String sql);
}
