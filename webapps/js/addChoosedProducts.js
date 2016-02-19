$(document).ready(function() {
	$('tbody input[type="checkbox"]').change(function() {
		if (this.checked) {
			var row = $(this.closest('tr'));
			row.remove().clone();
			$('#ChoosedProducts').children('tbody').append(row);

		}
		
	});
});