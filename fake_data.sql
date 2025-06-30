-- Fake data for persona (base for empleados, pacientes)
INSERT INTO persona (id, nombre, apellido, dni, fechaNacimiento, direccion, telefono, email, activo)
VALUES
  (1, 'Juan', 'Pérez', 12345678, '1980-05-10', 'Calle Falsa 123', '555-1234', 'juan.perez@email.com', true),
  (2, 'Maria', 'Gomez', 87654321, '1990-08-22', 'Avenida Siempre Viva 742', '555-5678', 'maria.gomez@email.com', true),
  (3, 'Carlos', 'Lopez', 11223344, '1975-12-01', 'Calle Salud 55', '555-1111', 'carlos.lopez@email.com', true);

-- Fake data for empleados (medico, enfermero, administrativo)
INSERT INTO empleado (id, salario, cargo, fechaContratacion)
VALUES
  (1, 5000.00, 'MEDICO', '2010-01-15'),
  (2, 3200.00, 'ENFERMERO', '2015-03-20'),
  (3, 2800.00, 'ADMINISTRATIVO', '2018-09-10');

INSERT INTO medico (id, especialidad, numMatricula)
VALUES
  (1, 'CARDIOLOGIA', 'MAT12345');

INSERT INTO enfermero (id, area, turno)
VALUES
  (2, 'URGENCIAS', 'NOCHE');

INSERT INTO administrativo (id, area)
VALUES
  (3, 'RECEPCION');

-- Fake data for pacientes
INSERT INTO pacientes (id, grupoSanguineo, alergias, historialMedico, historial_id)
VALUES
  (4, 'A_POSITIVO', 'POLEN, LACTOSA', 'Sin antecedentes graves', 1),
  (5, 'O_NEGATIVO', 'NINGUNA', 'Asma infantil', 2);

-- Fake data for historial_medico
INSERT INTO historial_medico (idHistorial)
VALUES (1), (2);

-- Fake data for consulta
INSERT INTO consulta (idConsulta, fechaConsulta, horaConsulta, motivo, diagnostico, tratamientoIndicado, medico_id, paciente_id, historial_id)
VALUES
  (1, '2024-06-01', '09:00:00', 'Dolor de pecho', 'Angina', 'Reposo y medicación', 1, 4, 1),
  (2, '2024-06-02', '10:30:00', 'Fiebre alta', 'Gripe', 'Paracetamol', 1, 5, 2);

-- Fake data for productos
INSERT INTO productos (id, nombre, precio, descripcion, stock, categoria)
VALUES
  (1, 'Paracetamol', 12.50, 'Analgésico y antipirético', 100, 'Medicamentos'),
  (2, 'Termómetro digital', 45.00, 'Termómetro para uso clínico', 30, 'Equipos Médicos'); 