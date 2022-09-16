
const addFiles = document.getElementById("addFiles");   //div
const fileAdd = document.getElementById("fileAdd"); //button
let fileLimit = 5;
let fileCount = 0;

let idx = 0;

/*
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">File</span>
  <input type="file" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="files">
  <button type="button" class="btn btn-danger del">삭제</button>
</div>
*/

function setCount(c){
    if(c >= 0 && c <= 5){
        fileCount = c;
    }
}

try{
    fileAdd.addEventListener("click", function(){

        if(fileCount < fileLimit){
            let div = document.createElement("div");
            let divCla = document.createAttribute("class");
            divCla.value = "input-group mb-3";
            div.setAttributeNode(divCla);
            let divAttr = document.createAttribute("id");
            divAttr.value = "file" + idx;
            div.setAttributeNode(divAttr);
            
            /*let span = document.createElement("span");
            let spanCla = document.createAttribute("class");
            spanCla.value = "input-group-text";
            let id = document.createAttribute("id");
            id.value = "basic-addon1";
            let t = document.createTextNode("File");
            span.setAttributeNode(spanCla);
            span.setAttributeNode(id);
            span.appendChild(t);*/
            let span = document.createElement("span");
            span.setAttribute("class", "input-group-text");
            span.setAttribute("id", "basic-addon1");
            let t = document.createTextNode("File");
            span.appendChild(t);
    
            let input = document.createElement("input");
            let type = document.createAttribute("type");
            type.value = "file";
            let inputCla = document.createAttribute("class");
            inputCla.value = "form-control";
            let aria_label = document.createAttribute("aria-label");
            aria_label.value = "Username";
            let aria_describedby = document.createAttribute("aria-describedby");
            aria_describedby.value = "basic-addon1";
            let name = document.createAttribute("name");
            name.value = "files";
            input.setAttributeNode(type);
            input.setAttributeNode(inputCla);
            input.setAttributeNode(aria_label);
            input.setAttributeNode(aria_describedby);
            input.setAttributeNode(name);
    
            let button = document.createElement("button");
            button.setAttribute("type", "button");
            let buttonCla = document.createAttribute("class");
            buttonCla.value = "btn btn-danger del";
            let buttonText = document.createTextNode("삭제");
            button.appendChild(buttonText);
            button.setAttributeNode(buttonCla);
            let buttonAttr = document.createAttribute("title");
            buttonAttr.value = idx;
            button.setAttributeNode(buttonAttr);
    
            div.appendChild(span);
            div.appendChild(input);
            div.appendChild(button);
    
            addFiles.append(div);
    
            fileCount = fileCount + 1;
            idx = idx + 1;
        } else{
            alert("파일은 5개까지만 추가 가능합니다.");
        }
        
    });
    
    addFiles.addEventListener("click", function(event){
        /*if(event.target.className == "btn btn-danger del"){
            alert("삭제 버튼 누름");
        }*/
    
        if(event.target.classList[2] == "del"){
            const fileForm = document.getElementById("file" + event.target.title);
    
            addFiles.removeChild(fileForm);
    
            fileCount = fileCount - 1;
        }
    });
} catch(e){

}



/******************************************* */
const fileDelete = document.querySelectorAll(".fileDelete");       // forEach 가능(배열)
//const fileDelete = document.getElementsByClassName(".fileDelete"); // forEach 불가능(유사배열)

try{
    fileDelete.forEach(function(f){
        f.addEventListener("click", function(){

            console.log(f.parentNode);

            let check = window.confirm("삭제를 하면 되돌릴 수 없다.");

            if(!check){
                return;
            }

            let fileNum = f.getAttribute("data-file-num");

            //ajax
            const xhttp = new XMLHttpRequest();

            xhttp.open("POST", "./fileDelete");

            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhttp.send("fileNum=" + fileNum);

            xhttp.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200){
                    let result = this.responseText.trim();

                    if(result == 1){
                        console.log(result);
                        f.parentNode.remove();
                        fileCount--;
                    } else{
                        console.log(result);
                    }
                }
            }

        });
    });
} catch(e) {

}
