function save(event){
    event.preventDefault();
    const name=document.getElementById("name").value;
    const gen=document.getElementsByName("gender");
    let gender=null;
    gen.forEach((g) => {
        if(g.checked){
            gender=g.value;
        }
        
    });
    const age=document.getElementById("age").value;
    const course=document.getElementById("course").value;
    const email=document.getElementById("email").value;
    const obj=new students(name,gender,age,course,email);
    document.getElementById("stud_form").reset();
    obj.table_create();
    addstud(obj);
    

}
let stud=[];
function addstud(obj){
      stud.push(obj);
}
function json_str(){
    var o=JSON.stringify(stud);
    document.getElementById("jso").innerText=o;
}

function students(names,gender,age,course,email){
    this.stud_name=names;
    this.stud_gender=gender;
    this.stud_age=age;
    this.stud_course=course;
    this.stud_email=email;

}
students.prototype.table_create=function(){
    var ele=document.getElementById("tab");
    var row=ele.insertRow();
    row.innerHTML=
    `<td id="n">${this.stud_name}</td>
    <td id="a">${this.stud_age}</td>
     <td id="c">${this.stud_course}</td>
      <td id="g">${this.stud_gender}</td>
       <td id="e">${this.stud_email}</td>
       <td><button id="edit" onclick="edit_details(event)"> EDIT</button>
       <button id="del" onclick="del_details(event)"> DELETE</button></td>`
       

};
function edit_details(event){
    var row=event.target.closest('tr');
    var name=row.cells[0].innerText;
    var age=row.cells[1].innerText;
    var gender=row.cells[2].innerText;
    var course=row.cells[3].innerText;
    var email=row.cells[4].innerText;
    document.getElementById("name").value=name;
    document.getElementById("age").value=age;
    document.getElementById("course").value=course;
    document.getElementById("email").value=email;
    if(gender=="male"){
        document.getElementById("male").checked=true;
    }
    else{
        document.getElementById("female").checked=true;
    }
    row.remove();   
}
function del_details(event){
       event.target.parentElement.parentElement.remove();
}



