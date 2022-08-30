
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const comment = document.getElementById("comment");

btn.addEventListener("click", function(){
    console.log("submit clicked");

    let idLen = inputId.value;
    let pwLen = inputPw.value;

    if(idLen.length == 0){
        alert("ID는 필수입니다.");
        //comment.innerHTML("<h5>ID는 필수입니다.</h5>");
        return;
    }

    if(pwLen.length == 0){
        alert("PW는 필수입니다.");
        //comment.innerHTML("<h5>PW는 필수입니다.</h5>");
        return;
    }

    frm.submit();

    //console.log(idLen);
    //console.log(pwLen);

    /*if(idLen.length > 0 && pwLen.length > 0){
        frm.submit();
    } else{
        alert("ID와 PW는 필수 입력입니다.");
    }*/
    
    //frm.submit();
    // A1, B4, C1, D6
});
