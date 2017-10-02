

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach items="${viewModel.jss}" var="script">
    <c:choose>
        <c:when test="${fn:contains(script, http)}">
            <script src="${script}"></script>
        </c:when>
        <c:otherwise>
            <script src="${innerPrefix}${script}"></script>
        </c:otherwise>
    </c:choose>

</c:forEach>
<script>
    Config.set('assets', 'assets');
</script>

<script>
    (function(document, window, $) {
        'use strict';
        var Site = window.Site;
        $(document).ready(function() {
            Site.run();
        });
        Waves.init();
        Waves.attach('.button', ['waves-button', 'waves-float']);
    })(document, window, jQuery);
</script>
</body>

</html>