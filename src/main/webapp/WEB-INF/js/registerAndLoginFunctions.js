/**
 * 
 */
function checkName(){
    var message = "";
    var name = document.getElementById("name");
    var nameStr = name.value;
    if(nameStr == ""){
        message = message + "Name cannot be blank!!! \n";
    }
    if(nameStr.length > 20){
        message = message +"Name cannot be bigger than 20 \n";
        name.value="";
    }
    return message;
}
function checkSurName(){
    var message = "";
    var surName = document.getElementById("surname");
    var surNameStr = surName.value;
    if(surNameStr == ""){
        message = message + "Surname cannot be blank!!! \n";
    }
    return message;
}

function checkMail(){
    var message = "";
    var e_mail = document.getElementById("e_mail");
    var e_mailStr = e_mail.value;
    if(e_mailStr == ""){
        message = message + "E_mail cannot be blank!!! \n";
    }
    return message;
}

function checkPassword(){
    var message = "";
    var password = document.getElementById("password");
    var passwordStr = password.value;
    if(passwordStr == ""){
        message = message + "Password cannot be blank!!! \n";
    }
    return message;

}


function registerFunction(){
    var form = document.getElementById("form");
    var message = checkName() + checkSurName() + checkMail() + checkPassword();
    if(message == ""){form.submit();}
    else window.alert(message);
}


function loginFunction(){
    var form = document.getElementById("form");
    var message = checkMail() + checkPassword();
    if(message ==""){form.submit();}
    else window.alert(message);
}