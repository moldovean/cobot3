var $messages = $('.messages-content');

$(window).load(function() {
    $messages.mCustomScrollbar();
});

$('.message-submit').click(function() {
    insertMessage();
});

$(window).on('keydown', function(e) {
    if (e.which == 13) {
        insertMessage();
        return false;
    }
});

function updateScrollbar() {
    $messages.mCustomScrollbar("update").mCustomScrollbar('scrollTo', 'bottom', {
        scrollInertia: 10,
        timeout: 0
    });
}

function setDate(messageElement){
    var data = new Date();
    $('<div class="timestamp">' + data.getHours() + ':' + data.getMinutes() + '</div>').appendTo($('.message:last'));
}

function insertMessage() {
    var input = $('.message-input');
    var msg = input.val();

    if ($.trim(msg) == '') {
        return false;
    }

    input.val(null);
    $('.message.loading').remove();
    $('<div class="message message-personal">' + msg + '</div>').appendTo($('.mCSB_container')).addClass('new');
    setDate();
    updateScrollbar();

    setTimeout(function() {
        $.get('/cobot', { text: msg } ).done(function(data) {
            fakeMessage(data.answer);
        });
    }, 150 + (Math.random() * 20) * 1);
}

function fakeMessage(message) {
    $('<div class="message loading new"><figure class="avatar"><img src="/resources/avatar.png" /></figure><span></span></div>').appendTo($('.mCSB_container'));
    updateScrollbar();

    setTimeout(function() {
        $('.message.loading').remove();
        $('<div class="message new"><figure class="avatar"><img src="/resources/avatar.png" /></figure>' + message + '</div>').appendTo($('.mCSB_container')).addClass('new');
        setDate();
        updateScrollbar();
    }, 200 + (Math.random() * 20) * 10);
}