-- =====================================================
-- FAKE DATA FOR HOSPITAL MANAGEMENT SYSTEM
-- Based on actual database schema from 'clinica' database
-- =====================================================

-- Clear existing data (optional - uncomment if needed)
-- DELETE FROM consulta;
-- DELETE FROM historial_diagnosticos;
-- DELETE FROM historial_tratamientos;
-- DELETE FROM historial_medico;
-- DELETE FROM medico_horario;
-- DELETE FROM administrativo;
-- DELETE FROM enfermero;
-- DELETE FROM medico;
-- DELETE FROM empleado;
-- DELETE FROM pacientes;
-- DELETE FROM persona;

-- =====================================================
-- PERSONA DATA (Base for all entities)
-- =====================================================
INSERT INTO persona (id, nombre, apellido, dni, fecha_nacimiento, direccion, telefono, email, activo) VALUES
-- Patients (ID 1-20)
(1, 'Juan', 'Pérez', 12345678, '1980-05-10', 'Calle Falsa 123, Buenos Aires', '555-1234', 'juan.perez@email.com', 1),
(2, 'María', 'Gómez', 87654321, '1990-08-22', 'Avenida Siempre Viva 742, CABA', '555-5678', 'maria.gomez@email.com', 1),
(3, 'Carlos', 'López', 11223344, '1975-12-01', 'Calle Salud 55, Rosario', '555-1111', 'carlos.lopez@email.com', 1),
(4, 'Ana', 'Martínez', 22334455, '1985-03-15', 'Rivadavia 1000, La Plata', '555-2222', 'ana.martinez@email.com', 1),
(5, 'Roberto', 'Fernández', 33445566, '1970-07-08', 'San Martín 500, Córdoba', '555-3333', 'roberto.fernandez@email.com', 1),
(6, 'Laura', 'Rodríguez', 44556677, '1992-11-30', 'Belgrano 200, Mendoza', '555-4444', 'laura.rodriguez@email.com', 1),
(7, 'Miguel', 'García', 55667788, '1988-04-12', 'Sarmiento 750, Tucumán', '555-5555', 'miguel.garcia@email.com', 1),
(8, 'Carmen', 'Hernández', 66778899, '1983-09-25', 'Mitre 300, Salta', '555-6666', 'carmen.hernandez@email.com', 1),
(9, 'Diego', 'Moreno', 77889900, '1978-01-18', 'Urquiza 450, Neuquén', '555-7777', 'diego.moreno@email.com', 1),
(10, 'Patricia', 'Jiménez', 88990011, '1995-06-03', 'Alberdi 600, Bahía Blanca', '555-8888', 'patricia.jimenez@email.com', 1),
(11, 'Fernando', 'Torres', 99001122, '1987-12-14', 'Roca 800, Mar del Plata', '555-9999', 'fernando.torres@email.com', 1),
(12, 'Isabel', 'Ruiz', 11002233, '1981-02-28', 'Pueyrredón 350, San Juan', '555-0000', 'isabel.ruiz@email.com', 1),
(13, 'Ricardo', 'Díaz', 22003344, '1973-10-07', 'Rawson 900, Santa Fe', '555-1112', 'ricardo.diaz@email.com', 1),
(14, 'Elena', 'Morales', 33004455, '1989-05-20', 'Lavalle 250, Paraná', '555-2223', 'elena.morales@email.com', 1),
(15, 'Alberto', 'Castro', 44005566, '1976-08-11', 'Pellegrini 700, Resistencia', '555-3334', 'alberto.castro@email.com', 1),
(16, 'Sofía', 'Ortiz', 55006677, '1993-03-26', 'Independencia 400, Corrientes', '555-4445', 'sofia.ortiz@email.com', 1),
(17, 'Héctor', 'Silva', 66007788, '1984-07-19', 'Libertad 550, Posadas', '555-5556', 'hector.silva@email.com', 1),
(18, 'Natalia', 'Cruz', 77008899, '1991-11-02', 'San Lorenzo 650, Formosa', '555-6667', 'natalia.cruz@email.com', 1),
(19, 'Oscar', 'Flores', 88009900, '1986-04-09', 'Entre Ríos 750, Santiago del Estero', '555-7778', 'oscar.flores@email.com', 1),
(20, 'Verónica', 'Reyes', 99000011, '1979-12-31', 'Catamarca 850, Jujuy', '555-8889', 'veronica.reyes@email.com', 1),

