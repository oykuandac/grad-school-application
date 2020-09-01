

$(document).ready(function(){
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var input = $(this).attr('input');
		
		$.get(input,function(interview,status){
			console.log(interview.id)
			$('.form-control #note').val(interview.note);			
		});
		
		$('.myForm #exampleModal').modal();
	});
	
});