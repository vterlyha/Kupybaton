window.onload = function sortTable() {
	var rows = $('#NotChoosedProducts tbody  tr').get();
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
		$('#NotChoosedProducts').children('tbody').append(row);
	});
};