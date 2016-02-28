$(document).ready(function () {
    console.log("ready!");
    $("#playButton").click(function () {
        var number = $("#fizzBuzzNumber").val();
        console.log("play!", number);
        jQuery.ajax({
            type: "GET",
            url: "/fizzbuzz",
            data: {
                number: number
            },
            success: function (res) {
                console.log("WOW!", res);
                $("#response").text(res);
            },
            error: function (res) {
                console.log("DAMN!!", res);
                $("#response").text(res.responseJSON.message);
            }
        });
    })
});