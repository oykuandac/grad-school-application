<!DOCTYPE html>
<html lang="en">
<head>
<title>Upload File</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/fileupload.css">
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="index" class="header-logo">
     <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png" style="width: 80%;">
  </a>
        </div>
    </div>

    <div class="header-section-2">
    </div>
</div> 

<div class="topnav" id="myTopnav">
  <a href="/index" class="active">Home</a>
  <a href="/news">Announcements</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>


<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

</script>

<div class="upload-container">

          
            <form id="multipleUploadForm" name="multipleUploadForm" action = "/uploadFiles" method = "post" enctype="multipart/form-data">     
               <p> Please upload your Transcript!</p>        
                   <input  id="singleFileUploadInput1" type="file" name="files" class="file-input" />
                   <button type="button" class="primary submit-btn" onclick="addtofile()" style="width: 20%;">Add</button> 
                    <p> Please upload photo!</p>  
                    <input  id="singleFileUploadInput2" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile1()">Add</button> 
                    <p> Please upload your English Exam result!</p>  
                    <input  id="singleFileUploadInput3" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile2()">Add</button> 
                     <p> Please upload ALES result!</p>  
                   <input  id="singleFileUploadInput4" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile3()">Add</button> 
                   <p> Please upload Reference Letter!</p>
                   <input  id="singleFileUploadInput5" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile4()">Add</button> 
                  <p> Please upload Statement of Purpose!</p>  
                   <input  id="singleFileUploadInput6" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile5()">Add</button> 
            		<h3>******************Below is Optional******************</h3>
                   <p> Please upload your Passport!(If you are foreign)</p>  
                   <input  id="singleFileUploadInput7" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile6()">Add</button>  
                    <p> Please upload your Master Transcript!(If you want to apply for PhD)</p>
                   <input  id="singleFileUploadInput8" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile7()">Add</button> 
                   <p> Please upload your Permission Letter!(If you are working)</p>
                   <input  id="singleFileUploadInput9" type="file" name="files" class="file-input"/>
                   <button type="button" class="primary submit-btn" onclick="addtofile8()">Add</button> 
                   
                    <div id="uploadFiles">
                    
                    </div>
                                      <br><br>
                   <button type="submit" class="primary submit-btn" onclick="filetoinput()">Save</button>
                   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                   
               </form>

                </div>
       
                </div>

<script type="text/javascript" src="/js/upload.js"></script>

</body>
</html>