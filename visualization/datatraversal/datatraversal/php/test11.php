<?php
include 'sqlserverdetails.php';

$fn = $_POST['fn'];
$ln = $_POST['ln'];

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


		mysqli_query( $conn, "CREATE VIEW Temp AS SELECT DISTINCT sectionid
								FROM person
								WHERE lastname = '".$ln."'
								AND firstname = '".$fn."';");

$result = mysqli_query( $conn, "	SELECT DISTINCT A.id, A.id AS name 
						FROM	document A, Temp T
						WHERE  A.id = T.sectionid;");
										 
		mysqli_query( $conn, "DROP VIEW Temp;");
					   
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
  
mysql_close($conn);
//echo '>>Connection Closed<br>';
?>