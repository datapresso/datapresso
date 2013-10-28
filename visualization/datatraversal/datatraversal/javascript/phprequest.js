			//===================================================
			//return json file from php/mysql request, simple, no variables passed
			//-------------------------
			function get_json(phpfile){
				var temp;
				
				$.ajaxSetup({'async':false});
				
				$.ajax({
						type:"POST",
						dataType: "json",
						cache: false,
						url: phpfile,
						success: function(data){
									temp = data;
								 }
						}
					   );
					   
				return temp;
		   }
		   //===================================================
		   //return json file from php/mysql request, passing variables
		   //-------------------------
		   function get_json_ext(phpfile,d){
				var temp;
				
				$.ajaxSetup({'async':false});
				
				$.ajax({
						type:"POST",
						dataType: "json",
						cache: false,
						url: phpfile,
						data : d,
						success: function(data){
									temp = data;
								 }
						}
					   );
					   
				return temp;
		   }
		   //===================================================