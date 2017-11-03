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
            <span class="input-group-addon">Name</span>
            <form:input path="name" type="text" class="form-control" name="name"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Method</span>
            <form:input path="method" type="text" class="form-control" name="method"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">Action</span>
            <form:input path="action" type="text" class="form-control" name="action"/>
        </div>
        <div class="input-group" style="margin-bottom: 10px;">
            <span class="input-group-addon">File</span>
            <form:input path="file" type="text" class="form-control" name="file"/>
        </div>
        <input class="btn btn-primary" type="submit" value="Send"/>
    </form:form>

    <a class="btn btn-default" href="/sendtoftp" role="button">Send</a>

</div>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>