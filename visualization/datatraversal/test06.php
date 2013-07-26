<?php
$x = $_POST['x'];

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


$result = mysql_query("SELECT 	id, 
                                id AS name
					   FROM	document");
					   
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