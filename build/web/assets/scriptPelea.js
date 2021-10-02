var turno = document.getElementById("turno");
var carddark = document.getElementById("personaje");
var carddark1 = document.getElementById("personaje1");
function ataque() {
    ataque1();
    devolver(); 
    
    return true;
}

function ataque1() {
  if(turno.value % 2 == 0) {
    carddark.id = "cardAnimation";
  }else{
      carddark1.id = "cardAnimation";
  }
        
 }
 setTimeout(function devolver() {
     if(turno.value % 2 == 0) {
         carddark.id = "personaje";
  }else{
      carddark1.id = "personaje";
  }}, 8000);  
  function derrota(){
      alert("Deshonor!, deshonor sobre toda tu familia. Deshonrado tu, deshonrada tu vaca.");
  }