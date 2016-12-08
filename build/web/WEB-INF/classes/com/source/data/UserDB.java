/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.data;

import java.util.*;

import com.source.dao.User;

/**
 *
 * @author User
 */
public class UserDB {

    public static ArrayList<User> defaultUsers() {
        ArrayList<User> users = new ArrayList<>();
        //
        User user1 = new User();
        user1.setName("Sakthi");
        user1.setEmail("sakthi@gmail.com");
        user1.setType("Participant");
        user1.setNumCoins(0);
        user1.setNumPostedStudies(0);
        user1.setNumPartipation(0);
        users.add(user1);
        //
        User user2 = new User();
        user2.setName("Saranya");
        user2.setEmail("saranya@gmail.com");
        user2.setType("Participant");
        user2.setNumCoins(0);
        user2.setNumPostedStudies(2);
        user2.setNumPartipation(0);
        users.add(user2);
        //
        User user3 = new User();
        user3.setName("Mayur");
        user3.setEmail("mayur@gmail.com");
        user3.setType("Admin");
        user3.setNumCoins(0);
        user3.setNumPostedStudies(0);
        user3.setNumPartipation(0);
        users.add(user3);
        //
        User user4 = new User();
        user4.setName("Gupta");
        user4.setEmail("gupta@gmail.com");
        user4.setType("Admin");
        user4.setNumCoins(0);
        user4.setNumPostedStudies(0);
        user4.setNumPartipation(0);
        users.add(user4);

        return users;
    }

    public static User getUser(ArrayList<User> users, String email) {
        int i = users.size();
        for (int j = 0; j < i; j++) {
            String currentUserEmail = users.get(j).getEmail();
            if (currentUserEmail.equals(email)) {
                return users.get(j);
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers(ArrayList<User> users) {
        return users;
    }

    public static void updateUserParticipation(ArrayList<User> users, String email) {
        int i = users.size();
        for (int j = 0; j < i; j++) {
            String currentUserEmail = users.get(j).getEmail();
            if (currentUserEmail.equals(email)) {
                users.get(j).setNumCoins(users.get(j).getNumCoins() + 1);
                users.get(j).setNumPartipation(users.get(j).getNumPartipation() + 1);
            }
        }
    }
}
