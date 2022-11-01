<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temp/boot.jsp"></c:import>
	<link href="/css/board.css" rel="stylesheet">
</head>
<body>


<div class = "boardList col-lg-7" style="min-width: 700px; margin: auto; margin-top: 100px;">
<h1> 리스트 다아아아아앙</h1>
<table class="table table-hover">
				  <thead>
				    <tr>
				      <th scope="col" width="140px">글 번호</th>
				      <th scope="col" width="450px">글 제목</th>
				      
				      <th scope="col" width="150px">작성자</th>
				      <th scope="col" width="200px">게시일</th>
				      
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${list }" var="dto">
				  		<tr>
						  	<td scope="row" style="color: #676e74;">${dto.num}</td>
						  	<td><a href="./detail?num=${dto.num }" style="color: black;">${dto.title }</a></td>
					        <td>${dto.writer }</td>
    						 <td>${dto.regDate }</td>
    						
			        	</tr>
				  	</c:forEach>
				  
				  	
				  </tbody>
				</table>
				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				  	<c:choose>
				  		<c:when test="${pager.startNum <= 1}">
				  			<li class="page-item disabled">
				      			<a class="page-link">Previous</a>
							</li>
				  		</c:when>
				  		<c:otherwise> 
				  		<li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
				  		</c:otherwise>
				  	</c:choose>
				  	
				  		<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
						  			<li class="page-item"><a class="page-link" href="./list?page=${i}${pager.param}">${i}</a></li>
					  	</c:forEach>
				   	 	<c:choose>
				  		<c:when test="${pager.lastNum >= pager.totalPage}"> 
				  			<li class="page-item disabled">
				  			<a class="page-link" href="./list?page=${pager.lastNum+1}">Next</a>
						  </li>
				  		</c:when>
				  		<c:otherwise> 
				  		 	<li class="page-item">
				  		 	<a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
						  </li>
				  		</c:otherwise>
				  	</c:choose>
				  </ul>
				</nav>
				
				
				<div >
				
				<form class="row row-cols-lg-auto g-3 align-items-center" action="./list" method="get">
					  <div class="col-12">
					    <label class="visually-hidden" for="kind">Kind</label>
					    <select name="kind" class="form-select"  id="kind">
					      <option class = "kinds" selected value="title">제목</option>
					      <option class = "kinds" value="contents">내용</option>
					      <option class = "kinds" value="userId">작성자</option>
					    </select>
					  </div>
						<div class="col-12">
				  	  		<label class="visually-hidden" for="search">검색어</label>
						    <div class="input-group">
						      <input type="text" name="search" class="form-control" id="search" value="${search.search }">
						    </div>
				 		 </div>
				
					  <div class="col-12">
					    <button type="submit" class="boardBlueBtn">검색</button>
					  </div>
					  
				</form>
						<div class="col-12 boardBlueBtn" style="color: white;" >
					    <a href="/board/add" class="" style="color: white; ">글쓰기</a>
					  </div>
				</div>
				</div>
</body>
</html>