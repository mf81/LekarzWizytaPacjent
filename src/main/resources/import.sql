insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Zbigniew','Marchewa','proktolog');
insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Krystyna','Jednooko','okulista');
insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Wiesław','Muszelka','ginekolog');

insert into patient(name_of_patient,surname_of_patient) values ('Maciej','Fijałkowski');
insert into patient(name_of_patient,surname_of_patient) values ('Małgorzata','Wąsacz');
insert into patient(name_of_patient,surname_of_patient) values ('Krzysztof','Fijałkowski');

insert into medical_visit(date_and_time_of_visit,doctor_id,patient_id) values ('2018-02-20 12:15',1,1);
insert into medical_visit(date_and_time_of_visit,doctor_id,patient_id) values ('2018-03-01 13:25',1,1);
insert into medical_visit(date_and_time_of_visit,doctor_id,patient_id) values ('2018-03-01 13:25',2,2);