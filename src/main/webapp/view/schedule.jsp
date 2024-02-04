<%-- 
    Document   : schedule
    Created on : 15-jun-2016, 10:59:15
    Author     : jeffrey2e
--%>
<%@include file="includes/layout.jsp" %>


<div class="col-lg-12">
    <script>
 
 function countNames() {
     
     var Ja = {"name": "Jari", "aantalUren": 11, "aantalKlokUren": 15};
     var Je = {"name": "Jeffrey", "aantalUren": 10, "aantalKlokUren": 17};
     var Gi = {"name": "Gino", "aantalUren": 16, "aantalKlokUren": 12};
     
    array_elements = [Ja,Je,Gi];

    array_elements.sort();

    var current = null;
    var cnt = 0;
    for (var i = 0; i < array_elements.length; i++) {
      console.log(array_elements[i].name + " Uren: " + array_elements[i].aantalUren + " Klokuren: " + array_elements[i].aantalKlokUren); 
    }
}
    
</script>
</div>


<%@include file="includes/footer.jsp" %>