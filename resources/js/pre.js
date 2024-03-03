/*
import {myFunction} from "/prediction.js";

document.getElementById("leagueName").innerHTML = state1;
document.getElementById("leagueDivision").innerHTML = "Hello World";
*/
document.getElementById("leagueName").innerHTML= sessionStorage.getItem("leagueName1");
document.getElementById("leagueDivision").textContent= sessionStorage.getItem("leagueDivision1");

