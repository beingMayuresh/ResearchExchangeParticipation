/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import com.source.dao.User;
import com.source.dao.Study;
import com.source.dao.Report;
import com.source.dao.Answer;
import com.source.data.StudyDB;
import com.source.data.UserDB;

/**
 *
 * @author User
 */
@WebServlet(name = "StudyController", urlPatterns = {"/studies"})
public class StudyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = null;
        //
        String action = request.getParameter("action");
        if (action == null) {
            if (session.getAttribute("theUser") != null) {
                url = "/main.jsp";
            } else if (session.getAttribute("theAdmin") != null) {
                url = "/admin.jsp";
            } else {
                url = "/home.jsp";
            }
        } else if (action.equals("participate")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                //
                if (studyCode == null) {
                    //retrieve open studies
                    ArrayList<Study> openStudies = StudyDB.getOpenStudies(studyDB);
                    request.setAttribute("openStudies", openStudies);
                    //
                    for(Study s :openStudies)
					{
						System.out.println(s.getImageURL());
					}
                    url = "/participate.jsp";
                    
                } else {
                    //retrieve a study based on study code
                    Study participateStudy = StudyDB.getStudy(studyDB, studyCode);
                    //
                    url = "/question.jsp";
                    request.setAttribute("participateStudy", participateStudy);
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("edit")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                String creatorEmail = request.getParameter("creatorEmail");
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                //retrieve a study based on study code and creator email
                Study editStudy = StudyDB.getStudy(studyDB, studyCode, creatorEmail);
                //
                url = "/editstudy.jsp";
                request.setAttribute("editStudy", editStudy);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("report")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get current user email
                User sessionUser = (User) session.getAttribute("theUser");
                String currentUserEmail = sessionUser.getEmail();
                //
                if (studyCode == null) {
                    //retrieve reports based on current user email
                    ArrayList<Report> reportDB = (ArrayList<Report>) session.getAttribute("reportDB");
                    ArrayList<Report> myReports = StudyDB.getReports(reportDB, currentUserEmail);
                    //
                    url = "/reporth.jsp";
                    request.setAttribute("myReports", myReports);
                } else {
                    //create a report
                    Report report = new Report();
                    report.setReportID("200");
                    report.setReporterEmail(currentUserEmail);
                    report.setStudyCode(studyCode);
                    report.setDateCreated("03/01/2016");
                    //add report
                    ArrayList<Report> reportDB = (ArrayList<Report>) session.getAttribute("reportDB");
                    StudyDB.addReport(reportDB, report);
                    //save modified data
                    session.setAttribute("reportDB", reportDB);
                    //
                    url = "/confirmrep.jsp";
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("approve")) {
            if (session.getAttribute("theAdmin") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get report DB
                ArrayList<Report> reportDB = (ArrayList<Report>) session.getAttribute("reportDB");
                //approve the report based on study code
                StudyDB.approveReport(reportDB, studyCode);
                //save modified data
                session.setAttribute("reportDB", reportDB);
                //
                url = "/reportques.jsp";
                request.setAttribute("reports", reportDB);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("disapprove")) {
            if (session.getAttribute("theAdmin") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get report DB
                ArrayList<Report> reportDB = (ArrayList<Report>) session.getAttribute("reportDB");
                //disapprove the report based on study code
                StudyDB.disapproveReport(reportDB, studyCode);
                //save modified data
                session.setAttribute("reportDB", reportDB);
                url = "/reportques.jsp";
                request.setAttribute("reports", reportDB);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("update")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //create a study
                Study study = new Study();
                study.setStudyName(request.getParameter("study_name"));
                study.setQuestion(request.getParameter("question_text"));
                study.setRequestedParticipants(Integer.parseInt(request.getParameter("participants")));
                int numOfChoice = Integer.parseInt(request.getParameter("numOfChoice"));
                ArrayList<String> choices = new ArrayList();
                for (int i = 1; i <= numOfChoice; i++) {
                    choices.add(request.getParameter("Answer" + i));
                }
                study.setAnswerList(choices);
                study.setDescription(request.getParameter("description"));
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                //update study based on study code
                StudyDB.updateStudy(studyDB, studyCode, study);
                //get current user email
                User sessionUser = (User) session.getAttribute("theUser");
                String currentUserEmail = sessionUser.getEmail();
                //get studies posted by current user based on email
                ArrayList<Study> myStudies = StudyDB.getStudies(studyDB, currentUserEmail);
                //save modified data
                session.setAttribute("studyDB", studyDB);
                //
                url = "/studies?action=studies";
                request.setAttribute("myStudies", myStudies);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("add")) {
            if (session.getAttribute("theUser") != null) {
                //get current user email
                User sessionUser = (User) session.getAttribute("theUser");
                String currentUserEmail = sessionUser.getEmail();
                //create A study
                Study study = new Study();
                study.setStudyName(request.getParameter("study_name"));
                study.setStudyCode("004");
                study.setDateCreated("03/01/2016");
                study.setCreatorEmail(currentUserEmail);
                study.setQuestion(request.getParameter("question_text"));
                study.setRequestedParticipants(Integer.parseInt(request.getParameter("participant_text")));
                study.setNumOfParticipants(0);
                study.setDescription(request.getParameter("description"));
                study.setStatus("Stop");
                study.setAnswerType("Text");
                int numOfChoice = Integer.parseInt(request.getParameter("numOfChoice"));
                ArrayList<String> choices = new ArrayList();
                for (int i = 1; i <= numOfChoice; i++) {
                    choices.add(request.getParameter("Answer" + i));
                }
                study.setAnswerList(choices);
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                StudyDB.addStudy(studyDB, study);
                //get studies poseted by current user based on email
                ArrayList<Study> myStudies = StudyDB.getStudies(studyDB, currentUserEmail);
                //save modified dara
                session.setAttribute("studyDB", studyDB);
                //
                url = "/studies.jsp";
                request.setAttribute("myStudies", myStudies);
            } else {
            }
        } else if (action.equals("start")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                //start study based on study code 
                StudyDB.startStudy(studyDB, studyCode);
                //save modified data
                session.setAttribute("studyDB", studyDB);
                //get current user email
                User sessionUser = (User) session.getAttribute("theUser");
                String currentUserEmail = sessionUser.getEmail();
                //get studies poseted by current user based on email
                ArrayList<Study> myStudies = StudyDB.getStudies(studyDB, currentUserEmail);
                //
                url = "/studies.jsp";
                request.setAttribute("myStudies", myStudies);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("stop")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                //get study DB
                ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                //stop study based on study code 
                StudyDB.stopStudy(studyDB, studyCode);
                //save modified data
                session.setAttribute("studyDB", studyDB);
                User sessionUser = (User) session.getAttribute("theUser");
                //get current user email
                String currentUserEmail = sessionUser.getEmail();
                //get studies poseted by current user based on email
                ArrayList<Study> myStudies = StudyDB.getStudies(studyDB, currentUserEmail);
                //
                url = "/studies.jsp";
                request.setAttribute("myStudies", myStudies);
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("answer")) {
            if (session.getAttribute("theUser") != null) {
                //get request parameter
                String studyCode = request.getParameter("studyCode");
                String choice = request.getParameter("number");
                //get current user email
                User sessionUser = (User) session.getAttribute("theUser");
                String currentUserEmail = sessionUser.getEmail();
                //
                if (studyCode != null) {
                    //add the answer
                    Answer answer = new Answer();
                    answer.setEmail(currentUserEmail);
                    answer.setChoice(choice);
                    answer.setSubmissionDate(new Date());
                    //update userDB
                    ArrayList<User> userDB = (ArrayList<User>) session.getAttribute("userDB");
                    UserDB.updateUserParticipation(userDB, currentUserEmail);
                    session.setAttribute("userDB", userDB);
                    //update study participation info
                    ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
                    StudyDB.updateStudyParticipation(studyDB, studyCode);
                    session.setAttribute("studyDB", studyDB);
                    //retrieve open studies
                    ArrayList<Study> openStudies = StudyDB.getOpenStudies(studyDB);
                    //
                    url = "/participate.jsp";
                    request.setAttribute("openStudies", openStudies);
                }
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("studies")) {
            //get current user email
            User sessionUser = (User) session.getAttribute("theUser");
            String currentUserEmail = sessionUser.getEmail();
            //get study DB
            ArrayList<Study> studyDB = (ArrayList<Study>) session.getAttribute("studyDB");
            //get studies posted by current user based on email
            ArrayList<Study> myStudies = StudyDB.getStudies(studyDB, currentUserEmail);
            //
            url = "/studies.jsp";
            request.setAttribute("myStudies", myStudies);
        } else if (action.equals("reportList")) {
            if (session.getAttribute("theAdmin") != null) {
                //get report list for admin in reqortques.jsp
                ArrayList<Report> reportDB = (ArrayList<Report>) session.getAttribute("reportDB");
                //
                url = "/reportques.jsp";
                request.setAttribute("reports", reportDB);
            } else {
                url = "/login.jsp";
            }
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}