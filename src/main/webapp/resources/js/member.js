
function loginCheck(){

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
            //alert("ID는 필수입니다.");
            comment.innerHTML = "<h5>ID는 필수입니다.</h5>";
            return;
        }

        if(pwLen.length == 0){
            //alert("PW는 필수입니다.");
            comment.innerHTML = "<h5>PW는 필수입니다.</h5>";
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
}

function termsCheck(){
    const boxAll = document.getElementById("boxAll");
    const boxes = document.getElementsByClassName("boxes");
    const nextBtn = document.getElementById("nextBtn");
    const termsFrm = document.getElementById("termsFrm");
    const req = document.getElementsByClassName("req");

    boxAll.addEventListener("click", function(){
        for(let i = 0; i < boxes.length; i++){
            boxes[i].checked = boxAll.checked;
        }
    });

    for(let i = 0; i < boxes.length; i++){
        boxes[i].addEventListener("click", boxesCheck);
    }

    function boxesCheck(){
        let result = true;
        for(let i = 0; i < boxes.length; i++){
            if(!boxes[i].checked){
                result = false;
                break;
            }
        }
        boxAll.checked = result;
    }

    nextBtn.addEventListener("click", nextBtnCheck);

    function nextBtnCheck(){
        /*for(let i = 0; i < boxes.length; i++){
            if(!boxes[i].checked){
                alert("모든 약관에 동의해주세요.");
                return;
            }
        }*/
        /*if(!boxAll.checked){
            alert("모든 약관에 동의해주세요.");
            return;
        }*/

        for(let i = 0; i < req.length; i++){
            if(!req[i].checked){
                alert("필수 약관에 동의해주세요.");
                return;
            }
        }

        termsFrm.submit();
    }
}