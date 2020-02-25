    $("#send").click(function(){
        var msg = $("#text-box").val();
        
        $("#this-message").text(msg);

        var markup = "<tr><td>" + msg + "</td></tr>";
        
       /* $("table tbody").append(msg);*/
        
        $("#text-box").val("");


    });

function AI_function(){
	var Chat_Array = [
	["hello", "hi, how are you"],
	["how is your day", "my day is great so far"]
	];

	for (e=0; e< len(Chat_Array); e++){
		if (msg.include(Chat_Array[e][0]) == true)
			var AI_response = chat_Array[e][0]

		return AI_response;


	}
					  	 
}

