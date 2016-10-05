
<html><body><?php
$housingOptions = array("leo","champ","marian","sheahan","midrise","foy","new","lowerwest","upperwest","newgarland","newfulton","fultonst","talmadge");
$freshman = array("leo","sheahan","champ","marian");
$sophmore = array("foy","new","midrise","lowerwest","upperwest");
$upperclassmen = array("newgarland","newfulton","fultonst","talmagde");
$laundry = array("leo","champ","marian","sheahan","midrise","foy","new","lowerwest","upperwest","newgarland","newfulton","fultonst","talmadge");
$special = array("foy","new","upperwest",);
$kitchen = array("leo","sheahan","champ","foy","new","lowerwest","upperwest","newgarland","newfulton","fultonst","talmadge");
$longName = array("leo" => "Leo Hall",
"champ" => "Champagnant Hall",
"marian" => "Marian Hall",
"sheahan" => "Sheahan Hall",
"midrise" => "Midrise Hall",
"foy" => "Foy Townhouses",
"new" => "New Townhouses",
"lowerwest" => "Lower West Cedar St. Townhouses",
"upperwest" => "Upper West Cedar St. Townhouses", 
"newgarland" => "Building A",
"newfulton" => "New Fulton Townhouses",
"fultonst" => "Fulton St. Townhouses",
"talmadge" => "Talmadge Court");
$classhouse;

//print_r($_POST); echo "</br>";//debug

switch ($_POST["class"]) {
    case "freshman": 
        $classhouse = $freshman;
        break;
    case "sophomore": 
        $classhouse = $sophmore;
        break;
    case "junior": 
    case "senior": 
        $classhouse = $upperclassmen;
        break;
    default:
        $classhouse = array("error");
        break;
}

//echo "classhouse";print_r($classhouse);echo "</br>";//debug
if ($_POST["house"] == null){
    echo "Housing options that meet your criteria: </br><form action='confirmation.php' method='post'>"; 
    foreach($housingOptions as $i){
        if(checkmatch($i) == true)
            //echo $i . "</br>";
            echo "<input type='radio' name='house' value='$i'> $longName[$i] </br>";
        }
    foreach($_POST as $j){
            echo "<input type='hidden' name='" . key($_POST) . "' value='$j'>";
            //echo key($_POST) . "=>" . $j . "</br>"; //debug
            next($_POST);
    }
    echo "<input type='submit' value='Submit'></form>";
}
else if (checkmatch($_POST["house"])){ //works i think
    echo "<form action='confirmation.php' method='post'>";
    echo "Your housing selection meets your criteria. Click to access confirmation. </br>";
    foreach($_POST as $j){
            echo "<input type='hidden' name='" . key($_POST) . "' value='$j'>";
            //echo key($_POST) . "=>" . $j . "</br>"; //debug
            next($_POST);
        }
    echo "<input type='submit' value='Confirm'></form>";
}
else { //works
    echo "Your housing selection does not meet your criteria. Click to return to the previous page. </br>";
    echo "<a href='index.php'><button type='button'>Return</button></a>"; 
}
function checkmatch ($house){
    //echo $house . "</br>";
    global $laundry;
    //print_r ($laundry); echo "laundry </br>";//debug
    global $kitchen;
    //print_r ($kitchen); echo "kitchen </br>";  //debug
    global $special;
    //print_r ($special); echo "special </br>"; //debug
    global $classhouse;
    //print_r ($classhouse);  echo "class </br>";//debug
    if ((in_array($house,$special) OR $_POST["special"] == FALSE) AND (in_array($house,$laundry) OR $_POST["laundry"] == FALSE) AND (in_array($house,$kitchen) OR $_POST["kitchen"] == FALSE) AND (in_array($house,$classhouse))) {
        //echo "yay"; echo "</br>";//debug
        return true;
    }
    else {
        //echo "nay"; echo "</br>";//debug
        return false;
    }
    
}
?></body></html>