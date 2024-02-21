insert into empleado (id, nombre, apellidos)
select 1, 'Rocío', 'De la O' from dual where not exists (select 1 from empleado where id = 1);

insert into empleado (id, nombre, apellidos)
select 2, 'Alberto', 'Del Monte' from dual where not exists (select 1 from empleado where id = 2);

insert into asignatura (id, nombre, descripcion, curso)
select 1, 'Matemáticas', 'Asignatura de matemáticas', 2 from dual where not exists (select 1 from asignatura where id = 1);

insert into asignatura (id, nombre, descripcion, curso)
select 2, 'Física', 'Asignatura de física', 3 from dual where not exists (select 1 from asignatura where id = 2);
