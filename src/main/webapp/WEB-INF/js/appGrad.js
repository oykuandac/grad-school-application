

$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href,function(app,status){
			$('.myForm #id').val(app.id);
			$('.myForm #email').val(app.user.email);

		});
		
		$('.myForm #exampleModal').modal();
	});
	
});

$(document).ready(function(){
	$('.table .eBtnn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(files,status){
			$("#fileList").empty();
			for (i = 0; i < files.length; i++) {
				$("#fileList").append('<li><form action="/downloadFile/'+files[i].id+'" method="get"><a href="#" onclick="this.parentNode.submit()">'+files[i].fileName+'</a> </form></li>');

				}
			
		});
		
		$('.myForm2 #exampleModal2').modal();
	});
	
});

$(document).ready(function(){
	$('.table .eBtnnn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(preApp,status){
			console.log(preApp)
			$('.myForm3 #name').text("Name: "+ preApp.name);
			$('.myForm3 #surname').text("SurName: "+preApp.surName);
			$('.myForm3 #gender').text("Gender: "+preApp.gender);
			$('.myForm3 #birthdate').text("Birthdate: "+preApp.birthDate);
			$('.myForm3 #number').text("Number: "+preApp.number);
			$('.myForm3 #nationality').text("Nationality: "+preApp.nationality);
			$('.myForm3 #citizen').text("Citizen: "+preApp.citizen);
			$('.myForm3 #working').text("Working Status: "+preApp.status);
			$('.myForm3 #degree').text("Applied Degree: "+preApp.degree);
			$('.myForm3 #tcno').text("TC No/Password No: "+preApp.tcno);
			$('.myForm3 #addres').text("Address: "+preApp.address);
			$('.myForm3 #uni').text("Address: "+preApp.university);
			$('.myForm3 #dept').text("Applied Department: "+preApp.dept);
			$('.myForm3 #gpa').text("Gpa: "+preApp.gpa);
			$('.myForm3 #ales').text("Ales: "+preApp.ales);
		});
		
		$('.myForm3 #exampleModal3').modal();
	});
	
});