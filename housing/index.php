<html>

<body>
<form action="checkentry.php" method="post">
<!--General Information: Name, CWID, Gender-->
<table>
<tr><td>First Name:</td><td><input type="text" name="fname" value="First Name"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname" value="Last Name"></td></tr>
<tr><td>CWID:</td><td><input type="text" name="cwid" value="XXX-XX-XXX"></td></tr>
</table></br>
<input type="radio" name="gender" value="male" checked="true"> Male</br>
<input type="radio" name="gender" value="female"> Female</br>
<input type="radio" name="gender" value="other"> Other</br></br>
<!--Class (Freshman, Sophomore, etc.)-->
<input type="radio" name="class" value="freshman" checked="true"> Freshman</br>
<input type="radio" name="class" value="sophomore"> Sophomore</br>
<input type="radio" name="class" value="junior"> Junior</br>
<input type="radio" name="class" value="senior"> Senior</br></br>
<!--Residence Area Selection: student picks zero or one of the Marist Residence Areas (http://www.marist.edu/housing/residence.html)-->
<input type="radio" name="house" value="leo"> Leo Hall</br>
<input type="radio" name="house" value="champ"> Champagnant Hall</br>
<input type="radio" name="house" value="marian"> Marian Hall</br>
<input type="radio" name="house" value="sheahan"> Sheahan Hall</br>
<input type="radio" name="house" value="midrise"> Midrise Hall</br>
<input type="radio" name="house" value="foy"> Foy Townhouses</br>
<input type="radio" name="house" value="new"> New Townhouses</br>
<input type="radio" name="house" value="lowerwest"> Lower West Cedar St. Townhouses</br>
<input type="radio" name="house" value="upperwest"> Upper West Cedar St. Townhouses</br>
<input type="radio" name="house" value="newgarland"> Building A</br>
<input type="radio" name="house" value="newfulton"> New Fulton Townhouses</br>
<input type="radio" name="house" value="fultonst"> Fulton St Townhouses</br>
<input type="radio" name="house" value="talmadge"> Talmadge Court</br></br>
<!--Preferences:
    Special Needs
    Laundry on Premise
    Fully Equipped Kitchen-->
<input type="checkbox" name="special" value="true"> Special Needs</br>
<input type="checkbox" name="laundry" value="true"> Laundry on Premise</br>
<input type="checkbox" name="kitchen" value="true"> Fully Equipped Kitchen</br>
<input type="submit" value="Submit">   
</form>
</body>    
</html>