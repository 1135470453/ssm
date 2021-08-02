<?php
session_start();
$_SESSION['count']++;
 echo "You have visited here ".
     $_SESSION['count']." time(s).";
?>
<a href="test.php">Visit page1.php</a>
