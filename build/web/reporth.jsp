<%-- 
    Document   : reporth
    Created on : Feb 5, 2016, 5:20:55 PM
    Author     : Abhishek Banerjee
--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to go back to Main page  --%>
<br>
<a href="main.jsp" id="back_to_page">&laquo;Back to the Main Page</a>
<br>
<div class="table-responsive">
    <table class="table" >
        <%--Column Names --%>
        <tr>
            <th>Report Date</th>
            <th>Report Question</th>		
            <th>Report Status</th>

        </tr>
        <c:forEach var="report" items="${myReports}">
            <tr>
                <td>${report.dateCreated}</td>
                <td>${report.question}</td>
                <td>${report.status}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>