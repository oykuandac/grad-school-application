<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.js"/>
<script type="text/javascript" src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
		<div class = "card">			
			<div class = "card-block">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>							
						</tr>
					</thead>					
					<tbody>
						<tr th:each="application :${data.content}">
							<td th:text="${application.id}"></td>
							<td th:text="${application.name}"></td>						
						</tr>
					</tbody>
				</table>
			
			</div>
		
		</div>	
	</div>
	</body>
</html>