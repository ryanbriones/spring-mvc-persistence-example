<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <ul>
      <c:forEach items="${words}" var="word">
        <li>${word.value} (${word.count}|${word.classification})</li>
      </c:forEach>
    </ul>
  </body>
</html>