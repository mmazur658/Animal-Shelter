$('#edit-animal-button').on('click', function(){
		var animalId = $('#animamIdHolder').attr('data-animal-id');
		loadAnimalEditForm(animalId);		
	});

	$(document).ready(function(){
		
		var addNew = $('#animal-form').attr('data-add-new');
		
		$('#cancelBtn').on('click',function(){
			if(addNew){				
				$('#animalModalForm').modal('hide');
			} else {
				$('#animalModalForm').modal('hide');
				loadAnimalDetails($('#animamIdHolder').attr('data-animal-id'));
				$('#animalDetails').modal('show');
			}
			
		});		

		$('#animal-form').submit(function(event){
			
			event.preventDefault();
			
			 var $form = $( this ),
		    	url = $form.attr( 'action' );
			
			var animalId = $('#animalIdInput').val();
			var animalName = $('#animalNameInput').val();
			var animalAge = $('#animalAgeInput').val();
			var animalCategory = $('#categorySel').val()
			var animalDesc = $('#animalDescTextArea').val();
			
			$.post( url, {
				animalId: animalId, 
				animalName: animalName,
				animalAge: animalAge, 
				animalCategory: animalCategory, 
				animalDesc: animalDesc},
				function(){	
					if(addNew){
						location.reload();
					}
			});
			
			if(addNew){
				$('#animalModalForm').modal('hide');	
			} else {
				$('#animalModalForm').modal('hide');	
				loadAnimalDetails(animalId);
				$('#animalDetails').modal('show');	
			}					
			 
		});	
	});
