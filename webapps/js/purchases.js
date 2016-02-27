$(document).ready(function() {
	
	window.onload = function () {		
		 var rows = $('#NotChoosedProducts tbody  tr');		
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
			$('#NotChoosedProducts tbody').append(row);		
		});
		
	};
		
	
    $('tbody input[type="checkbox"]').change(function() {
    	if (this.checked) {
            
    		var row = $(this.closest('tr'));
            row.css({
                      'text-decoration' : 'line-through'
                  });
                   
			row.remove().clone();
			$('#ChoosedProducts').children('tbody').append(row);

		}
    	
    	var rows = $('#ChoosedProducts tbody  tr');
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
            $('#ChoosedProducts tbody').append(row);
        });
        
    });

    
	$(".changeSmth").click(function() {
        $(".dropdown-content").show();
              
    });
	

	window.onclick = function(event) {
		if (!event.target.matches('.changeSmth')) {
			$(".dropdown-content").hide();
		}
	};

    

    var $product = $("select[name='productId']");
    $product.on("change", function() {
        var selectedProduct = $("option:selected", $product).val();
        $("#productUnit").text(productVsUnit[selectedProduct]);
    });
    
    
    
   
});

