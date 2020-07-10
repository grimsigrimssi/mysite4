<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/mysite2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/mysite2/assets/css/board.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //header & navi -->

		<c:import url="/WEB-INF/views/includes/asideUser.jsp"></c:import>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">일반게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
			
				<div id="list">
				
					<form action="/WEB-INF/views/board/list.jsp" method="get">
						<div class="form-group text-right">
							<input type="text">
							<button type="submit" id=btn_search>검색</button>
						</div>
						
						<input type="hidden" name="action" value="listSearch">
					</form>
					
					<c:forEach items="${bList }" var="vo" varStatus="status">
					<table class="boardRead">
						<thead>
							<tr>
								<th>${vo.no }</th>
								<th>${vo.title }</th>
								<th>${vo.name }</th>
								<th>${vo.hit }</th>
								<th>${vo.reg_date }</th>
								<th>${vo.user_no }</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>123</td>
								<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
								<td>정우성</td>
								<td>1232</td>
								<td>2020-12-23</td>
								<td><a href="">[삭제]</a></td>
							</tr>
							<tr>
								<td>123</td>
								<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
								<td>정우성</td>
								<td>1232</td>
								<td>2020-12-23</td>
								<td><a href="">[삭제]</a></td>
							</tr>
							<tr>
								<td>123</td>
								<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
								<td>정우성</td>
								<td>1232</td>
								<td>2020-12-23</td>
								<td><a href="">[삭제]</a></td>
							</tr>
							<tr>
								<td>123</td>
								<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
								<td>정우성</td>
								<td>1232</td>
								<td>2020-12-23</td>
								<td><a href="">[삭제]</a></td>
							</tr>
							<tr class="last">
								<td>123</td>
								<td class="text-left"><a href="#">게시판 게시글입니다.</a></td>
								<td>정우성</td>
								<td>1232</td>
								<td>2020-12-23</td>
								<td><a href="">[삭제]</a></td>
							</tr>
						</tbody>
					</table>
					<!-- boardRead -->
					</c:forEach>	
		
					<div id="paging">
						<ul>
							<li><a href="">◀</a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li class="active"><a href="">5</a></li>
							<li><a href="">6</a></li>
							<li><a href="">7</a></li>
							<li><a href="">8</a></li>
							<li><a href="">9</a></li>
							<li><a href="">10</a></li>
							<li><a href="">▶</a></li>
						</ul>
						
						
						<div class="clear"></div>
					</div>
					<a id="btn_write" href="">글쓰기</a>
				
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>
</html>