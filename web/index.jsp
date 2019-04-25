
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
  <title>ARaynorDesign Template</title>
  <meta name="description" content="free website template" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="style.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
$( "#tabs" ).tabs();
} );
</script>

</head>

<body>
  <div id="main">
    
	<div id="menubar">
      <ul id="menu">
        <li class="current"><a href="index.jsp">Home</a></li>
        <li><a href="ourwork.jsp">Our Work</a></li>
        <li><a href="testimonials.jsp">Testimonials</a></li>
        <li><a href="projects.jsp">Projects</a></li>
        <li><a href="contact.jsp">Contact Us</a></li>
      </ul>
    </div><!--close menubar-->	

    <div id="slideshow">
	  <ul class="slideshow">
        <li class="show"><img width="920" height="250" src="images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        <li><img width="920" height="250" src="images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        <li><img width="920" height="250" src="images/badminton_racket_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        <li><img width="920" height="250" src="images/chess.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        <li><img width="920" height="250" src="images/cricket.jpg" alt="&quot;Enter your caption here&quot;" /></li>
      </ul> 
    </div><!--close slideshow-->		  
	
	<div id="header">
	  <div id="banner">
	    <div id="welcome">
	      <h1>WELCOME TO CLUB RESERVATION</h1>
	    </div><!--close welcome-->
	  </div><!--close banner-->
    </div><!--close header-->
    
	<div id="site_content">		
	 
	  <div class="sidebar_container">       
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Sign Up</h2>
            <p>
              <form action="SignUp" method="post">
                
                  <input type="radio" value="club_owner" name="radchoice" checked>Club Owner</input><br><br>
                 
                <input type="radio" value="club_member" name="radchoice">Club Member</input><br><br>
                
                     <input type="submit" value="register"/>  
              </form>
            </p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Latest Update</h2>
            <h3>July 2017</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->   
        <div class="sidebar">
          <div class="sidebar_item">
            <h2>Contact</h2>
            <h3>Phone: +91 8103164020</h3>
            <h3>Email: <a href="mailto:info@youremail.co.uk">info@youremail.co.uk</a></h3>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->		 
	 
	  <div id="content">
        <div class="content_item">
		  <h1>Welcome Club Registration</h1> 
	      <p>This standards compliant, simple, fixed width website template is released as an 'open source' design (under the Creative Commons Attribution 3.0 Licence), which means that you are free to download and use it for anything you want (including modifying and amending it). If you wish to remove the &lsquo;ARaynorDesign&rsquo; link in the footer of the template, please contact me first, but other than that...</p>
		  
              <font size="5">Login</font>
              <br>
              <%
              String res=(String)request.getAttribute("res");
              if(res!=null)
              out.print(res);
              %>
              </br>
    <p>
        <form action="LoginServlet" method="post">
            <table>
            <tr>
                <td>Enter User_ID</td>
                <td><input type="text" name="userid"/></td>
            </tr>
            <tr>
                <td>Enter Password</td>
                <td><input type="password" name="pass"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="login"/></td>
                <td><input type="reset" value="clear"/></td>
            </tr>
            </table>
            
        </form>
    </p>
</div>
		  
		  <div class="content_container">
		    <p>     THe club is open throughout the week timing slots are different for different activities for more details sign up as club_member
</p>
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->
		  </div><!--close content_container-->
          <div class="content_container">
		    <p>Campus Club will be open 24 hours from Monday, January 11th – Tuesday, January 12th
for Dean’s Date.  Please note, from 12 midnight – 8am, you will need to use the front door.</p>          
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->		  
		  </div><!--close content_container-->			  
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content--> 
    
	<div id="content_grey">
	  <div class="content_grey_container_box">
		<h4>Latest Blog Post</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
		<div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->
	  </div><!--close content_grey_container_box-->
      <div class="content_grey_container_box">
       <h4>Latest News</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
	    <div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->
	  </div><!--close content_grey_container_box-->
      <div class="content_grey_container_boxl">
		<h4>Latest Projects</h4>
	    <p> Phasellus laoreet feugiat risus. Ut tincidunt, ante vel fermentum iaculis.</p>
	    <div class="readmore">
		  <a href="#">Read more</a>
		</div><!--close readmore-->	  
	  </div><!--close content_grey_container_box1-->      
	  <br style="clear:both"/>
    </div><!--close content_grey-->   
 
  </div><!--close main-->
  
  <div id="footer">
	  <a href="http://validator.w3.org/check?uri=referer">Valid XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">Valid CSS</a> | <a href="http://fotogrph.com/">Images</a> | website template by <a href="http://www.araynordesign.co.uk">ARaynorDesign</a>
  </div><!--close footer-->  
  
</body>
</html>

