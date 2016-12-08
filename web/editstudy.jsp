<%--
        Document: aboutl.jsp
        Created On: Feb 4, 2016
        Authors: Deepak Rohan, Abhishek

--%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<script type="text/javascript" src="js/editstudy.js">
</script>
<%-- Code to display Page Name --%>
<h3 id="page_name">Editing a study</h3>
<%-- Code to go back to Main page  --%>
<a href="main.jsp" id="back_to_page">&laquo;Back to the Main Page</a>
<%-- Section to input study details --%>
<section>
    <form class="form-horizontal" action="studies" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="studyCode" value="${editStudy.studyCode}"/>
        <div class="form-group">
            <label class="col-sm-4 control-label">Study Name *</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="study_name" value="${editStudy.studyName}" required/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label">Question Text *</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="question_text" value="${editStudy.question}" required/>
            </div>
        </div>


        <%-- Img tag is used to import image --%>
        <div class="form-group">
            <label class="col-sm-4 control-label">Image *</label>
            <div class="col-sm-4">
                <img src="images/placeholder.jpg" class="img-responsive" height="50" width="75" alt="Edit"/>
                <button type="button" class="btn btn-primary">Browse</button>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-4 control-label"># Participants *</label>
            <div class="col-sm-4"> 
                <input type="text" class="form-control" name="participants" value="${editStudy.requestedParticipants}" required/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-4 control-label"># Answers *</label>
            <div class="col-sm-4">
                <select class="form-control" id="edit_study_answers" name="numOfChoice">
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select> 
            </div>
        </div>


        <div id="TextBoxContainer1">
            <!--Textboxes will be added here -->
        </div>


        <div class="form-group">
            <label class="col-sm-4 control-label">Description *</label>
            <div class="col-sm-4"> 
                <textarea name="description" class="form-control" required>${editStudy.description}</textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-4">
                <button type="submit"  class="btn btn-primary">Update</button>
            </div>
        </div>
        <br/><br/><br/>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>