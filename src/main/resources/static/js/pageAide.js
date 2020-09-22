// Function pour limité les nombres de caractères sur le textarea

let message = document.getElementById("message");
let length = message.getAttribute("maxlength");
let count = document.getElementById("count");

count.innerHTML = length;
message.onkeyup = function() {
  document.getElementById("count").innerHTML = length - this.value.length;
};
