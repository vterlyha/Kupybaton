$(document).ready(function() {
	$("#myTableChoosedProducts tbody tr").click(function() {
		var row = $(this).remove().clone();
		$('#myTableUnchoosedProducts').children('tbody').append(row);

	});
});