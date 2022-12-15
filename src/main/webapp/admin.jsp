<html>

<head>
    <!-- <h1>ADMIN PORTAL</h1> -->
   
    <link rel="stylesheet" href="my1.css">
    </head>
    <script src="jquery.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js" defer></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</script>
 
    
    
    

<body onload="name()">
  <div id="top"> ADMIN PORTAL  <button id="logout" onclick="logout()">logout</button> <br></div>

    <!-- <center><h1>college Admission Data</h1> </center>  -->
    
    <div id="std">
      <div id="logo">
        <p>AU</p></div>
      <div id="bu">
      <button id="aa" type="submit" onclick="appdisplayItems()"> Student Application list</button>
      <button id="aa" type="button" onclick="alldisplayItems()"> Selected Student List</button>
      <button id="aa" type="button" onclick="rjectedStud()"> Rejected Student</button>
      <button id="aa" type="button" onclick="department()"> Departments</button>
      <button id="aa" type="button" onclick="std_approval()"> New students</button>
    </div>
    </div>



  <div id="main">
      <div id="std1">
    
          <div id="t1">
            <table id="tableid" class="display" >
                <thead>
                    <tr>
                      <th>APPLICATION ID</th>
                      <th>STUDENT NAME</th>
                      <th>STUDENT MARK</th>
                      <th>LOCATION NAME</th>
                    </tr>
                </thead>
                
            </table>
        </div>
        <button onclick="redirectAdmin()">HOME</button><BR></BR>
        <a href="index.html">EXIT FROM THE PAGE</a>
        </div>

        
      
        <div id="std2">
          <div id="t2">
           <table id="tablei" class="display" >
            <thead>
              <tr>
                  <th>STUDENT NAME</th>
                  <th>ALLOTMENT ID</th>
                  <th>APPLICATION ID</th>
                  <th>COLLEGE NAME</th>
                  <th>COURSE</th>
              </tr>
          </thead>
          
      </table>
    </div>
      <button onclick="redirectAdmin()">HOME</button><BR></BR>
        <a href="index.html">EXIT FROM THE PAGE</a>
    </div>


    <div id="std3">
        <div id="t3">
         <table id="rejected" class="display" >
        <thead>
            <tr>
                <th>APPLICATION ID</th>
                <th>STUDENT NAME</th>
            </tr>
        </thead>
        
    </table>
  </div>
    <button onclick="redirectAdmin()">HOME</button><BR></BR>
      <a href="index.html">EXIT FROM THE PAGE</a>
  </div>


  <div id="std4">
      <div id="t4">
       <table id="depart" class="display" >
      <thead>
          <tr>
              <th>COURSE ID</th>
              <th>COURSE NAME</th>
          </tr>
      </thead>
      
  </table>
</div>
  <button onclick="redirectAdmin()">HOME</button><BR></BR>
    <a href="index.html">EXIT FROM THE PAGE</a>
</div>

<div id="std5">
  <div id="t5">
    <table id="approvetb" class="display" >
        <thead>
            <tr>
              <th>UserName</th>
              <th>Category</th>
              <th>Action</th>
              <th>action</th>
            </tr>
        </thead>
        
    </table>
    </div>
    <button onclick="redirectAdmin()">HOME</button><BR></BR>
        <a href="index.html">EXIT FROM THE PAGE</a>
</div>
</div>
    
   
  
</body>
</html>