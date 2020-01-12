DELIMITER $$
CREATE TRIGGER trig_before_insert BEFORE insert ON emp
FOR EACH ROW
BEGIN
  IF (NEW.salary < 1000) THEN
    set NEW.salary = NEW.salary + 500;
  END IF;
END$$
DELIMITER ;

insert into emp value(4, 'logesh4', 850);	# inserts 1350
insert into emp value(5, 'logesh5', 1300);	# inserts 1300 (actual value)

#------------------------------------------------------------------#

DELIMITER $$
CREATE TRIGGER trig_before_update BEFORE update ON emp
FOR EACH ROW
BEGIN
  IF (OLD.salary < 1000) THEN
    set NEW.salary = 1000;
  END IF;
END$$
DELIMITER ;

update emp
set salary = 1100
where id = 1;	# updates 1000

update emp
set salary = 1700
where id = 5;	# updates 1700 (actual value)

#------------------------------------------------------------------#

DELIMITER $$
CREATE TRIGGER trig_before_delete BEFORE delete ON emp
FOR EACH ROW
BEGIN
  insert into deleted_emp(id, name, salary) value(OLD.id, OLD.name, OLD.salary);
END$$
DELIMITER ;

delete from emp
where id = 3; # Move the record from 'emp' to 'deleted_emp' table along with deleted timestamp.