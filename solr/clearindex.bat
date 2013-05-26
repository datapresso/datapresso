curl "http://localhost:8080/solr/update" -d stream.body="<delete><query>*:*</query></delete>"
curl "http://localhost:8080/solr/update" -d stream.body="<commit/>"