CREATE DEFINER=`root`@`localhost` PROCEDURE `emp_details`(
id integer
)
BEGIN
	select * from employee
    cross join dept
    on employee.dept = dept.id and dept.id = id;
END