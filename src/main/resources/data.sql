insert into role (role_id, role_name, role_discipline) values (1, 'Software Engineer','Engineering');
insert into role (role_id, role_name, role_discipline) values (2, 'Data Analyst','Data Science & Analytics');
insert into role (role_id, role_name, role_discipline) values (3, 'Senior Manager','Unknown');
insert into role (role_id, role_name, role_discipline) values (4, 'Sales Associate','Sales');
insert into role (role_id, role_name, role_discipline) values (5, 'Director','Unknown');

insert into skill (skill_id, skill_name, skill_type, role_name) values (1001, 'Java', 'Technical', 'Software Engineer');
insert into skill (skill_id, skill_name, skill_type, role_name) values (1002, 'Python', 'Technical', 'Software Engineer');
insert into skill (skill_id, skill_name, skill_type, role_name) values (1003, 'C++', 'Technical', 'Software Engineer');
insert into skill (skill_id, skill_name, skill_type, role_name) values (1004, 'Customer Service', 'Technical', 'Sales Associate');
insert into skill (skill_id, skill_name, skill_type, role_name) values (1005, 'Product Knowledge', 'Technical', 'Sales Associate');

insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2001, 32,'Male','Masters','Software Engineer',6,100000,'gbp', 1);
insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2002, 28,'Male','Bachelors', 'Software Engineer',2,40000,'gbp', 1);
insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2003, 28,'Female','Bachelors','Software Engineer',3,125000,'gbp', 1);
insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2004, 29,'Female','Bachelors','Software Engineer',4,140000,'gbp', 1);
insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2005, 24,'Male','High School', 'Sales Associate',1,30000,'gbp', 4);
insert into salary (salary_id, age, gender, education_level, role_name, years_of_experience, basic_salary, currency, role_id) values (2006, 29,'Female','High School', 'Sales Associate',1,30000,'gbp', 4);

insert into role_skill (role_id, skill_id) values (1,1001);
insert into role_skill (role_id, skill_id) values (1,1002);
insert into role_skill (role_id, skill_id) values (1,1003);
insert into role_skill (role_id, skill_id) values (4,1004);
insert into role_skill (role_id, skill_id) values (4,1005);