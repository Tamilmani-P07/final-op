
function redirectAdmin() {
    location.href="admin.html";
    
}
function redirectStudent() {
    document.getElementById("csl").style.display = "none";
    document.getElementById("status").style.display= "none"; 
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
    }
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
        },
    })
}

function logout(){
    location.href="index.html";
}
function signup(){
    var x = [];
    
    let n = document.getElementById("uname").value;
    let p=document.getElementById("pass").value;
    let cp=document.getElementById("cpass").value;
    let cat=document.getElementById("cat").value;
    console.log(n);
    
        
    
    var item = {
        name:n,
        pass:p,
        cpass:cp,
        category:cat
    };
         
        $.ajax({
            type:"PUT",
            url:"http://localhost:9090/login",
            data: JSON.stringify(item),
            success:function(data){
                location.reload();
                
    
            },
            error: function (data){
                alert("INVALID ENTRY");
            }
            });
        
        }

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