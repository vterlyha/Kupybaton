$(document).ready(function() {
	$('tbody input[type="checkbox"]').change(function sortTable() {
		var rows = $('#ChoosedProducts tbody  tr').get();
		rows.sort(function(a, b) {
			var A = $(a).children('td').eq(0).text().toUpperCase();
			var B = $(b).children('td').eq(0).text().toUpperCase();

			if (A < B) {
				return -1;
			}

			if (A > B) {
				return 1;
			}

			return 0;

		});

		$.each(rows, function(index, row) {
			$('#ChoosedProducts').children('tbody').append(row);
		});
	});
});
