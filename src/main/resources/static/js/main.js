
(function ($) {
    "use strict"
    /* Inicializar o contador */
    $('.contar').counterUp({
        time: 1000,
        delay: 10
    });

    /* Função para estilizar o movimento do href */
    var $doc = $('html,body');
    $('.scroll-page').click(function () {
        $doc.animate({
            scrollTop: $($, attr(this, 'href')).offset().top
        }, 500);
        return false;
    });
})(jQuery);

/* Botão Flutuante */
window.onscroll = function(){
    scroll();
};
function scroll(){
    if (document.documentElement.scrollTop > 50) {
        document.getElementById("btnTop").style.display = "block";
    }else{
        document.getElementById("btnTop").style.display = "none";
    }  
}
function backToTop(){
    document.documentElement.scrollTop = 0;
}

var capturando ="";

function capturar() {
    capturando = document.getElementById('nome').value;
    document.getElementById('valorDigitado').innerHTML = capturando;
}




