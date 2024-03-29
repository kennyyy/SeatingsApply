<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>

	<div class="form-group" ">
        <h3>랜덤 버튼 : ${msg } <input class="ran_btn" type="button" name="RANDOMCYCLE" value="랜덤 뽑기" onclick="randomChoose(${userList.size()}, ${winNum})"> 
        [누를때마다 정하신 당첨인원이 랜덤으로 뽑힙니다.] </h3>
       <input style="font-size: 30px; font-weight: bold;" type="text"  value= "대기 중인 유저 : ${userList }" /> 
       <input style="font-size: 30px; font-weight: bold;" type="text"  value= "당첨 순서 : ${remainUser }" />
 	</div> 
 	<h3 style="text-align: center;">[이쪽이 칠판] </h3>
<c:set var="index" value="1"/>
<div style="text-align: center">
    <form action="./result.apply" method="post">
        <table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">
            <tbody>


            <c:forEach var="i" begin="1" end="${height }" step="1">
                <tr style="border : 3px solid black; border-collapse : collapse;">
                    <c:forEach var="j" begin="1" end="${width }" step="1">

                        <td style="width: 200px; height:30px; border : 3px solid black; border-collapse : collapse;"><b>${index }</b> 
                        	 <input style="text-align: center;" type="text" name="seat"  placeholder="유저를 적어주세요.">
                            

                        <c:set var="index" value="${index + 1 }"/>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
		
		<div id="interval-time"></div>
		
        <br>
        <input type="submit" value="좌석 확정 하기"/><br>
    </form>
</div>
<script type="text/javascript">
	function randomChoose(listSize, winNum)  {
	  	
		var a = 2;
		var x = window.setInterval(() => {
			
			document.getElementById("interval-time").innerHTML = a;
			a--;
			
		}, 1000)

		if(a <= 0) {
			clearInterval(x)
		}
		
		
		window.setTimeout(() => {
			
			if(listSize-winNum <= 0){
				alert("랜덤뽑기가 완료되었습니다. (남은유저 : 0명)");
			}else{
				alert("랜덤 당첨자 뽑기 완료! (남은유저 : "+(listSize - winNum)+"명)");
			}
			location.href='./random.apply';
			
		}, 3000)

	}
	
</script>

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
	