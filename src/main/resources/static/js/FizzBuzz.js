$(document).ready(function () {
    console.log("ready!");

    function handleAuthentication(logged, userDetails) {
        if (logged) {
            $(".pleaseLogin").hide();
            $("#userInfo").show();
            $("#username").text(userDetails.username);
        } else {
            $(".pleaseLogin").show();
            $("#userInfo").hide();
            $("#username").text(null);
        }
    }

    handleAuthentication(false);


    jQuery.ajax({
        type: "GET",
        url: "/me",
        success: function (res) {
            handleAuthentication(true, res)
        },
        error: function (res) {
            handleAuthentication(false)
        }
    });


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