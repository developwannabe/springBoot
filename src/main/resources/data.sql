DELETE FROM EMPLEADO;
DELETE FROM ASIGNATURA;
DELETE FROM USUARIO;
DELETE FROM ROL;

insert into empleado (id, nombre, apellidos)
select 1, 'Rocío', 'De la O' from dual where not exists (select 1 from empleado where id = 1);

insert into empleado (id, nombre, apellidos)
select 2, 'Alberto', 'Del Monte' from dual where not exists (select 1 from empleado where id = 2);

insert into asignatura (id, nombre, descripcion, curso)
select 1, 'Matemáticas', 'Asignatura de matemáticas', 2 from dual where not exists (select 1 from asignatura where id = 1);

insert into asignatura (id, nombre, descripcion, curso)
select 2, 'Física', 'Asignatura de física', 3 from dual where not exists (select 1 from asignatura where id = 2);

insert into rol (id, rol)
select 1, 'ADMIN' from dual where not exists (select 1 from rol where id = 1);

insert into rol (id, rol)
select 2, 'GESTOR' from dual where not exists (select 1 from rol where id = 2);

/* pass = 1111 */
insert into usuario (username, nombre, password, rol_id)
select 'user1', 'Illán',
'$2a$10$5xOe75pbLcAjp0TbVWaluunrSshgYdH82YNwGd.b0Os4hAWbIEkry', 1 from dual where not
exists (select 1 from usuario where username = 'user1');

insert into usuario (username, nombre, password, rol_id)
select 'user2', 'Empleado de everis',
'$2a$10$5xOe75pbLcAjp0TbVWaluunrSshgYdH82YNwGd.b0Os4hAWbIEkry', 2 from dual where not
exists (select 1 from usuario where username = 'user2');