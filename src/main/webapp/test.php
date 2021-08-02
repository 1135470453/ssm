<html>
<head>

</head>
<body>

<form method="GET" action="test.php">
    <p>Please input your student ID: <input type="text"
                                            name="ID" /></p>
    <input type="submit" value="Check your score">
</form>
<?php
    if ($_GET["ID"] == ""){
        print ("Fill in your student ID");
    }
$list = array (
    array ("name" => "Andy", "id" => 21345678,
        "score" => 58),
    array ("name" => "Benson", "id" => 23454567,
        "score" => 76),
    array ("name" => "Candy", "id" => 29876543,
        "score" => 61),
    array ("name" => "Danny", "id" => 22334455,
        "score" => 69),
    array ("name" => "Elaine", "id" => 25457678,
        "score" => 87),
    array ("name" => "Felix", "id" => 28268626,
        "score" => 72)
);

