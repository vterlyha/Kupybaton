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

    $('tbody input[type="checkbox"]').change(function() {
        if (this.checked) {
            var a = $(this.closest('tr'));
            a.css({
                      'text-decoration' : 'line-through'
                  });
        }
    });

	$('tbody input[type="checkbox"]').change(function() {
		if (this.checked) {
			var row = $(this.closest('tr'));
			row.remove().clone();
			$('#ChoosedProducts').children('tbody').append(row);

		}

	});

    window.onclick = function(event) {
        if (!event.target.matches('.changeSmth')) {

            var dropdowns = $(".dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    };

    $(".changeSmth").click(function() {
        $("#myDropdown").classList.toggle("show");
    });

    var $product = $("select[name='productId']");
    $product.on("change", function() {
        var selectedProduct = $("option:selected", $product).val();
        $("#productUnit").text(productVsUnit[selectedProduct]);
    })
});

