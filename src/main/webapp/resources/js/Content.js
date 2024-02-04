jQuery('#taskLessonHours').on('input propertychange paste', function () {
    var clockHours = Math.round($('#taskLessonHours').val() * 0.8333333333333333 * 10) / 10;
    $('#taskClockHours').val(clockHours);
    
    if( $('#taskClockHours').val() === "NaN"){
    	$('#taskClockHours').val('Tekst niet toegestaan.');
        $('#taskClockHours').css('color','#FF0000');
        document.getElementById("submitId").setAttribute("disabled","disabled");
        $('#taskLessonHours').css('border-color','#FF0000');
        $('#taskClockHours').css('border-color','#FF0000');
        console.log("Henk");
        
        
    }else
    {
        console.log('Doei');
        document.getElementById("submitId").removeAttribute("disabled");
        $('#taskLessonHours').css('border-color','#999999');
        $('#taskClockHours').css('border-color','#999999');
        $('#taskClockHours').css('color','black');
        $('#taskLessonHours').css('color','black');
    }
    
    
});

jQuery('#taskCategory').on('select propertychange', function () 
{

});

var email = document.getElementById("taskCategory");

email.addEventListener('change', function (e) {
    var selectedValue = parseInt(email.options[email.selectedIndex].value, 10);

    if (selectedValue === 7) {
        alert("Please select a email");
    }else
    {
    	alert('Lalalalalala');
    }
});

function categorySelect()
{
	console.log('dit moet hij toch wel gewoon ff doen, anders !!@@@@@@@@@@@@@@@@@');
	console.log($('#taskCategory').selectedIndex);
	if($('#taskCategory').val() === "")
	{
		console.log('moet je weer zo doen');
        document.getElementById("submitId").setAttribute("disabled","disabled");
	}else
	{
		console.log('Uhh hoe heet het? Ja toch?');
        document.getElementById("submitId").removeAttribute("disabled");
	}
}

$(document).ready(function() {
    document.getElementById("submitId").setAttribute("disabled","disabled");
});
//WORST

jQuery('#taskClockHours').on('input propertychange paste', function () {
    var lessonHours = Math.round($('#taskClockHours').val() * 1.20 * 10) / 10;
    $('#taskLessonHours').val(lessonHours);
 
        console.log($('#taskLessonHours').val());
        if( $('#taskLessonHours').val() === "NaN"){
        $('#taskLessonHours').val('Tekst niet toegestaan.');
        $('#taskLessonHours').css('color','#FF0000');
        document.getElementById("submitId").setAttribute("disabled","disabled");
        $('#taskClockHours').css('border-color','#FF0000');
        $('#taskLessonHours').css('border-color','#FF0000');
        console.log("Piet");
        $('#taskClockHours').className += "errorPopup";
    }else
    {
        console.log('Doei');
        document.getElementById("submitId").removeAttribute("disabled","disabled");
        $('#taskClockHours').css('border-color','#999999');
        $('#taskLessonHours').css('border-color','#999999');
        $('#taskClockHours').css('color','black');
        $('#taskLessonHours').css('color','black');
    }
    
});

$(document).ready((function () {
    $(":text").attr("autocomplete", "off");
}));
