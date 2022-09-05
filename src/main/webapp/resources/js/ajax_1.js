

const d1 = document.querySelector("#d1");
const d2 = document.querySelector("#d2");
const result = document.querySelector("#result");

d1.addEventListener("click", function(){
    // 1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();
    let id = d2.value;

    // 2. 요청 정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/" + id);

    // 3. 요청 발생
    xhttp.send();

    // 4. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this = XMLHttpRequest객체
        /*console.log("status : ", this.status);
        console.log("readyState : ", this.readyState);
        console.log("----------------------------------");*/
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
            let response = this.responseText.trim();
            response = JSON.parse(response);

            /*console.log(response.userId);
            console.log(response.id);
            console.log(response.title);*/
            let h3 = document.createElement("h3");
            h3.innerHTML = response.userId;
            result.append(h3);
            h3 = document.createElement("h3");
            h3.innerHTML = response.id;
            result.append(h3);
            h3 = document.createElement("h3");
            h3.innerHTML = response.title;
            result.append(h3);
        }
    }

    console.log("Ajax 발생");
});