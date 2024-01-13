<%@ page import="com.sa.roomset.model.RoomSetVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>
<%

    int tr = Integer.parseInt(request.getParameter("width")); //가로
    int td = Integer.parseInt(request.getParameter("height")); //세로
    RoomSetVO RVO = (RoomSetVO) request.getAttribute("RVO");
    request.setAttribute("RVO", RVO);
%>

<%--    <form action="roomTableForm.roomSet" method="post">--%>
<%--        <table style="margin-left: auto; margin-right: auto;" border="2">--%>
<%--            <h3>제외할 좌석을 선택해주세요.</h3>--%>
<%--            <br>--%>

<%--            <% for (int i = 1; i <= tr; i++) { %>--%>
<%--                  <tr style="text-align: center;">--%>
<%--                <% for (int j = 1; j <= td; j++) { %>--%>
<%--                      <td class="form-group" style="text-align: center;">--%>
<%--                          <small><%="<" + j + ">"%></small><br>--%>
<%--                          <input type="checkbox" id="seat" name="seat" value="<%=j%>">--%>
<%--                      </td>--%>
<%--                <%} %>--%>
<%--                  </tr>--%>
<%--            <%} %>--%>
<%--        </table>--%>

<%--        <br>--%>

<%--        <input type="submit" value="방 생성">--%>
<%--    </form>--%>

<c:set var="index" value="1"/>
<div style="text-align: center">
    <form action="roomTableForm.roomSet" method="post">
        <table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">
            <tbody>


            <c:forEach var="i" begin="1" end="<%=td%>" step="1">
                <tr style="border : 3px solid black; border-collapse : collapse;">
                    <c:forEach var="j" begin="1" end="<%=tr%>" step="1">

                        <td style="width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${index }
                            <input type="checkbox" name="seat" value="${index }"/></td>

                        <c:set var="index" value="${index + 1 }"/>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <br><br>
        <input type="submit" value="좌석선택"/><br>
    </form>
</div>


<%@ include file="/include/footer.jsp" %>