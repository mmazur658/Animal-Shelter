	$('#edit-animal-button').on('click', function(){
		var animalId = $('#animamIdHolder').attr('data-animal-id');
		$('#animalDetails').modal('hide');
		loadAnimalEditForm(animalId);	
		$('#animalModalForm').modal('show');
	});