-- Employees (ID 21-40)
(21, 'Dr. Alejandro', 'González', 11111111, '1975-03-15', 'Av. Corrientes 1500, CABA', '555-1001', 'alejandro.gonzalez@hospital.com', 1),
(22, 'Dra. Beatriz', 'Ramírez', 22222222, '1980-07-22', 'Belgrano 800, CABA', '555-1002', 'beatriz.ramirez@hospital.com', 1),
(23, 'Dr. Claudio', 'Morales', 33333333, '1978-11-08', 'Palermo 1200, CABA', '555-1003', 'claudio.morales@hospital.com', 1),
(24, 'Dra. Diana', 'Vargas', 44444444, '1982-04-30', 'Recoleta 600, CABA', '555-1004', 'diana.vargas@hospital.com', 1),
(25, 'Dr. Eduardo', 'Soto', 55555555, '1973-09-12', 'Villa Crespo 900, CABA', '555-1005', 'eduardo.soto@hospital.com', 1),
(26, 'Enf. Fabiana', 'Luna', 66666666, '1985-01-25', 'Caballito 1100, CABA', '555-1006', 'fabiana.luna@hospital.com', 1),
(27, 'Enf. Gabriel', 'Herrera', 77777777, '1987-06-18', 'Flores 700, CABA', '555-1007', 'gabriel.herrera@hospital.com', 1),
(28, 'Enf. Helena', 'Cortés', 88888888, '1989-12-03', 'Villa Devoto 500, CABA', '555-1008', 'helena.cortes@hospital.com', 1),
(29, 'Enf. Ignacio', 'Paredes', 99999999, '1984-08-14', 'Villa Pueyrredón 800, CABA', '555-1009', 'ignacio.paredes@hospital.com', 1),
(30, 'Enf. Julia', 'Rojas', 10101010, '1990-02-28', 'Villa Urquiza 400, CABA', '555-1010', 'julia.rojas@hospital.com', 1),
(31, 'Adm. Kevin', 'Mendoza', 20202020, '1986-05-07', 'Villa Ortúzar 300, CABA', '555-1011', 'kevin.mendoza@hospital.com', 1),
(32, 'Adm. Lucía', 'Aguilar', 30303030, '1988-10-20', 'Villa General Mitre 600, CABA', '555-1012', 'lucia.aguilar@hospital.com', 1),
(33, 'Adm. Marcos', 'Valdez', 40404040, '1983-03-11', 'Villa Santa Rita 450, CABA', '555-1013', 'marcos.valdez@hospital.com', 1),
(34, 'Adm. Nora', 'Campos', 50505050, '1981-07-04', 'Villa del Parque 750, CABA', '555-1014', 'nora.campos@hospital.com', 1),
(35, 'Adm. Omar', 'Ríos', 60606060, '1987-12-16', 'Villa Luro 550, CABA', '555-1015', 'omar.rios@hospital.com', 1);

-- =====================================================
-- EMPLEADO DATA (Base for medical staff)
-- =====================================================
INSERT INTO empleado (id, salario, cargo, fecha_contratacion) VALUES
-- Doctors (ID 21-25)
(21, 8500.00, 'MEDICO', '2010-01-15'),
(22, 8200.00, 'MEDICO', '2012-03-20'),
(23, 8800.00, 'MEDICO', '2015-06-10'),
(24, 8100.00, 'MEDICO', '2018-09-05'),
(25, 8700.00, 'MEDICO', '2020-02-14'),

