<?php
include 'sqlserverdetails.php';

$loc = $_POST['loc'];

$conn = mysqli_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
  die('>> Could not connect: ' .mysqli_connect_error());
}
//echo '>>Connected successfully<br>';


if( !mysqli_select_db( $conn, $dbname ) ){
  die('>> Could not open database: '.$dbname . mysqli_error($conn).'<br>');
}
//echo '>>Connected to database: '.$dbname.'<br>';


          mysqli_query( $conn, "	CREATE VIEW Temp1 AS SELECT DISTINCT coveredText, sectionid
									FROM address
									WHERE coveredText = '".$loc."';");
									
		  mysqli_query( $conn, " 	CREATE VIEW Temp2 AS SELECT DISTINCT	CONCAT(CONCAT(P.sectionid,P.firstname),P.lastname) AS id,
									P.firstname AS fname,
									CASE WHEN P.middlename IS NOT NULL THEN P.middlename ELSE '' END AS mname,
									P.lastname AS lname,
									P.sectionid AS sid
									FROM person P
									WHERE P.firstname IS NOT NULL 
									AND   P.firstname != ''
									AND   P.lastname IS NOT NULL
									AND   P.lastname != '';");
			
		$result = mysqli_query( $conn, "	SELECT A.*, B.*
										FROM Temp1 A, Temp2 B
										WHERE A.sectionid = B.sid;");
								
		mysqli_query( $conn, "DROP VIEW Temp1;");
		mysqli_query( $conn, "DROP VIEW Temp2;");
					   
if (!$result) {
    die('Could not run query:' . mysqli_error($conn) );
}
//echo '>>Query finished<br>';


$box = array();

	while($row = mysqli_fetch_array($result))
	  {
	  array_push($box, $row);
	  //echo $row['firstname'];
	  //echo "<br>";
	  }
 //$row = mysql_fetch_array($result);
 header('Content-Type: application/json');
 echo json_encode( $box, JSON_PRETTY_PRINT );
  
mysqli_close( $conn );
//echo '>>Connection Closed<br>';
?>