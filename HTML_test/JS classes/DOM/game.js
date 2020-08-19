
var buttonColors = ["green", "red", "yellow", "blue"];

var gamePattern = [];

var userClickedPattern = [];

var level = 0;

var isStarted = false;


//Check for Keypress to start the game.
$(document).keypress(function () {
    console.log("Key Pressed");
    //Generate Game Pattern and show the animated fade & sound.
    while (!isStarted) {

        playGame();

        isStarted = true;

        //Get User's Key-input
        $(".btn").click(function () {
            var userChosenColor = $(this).attr("id");

            getUserClickedPattern(userChosenColor);

            //Check GamePattern & User's Pattern
            checkAnswer((userClickedPattern.length) - 1);
        });

    }
});

function playGame() {
    console.log(isStarted);
    //Level
    changeLevelValues();

    //Set Game Pattern
    nextSequence();
}

function nextSequence() {

    console.log("Sequence Started");

    var randomNumber = Math.floor(Math.random() * 4);
    var randomChosenColor = buttonColors[randomNumber];
    gamePattern.push(randomChosenColor);

    console.log("game pattern " + gamePattern);

    $("#" + randomChosenColor).fadeIn(100).fadeOut(100).fadeIn(100);

    playSound(randomChosenColor);
    userClickedPattern = [];
    console.log(userClickedPattern);
}

function getUserClickedPattern(color) {

    console.log("Button Clicked");

    userClickedPattern.push(color);
    console.log(userClickedPattern);
    playSound(color);
    animatePress(color);
}

function playSound(color) {
    console.log("Playing Audio")
    var audio = new Audio("sounds/" + color + ".mp3");
    audio.play();
}

function animatePress(color) {
    console.log(color + " pressed - animating");
    $("#" + color).addClass("pressed");
    setTimeout(function () {
        $("#" + color).removeClass("pressed");
    }, 100);
}

function changeLevelValues() {
    $("#level-title").text("Level " + level);
    level++;

    console.log(level + " changing level values");
}

function checkAnswer(arrayPosition) {
    console.log("checking answer");
    if (gamePattern[arrayPosition] === userClickedPattern[arrayPosition]) {
        console.log("Success, playgame is to be called.");

        if (userClickedPattern.length === gamePattern.length) {
            console.log("User had enetred required number of pressed, continue");
            setTimeout(playGame, 1000);
        }
        else {
            console.log("Waiting for required number of presses.");
        }
    }
    else {
        console.log("Failed");
        gameFailed();
    }
}

function gameFailed() {
    gamePattern = [];
    userClickedPattern = [];
    level = 0;

    playSound("wrong");

    $("body").addClass("game-over");
    setTimeout(function () {
        $("body").removeClass("game-over");
    }, 200);

    $("#level-title").text("Game Over, Press any key or Refresh to start again!");

    $(document).keypress(function () {
        window.location.reload(true);
    });

    $(".btn").click(function () {
        window.location.reload(true);
    });
}