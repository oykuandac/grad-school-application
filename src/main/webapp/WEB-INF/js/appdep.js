

$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href,function(app,status){
			console.log(app)
			$('.myForm #id').val(app.id);
			var date = app.interview.date
			date = date.slice(0, -9);
			$('.myForm #date').val(date);
			$('.myForm #location').val(app.interview.location);

		});
		
		$('.myForm #exampleModal').modal();
	});
	
});