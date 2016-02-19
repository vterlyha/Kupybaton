// Close the dropdown menu if the user clicks outside of it
$(document).ready(function() {
window.onclick = function(event) {
  if (!event.target.matches('.changeSmth')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
});