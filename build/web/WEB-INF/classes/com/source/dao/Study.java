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
public class Study implements Serializable {

    private String studyName;
    private String studyCode;
    private String dateCreated;
    private String creatorEmail;
    private String question;
    private int requestedParticipants;
    private int numOfParticipants;
    private String description;
    private String status;
    private String answerType;
    private ArrayList<String> answerList;

    public Study() {
    }

    public Study(String studyName, String studyCode, String dateCreated, String creatorEmail, String question, int requestedParticipants, int numOfParticipants, String description, String status, String answerType, ArrayList<String> answerList) {
        this.studyName = studyName;
        this.studyCode = studyCode;
        this.dateCreated = dateCreated;
        this.creatorEmail = creatorEmail;
        this.question = question;
        this.requestedParticipants = requestedParticipants;
        this.numOfParticipants = numOfParticipants;
        this.description = description;
        this.status = status;
        this.answerType = answerType;
        this.answerList = answerList;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getStudyCode() {
        return studyCode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public String getQuestion() {
        return question;
    }

    public int getRequestedParticipants() {
        return requestedParticipants;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getAnswerType() {
        return answerType;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public void setStudyCode(String studyCode) {
        this.studyCode = studyCode;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setRequestedParticipants(int requestedParticipants) {
        this.requestedParticipants = requestedParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public void setAnswerList(ArrayList<String> answerList) {
        this.answerList = answerList;
    }

    public String getImageURL() {
		if (this.getStudyCode().equals("5120")) {
			return "images/small_tree.jpg";
		}
		if (this.getStudyCode().equals("6100")) {
			return "images/computer.jpg";
		}
		if (this.getStudyCode().equals("7120")) {
			return "images/computer.jpg";
		}
		return "images/mind.jpg";
	}

    public int getAverage() {
        return 0;
    }

    public int getMinimun() {
        return 0;
    }

    public int getMaimun() {
        return 0;
    }

    public double getSD() {
        return 0;
    }
    
    
}
