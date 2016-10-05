<html>
<body>
    here is your confirmation of your prefrences.
<table>    
<?php
    echo"<tr><td>First Name</td><td>$_POST[fname]</td</tr>
         <tr><td>Last Name</td><td>$_POST[lname]</td</tr>
         <tr><td>Gender</td><td>$_POST[gender]</td</tr>
         <tr><td>Class</td><td>$_POST[class]</td></tr>
         <tr><td>House</td><td>$_POST[house]</td></tr>
         <tr><td>other requests</td><td>";
         if ($_POST["special"] == true){echo "Special Needs<br>";}
         if ($_POST["laundry"] == true){echo "Laundry on Premise<br>";}
         if ($_POST["kitchen"] == true){echo "Fully Equipped Kitchen<br>";}
         else {echo "None";}
         echo "</td></tr>";
        
?>
</table>
</body>    
</html>