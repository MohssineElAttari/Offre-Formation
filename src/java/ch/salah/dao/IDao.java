/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.dao;

import java.util.List;

/**
 *
 * @author salah
 */
public interface IDao <S>{
    
    void create(S o);
    S findById(int id);
    void update(S o);
    void delete(S o);
    List<S> findAll();
}
