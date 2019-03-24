	$(function() {
	    $('body').removeClass('fade-out');
	});
	
	var scroll = new SmoothScroll('a[href*="#"]',{
		offset: 75
	});
  
	$('.start-modal').on("click", function(){
		var animalId = $(this).attr('data-animal-id');
		$('#animalModalTitle').text("Szczegóły zwierzaka");
		loadAnimalDetails(animalId);
		$('#animalDetails').modal('show');		
	});	
	
	$('.start-comment-modal').on("click", function(){
		var commentAnimalId = $(this).attr('data-animal-id');
		$('#animalIdComment').val(commentAnimalId);
		$('#commentModal').modal('show');	
	});	
	
	$('#addNewButton').on("click", function(event){
		event.preventDefault();
		$('#animalModalFormTitle').text("Dodawanie nowego zwierzaka");
		loadAnimalEditForm(0);
		$('#animalModalForm').modal('show');	
	});
	
	$('#add-comment-form').submit(function(event){
		event.preventDefault();
		
		var $form = $( this ),
	    	url = $form.attr( 'action' );
		 
		var animalId = $('#animalIdComment').val();
		var text = $('#commentTextInput').val();
		var author = $('#commentAuthorInput').val();
		
		$.post( url, {			
			animalId: animalId,
			author: author,
			text: text }, 
			function(){		
			location.reload();
		});
	});	
	
	$('#cancelComment').on('click', function(){
		$('#commentTextInput').val("");
		$('#commentAuthorInput').val("")
		$('#commentModal').modal('hide');
	});
	 
	function loadAnimalDetails( animalId ){
		$('#modal-cont-details').fadeOut('1000', function() {				
			$('#modal-cont-details').load('/animal-details', { animalId: animalId });
		}).fadeIn('1000');
	};	
	
	function loadAnimalEditForm (animalId ){
		$('#modal-cont-form').fadeOut('1000', function() {
			if(animalId == 0){
				$('#modal-cont-form').load('/add-new-animal');
			} else {
				$('#modal-cont-form').load('/edit-animal', { animalId: animalId });
			}			
		}).fadeIn('1000');
	};
  
	