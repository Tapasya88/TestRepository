// Empty JS for your own code to be here


    	 var frm = $('#detailsForm');
    	    frm.submit(function (ev) {
    	        $.ajax({
    	            type: frm.attr('method'),
    	            url: frm.attr('action'),
    	            data: frm.serialize(),
    	            success: function (data) {
    	            	$('#sucessid').show();
    	            }
    	        });

    	        ev.preventDefault();
    	    });

    	    function getDetails(){
    	    	
    	    	var srh = $("input[name=exampleInputClient]").val();;
    	    	var url = "/test-app/ClientServlet?search=y&exampleInputClient="+srh;
    	    	$.ajax({
    	    		url: url,
    	    		dataType:'json',
    	    		type:'post',
    	    		success: function(response){
    	    		var json_obj = $.parseJSON(JSON.stringify(response));
    	    		alert(json_obj);
    	    		populate('#detailsForm', json_obj);
    	        }});
    	    }
    	    
    	    function populate(frm, data) {
    	    	  $.each(data, function(key, value){
    	    	    $('[name='+key+']', frm).val(value);
    	    	  });
    	    	}
    	    
    	    function resetForm(){
    	    	$('#detailsForm')[0].reset();
    	    	$('#sucessid').hide();
    	    }
