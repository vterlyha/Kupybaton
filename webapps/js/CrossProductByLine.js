$(document).ready(function() {
	$('tbody input[type="checkbox"]').change(function() {
		if (this.checked) {
			var a = $(this.closest('tr'));
			a.css({
				'text-decoration' : 'line-through'
			});
		}
	});
});

