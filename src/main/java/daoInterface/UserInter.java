/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import java.util.List;
import model.User;

/**
 *
 * @author Marc
 */
public interface UserInter {

    void create(User user);

    User findById(String nick,String pass );

    void update(User user);

    List<User> listUsers();

    void delete(int id);

      boolean existById(String nick,String pass );
}
