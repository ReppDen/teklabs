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
            message += " " + res.responseJSON.message;
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
        $("#response").text("");
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

    $("#playMultipleButton").click(function () {
        $("#responseMultiple").text("");
        var arrayOfLines = $('#fizzBuzzNumberMultiple').val().split('\n');
        var inputArray = [];
        $.each(arrayOfLines, function (i, v) {
            v = v.trim();
            if (v) {
                inputArray.push(v);
            }
        });
        if (!arrayOfLines) {
            $("#responseMultiple").text("Please enter the number");
            return;
        }
        jQuery.ajax({
            type: "GET",
            url: "/fizzbuzz/multiple",
            data: {
                numbers: inputArray
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