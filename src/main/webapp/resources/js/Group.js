
$(document).ready(
        function () {
            var selectedValue = $('#hiddenTeam').val();
            var select = document.getElementById('team');
            for (var i = 0; i < select.length; i++) {
                if (select.options[i].text == selectedValue) {
                    select.options[select.options[i].selected = true];
                }
            }
        });

$(document).ready(
        function () {
            var selectedValue = $('#hiddenTeacher').val();
            var select = document.getElementById('teacher');
            for (var i = 0; i < select.length; i++) {
                if (select.options[i].text == selectedValue) {
                    select.options[select.options[i].selected = true];
                }
            }
        });