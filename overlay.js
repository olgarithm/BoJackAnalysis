(function () {
   "use strict";
   // Given an id, returns the corresponding element
	function $(id) { return document.getElementById(id); }

	// Given a selector, returns all the elements that match that selection
	function qsa(sel) { return document.querySelectorAll(sel); }

	// Give a selector, returns the first element that matches that selection
	function qs(sel) { return document.querySelector(sel); }
   
	window.onload = function() {
		$("bojack").onclick = showOverlay;
		$("carolyn").onclick = showOverlay;
		$("diane").onclick = showOverlay;
		$("mr-peanutbutter").onclick = showOverlay;
		$("todd").onclick = showOverlay;
		var allBackBtns = qsa(".back");
		for (var i = 0; i < allBackBtns.length; i++) {
			allBackBtns[i].onclick = closeOverlay;
		}
  	};

  	// Slides the character's overlay down
  	function showOverlay() {
	    document.getElementById(this.id+"-overlay").style.height = "100%";
	}

	// Slides the character's overlay back up
	function closeOverlay() {
	    this.parentNode.parentNode.style.height = "0";
	}
})();