-- Nurses (ID 26-30)
(26, 4200.00, 'ESPECIALISTA', '2015-03-20'),
(27, 3800.00, 'ESPECIALISTA', '2016-07-12'),
(28, 4500.00, 'ESPECIALISTA', '2017-11-08'),
(29, 4100.00, 'ESPECIALISTA', '2019-04-25'),
(30, 3900.00, 'ESPECIALISTA', '2021-01-30'),

-- Administrative (ID 31-35)
(31, 3200.00, 'ADMINISTRADOR', '2018-09-10'),
(32, 2800.00, 'RECEPCIONISTA', '2019-05-15'),
(33, 3500.00, 'ADMINISTRADOR', '2020-08-22'),
(34, 3100.00, 'RECEPCIONISTA', '2021-03-11'),
(35, 3300.00, 'ADMINISTRADOR', '2022-06-18');

-- =====================================================
-- MEDICO DATA (5 doctors)
-- =====================================================
INSERT INTO medico (id, especialidad, num_matricula) VALUES
(21, 'CARDIOLOGIA', 'MAT12345'),
(22, 'PEDIATRIA', 'MAT23456'),
(23, 'DERMATOLOGIA', 'MAT34567'),
(24, 'NEUROLOGIA', 'MAT45678'),
(25, 'CLINICA_GENERAL', 'MAT56789');

-- =====================================================
-- MEDICO_HORARIO DATA (Doctor schedules) - MOVED AFTER MEDICO
-- =====================================================
INSERT INTO medico_horario (medico_id, dia, horario) VALUES
(21, 'Lunes', '08:00-12:00'),
(21, 'Martes', '08:00-12:00'),
(21, 'Miércoles', '08:00-12:00'),
(21, 'Jueves', '08:00-12:00'),
(21, 'Viernes', '08:00-12:00'),
(22, 'Lunes', '14:00-18:00'),
(22, 'Martes', '14:00-18:00'),
(22, 'Miércoles', '14:00-18:00'),
(22, 'Jueves', '14:00-18:00'),
(22, 'Viernes', '14:00-18:00'),
(23, 'Lunes', '09:00-13:00'),
(23, 'Martes', '09:00-13:00'),
(23, 'Miércoles', '09:00-13:00'),
(23, 'Jueves', '09:00-13:00'),
(23, 'Viernes', '09:00-13:00'),
(24, 'Lunes', '15:00-19:00'),
(24, 'Martes', '15:00-19:00'),
(24, 'Miércoles', '15:00-19:00'),
(24, 'Jueves', '15:00-19:00'),
(24, 'Viernes', '15:00-19:00'),
(25, 'Lunes', '10:00-14:00'),
(25, 'Martes', '10:00-14:00'),
(25, 'Miércoles', '10:00-14:00'),
(25, 'Jueves', '10:00-14:00'),
(25, 'Viernes', '10:00-14:00');

-- =====================================================
-- ENFERMERO DATA (5 nurses)
-- =====================================================
INSERT INTO enfermero (id, area, turno) VALUES
(26, 'FACTURACION', 'MANANA'),
(27, 'RECEPCION', 'TARDE'),
(28, 'RRHH', 'NOCHE'),
(29, 'ADMINISTRACION', 'MANANA'),
(30, 'FACTURACION', 'TARDE');

-- =====================================================
-- ADMINISTRATIVO DATA (5 administrative staff)
-- =====================================================
INSERT INTO administrativo (id, area) VALUES
(31, 'FACTURACION'),
(32, 'RECEPCION'),
(33, 'RRHH'),
(34, 'ADMINISTRACION'),
(35, 'FACTURACION');

-- =====================================================
-- HISTORIAL_MEDICO DATA (20 records for patients)
-- =====================================================
INSERT INTO historial_medico (id_historial) VALUES 
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10),
(11), (12), (13), (14), (15), (16), (17), (18), (19), (20);

