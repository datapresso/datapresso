<?php
//$x = $_POST['x'];

$dbhost = 'localhost:3306';
$dbuser = 'root';
$dbpass = 'password';
$dbname = 'datapresso';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
  die('>>Could not connect: ' . mysql_error());
}


if( !mysql_select_db( $dbname ) ){
  die('>>Could not open database: '.$dbname . mysql_error().'<br>');
}


$result = mysql_query("SELECT DISTINCT	CONCAT(CONCAT(P.sectionid,P.firstname),P.lastname) AS id,
				P.firstname AS fname,
				CASE WHEN P.middlename IS NOT NULL THEN P.middlename ELSE '' END AS mname,
				P.lastname AS lname,
				P.sectionid AS sid
                       FROM person P 
					   WHERE P.firstname IS NOT NULL 
					   AND   P.firstname != ''
					   AND   P.lastname IS NOT NULL
					   AND   P.lastname != ''");
if (!$result) {
    die('Could not run query:' . mysql_error() );
}


$box = array();

	while($row = mysql_fetch_array($result))
	  {
	  array_push($box, $row);
	  }

 header('Content-Type: application/json');
 echo json_encode( $box, JSON_PRETTY_PRINT );
  
mysql_close($conn);

?>