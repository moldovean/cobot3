<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>CoBoT - Pagina temporală de testare</title>
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>
    <%--<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.min.css'>--%>
    <%--<link rel="stylesheet" href="resources/css/style.css">--%>

    <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js' defer></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.3/jquery.mCustomScrollbar.concat.min.js' defer></script>
    <script src="resources/js/scriptTom.js" defer></script>
</head>
<body>

<div class="chat">
    <div class="chat-title">
        <h1>CoBoT</h1>
        <h2>demo</h2>
        <figure class="avatar">
            <img src="/resources/avatar.png"/>
        </figure>
    </div>

    <div class="messages">
        <div class="messages-content"></div>
    </div>

    <div class="message-box">
        <textarea type="text" class="message-input" placeholder="Introduceți mesajul..."></textarea>
        <button type="submit" class="message-submit">Expediază</button>
    </div>
</div>

<div class="bg"></div>
<div class="undpLogo">
    <h3>Acest proiect a fost realizat cu sprijinul financiar al Organizatiei Natiunilor Unite pentru Dezvoltare si a Ambasadei Regatului Norvegiei.</h3>
</div>

</body>
</html>
