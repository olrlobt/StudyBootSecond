<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>

	<section class="container-fluid container-lg-8 mt-5">
			<div class = " justify-content-center mt-5" >
				<div class = "boardDetailbody">
				<div  id="boardSection" class="shadowBox">
				
					<div class="board-url">
						디테일이다아아아ㅏ
					</div>
						<div class="board-title">
							${list.title }
						</div>
						
						<div  class="board-writerSection">
							
							<div>
								<div  class="board-userId">
									${list.writer }
								</div>
								<div class="board-info">
									${list.regDate } 조회수 ${list.hit }
								</div>
							</div>
						</div>
						<hr>
						<div class="board-contents">
						     ${list.contents }
						</div>
					 
					</div>
				</div>
			</div>
		
	</section>
</body>
</html>