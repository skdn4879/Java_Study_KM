
const addFiles = document.getElementById("addFiles");   //div
const fileAdd = document.getElementById("fileAdd"); //button
let fileLimit = 5;
let fileCount = 0;

fileAdd.addEventListener("click", function(){

    if(fileCount < fileLimit){
        let div = document.createElement("div");
        let divCla = document.createAttribute("class");
        divCla.value = "input-group mb-3";
        div.setAttributeNode(divCla);
        
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

        div.appendChild(span);
        div.appendChild(input);

        addFiles.append(div);

        fileCount = fileCount + 1;
    } else{
        alert("파일은 5개까지만 추가 가능합니다.");
    }
    
});