-- =====================================================
-- PACIENTES DATA (20 records)
-- =====================================================
INSERT INTO pacientes (id, grupo_sanguineo, alergias, historial_medico, historial_id) VALUES
(1, 'A_POS', 'POLEN, LACTOSA', 'Sin antecedentes graves', 1),
(2, 'O_NEG', 'NINGUNA', 'Asma infantil', 2),
(3, 'B_POS', 'PENICILINA', 'Hipertensión arterial', 3),
(4, 'AB_NEG', 'SULFAS', 'Diabetes tipo 2', 4),
(5, 'A_NEG', 'NINGUNA', 'Artritis reumatoidea', 5),
(6, 'O_POS', 'MARISCOS', 'Epilepsia controlada', 6),
(7, 'B_NEG', 'NINGUNA', 'Insuficiencia cardíaca', 7),
(8, 'AB_POS', 'LACTOSA', 'Enfermedad pulmonar obstructiva', 8),
(9, 'A_POS', 'POLEN', 'Hipotiroidismo', 9),
(10, 'O_NEG', 'NINGUNA', 'Migraña crónica', 10),
(11, 'B_POS', 'PENICILINA, SULFAS', 'Osteoporosis', 11),
(12, 'AB_NEG', 'NINGUNA', 'Enfermedad de Crohn', 12),
(13, 'A_NEG', 'LACTOSA', 'Psoriasis', 13),
(14, 'O_POS', 'NINGUNA', 'Fibromialgia', 14),
(15, 'B_NEG', 'MARISCOS', 'Esclerosis múltiple', 15),
(16, 'AB_POS', 'POLEN, LACTOSA', 'Lupus eritematoso', 16),
(17, 'A_POS', 'NINGUNA', 'Enfermedad de Parkinson', 17),
(18, 'O_NEG', 'PENICILINA', 'Cáncer de mama en remisión', 18),
(19, 'B_POS', 'NINGUNA', 'Enfermedad renal crónica', 19),
(20, 'AB_NEG', 'SULFAS', 'Esquizofrenia controlada', 20);

-- =====================================================
-- HISTORIAL_DIAGNOSTICOS DATA (Sample diagnoses for each patient)
-- =====================================================
INSERT INTO historial_diagnosticos (historial_id, diagnostico) VALUES
(1, 'Hipertensión arterial'),
(1, 'Diabetes tipo 2'),
(2, 'Asma bronquial'),
(3, 'Artritis reumatoidea'),
(4, 'Epilepsia'),
(5, 'Insuficiencia cardíaca'),
(6, 'EPOC'),
(7, 'Hipotiroidismo'),
(8, 'Migraña'),
(9, 'Osteoporosis'),
(10, 'Enfermedad de Crohn'),
(11, 'Psoriasis'),
(12, 'Fibromialgia'),
(13, 'Esclerosis múltiple'),
(14, 'Lupus eritematoso'),
(15, 'Enfermedad de Parkinson'),
(16, 'Cáncer de mama'),
(17, 'Enfermedad renal crónica'),
(18, 'Esquizofrenia'),
(19, 'Depresión mayor'),
(20, 'Trastorno bipolar');

-- =====================================================
-- HISTORIAL_TRATAMIENTOS DATA (Sample treatments for each patient)
-- =====================================================
INSERT INTO historial_tratamientos (historial_id, tratamiento) VALUES
(1, 'Enalapril 10mg diario'),
(1, 'Metformina 500mg dos veces al día'),
(2, 'Salbutamol inhalador según necesidad'),
(3, 'Methotrexate semanal'),
(4, 'Levetiracetam 500mg dos veces al día'),
(5, 'Furosemida 40mg diario'),
(6, 'Bromuro de tiotropio inhalador'),
(7, 'Levotiroxina 50mcg diario'),
(8, 'Sumatriptán según necesidad'),
(9, 'Alendronato semanal'),
(10, 'Mesalazina 800mg tres veces al día'),
(11, 'Betametasona tópica'),
(12, 'Duloxetina 60mg diario'),
(13, 'Interferón beta-1a semanal'),
(14, 'Hidroxicloroquina 200mg diario'),
(15, 'Levodopa/Carbidopa tres veces al día'),
(16, 'Tamoxifeno 20mg diario'),
(17, 'Epoetina alfa semanal'),
(18, 'Risperidona 2mg diario'),
(19, 'Sertralina 50mg diario'),
(20, 'Litio 600mg dos veces al día');

