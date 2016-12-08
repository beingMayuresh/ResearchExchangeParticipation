/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.data;

import java.util.*;
import com.source.dao.Study;
import com.source.dao.Report;

/**
 *
 * @author User
 */
public class StudyDB {

    public static ArrayList<Study> defaultStudies() {
        ArrayList<Study> studies = new ArrayList<>();
        //
        Study study1 = new Study();
        study1.setStudyName("ITPM");
        study1.setStudyCode("5120");
        study1.setDateCreated("09/01/2016");
        study1.setCreatorEmail("sakthi@gmail.com");
        study1.setQuestion("Which version of the project?");
        study1.setRequestedParticipants(10);
        study1.setNumOfParticipants(0);
        study1.setDescription("Project Management");
        study1.setStatus("Start");
        study1.setAnswerType("Numeric");
        ArrayList<String> list1 = new ArrayList();
        list1.add("1.1");
        list1.add("1.2");
        list1.add("1.3");
        list1.add("1.4");
        study1.setAnswerList(list1);
        studies.add(study1);
        //
        Study study2 = new Study();
        study2.setStudyName("SSDI");
        study2.setStudyCode("6100");
        study2.setDateCreated("02/03/2016");
        study2.setCreatorEmail("saranya@gmail.com");
        study2.setQuestion("What is MVC?");
        study2.setRequestedParticipants(10);
        study2.setNumOfParticipants(0);
        study2.setDescription("Software development");
        study2.setStatus("Start");
        study2.setAnswerType("Text");
        ArrayList<String> list2 = new ArrayList();
        list2.add("1.Model View Controller");
        list2.add("2.Monitor View Controller");
        list2.add("3.Minimum Velocity Controller");
        study2.setAnswerList(list2);
        studies.add(study2);
        //
        Study study3 = new Study();
        study3.setStudyName("Algos");
        study3.setStudyCode("7120");
        study3.setDateCreated("03/03/2016");
        study3.setCreatorEmail("sakthi@gmail.com");
        study3.setQuestion("The memory address of the first element of an array is called");
        study3.setRequestedParticipants(10);
        study3.setNumOfParticipants(0);
        study3.setDescription("Data structures and Algorithms");
        study3.setStatus("Start");
        study3.setAnswerType("Text");
        ArrayList<String> list3 = new ArrayList();
        list3.add("1.foundation address");
        list3.add("2.first address");
        list3.add("3.base address");
        study3.setAnswerList(list3);
        studies.add(study3);

        return studies;
    }

