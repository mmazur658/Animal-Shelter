var scroll = new SmoothScroll('a[href*="#"]',{
				offset: 75
	});

	$(function() {
		   $('body').removeClass('fade-out');
	});

	$(document).ready(function() {
		loadCategoryList();
	});
	
	function loadCategoryList(){
		$('#tablePlaceholder').fadeOut('1000', function() {				
			$('#tablePlaceholder').load('/list');
		}).fadeIn('1000');
	};	
	
	$('#addCategory').on('click', function(){
		
		var category = $('#categoryInput').val();		
		console.log(category);
		
		if(category != null || category != ""){
			
			var url = '/category/add-category';
			
			$.post(	url, {category: category},	function(data){
				
				if(data){
					$('#messageHolder').text("Kategoria została dodana");
					$('#messageHolder').removeClass();
					$('#messageHolder').addClass("alert alert-success");
					loadCategoryList();					
				} else {
					$('#messageHolder').text("Błąd dodawania kategorii");
					$('#messageHolder').removeClass();
					$('#messageHolder').addClass("alert alert-danger");
				}			
	
			});			
		}
				
	});