<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Z/OS report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous"/>
</head>
<body>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse" style="width: 70%;left:15%;">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">XmlGen</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div style="width: 70%;left:15%;position: relative;padding: 100px;border: 1px solid;">

    <form:form action="sendtoftp" method="post" modelAttribute="pageInfo">
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Application name</span>
            <form:input path="applicationName" type="text" class="form-control" name="name"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Project/CR id</span>
            <form:input path="prodect_CR_ID" type="text" class="form-control" name="prodect_CR_ID"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Requester</span>
            <form:input path="requester" type="text" class="form-control" name="requester"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Transfer date</span>
            <form:input path="transferDate" type="text" class="form-control" name="transferDate"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Region</span>
            <form:input path="region" type="text" class="form-control" name="region"/>
        </div>
        <details>
            <summary>Promote Overlays</summary>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item name</span>
                <form:input path="items[0].name" type="text" class="form-control" name="item-name" value="Promote Overlays"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item value</span>
                <form:input path="items[0].dataSets[0].itemValue" type="text" class="form-control" name="itemValue"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item remark</span>
                <form:input path="items[0].dataSets[0].itemRemark" type="text" class="form-control" name="itemRemark"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[0].dataSets[0].members[0]" type="text" class="form-control" name="member"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[0].dataSets[0].members[1]" type="text" class="form-control" name="member"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[0].dataSets[0].members[2]" type="text" class="form-control" name="member"/>
            </div>
        </details>
        <details>
            <summary>Promote PLI sources (CEMA)</summary>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item name</span>
                <form:input path="items[1].name" type="text" class="form-control" name="item-name" value="Promote PLI sources (CEMA)"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item value</span>
                <form:input path="items[1].dataSets[0].itemValue" type="text" class="form-control" name="itemValue"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Item remark</span>
                <form:input path="items[1].dataSets[0].itemRemark" type="text" class="form-control" name="itemRemark"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[1].dataSets[0].members[0]" type="text" class="form-control" name="member"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[1].dataSets[0].members[1]" type="text" class="form-control" name="member"/>
            </div>
            <div class="input-group" style="margin-bottom: 10px;">
                <span class="input-group-addon">Member</span>
                <form:input path="items[1].dataSets[0].members[2]" type="text" class="form-control" name="member"/>
            </div>
        </details>
        <input class="btn btn-primary" style="bottom: 10px; right: 10px; position: absolute;" type="submit" value="Send"/>
    </form:form>

    <!--<a class="btn btn-default" href="/sendtoftp" role="button">Send</a>-->

</div>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>