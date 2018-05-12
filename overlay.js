(function () {
   "use strict";
   // Given an id, returns the corresponding element
	function $(id) { return document.getElementById(id); }

	// Given a selector, returns all the elements that match that selection
	function qsa(sel) { return document.querySelectorAll(sel); }

	// Give a selector, returns the first element that matches that selection
	function qs(sel) { return document.querySelector(sel); }
   
	window.onload = function() {
		$("bojack-img").onclick = openNav;
		$("carolyn-img").onclick = openCarolyn;
		$("diane-img").onclick = openDiane;
		$("mr-peanutbutter-img").onclick = openMrPB;
		$("todd-img").onclick = openTodd;
  	};

  	/* Open */
	function openNav() {
	    document.getElementById("bojack-overlay").style.height = "100%";
	}

	function openCarolyn() {
	    document.getElementById("carolyn-overlay").style.height = "100%";
	}

	function openDiane() {
	    document.getElementById("diane-overlay").style.height = "100%";
	}

	function openMrPB() {
	    document.getElementById("mr-peanutbutter-overlay").style.height = "100%";
	}

	function openTodd() {
		document.getElementById("todd-overlay").style.height = "100%";
	}

	/* Close */
	function closeNav() {
	    document.getElementById("bojack-overlay").style.height = "0";
	}
})();