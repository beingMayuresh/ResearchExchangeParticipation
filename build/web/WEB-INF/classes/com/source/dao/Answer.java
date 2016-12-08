/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.dao;

import java.io.Serializable;
import java.util.*;


/**
 *
 * @author User
 */
public class Answer implements Serializable {

    private String email;
    private String choice;
    private Date submissionDate;

    public Answer() {
    }

    public Answer(String email, String choice, Date submissionDate) {
        this.email = email;
        this.choice = choice;
        this.submissionDate = submissionDate;
    }

    public String getEmail() {
        return email;
    }

    public String getChoice() {
        return choice;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

}