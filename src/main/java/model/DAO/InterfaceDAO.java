/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriely
 */
public interface InterfaceDAO<T> {
  public abstract void create(T objeto);
  public abstract List<T> retrieve();
  public abstract T retrieve(int pk);
  public abstract List<T> retrieve(String parametro, String atributo);
  public abstract void update(T objeto);
  public abstract void delete(T objeto);
}