    public static Study getStudy(ArrayList<Study> studies, String studyCode) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudyCodes = studies.get(j).getStudyCode();
            if (currentStudyCodes.equals(studyCode)) {
                return studies.get(j);
            }
        }
        return null;
    }

    public static Study getStudy(ArrayList<Study> studies, String studyCode, String creatorEmail) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudyCodes = studies.get(j).getStudyCode();
            String currentCreatorEmail = studies.get(j).getCreatorEmail();
            if (currentStudyCodes.equals(studyCode) && currentCreatorEmail.equals(creatorEmail)) {
                return studies.get(j);
            }
        }
        return null;
    }

    public static ArrayList<Study> getStudies(ArrayList<Study> studies) {
        return studies;
    }

    public static ArrayList<Study> getStudies(ArrayList<Study> studies, String creatorEmail) {
        ArrayList<Study> qualifiedStudies = new ArrayList<>();
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentCreatorEmails = studies.get(j).getCreatorEmail();
            if (currentCreatorEmails.equals(creatorEmail)) {
                qualifiedStudies.add(studies.get(j));
            }
        }
        return qualifiedStudies;
    }

    public static ArrayList<Study> getOpenStudies(ArrayList<Study> studies) {
        ArrayList<Study> qualifiedStudies = new ArrayList<>();
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudiesStatus = studies.get(j).getStatus();
            if (currentStudiesStatus.equals("Start")) {
                qualifiedStudies.add(studies.get(j));
            }
        }
        return qualifiedStudies;
    }

    public static void addStudy(ArrayList<Study> studies, Study study) {
        studies.add(study);
    }

    public static void updateStudy(ArrayList<Study> studies, String studyCode, Study study) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            Study currentStudy = studies.get(j);
            String currentStudyCodes = currentStudy.getStudyCode();
            if (currentStudyCodes.equals(studyCode)) {
                currentStudy.setStudyName(study.getStudyName());
                currentStudy.setQuestion(study.getQuestion());
                currentStudy.setRequestedParticipants(study.getRequestedParticipants());
                currentStudy.setAnswerList(study.getAnswerList());
                currentStudy.setDescription(study.getDescription());
                break;
            }
        }
    }

    public static void startStudy(ArrayList<Study> studies, String studyCode) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudyCode = studies.get(j).getStudyCode();
            if (currentStudyCode.equals(studyCode)) {
                studies.get(j).setStatus("Start");
            }
        }
    }

    public static void stopStudy(ArrayList<Study> studies, String studyCode) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudyCode = studies.get(j).getStudyCode();
            if (currentStudyCode.equals(studyCode)) {
                studies.get(j).setStatus("Stop");
            }
        }
    }

    public static void updateStudyParticipation(ArrayList<Study> studies, String studyCode) {
        int i = studies.size();
        for (int j = 0; j < i; j++) {
            String currentStudyCode = studies.get(j).getStudyCode();
            if (currentStudyCode.equals(studyCode)) {
                studies.get(j).setNumOfParticipants(studies.get(j).getNumOfParticipants() + 1);
            }
        }
    }

    public static ArrayList<Report> defaultReports() {
        ArrayList<Report> reports = new ArrayList<>();
        //
        Report report1 = new Report();
        report1.setReportID("101");
        report1.setReporterEmail("mayur@gmail.com");
        report1.setStudyCode("5120");
        report1.setQuestion("Question is not chanllenging?");
        report1.setDateCreated("07/02/2016");
        report1.setStatus("Approved");
        reports.add(report1);
        //
        Report report2 = new Report();
        report2.setReportID("102");
        report2.setReporterEmail("gupta@gmail.com");
        report2.setStudyCode("7120");
        report2.setQuestion("This question is useful?");
        report2.setDateCreated("02/02/2016");
        report2.setStatus("Approved");
        reports.add(report2);
        //
        Report report3 = new Report();
        report3.setReportID("103");
        report3.setReporterEmail("gupta@gmail.com");
        report3.setStudyCode("6100");
        report3.setQuestion("The answer is 1 right?");
        report3.setDateCreated("02/02/2016");
        report3.setStatus("Approved");
        reports.add(report3);
        //
        Report report4 = new Report();
        report4.setReportID("104");
        report4.setReporterEmail("mayur@gmail.com");
        report4.setStudyCode("6100");
        report4.setQuestion("Understanding Knowledge?");
        report4.setDateCreated("04/03/2016");
        report4.setStatus("Pending");
        reports.add(report4);

        return reports;
    }

    public static ArrayList<Report> getReports(ArrayList<Report> reports, String reporterEmail) {
        ArrayList<Report> qualifiedReports = new ArrayList<>();
        int i = reports.size();
        for (int j = 0; j < i; j++) {
            String currentReporterEmails = reports.get(j).getReporterEmail();
            if (currentReporterEmails.equals(reporterEmail)) {
                qualifiedReports.add(reports.get(j));
            }
        }
        return qualifiedReports;
    }

    public static void approveReport(ArrayList<Report> reports, String reportID) {
        int i = reports.size();
        for (int j = 0; j < i; j++) {
            String currentReportID = reports.get(j).getReportID();
            if (currentReportID.equals(reportID)) {
                reports.get(j).setStatus("Approved");
            }
        }
    }

    public static void disapproveReport(ArrayList<Report> reports, String reportID) {
        int i = reports.size();
        for (int j = 0; j < i; j++) {
            String currentReportID = reports.get(j).getReportID();
            if (currentReportID.equals(reportID)) {
                reports.get(j).setStatus("Disapproved");
            }
        }
    }

    public static void addReport(ArrayList<Report> reports, Report report) {
        reports.add(report);
    }
}
