/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.salah.dao;

/**
 *
 * @author salah
 */
public interface IDao <S>{
    
    void create(S o);
    S getById(int id);
    void delete(S o);
}
