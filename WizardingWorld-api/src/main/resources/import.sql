insert into wizardingschool (id, name) values (1, 'Hogwarts'); 
insert into student (name, wizarding_school_id) values ('Harry',1);
insert into student (name, wizarding_school_id) values ('Hermione',1);
insert into student (name, wizarding_school_id) values ('Ronald',1);
update student set family_name='Potter' where name='Harry';  
update student set family_name='Wesley' where name='Ronald';  
update student set family_name='Granger' where name='Hermione'; 
insert into subject (name) values ('Astronomy');  
