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
<%-- Code to Display Question--%>
<section class="question_section">
    <h3><span class="label label-default" >Question</span></h3>
    <%-- Img tag to display image--%>
    <img src="images/small_tree.jpg" class="img-responsive" height="250" width="250" alt="Tree"/>

    <%--Code to rating the Question --%>
    <p class="text-left">${participateStudy.question}</p>

    <form action="studies" method="post">
        <input type="hidden" name="studyCode" value="${participateStudy.studyCode}">
        <input type="hidden" name="action" value="answer">
        <c:forEach var="answer" items="${participateStudy.answerList}">
            <div class="radio">
                <input type="radio" name="number" value="${answer}" required>${answer}
            </div>
        </c:forEach>

        <%-- Code to submit the Rating  --%>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-4">
                <button type="submit"  class="btn btn-primary">Submit</button>
            </div>
        </div>
        <br/><br/><br/>   
    </form>


</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>