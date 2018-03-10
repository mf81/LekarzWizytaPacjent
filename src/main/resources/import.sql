insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Zbigniew','Marchewa','proktolog');
insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Krystyna','Jednooko','okulista');
insert into doctor(name_of_doctor,surname_of_doctor,specializacion) values ('Wiesław','Muszelka','ginekolog');

insert into patient(name_of_patient,surname_of_patient) values ('Maciej','Fijałkowski');
insert into patient(name_of_patient,surname_of_patient) values ('Małgorzata','Wąsacz');
insert into patient(name_of_patient,surname_of_patient) values ('Krzysztof','Fijałkowski');

insert into medical_visit(date_of_visit,time_of_visit,doctor_id,patient_id) values ('10.02.2018','15:00',1,1);
insert into medical_visit(date_of_visit,time_of_visit,doctor_id,patient_id) values ('05.03.2018','10:00',1,1);