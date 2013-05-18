delete from company
delete from person
delete from compensation

select * from company
select * from person
select * from compensation order by companyid,name,year

GRANT ALL ON DATABASE cersold TO cersuser

\d company

insert into person values (-363879114, 'Stephanie', 'G', 'DiMarco', 0, NULL, NULL, NULL, NULL, 1002225)

SELECT STR_TO_DATE('04/31/2004', '%m/%d/%Y');
SELECT to_timestamp('2008-08-01', 'YYYY-MM-DD') AS date;