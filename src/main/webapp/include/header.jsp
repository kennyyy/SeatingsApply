<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
    <title>좌석 선택 프로그램</title>
    <style>
		.container{
			background-color: rgba(0, 0, 0, 0.03);
			width: 100wh;

		}
		header{
			
			width: 100%;
			height: 12.5%;
			background-color: #26282A;
			color: white;
		}
		section{
			margin: 0 auto;
			width: 100%;
			height: 670px;
		}
	
		footer{

			position:sticky;
			bootom: 0px;
			width: 100%;
			height: 150px;
			background-color: #26282A;
			color: #fff;
			text-align: center;
		}
		footer p{
			margin: 0px;
			line-height: 150px;
		}
		footer a{
			text-decoration: none;
			color: white;
		}
		.header_container{
			width: 100%;
			height: 100%;
			display: flex;
			justify-content: start;
			align-items: center;
			flex-direction: row;
		
			
		}
		.header_container h1{
			text-align: center;
			padding-right: 100px;
			width: 60%;
			height: 100%;
			line-height: 100px;
			color: white;
			
		}
		a{
		 font-weight: bold;
		}
		
		.section_container{
			width: 60%;
			margin: 80px auto;
			border-radius: 15px;
			
		}
		.ran_btn{
			background-color: #333;
			border-radius: 5px; 
		  	color: white;  
		  	cursor:pointer;
		 	border: none; 
		 	width: 100px; 
		 	height: 30px;
		}
		.ran_btn:hover {
			background-color : gray;
		}
	</style>
</head>
<body id="body-pd">
    <div class="l-navbar expander" id="navbar">
        <nav class="nav">
            <div>
                <div class="nav__brand ">
                    <ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
                    <a href="/" class="nav__logo">Menu</a>
                </div>
                <div class="nav__list">
                    <a href="/" class="nav__link">
                      
                        <span class="nav_name"><b>Home</b></span>
                    </a>
                    
                    <a href="/apply/list.apply" class="nav__link">
      
                        <span class="nav_name">Room Join</span>
                    </a>
               

                    <a href="/room/roomSet.roomSet" class="nav__link">

                        <span class="nav_name">Room Setting</span>
                    </a>
                    
                    <a href="/list.other" class="nav__link">

                        <span class="nav_name">Board</span>
                    </a>

					<c:choose>
						<c:when test="${sessionScope.user_id == null }">
						
	                    <a href="/join.member" class="nav__link">
	                        
	                        <span class="nav_name">Join</span>
	                    </a>
	                    
	               		 <a href="/login.member" class="nav__link">
	
	                   		 <span class="nav_name">Log In</span>
	                    </a>
	                    </c:when>
                    <c:otherwise>
	                    
	                    <a href="/mypage.member" class="nav__link">
	                        
	                        <span class="nav_name">MyPage</span>
	                    </a>
	                    
	               		 <a href="/logout.member" class="nav__link">
	
	                    	<span class="nav_name">Log Out</span>
	                    </a>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
    </div>
    
    <div class="container">
		<header>
			<div class="header_container">

					<h1><a href="/" style="color : white;">HOME</a></h1>
			
			</div>
		</header>
		
		<section>
			<div class="section_container">