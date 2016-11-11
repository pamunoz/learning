<?php
  /*
   * This is the first file loaded by the web server.
   * It prints some messages and html from other files.
   */

  // let's print a message from php
  echo 'hello world';

  // and then include the rest of html
  require 'page1/index.html';

  $a =1;
  $b = 2;
  $c = $a + $b;
  echo $c; // 3
?>
