
function sendProfileInfoToServlet(){
		var obj = {
				"id": document.getElementById("userId").value,
				"name": document.getElementById("name").value, 
				"work":document.getElementById("work").value, 
				"description":document.getElementById("description").value
				};
           	
         fetch('userProfileInfo', {
                  method: 'POST',
                  headers: {
                    		'Content-Type': 'application/json',
                    	 },
                    	body: JSON.stringify(obj),
                        })
                    	    .then((response) => response.json())
                    		.then((data) => {
                    	console.log('Success:', data);
                  		
   });
}

function sendContactsToServlet(){
	var obj = {
			"id": document.getElementById("userId").value,
			"street": document.getElementById("street").value,
			"town": document.getElementById("town").value, 
			"address":document.getElementById("address").value, 
			"phone":document.getElementById("phone").value
			};
       	
     fetch('userContactInfo', {
              method: 'POST',
              headers: {
                		'Content-Type': 'application/json',
                	 },
                	body: JSON.stringify(obj),
                    })
                	    .then((response) => response.json())
                		.then((data) => {
                	console.log('Success:', data);
              		
});
}

function sendSkillsToServlet(){
	var obj = {
			"id": document.getElementById("userId").value,
			"java": document.getElementById("java").value,
			"html": document.getElementById("html").value
			};
       	
     fetch('userSkillsInfo', {
              method: 'POST',
              headers: {
                		'Content-Type': 'application/json',
                	 },
                	body: JSON.stringify(obj),
                    })
                	    .then((response) => response.json())
                		.then((data) => {
                	console.log('Success:', data);
              		
});
}