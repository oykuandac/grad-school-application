$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href,function(app,status){
			$('.myForm #id').val(app.id);

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