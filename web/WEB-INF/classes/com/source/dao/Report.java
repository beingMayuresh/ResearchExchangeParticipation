/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.dao;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Report implements Serializable {

    private String reportID;
    private String reporterEmail;
    private String studyCode;
    private String question;
    private String dateCreated;
    private String status;

    public Report() {
        question = "Could you be more specific about this?";
        status = "Pending";
    }

    public Report(String reportID, String reporterEmail, String studyCode, String question, String dateCreated, String status) {
        this.reportID = reportID;
        this.reporterEmail = reporterEmail;
        this.studyCode = studyCode;
        this.question = question;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public String getReportID() {
        return reportID;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getStudyCode() {
        return studyCode;
    }

    public String getQuestion() {
        return question;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public void setStudyCode(String studyCode) {
        this.studyCode = studyCode;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
