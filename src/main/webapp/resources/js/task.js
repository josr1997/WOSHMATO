
$(document).ready(
        function () {
            var selectedValue = $('#categoryHidden').val();
            var select = document.getElementById('taskCategory');
            for (var i = 0; i < select.length; i++) {
                if (select.options[i].text == selectedValue) {
                    select.options[select.options[i].selected = true];
                }
            }
            
        });
        

$(document).ready(
 function() {
    $( document ).tooltip();
  });     

