<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>
<%

    int tr = Integer.parseInt(request.getParameter("width")); //가로
    int td = Integer.parseInt(request.getParameter("height")); //세로
 
   
%>

<c:set var="index" value="1"/>
<div style="text-align: center">
    <form action="roomTableForm.roomSet" method="post">
        <table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">
            <tbody>


            <c:forEach var="i" begin="1" end="<%=td%>" step="1">
                <tr style="border : 3px solid black; border-collapse : collapse;">
                    <c:forEach var="j" begin="1" end="<%=tr%>" step="1">

                        <td style="width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${index } : 
                        	 <input type="text" name="seat" placeholder="여기에 뽑히신 아이디를 적어주세요 ">
                            

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

<!-- public void startRandomSeat(HttpServletRequest request, HttpServletResponse response) {
		String roomnumber = request.getParameter("roomnumber");
		int winningNum = 3;
		ArrayList<String> applyUserList = adao.getApply(roomnumber);
		Set<String> winningUser = new HashSet<>();
		Random random = new Random();

		while(applyUserList.size() >= winningNum) {
			while(winningUser.size() != winningNum) {
				winningUser.add(applyUserList.get(random.nextInt(applyUserList.size())));
			}
			 
	 		applyUserList.removeAll(winningUser); 
	 		winningUser.clear();
	 		System.out.println(applyUserList); 
	 		System.out.println(winningUser); 
		
			 
		}
		
		System.out.println(applyUserList); 
 		 

	}
	 -->
	