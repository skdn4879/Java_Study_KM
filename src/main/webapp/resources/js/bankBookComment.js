

const commentSendBtn = document.querySelector("#commentSendBtn");
const commentList = document.querySelector("#commentList");
const moreBtn = document.querySelector("#moreBtn");
let page = 1;   //페이지 번호
const bookNum = commentSendBtn.getAttribute("data-booknum");

getCommentList(page, bookNum, true);

commentSendBtn.addEventListener("click", function(){
    //console.log("commentSendBtn 클릭");
    let writer = document.querySelector("#writer").value;
    let contents = document.querySelector("#contents").value;

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
            //console.log(result);
            result = JSON.parse(result);
            if(result.result == 1){
                alert("댓글 등록");
                page = 1;
                getCommentList(page, bookNum, true);
            }
        }
    }

});

function getCommentList(p, bn, dFlag){
    //1.XMLHttpRequest객체 생성
    const xhttp = new XMLHttpRequest();

    //2.Method, Url준비
    xhttp.open("GET", "./commentList?page=" + p + "&bookNum=" + bn);

    //3.요청 발생
    xhttp.send();

    //4.응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200){
            //commentList.innerHTML = "";
            let result = this.responseText.trim();

            // 1. JSP 사용 결과물
            //console.log(result);
            //commentList.innerHTML = result;

            // 2. JSON 결과물(jackson-databind 라이브러리 사용)
            result = JSON.parse(result);

            let pager = result.pager;
            let list = result.list;

            let table = document.createElement("table");
            table.setAttribute("class", "table table-success");
            let tbody = document.createElement("tbody");
            
            for(let i = 0; i < list.length; i++){
                /*console.log(result[i]);
                console.log(result[i].contents);
                console.log(result[i].writer);*/
                let tr = document.createElement("tr");
                /*let trAttr = document.createAttribute("data-num");
                trAttr.value = list[i].num;
                tr.setAttributeNode(trAttr);*/

                let td = document.createElement("td");
                td.innerHTML = list[i].contents;
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = list[i].writer;
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = list[i].regDate;
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = "수정";
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-num");
                tdAttr.value = list[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                td = document.createElement("td");
                td.innerHTML = "삭제";
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-num");
                tdAttr.value = list[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                tbody.appendChild(tr);
            }
            table.appendChild(tbody);

            let t = commentList.children;
            if(t.length > 0 && dFlag){
                const tLen = t.length;
                for(let i = 0; i < tLen; i++){
                    commentList.removeChild(t[0]);
                }
                
            }

            commentList.append(table);
            //console.log(commentList.children);
            //console.log(commentList.firstChild);

            if(page >= pager.totalPage){
                moreBtn.classList.add("disabled");
            } else{
                moreBtn.classList.remove("disabled");
            }

        }
    });

}


moreBtn.addEventListener("click", function(){
    page++;
    getCommentList(page, bookNum, false);
    //console.log(bookNum);
});


commentList.addEventListener("click", function(event){
    
    if(event.target.className == 'update'){
        /*let contents = event.target.previousSibling.previousSibling.previousSibling;
        //console.log(contents);
        let v = contents.innerHTML;
        contents.innerHTML = "<textarea>" + v + "</textarea>";*/

        document.querySelector("#commentUpdateBtn").click();

    } else if (event.target.className == 'delete'){
        
        let check = window.confirm("삭제 ㄱ?");
        if(check){
            let commentNum = event.target.getAttribute("data-num");

            const xhttp = new XMLHttpRequest();
            xhttp.open("POST", "./commentDelete");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num=" + commentNum);

            xhttp.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200){
                    //console.log(this.responseText.trim());
                    let deleteResult = JSON.parse(this.responseText.trim());

                    if(deleteResult.result == 1){
                        alert("삭제 완료");
                        page = 1;
                        getCommentList(page, bookNum, true);
                    }
                }
            }
        }
    }
});