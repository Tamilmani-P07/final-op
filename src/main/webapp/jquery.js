// admin functionns

function alldisplayItems() {
    document.getElementById("std1").style.display="none";
    document.getElementById("std3").style.display="none";
    document.getElementById("std5").style.display="none";
    document.getElementById("std4").style.display="none";

    document.getElementById("std2").style.display="block";
  
    $('#tablei').DataTable( {
        "ajax": {
            "url": "http://localhost:9090/allotment",
            "dataSrc": ""
        },
        "columns": [
            { "data": "studentName" },
            { "data": "allotmentId" },
            { "data": "applicationId" },
            { "data": "collegeName" },
            { "data": "courseName" }
        ]
    } );
}
function appdisplayItems() {
    document.getElementById("std3").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std1").style.display="block";
    
    $('#tableid').DataTable( {
        "ajax": {
            "url": "http://localhost:9090/app",
            "type":"GET",
            "dataSrc": ""
            
        },
        "columns": [
            { "data": "application_id" },
            { "data": "student_name" },
            { "data": "student_mark" },
            { "data": "location_name" }
        ]
    } );
}
function accept(n,p,cat){
    let x=[];
    alert("acceptStudent");
    let si={
         name:n,
        pass:p,
        category:cat
    }
    $.ajax({
        type:"PUT",
        url:"http://localhost:9090/login",
        data: JSON.stringify(si),
        success:function(data){
            var msg
            x = JSON.parse(data);
            let temp=x[0];
            if (temp===1) {
                msg="Waiting Admin Approval";
            } else if (temp===-1) {
                msg="name is already registerd try with another user name"
            } else {
                msg="Server Dead so Try Later"
                
            } 
           document.getElementById("msg").textContent=msg;     
            
            
        },
        error: function (data){
            alert("Invalid Username or Password");
        }
        });

}
function signup(){
    var x = [];
    
    let n = document.getElementById("uname").value;
    let p=document.getElementById("pass").value;
    let cp=document.getElementById("cpass").value;
    let cat=document.getElementById("cat").value;
    console.log(n);
    if (cp===p) {
        alert();
        accept(n,p,cat);
    }
    else{
        alert("Password and Confirm Password Mismatch");
    }
         
}
function std_approval(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std3").style.display="none";

    document.getElementById("std5").style.display="block";
    let x=[];

    $.ajax({
            type:"GET",
            url:"http://localhost:9090/login",
        
            success:function(data){
                x=JSON.parse(data);
               console.log(x);
               displayApproval(x);
    
            },
            error: function (data){
                alert("INVALID ENTRY");
            }
            });

}
function displayApproval(data) {
   
    $(".trc").remove();
    console.log(data);
    const tBody = document.getElementById("approvetb");
    const button = document.createElement("button");
    data.forEach(ele => {
        let acceptButton = button.cloneNode(false);
        acceptButton.innerText = "Accept";
        acceptButton.setAttribute("onclick", `acceptItem('${ele.name}','Accept')`);
 
        let declineButton = button.cloneNode(false);
        declineButton.innerText = "Decline";
        declineButton.setAttribute("onclick", `acceptItem('${ele.name}','Decline')`); 

        let tr = tBody.insertRow();
        tr.className="trc";
        let td1 = tr.insertCell(0);
        let cn = document.createTextNode(ele.name);
        td1.appendChild(cn);

        let td2 = tr.insertCell(1);
        let con = document.createTextNode(ele.category);
        td2.appendChild(con);

        let td3 = tr.insertCell(2);
        td3.appendChild(acceptButton);
 
        let td4 = tr.insertCell(3);
        td4.appendChild(declineButton);

    });
    
}
function acceptItem(n,s){
console.log(n,s);
let item={
    name:n,
    action:s
}

 $.ajax({
            type:"DELETE",
            url:"http://localhost:9090/login",
            data: JSON.stringify(item),
            success:function(data){
                // x=JSON.parse(data);
               console.log(x);
              
                
    
            },
            error: function (data){
                alert("INVALID ENTRY");
            }
            });

}
function rjectedStud(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std3").style.display="block";

    

  
    $('#rejected').DataTable( {
        "ajax": {
            "url": "http://localhost:9090/allotment",
            "type": "POST",
            "dataSrc": ""
        },
        "columns": [
            { "data": "application_id" },
            { "data": "student_name" }
          
    ]} );

}
function department(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std3").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std4").style.display="block";
    
    $('#depart').DataTable( {
        "ajax": {
            "url": "http://localhost:9090/app",
            "type": "POST",
            "dataSrc": ""
        },
        "columns": [
            { "data": "courseId" },
            { "data": "courseName" }
          
    ]} );
    
}

