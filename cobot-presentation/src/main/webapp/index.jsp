<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>CoBoT</title>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
  	<link rel="stylesheet" href="font/icons_style.css">
  	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700&amp;subset=latin-ext" rel="stylesheet">
	<link rel="stylesheet" href="css/cobot.css">
	<link rel="stylesheet" href="css/qury_cobot.css">
</head>
<body>
	<section id="Cobot_content">
		<div class="row main_row">
			<div class="col m3 s12 nav_bar">
				<i class="icon-logo_cobot logo_app"></i>
				<ul class="list_folting_nav">
					<li>
						<h3>#CoBoT (ver: Grivei)</h3>
						<span>Stagiar CNA</span>
					</li>
					<li>
						<h3>secretariat@cna.md</h3>
						<span>CNA EMAIL</span>
					</li>
					<li>
						<h3>+373 22/ 257-257</h3>
						<span>LINIE FIERBINTE</span>
					</li>
					<li>
						<hr  class="short_hr">
					</li>
					<li class="ora_cel">
						<h3 id="getTime">15:04</h3>
						<span>ORA</span>
					</li>
					<li>
						<h3 id="getDate">13.12.16</h3>
						<span>DATA</span>
					</li>
				</ul>

				<a href="http://old.cna.md/cum-declaram" target="_blank" class="raposteaza_btn">RAPORTEAZA O CRIMA</a>
				<img class="support_img" src="img/baner-partnert.png" alt="">
			</div>
			<a href="#mobile_navbar">
				<i class="fixed_menu_button icon-menu"></i>
			</a>
			<div class="col m9 s12 chat_grid">
				<div class="container_caht">
					<!-- fixed sender -->
					<div id="fixed_input_box_send_msg_cont">
						<form action="" id="chat_form">
							<div class="input-field" >
							  	<input type="text" autocomplete="off" id="msg_area"  placeholder="Încercăm să scrie corect aici...">
							</div>
						</form>
					</div>
					<div valign="bottom" class="messages_content">
						<!-- Bot message container -->
						<div class="bot_container">
							<span> Află la care întrebări îţi poate răspunde CoBoT (ver Grivei) <a class="link_bot" href="#">aici</a> !</span>
							<p class="start_bot_time">2:47pm</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a class="waves-effect waves-light btn" href="#modal1">Modal</a> 
	</section>
	 <!-- Modal Structure -->
		  <div id="mobile_navbar" class="modal">
		    <div class="modal-content">
		      <a href="#!" class="modal-close icon-close close_navbar"></a>
		    </div>
		  </div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/cobot_functional.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.modal').modal({
				ending_top: '0'
			});
		});
	</script>
</body>
</html>