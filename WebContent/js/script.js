

var editStatus = function() {
	var html = document.getElementById('status').innerHTML;
	document.getElementById('status').innerHTML="<form action='controller.UpdateStatus' method='get' id='statusform'></form>"
	document.getElementById('statusform').innerHTML="<textarea required name='status' id='statusinput' rows='4' cols='50' placeholder='what&#39;s on your mind?' ></textarea>";
	document.getElementById('statusinput').style="padding:10px;resize:none;display:block;margin:10px auto";
	
	var node1=document.createElement('input');
	node1.type="submit";
	node1.value="Update Status";
	node1.style="margin:5px 10px;display:inline-block;width:10%";
	node1.className +="btn btn-custom btn-block";
	document.getElementById('statusform').appendChild(node1);
	
	var node2=document.createElement('button');
	node2.innerHTML="Cancel";
	node2.type="button";
	node2.addEventListener('click',function(){
		document.getElementById('status').innerHTML=html;
	});
	node2.style="margin:auto;display:inline-block;width:10%;color:indigo";
	node2.className +="btn btn-default btn-block";
	document.getElementById('statusform').appendChild(node2);
};


