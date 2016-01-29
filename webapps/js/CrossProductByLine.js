$(document).ready(function() {
	$("#myTableChoosedProducts tbody tr").click(function() {
		$(this).css({
			'text-decoration' : 'line-through'
		});
	});
});

