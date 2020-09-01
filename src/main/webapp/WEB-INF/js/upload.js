
var singleFileUploadInput1 = document.querySelector('#singleFileUploadInput1');
var singleFileUploadInput2 = document.querySelector('#singleFileUploadInput2');
var singleFileUploadInput3 = document.querySelector('#singleFileUploadInput3');
var singleFileUploadInput4 = document.querySelector('#singleFileUploadInput4');
var singleFileUploadInput5 = document.querySelector('#singleFileUploadInput5');
var singleFileUploadInput6 = document.querySelector('#singleFileUploadInput6');
var singleFileUploadInput7 = document.querySelector('#singleFileUploadInput7');
var singleFileUploadInput8 = document.querySelector('#singleFileUploadInput8');
var singleFileUploadInput9 = document.querySelector('#singleFileUploadInput9');


var uploadFiles = document.querySelector('#uploadFiles');

var files = [];
var fileStore = [];
var index = 0;


function addtofile(){	
    files.push(singleFileUploadInput1.files[0]);
    
    createDiv(singleFileUploadInput1);  
}

function addtofile1(){	
    files.push(singleFileUploadInput2.files[0]);
	createDiv(singleFileUploadInput2);  
}

function addtofile2(){	
    files.push(singleFileUploadInput3.files[0]);
	createDiv(singleFileUploadInput3);  
}

function addtofile3(){	
    files.push(singleFileUploadInput4.files[0]);
	createDiv(singleFileUploadInput4);  
}

function addtofile4(){	
    files.push(singleFileUploadInput5.files[0]);
	createDiv(singleFileUploadInput5);  
}

function addtofile5(){	
    files.push(singleFileUploadInput6.files[0]);
	createDiv(singleFileUploadInput6);  
}

function addtofile6(){	
    files.push(singleFileUploadInput7.files[0]);
	createDiv(singleFileUploadInput7);  
}

function addtofile7(){	
    files.push(singleFileUploadInput8.files[0]);
	createDiv(singleFileUploadInput8);  
}

function addtofile8(){	
    files.push(singleFileUploadInput9.files[0]);
	createDiv(singleFileUploadInput9);  
}


function createDiv(name){
    var div = document.createElement("div");
    div.id="p"+index;
    index +=  1;
    
    var h = document.createElement("H4");
    h.style = "width: 66%;float: left;"     
    var deleteButton = document.createElement("button");
    var t = document.createTextNode(files[index-1].name);
    h.appendChild(t); 
    div.appendChild(h);
    
    deleteButton.type = "button";
    deleteButton.innerHTML = "Delete File";
    deleteButton.style = "background-color: #424242;color: #FFFFFF;width: 20%;margin-top: 25px;"
    uploadFiles.appendChild(div);   
    div.appendChild(deleteButton);
    deleteButton.onclick = function(){
    	removefromlist(div.id,name);
    } 
	
}


function removefromlist(i,name){
	var fileArray = Array.from(name.files);	
	var res = i.substring(1, 3);
	res = parseInt(res);
	files.splice(res,1);
	fileArray.splice(res,1);	
	name.files =new FileListItem(fileArray);	
	index = index -1;
	var pItem = document.getElementById(i);
	uploadFiles.removeChild(pItem);
}



function filetoinput(){
	for (i = 0; i < files.length; i++)
		fileStore.push(files[i]); 
	console.log(singleFileUploadInput1.files);
	singleFileUploadInput1.files = new FileListItem(fileStore);
	document.getElementById('singleFileUploadInput2').value = "";
	document.getElementById('singleFileUploadInput3').value = "";
	document.getElementById('singleFileUploadInput4').value = "";

	console.log(singleFileUploadInput1.files);

}

function FileListItem(a) {
	  a = [].slice.call(Array.isArray(a) ? a : arguments)
	  for (var c, b = c = a.length, d = !0; b-- && d;) d = a[b] instanceof File
	  if (!d) throw new TypeError("expected argument to FileList is File or array of File objects")
	  for (b = (new ClipboardEvent("")).clipboardData || new DataTransfer; c--;) b.items.add(a[c])
	  return b.files
	}