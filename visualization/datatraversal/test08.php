<?php
$loc = $_POST['loc'];

$dbhost = 'localhost:3306';
$dbuser = 'root';
$dbpass = 'password';
$dbname = 'datapresso';
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


          mysql_unbuffered_query("	CREATE VIEW Temp1 AS SELECT DISTINCT coveredText, sectionid
									FROM address
									WHERE coveredText = '".$loc."';");
									
		  mysql_unbuffered_query(" 	CREATE VIEW Temp2 AS SELECT DISTINCT	CONCAT(CONCAT(P.sectionid,P.firstname),P.lastname) AS id,
									P.firstname AS fname,
									CASE WHEN P.middlename IS NOT NULL THEN P.middlename ELSE '' END AS mname,
									P.lastname AS lname,
									P.sectionid AS sid
									FROM person P
									WHERE P.firstname IS NOT NULL 
									AND   P.firstname != ''
									AND   P.lastname IS NOT NULL
									AND   P.lastname != '';");
			
		$result = mysql_query("	SELECT A.*, B.*
								FROM Temp1 A, Temp2 B
								WHERE A.sectionid = B.sid;");
								
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