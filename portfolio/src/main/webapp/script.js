// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

jQuery(document).ready(function($) {


	var mastheadheight = $('.ds-header').outerHeight();
    console.log(mastheadheight);
	$(".ds-banner,.ds-main-section").css("margin-top" , mastheadheight);

	$(window).scroll(function(){
	    if ($(window).scrollTop() >= 10) {
	        $('.ds-header').addClass('ds-fixed-header');
	    }
	    else {
	        $('.ds-header').removeClass('ds-fixed-header');
	    }
	}).scroll();


 });

 /**
  * fetches the string from servlet
  */

  async function getString(){
      const responseFromServer= await fetch('/hello');
      const textFromResponse= await responseFromServer.json();
     // console.log(textFromResponse);
      const quote = textFromResponse[Math.floor(Math.random() * textFromResponse.length)];
      const quoteContainer = document.getElementById('quote-container');
      quoteContainer.innerText = quote;
  }



/**
 * Adds a random greeting to the page.
 */
function addRandomQuote() {
  const quotes =
      ['I have never lost a game of Othello.', 'I was born in Delhi, India.', 'My second toe is bigger than my first toe.', 'I can touch my nose with my tongue.'];

  // Pick a random greeting.
  const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Add it to the page.
  const quoteContainer = document.getElementById('quote-container');
  quoteContainer.innerText = quote;
}