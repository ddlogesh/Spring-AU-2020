CREATE DEFINER=`root`@`localhost` PROCEDURE `pagination`(
pageno integer,
count integer
)
BEGIN
	set pageno = (pageno * count);
	select * from emp limit count offset pageno;
END