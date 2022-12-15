<html>

<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

   

 
  <link rel="stylesheet" href="student.css">
  <script src="jquery.js"></script>
 
</head>

<body onload="name()">
  <div id="top"> Student portal <button id="logout" onclick="logout()">logout</button> <br></div>


  <div id="std">
   
    <img id="userpng" src="user png.png" alt="user_img">
    <h1 id="name"></h1>
 
    <button id="aa" type="button" onclick="getCollegeSeatList()"> college seat list</button>
    <button id="aa" type="button" onclick="getStudentStatusonload()"> Application Status </button>
   
  </div>
  <div id="std1">
    <div id="csl">
      <div id="cslform">
        <form action="javascript:void(0);" method="post">
          <!-- COLLEGE ID <input type="text" name="co_id" id="co_id">
          COURSE ID<input type="text" name="c_id" id="c_id"> -->
          <label id="fla" name="c_id" for="c_id">COLLEGE ID : </label>
            <select name="c_id" id="c_id">
              <option value="101">101</option>
              <option value="102">102</option>
              <option value="103">103</option>
              <option value="104">104</option>
              <option value="105">105</option>
            </select>
            <br>
            <label id="fla" name="co_id" for="co_id">COURSE ID : </label>
            <select name="co_id" id="co_id">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
            </select>
            <br>

            <button type="submit" onclick="dataSeatList()" >Search</button>
        </form>
      </div>

      <div id="csltable">
        <table border="1px">
          <thead>
            <tr>
              <th>COLLEGE NAME</th>
              <th>COURSE NAME </th>
              <th>COLLEGE ID</th>
              <th>FILLED SEATS</th>
              <th>REMAINING SEATS</th>
              <th>TOTAL SEATS</th>
            </tr>
          </thead>

          <tbody id="sea"></tbody>
        </table><br>
       <center><button onclick="redirectStudent()">HOME</button></center> 
      </div>

    </div>
    <div id="status">
      <table border="1px">
        <thead>
          <tr>
            <th>APPLICATION ID</th>
            <th>STUDENT NAME </th>
            <th>ALLOTMENT ID</th>
            <th>STATUS</th>
          </tr>
        </thead>

        <tbody id="sta"></tbody>
      </table><br>
      <center><button onclick="redirectStudent()">HOME</button></center>
    </div>

   
  </div>
</body>

</html>