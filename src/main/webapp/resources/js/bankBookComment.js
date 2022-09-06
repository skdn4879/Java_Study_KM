

const commentSendBtn = document.querySelector("#commentSendBtn");
const commentList = document.querySelector("#commentList");

getCommentList();

commentSendBtn.addEventListener("click", function(){
    //console.log("commentSendBtn 클릭");
    let writer = document.querySelector("#writer").value;
    let contents = document.querySelector("#contents").value;
    let bookNum = commentSendBtn.getAttribute("data-booknum");

    /*console.log("writer : ", writer);
    console.log("contents : ", contents);
    console.log("booknum : ", commentSendBtn.getAttribute("data-booknum"));*/

    //----Ajax----
    //1. XMLHttpRequest생성
    const xhttp = new XMLHttpRequest();

    //2. Method, Url 준비
    xhttp.open("POST", "./commentAdd");

    //3. Enctype
    // 요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생 (POST 일 경우 파라미터 추가)
    xhttp.send("bookNum=" + bookNum + "&writer=" + writer + "&contents=" + contents);

    //5. 응답 처리
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            if(result.result == 1){
                alert("댓글 등록");
                getCommentList();
            }
        }
    }

});

function getCommentList(){
    //1.XMLHttpRequest객체 생성
    const xhttp = new XMLHttpRequest();

    //2.Method, Url준비
    xhttp.open("GET", "./commentList?page=1&bookNum=" + commentSendBtn.getAttribute("data-booknum"));

    //3.요청 발생
    xhttp.send();

    //4.응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200){
            commentList.innerHTML = "";
            let result = this.responseText.trim();

            // 1. JSP 사용 결과물
            //console.log(result);
            //commentList.innerHTML = result;

            // 2. JSON 결과물(jackson-databind 라이브러리 사용)
            result = JSON.parse(result);
            let table = document.createElement("table");
            table.setAttribute("class", "table table-success");
            let tbody = document.createElement("tbody");
            
            for(let i = 0; i < result.length; i++){
                /*console.log(result[i]);
                console.log(result[i].contents);
                console.log(result[i].writer);*/
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                td.innerHTML = result[i].contents;
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = result[i].writer;
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = result[i].regDate;
                tr.appendChild(td);

                tbody.appendChild(tr);
            }
            table.appendChild(tbody);

            commentList.append(table);
        }
    });

}