-- =====================================================
-- CONSULTA DATA (20 medical appointments)
-- =====================================================
INSERT INTO consulta (id_consulta, fecha_consulta, hora_consulta, motivo, diagnostico, tratamiento_indicado, medico_id, paciente_id, historial_id) VALUES
(1, '2024-01-15', '09:00:00', 'Control de hipertensión', 'Hipertensión controlada', 'Continuar con Enalapril', 21, 1, 1),
(2, '2024-01-16', '10:30:00', 'Crisis asmática', 'Exacerbación asmática', 'Aumentar dosis de Salbutamol', 22, 2, 2),
(3, '2024-01-17', '14:00:00', 'Dolor articular', 'Artritis activa', 'Ajustar dosis de Methotrexate', 23, 3, 3),
(4, '2024-01-18', '11:15:00', 'Control diabetes', 'Diabetes compensada', 'Mantener Metformina', 25, 4, 4),
(5, '2024-01-19', '16:30:00', 'Convulsión', 'Epilepsia controlada', 'Continuar Levetiracetam', 24, 5, 5),
(6, '2024-01-20', '08:45:00', 'Falta de aire', 'Insuficiencia cardíaca estable', 'Ajustar Furosemida', 21, 6, 6),
(7, '2024-01-21', '13:20:00', 'Tos persistente', 'EPOC estable', 'Mantener tratamiento', 25, 7, 7),
(8, '2024-01-22', '10:00:00', 'Fatiga', 'Hipotiroidismo compensado', 'Ajustar Levotiroxina', 25, 8, 8),
(9, '2024-01-23', '15:45:00', 'Dolor de cabeza', 'Migraña', 'Sumatriptán según necesidad', 24, 9, 9),
(10, '2024-01-24', '09:30:00', 'Control osteoporosis', 'Osteoporosis estable', 'Continuar Alendronato', 25, 10, 10),
(11, '2024-01-25', '12:00:00', 'Dolor abdominal', 'Enfermedad de Crohn activa', 'Aumentar Mesalazina', 25, 11, 11),
(12, '2024-01-26', '14:30:00', 'Lesiones en piel', 'Psoriasis activa', 'Betametasona tópica', 23, 12, 12),
(13, '2024-01-27', '11:00:00', 'Dolor generalizado', 'Fibromialgia', 'Duloxetina 60mg', 25, 13, 13),
(14, '2024-01-28', '16:15:00', 'Control esclerosis', 'Esclerosis múltiple estable', 'Continuar Interferón', 24, 14, 14),
(15, '2024-01-29', '08:30:00', 'Erupción cutánea', 'Lupus activo', 'Ajustar Hidroxicloroquina', 23, 15, 15),
(16, '2024-01-30', '13:45:00', 'Temblores', 'Parkinson estable', 'Ajustar Levodopa', 24, 16, 16),
(17, '2024-02-01', '10:15:00', 'Control oncológico', 'Cáncer en remisión', 'Continuar Tamoxifeno', 25, 17, 17),
(18, '2024-02-02', '15:00:00', 'Anemia', 'Enfermedad renal estable', 'Ajustar Epoetina', 21, 18, 18),
(19, '2024-02-03', '12:30:00', 'Control psiquiátrico', 'Esquizofrenia estable', 'Mantener Risperidona', 24, 19, 19),
(20, '2024-02-04', '09:45:00', 'Estado de ánimo', 'Trastorno bipolar controlado', 'Ajustar Litio', 24, 20, 20);

-- =====================================================
-- DATA SUMMARY
-- =====================================================
-- Total records created:
-- - 35 personas (20 patients + 15 employees)
-- - 15 empleados (5 doctors + 5 nurses + 5 administrative)
-- - 5 medicos with schedules
-- - 5 enfermeros
-- - 5 administrativos
-- - 20 pacientes with medical histories
-- - 20 historiales médicos
-- - 20 consultas (medical appointments)
-- - 20 diagnósticos
-- - 20 tratamientos
-- - 25 horarios de médicos