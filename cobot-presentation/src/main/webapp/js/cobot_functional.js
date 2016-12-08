// here is cobot functional
var Normal = window.matchMedia( "(min-width: 1300px)" );
var medium = window.matchMedia( "(max-width: 1280px)" );
var Mobile = window.matchMedia( "(max-width: 700px)" );
$(document).ready(function() {
	$(window).load(function() {
	  $(".container_caht").animate({ scrollTop: $(document).height() }, 300);
	});



    $("#chat_form").submit(function(event) {
	    /* Act on the event */
	    var message = $("#msg_area").val();
	    if ($("#msg_area").val() == "") {event.preventDefault();}
	    else{
	        $('.user_container').removeClass('bounceInRight');
	        event.preventDefault();
	        var chatStr = "";
	        chatStr += $(".messages_content").html();
	        var myStr ="";
	        myStr = "<div class='user_container animated'>";
	        myStr += "<span>";
	        myStr +=$("#msg_area").val();
	        myStr += "</span>";
	        myStr +="<p>"+formatAMPM()+"</p>";
	        myStr+="</div>";
	        $(".messages_content").html(myStr+chatStr);
	        $('.user_container:first').addClass('bounceInRight');
	        myStr +=$("#msg_area").val("");

	        setTimeout(function() {
                $.get('/cobot', { text: message } ).done(function(data) {
                    var chatStr = "";
                    chatStr += $(".messages_content").html();
                    chatStr ='<div class="bot_container animated">' + data.answer + '<p>'+formatAMPM()+'</p>'+'</div>' + chatStr;
                    $(".messages_content").html(chatStr);
                    $('.bot_container:first').addClass('bounceInLeft');
                    myStr +=$("#msg_area").val();
                    // getServerResponse(data.answer);

                });
            }, 150 + (Math.random() * 20) * 1);
	        $(".container_caht").animate({ scrollTop: $(".container_caht")[0].scrollHeight }, 2000);



	    }
	});

    function getServerResponse(message) {

        setTimeout(function() {
            var chatStr = "";
            chatStr += $(".messages_content").html();
            chatStr +='<div class="bot_container animated">' + message + '</div>';
            $(".messages_content").html(chatStr);


        }, 200 + (Math.random() * 20) * 10);
    }

	function formatAMPM() {
	    var date = new Date();
	  var hours = date.getHours();
	  var minutes = date.getMinutes();
	  var ampm = hours >= 12 ? 'pm' : 'am';
	  hours = hours % 12;
	  hours = hours ? hours : 12; // the hour '0' should be '12'
	  minutes = minutes < 10 ? '0'+minutes : minutes;
	  var strTime = hours + ':' + minutes + ' ' + ampm;
	  return strTime;
	}

	// Adding meta data (time)
    $("#getTime").html(formatAMPM());
    setInterval(function() {
        $("#getTime").html(formatAMPM());
    }, 1000);
    $("#getDate").html(formatDate());

	function formatDate(){
	    var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth()+1; //January is 0!
	    var yyyy = today.getFullYear();

	    if(dd<10) {
	        dd='0'+dd
	    } 

	    if(mm<10) {
	        mm='0'+mm
	    } 

	    today = dd+'.'+mm+'.'+yyyy;
	    return today;
	}
	$(window).load(function() {
		if(Mobile.matches){
			$('#mobile_navbar > .modal-content').append($('.nav_bar'));
		}
	});
	$(window).resize(function() {
		if(Mobile.matches){
			$('#mobile_navbar > .modal-content').append($('.nav_bar'));
		}
	});
	// appending Navbar in meniu modal for mobile
    // putting bot message curent time
    $(".start_bot_time").html(formatAMPM());

});