function login() {
    
    var x = [];
    
    let u = document.getElementById("in").value;
    let p = document.getElementById("out").value;
    console.log(u);
    sessionStorage.setItem("u_name",u);
    sessionStorage.setItem("password",p);
    var datas = {
        name: u,
        pass: p
    };
      $.ajax({
        url: "http://localhost:9090/login",
        type: "POST",
        data: JSON.stringify(datas),
        success: function (data) {
            x = JSON.parse(data);
            console.log(x[0].category);
             
                if  (x[0].category==="Admin") {
                    location.href="admin.jsp";
                } else if(x[0].category==="Student") {
                    location.href="student.jsp";
        
                }
                else{
                    alert("invalid user name or password")
                }
        },
        error: function (error) {
            console.log("error");
        }
    });
}
//seat list for student
 function getCollegeSeatList() {
         document.getElementById("csl").style.display = "block";
         document.getElementById("cslform").style.display = "block";
         document.getElementById("status").style.display = "none";
         document.getElementById("csltable").style.display = "none";
}
 function dataSeatList(){
           var x = [];
           let college_id = document.getElementById("c_id").value;
           let course_id = document.getElementById("co_id").value;
            dataseat = {
               college_id: college_id,
               cour_id: course_id
           }
           console.log(dataseat);
           $.ajax({
               url: "http://localhost:9090/seats",
               type: "POST",
               data: JSON.stringify(dataseat),
               success: function (data) {
                   x = JSON.parse(data);
                   console.log(x);
                   document.getElementById("cslform").style.display = "none";
                   displaySeatList(x);
               },
               error: function (error) {
                   console.log("error");
               },
           })
}
 function displaySeatList(data) {
        //document.getElementById("cslform").style.display = "none";
         document.getElementById("csltable").style.display = "block";
        $(".trc").remove();
        console.log(data);
        const tBody = document.getElementById("sea");
        data.forEach(ele => {
    
            let tr = tBody.insertRow();
            tr.className="trc";
            let td1 = tr.insertCell(0);
            let cn = document.createTextNode(ele.c_name);
            td1.appendChild(cn);
    
            let td2 = tr.insertCell(1);
            let con = document.createTextNode(ele.cour_name);
            td2.appendChild(con);
    
            let td3 = tr.insertCell(2);
            let co_id = document.createTextNode(ele.college_id);
            td3.appendChild(co_id);
    
            let td4 = tr.insertCell(3);
            let fs = document.createTextNode(ele.filled_seats);
            td4.appendChild(fs);
    
            let td5 = tr.insertCell(4);
            let res = document.createTextNode(ele.remaining_seats);
            td5.appendChild(res);
    
            let td6 = tr.insertCell(5);
            let ts = document.createTextNode(ele.total_seats);
            td6.appendChild(ts);
    
        });
}
       //student status 
function getStudentStatusonload(){
        document.getElementById("csl").style.display = "block";
        document.getElementById("cslform").style.display = "none";
        document.getElementById("csltable").style.display = "none";
        var x = [];
        let name=sessionStorage.getItem("u_name")
        let p=sessionStorage.getItem("password");
        console.log(name);
        
        var datas={
            name:name,
            pass:p
        };
    
        $.ajax({
            url: "http://localhost:9090/status",
            type: "PUT",
            data:JSON.stringify(datas),
            success: function (data) {
                x = JSON.parse(data);
                // console.log(x);
                getstatusDisplay(x);
                },
            error: function (error) {
                console.log("error");
            },
        });
        
}
 
    function getstatusDisplay(data) {
        console.log(data);
        document.getElementById("status").style.display = "block";
        $(".trcc").remove();
        const tBody = document.getElementById("sta");
    
        data.forEach(ele => {
    
            let tr = tBody.insertRow();
            tr.className="trcc";
            let td1 = tr.insertCell(0);
            let cn = document.createTextNode(ele.applicationId);
            td1.appendChild(cn);
    
            let td2 = tr.insertCell(1);
            let con = document.createTextNode(ele.studentName);
            td2.appendChild(con);
    
            let td3 = tr.insertCell(2);
            let co_id = document.createTextNode(ele.allotmentId);
            td3.appendChild(co_id);
    
            let td4 = tr.insertCell(3);
            let fs = document.createTextNode(ele.status);
            td4.appendChild(fs);
    
    });    
}

 function name(){
     var temp=sessionStorage.getItem("u_name");
        document.getElementById("name").textContent=temp.toUpperCase();
}  
    //log out 
    function logout(){
        location.href="index.html";
}
     // redirect functions
    function redirectStudent() {
        document.getElementById("csl").style.display = "none";
        document.getElementById("status").style.display= "none"; 
}

    function redirectAdmin() {
        location.href="admin.jsp";
        
}
    function redirectStudent() {
        location.href="student.jsp";
        
}