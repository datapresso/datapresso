<?php include 'sqlserverdetails.php'
$fn = $_POST['fn'];
$ln = $_POST['ln'];

$conn = mysql_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
  die('>>Could not connect: ' . mysql_error());
}
//echo '>>Connected successfully<br>';


if( !mysql_select_db( $dbname ) ){
  die('>>Could not open database: '.$dbname . mysql_error().'<br>');
}
//echo '>>Connected to database: '.$dbname.'<br>';


          mysql_unbuffered_query("	CREATE VIEW Temp1 AS 
									SELECT DISTINCT sectionid 
									FROM person
									WHERE lastname = '".$ln."'
									AND firstname = '".$fn."';");
									
		  mysql_unbuffered_query(" 	CREATE VIEW Temp2 AS
									SELECT DISTINCT P.firstname, P.lastname, T.*
									FROM person P, Temp1 T
									WHERE P.sectionid = T.sectionid
									AND (P.lastname != '".$ln."'
									OR P.firstname != '".$fn."');");
			
		$result = mysql_query("	SELECT DISTINCT	CONCAT(CONCAT(P.sectionid,P.firstname),P.lastname) AS id,
								P.firstname AS fname,
								CASE WHEN P.middlename IS NOT NULL THEN P.middlename ELSE '' END AS mname,
								P.lastname AS lname,
								P.sectionid AS sid
								FROM person P, Temp2 T
								WHERE P.firstname IS NOT NULL 
								AND   P.firstname != ''
								AND   P.lastname IS NOT NULL
								AND   P.lastname != ''
								AND   P.lastname = T.lastname
								AND	  P.firstname = T.firstname;");
								
		mysql_unbuffered_query("DROP VIEW Temp1;");
		mysql_unbuffered_query("DROP VIEW Temp2;");
					   
if (!$result) {
    die('Could not run query:' . mysql_error() );
}
//echo '>>Query finished<br>';


$box = array();

	while($row = mysql_fetch_array($result))
	  {
	  array_push($box, $row);
	  //echo $row['firstname'];
	  //echo "<br>";
	  }
 //$row = mysql_fetch_array($result);
 header('Content-Type: application/json');
 echo json_encode( $box, JSON_PRETTY_PRINT );
  
mysql_close($conn);
//echo '>>Connection Closed<br>';
?>