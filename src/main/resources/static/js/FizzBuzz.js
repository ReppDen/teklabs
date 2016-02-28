$(document).ready(function () {

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

    function handleRestErrorForPrettyText(res, elemId) {
        var message = "";
        switch (res.status) {
            case 401:
                message = "Please login first!";
                break;
            case 400:
                message = "Incorrect value passed to backend! Make sure that you enter only numbers";
                break;
        }

        if (res.responseJSON) {
            message += " " + res.reponseJSON.message;
        }

        $("#" + elemId).text(message);
    }

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
        if (!number) {
            $("#response").text("Please enter the number");
            return;
        }
        jQuery.ajax({
            type: "GET",
            url: "/fizzbuzz",
            data: {
                number: number
            },
            success: function (res) {
                $("#response").text(res);
            },
            error: function (res) {
                handleRestErrorForPrettyText(res, "response");
            }
        });
    });

    $("#logout").click(function () {
        jQuery.ajax({
            type: "POST",
            url: "/logout",
            success: function (res) {
                handleAuthentication(false)
            },
            error: function (res) {
                console.log("Logout failed", res);
                handleAuthentication(false);
            }
        });
    });

    $("#playMultipleButton").click(function () {
        var arrayOfLines = $('#fizzBuzzNumberMultiple').val().split('\n');
        $.each(arrayOfLines, function (i, v) {
            v = v.trim();
        });
        if (!arrayOfLines) {
            $("#responseMultiple").text("Please enter the number");
            return;
        }
        jQuery.ajax({
            type: "GET",
            url: "/fizzbuzz/multiple",
            data: {
                numbers: arrayOfLines
            },
            success: function (res) {
                $("#responseMultiple").text(res);
            },
            error: function (res) {
                handleRestErrorForPrettyText(res, "responseMultiple");
            }
        });
    });
});