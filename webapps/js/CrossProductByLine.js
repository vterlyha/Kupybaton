$(document).ready(function() {
	$("#NotChoosedProducts tbody tr").click(function() {
		$(this).css({
			'text-decoration' : 'line-through'
		});
	});
});

