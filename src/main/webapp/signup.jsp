<html>
<head><title>Sign in</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


<script src="jquery.js"></script>

<link rel="stylesheet" href="index.css">

</head>
<body style="background-image:url('b_AllSoulsquad.jpg') ;">
  <h1 id="si">SIGNUP</h1>
    <!-- <div class="form-structor">
        <div class="signup">
          <h2 class="form-title" id="signup"><span>or</span>Sign up</h2>
          <div class="form-holder">
            <input type="text" class="uname" placeholder="Name" />
            <input type="email" class="pass" placeholder="Password" />
            <input type="password" class="cpass" placeholder=" Repeat your Password" />
          </div>
          <button class="submit-btn" onclick="signup()">Sign up</button>
        </div>
        <div class="login slide-up">
          <div class="center">
            <h2 class="form-title" id="login"><span>or</span>Log in</h2>
            <div class="form-holder">
              <input type="email" class="input" placeholder="Email" />
              <input type="password" class="input" placeholder="Password" />
            </div>
            <button class="submit-btn">Log in</button>
          </div>
        </div>
      </div> -->

   <center> <div id="signup">
        
        <div id="tt">
         <form action="javascript:void(0);" method="put">
                <input type="text" id="uname" placeholder="User Name" /><br>

                <input type="password" id="pass" placeholder="Password" /><br>

                <input type="password" id="cpass" placeholder="Repeat your password" /><br><br>

                <center><label for="cat" id="ce">Category</label></center>
                <select name="cat" id="cat">
                    <option value="Student">Student</option>
                    <option value="Admin">Admin</option>
                </select><br>


                <div>
                    <button type="submit" onclick="signup()">Register</button>
                </div>

                <p>Have already an account? <font ><a  href="index.html"><u>Login here</u></a></font></p>
                <label id="msg"></label>
        </form>
    </div>
    </div></center>

</body>

</html>