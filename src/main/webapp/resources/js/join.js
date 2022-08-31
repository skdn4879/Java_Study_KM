
const msgUserName = document.getElementById("msgUserName");
const userName = document.getElementById("userName");
const userNameMinLimit = 2;
let userNameCheck = false;

userName.addEventListener("blur", function(){
    if(userName.value.length < userNameMinLimit){
        msgUserName.innerHTML = '<h6 style="color:red;"> 2글자 이상 작성하세요.</h6>';
        userNameCheck = false;
    } else{
        msgUserName.innerHTML = "";
        userNameCheck = true;
    }
});

const password = document.getElementById("password");
const msgPassword = document.getElementById("msgPassword");
const passwordMinLimit = 6;
let passwordFlag = false;

password.addEventListener("keyup", function(){
    if(password.value.length < passwordMinLimit){
        msgPassword.innerHTML = '<h6 style="color:red;"> 6글자 이상 작성하세요.</h6>';
        passwordFlag = false;
    } else{
        msgPassword.innerHTML = "";
        passwordFlag = true;
    }
});
password.addEventListener("change", function(){
    passwordCheck.value = "";
    passwordCheck.focus();
});

const passwordCheck = document.getElementById("passwordCheck");
const msgPasswordCheck = document.getElementById("msgPasswordCheck");
let passwordCheckFlag = false;

passwordCheck.addEventListener("blur", function(){
    if(passwordCheck.value == password.value && password.value.length > 0){
        msgPasswordCheck.innerHTML='<h6>비밀번호가 일치합니다.<h6>';
        passwordCheckFlag = true;
    } else{
        msgPasswordCheck.innerHTML='<h6 style="color:red;">비밀번호가 일치하지 않습니다.<h6>';
        passwordCheckFlag = false;
    }
});

/*const addOn = document.getElementsByClassName("addOn");
const msgAddOn = document.getElementsByClassName("msgAddOn");
let addOnCheck = [];

for(let i = 0; i < addOn.length; i++){
    addOnCheck[i] = false;
}

for(let i = 0; i < addOn.length; i++){
    addOn[i].addEventListener("blur", function(){
        if(addOn[i].value.length < 1){
            msgAddOn[i].innerHTML = '<h6 style="color:red;">정확히 작성해주세요.<h6>';
            addOnCheck[i] = false;
        } else{
            msgAddOn[i].innerHTML = "";
            addOnCheck[i] = true;
        }
    });
}*/
const uname = document.getElementById("name");
const msgName = document.getElementById("msgName");
let nameCheck = false;

uname.addEventListener("blur", function(){
    if(uname.value.length < 1){
        msgName.innerHTML = '<h6 style="color:red;">정확히 작성해주세요.<h6>';
        nameCheck = false;
    } else{
        msgName.innerHTML = "";
        nameCheck = true;
    }
});

const email = document.getElementById("email");
const msgEmail = document.getElementById("msgEmail");
let emailCheck = false;

email.addEventListener("blur", function(){
    if(email.value.length < 1){
        msgEmail.innerHTML = '<h6 style="color:red;">정확히 작성해주세요.<h6>';
        emailCheck = false;
    } else{
        msgEmail.innerHTML = "";
        emailCheck = true;
    }
});

const phone = document.getElementById("phone");
const msgPhone = document.getElementById("msgPhone");
let phoneCheck = false;

phone.addEventListener("blur", function(){
    let k = phone.value.match(/^\d{3}-\d{4}-\d{4}$/);
    //console.log(k);
    if(k == null){
        msgPhone.innerHTML = '<h6 style="color:red;">010-0000-0000으로 입력하세요.<h6>';
        phoneCheck = false;
    } else{
        msgPhone.innerHTML = "";
        phoneCheck = true;
    }
});

const btnSign = document.getElementById("btnSign");
const joinFrm = document.getElementById("joinFrm");

btnSign.addEventListener("click", function(){
    /*console.log("userName : ", userNameCheck);
    console.log("password : ", passwordFlag);
    console.log("passwordCheck : ", passwordCheckFlag);
    for(let i = 0; i < addOnCheck.length; i++){
        console.log("addOn", i, addOnCheck[i]);
    }*/

    if(!userNameCheck){
        alert("UserName을 양식에 맞게 입력해주세요.");
        return;
    }
    if(!passwordFlag){
        alert("비밀번호를 양식에 맞게 입력해주세요.");
        return;
    }
    if(!passwordCheckFlag){
        alert("비밀번호 확인이 일치하지 않습니다.");
        return;
    }
    /*for(let i = 0; i < addOnCheck.length; i++){
        if(!addOnCheck[i]){
            alert(addOn[i].placeholder + " 부분을 양식에 맞게 써주세요.");
            return;
        }
    }*/
    if(!nameCheck){
        alert("이름을 입력하세요.");
        return;
    }
    if(!emailCheck){
        alert("이메일을 입력하세요.");
        return;
    }
    if(!phoneCheck){
        alert("휴대폰 번호를 양식에 맞춰 입력하세요.");
        return;
    }

    joinFrm.submit();

});