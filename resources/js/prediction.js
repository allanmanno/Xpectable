function myFunction() {
   var a = document.getElementById('states').value;
   var b = document.getElementById('division').value;
   var c = "resources/html/" + a + "_" + b + ".html";
   window.location.assign(c);
   
}