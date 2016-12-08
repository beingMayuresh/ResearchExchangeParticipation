<%--
        Document: aboutl.jsp
        Created On: Feb 4, 2016
        Authors: Deepak Rohan, Abhishek

--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        <li>Coins (<span class="count">${theUser.numCoins}</span>) </li>
        <li>Participants (<span class="count">${theUser.numPostedStudies}</span>) </li>
        <li>Participation (<span class="count">${theUser.numPartipation}</span>) </li>
        <li><br></li>
        <li><a href="home.jsp">Home</a></li>
        <li><a href="studies?action=participate">Participate</a></li>
        <li><a href="studies?action=studies">My Studies</a></li>
        <li><a href="recommend.jsp">Recommend</a></li>
        <li><a href="contact.jsp">Contact</a></li>
    </ul>

</nav>
<%-- Section to display studies and participate in that study--%>
<div>

    <h3 class="text-left"><span class="label label-default " >Studies</span>
        <span ><a class="label label-default" href="studies?action=report">Report History</a></span></h3>
</div>

<%-- Display the studies in the table --%>
<%-- Clicking on Participate button displays Question.jsp page where 
        you can rate the question--%>
<div class="table-responsive">
    <table class="table" >
        <%--Column Names --%>
        <tr>
            <th>Study Name</th>
            <th>Image</th>      
            <th>Question</th>
            <th>Action</th>
            <th>Report</th>
        </tr>
        <c:forEach var="study" items="${openStudies}">
            <tr>
                <td>${study.studyName}</td>
                <td><img src="${study.getImageURL()}" alt="Tree"></td>
                
                <td>${study.question}</td> 
          <%--      <td>
                    <form action="studies" method="Post">
                        <input type="hidden" name="studyCode" value="${study.studyCode}">
                        <input type="hidden" name="action" value="participate">
                        <input type="submit" class="participate_button" value="participate" />
                    </form>
                </td>
                <td>
                    <form action="studies" method="Post">
                        <input type="hidden" name="studyCode" value="${study.studyCode}">
                        <input type="hidden" name="action" value="report">
                        <input type="submit" class="participate_button" value="Report" />
                    </form>
                </td>
                --%>
                <td><form action="studies" method="post"><input type="submit" class="participate_button"
                                                                                value="Participate" />
                                                                                <input type="hidden" name="action" value="participate">
                                                                                <input type="hidden" name="StudyCode" value="${studi.studyCode}">
                                                                                </form></td>
            <td><form action="studies" method="post"><input type="submit" class="participate_button"
                                                                                value="Report" />
                                                                            <input type="hidden" name="action" value="report">
                                                                               <input type ="hidden" name="email"  value="${theUser.email}"/>
                                                                                 <input type="hidden" name="ques" value="${studi.question}">
                                                                               <input type="hidden" name="StudyCode" value="${studi.studyCode}">     
                                                                                </form></td>
                
                
            </tr>
        </c:forEach>
    </table>
</div>


<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>