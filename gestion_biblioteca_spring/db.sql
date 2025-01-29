create database if not exists biblioteca;
use biblioteca;

create table Libro
(
    isbn   varchar(20)  not null
        primary key,
    titulo varchar(200) not null,
    autor  varchar(100) not null
);

create table Ejemplar
(
    id     int auto_increment
        primary key,
    isbn   varchar(20)                                                    not null,
    estado enum ('DISPONIBLE', 'PRESTADO', 'DAÑADO') default 'DISPONIBLE' null,
    constraint Ejemplar_ibfk_1
        foreign key (isbn) references Libro (isbn)
            on delete cascade
);

create index isbn
    on Ejemplar (isbn);

create table Usuario
(
    id                int auto_increment
        primary key,
    dni               varchar(15)                      not null,
    nombre            varchar(100)                     not null,
    email             varchar(100)                     not null,
    password          varchar(255)                     not null,
    tipo              enum ('normal', 'administrador') not null,
    penalizacionHasta date                             null,
    constraint dni
        unique (dni),
    constraint email
        unique (email)
);

create table Prestamo
(
    id              int auto_increment
        primary key,
    usuario_id      int  not null,
    ejemplar_id     int  not null,
    fechaInicio     date not null,
    fechaDevolucion date null,
    constraint Prestamo_ibfk_1
        foreign key (usuario_id) references Usuario (id)
            on delete cascade,
    constraint Prestamo_ibfk_2
        foreign key (ejemplar_id) references Ejemplar (id)
            on delete cascade
);

create index ejemplar_id
    on Prestamo (ejemplar_id);

create index usuario_id
    on Prestamo (usuario_id);

-- DATOS de EJEMPLO

-- Libros
INSERT INTO Libro (isbn, titulo, autor) VALUES
                                            ('978-84-376-0494-7', 'Cien años de soledad', 'Gabriel García Márquez'),
                                            ('978-84-663-0375-2', 'El amor en los tiempos del cólera', 'Gabriel García Márquez'),
                                            ('978-84-670-0191-2', 'Don Quijote de la Mancha', 'Miguel de Cervantes'),
                                            ('978-84-8346-085-1', 'La sombra del viento', 'Carlos Ruiz Zafón'),
                                            ('978-84-473-4420-9', 'Los pilares de la Tierra', 'Ken Follett'),
                                            ('978-84-204-8696-9', '1984', 'George Orwell'),
                                            ('978-84-7888-750-1', 'Rebelión en la granja', 'George Orwell'),
                                            ('978-84-9998-082-3', 'Orgullo y prejuicio', 'Jane Austen'),
                                            ('978-84-473-3435-2', 'El código Da Vinci', 'Dan Brown'),
                                            ('978-84-397-2698-6', 'Harry Potter y la piedra filosofal', 'J.K. Rowling'),
                                            ('978-84-234-6829-5', 'El Hobbit', 'J.R.R. Tolkien'),
                                            ('978-84-233-4612-9', 'El Señor de los Anillos', 'J.R.R. Tolkien'),
                                            ('978-84-290-1254-9', 'Crónica de una muerte anunciada', 'Gabriel García Márquez'),
                                            ('978-84-339-7813-0', 'Rayuela', 'Julio Cortázar'),
                                            ('978-84-233-4620-4', 'Los juegos del hambre', 'Suzanne Collins'),
                                            ('978-84-204-8735-5', 'Dune', 'Frank Herbert'),
                                            ('978-84-8445-056-4', 'Fundación', 'Isaac Asimov'),
                                            ('978-84-473-3636-3', 'El nombre del viento', 'Patrick Rothfuss'),
                                            ('978-84-7871-895-9', 'La ladrona de libros', 'Markus Zusak'),
                                            ('978-84-473-3274-5', 'Los hombres que no amaban a las mujeres', 'Stieg Larsson'),
                                            ('978-84-204-8794-2', 'Fahrenheit 451', 'Ray Bradbury'),
                                            ('978-84-670-5767-7', 'El alquimista', 'Paulo Coelho'),
                                            ('978-84-8306-452-7', 'Memorias de una geisha', 'Arthur Golden'),
                                            ('978-84-206-7206-3', 'Matar a un ruiseñor', 'Harper Lee'),
                                            ('978-84-473-2453-5', 'La chica del tren', 'Paula Hawkins'),
                                            ('978-84-204-8610-5', 'El principito', 'Antoine de Saint-Exupéry'),
                                            ('978-84-319-2087-1', 'Un mundo feliz', 'Aldous Huxley'),
                                            ('978-84-233-4621-1', 'Las ventajas de ser invisible', 'Stephen Chbosky'),
                                            ('978-84-206-7680-0', 'La casa de los espíritus', 'Isabel Allende'),
                                            ('978-84-663-0733-0', 'El silencio de los corderos', 'Thomas Harris');
-- Ejemplares
INSERT INTO Ejemplar (isbn, estado) VALUES
                                        ('978-84-376-0494-7', 'DISPONIBLE'),
                                        ('978-84-376-0494-7', 'PRESTADO'),
                                        ('978-84-663-0375-2', 'DISPONIBLE'),
                                        ('978-84-663-0375-2', 'DISPONIBLE'),
                                        ('978-84-670-0191-2', 'DISPONIBLE'),
                                        ('978-84-670-0191-2', 'PRESTADO'),
                                        ('978-84-8346-085-1', 'DISPONIBLE'),
                                        ('978-84-473-4420-9', 'DISPONIBLE'),
                                        ('978-84-204-8696-9', 'DAÑADO'),
                                        ('978-84-7888-750-1', 'DISPONIBLE'),
                                        ('978-84-9998-082-3', 'DISPONIBLE'),
                                        ('978-84-473-3435-2', 'PRESTADO'),
                                        ('978-84-397-2698-6', 'DISPONIBLE'),
                                        ('978-84-234-6829-5', 'DISPONIBLE'),
                                        ('978-84-233-4612-9', 'DISPONIBLE'),
                                        ('978-84-290-1254-9', 'PRESTADO'),
                                        ('978-84-339-7813-0', 'DISPONIBLE'),
                                        ('978-84-233-4620-4', 'DISPONIBLE'),
                                        ('978-84-204-8735-5', 'DISPONIBLE'),
                                        ('978-84-8445-056-4', 'DISPONIBLE');

-- Ususarios
INSERT INTO Usuario (dni, nombre, email, password, tipo, penalizacionHasta) VALUES
                                                                                ('12345678A', 'Carlos Pérez', 'carlos.perez@example.com', 'password1', 'normal', NULL),
                                                                                ('87654321B', 'María García', 'maria.garcia@example.com', 'password2', 'normal', '2025-02-15'),
                                                                                ('11223344C', 'Juan López', 'juan.lopez@example.com', 'password3', 'administrador', NULL),
                                                                                ('22334455D', 'Ana Sánchez', 'ana.sanchez@example.com', 'password4', 'normal', NULL),
                                                                                ('33445566E', 'Pedro Fernández', 'pedro.fernandez@example.com', 'password5', 'normal', NULL),
                                                                                ('44556677F', 'Sofía Ramírez', 'sofia.ramirez@example.com', 'password6', 'administrador', NULL),
                                                                                ('55667788G', 'Laura Díaz', 'laura.diaz@example.com', 'password7', 'normal', '2025-03-01'),
                                                                                ('66778899H', 'David Moreno', 'david.moreno@example.com', 'password8', 'normal', NULL),
                                                                                ('77889900I', 'Isabel Gómez', 'isabel.gomez@example.com', 'password9', 'administrador', NULL),
                                                                                ('88990011J', 'Fernando Ruiz', 'fernando.ruiz@example.com', 'password10', 'normal', NULL);

-- Prestamos
INSERT INTO Prestamo (usuario_id, ejemplar_id, fechaInicio, fechaDevolucion) VALUES
                                                                                 (1, 2, '2025-01-10', NULL),
                                                                                 (2, 6, '2025-01-05', '2025-01-15'),
                                                                                 (3, 13, '2025-01-07', NULL),
                                                                                 (4, 17, '2025-01-12', '2025-01-22'),
                                                                                 (5, 20, '2025-01-08', NULL),
                                                                                 (6, 4, '2025-01-09', '2025-01-19'),
                                                                                 (7, 9, '2025-01-10', NULL),
                                                                                 (8, 15, '2025-01-11', '2025-01-21'),
                                                                                 (9, 11, '2025-01-10', NULL),
                                                                                 (10, 19, '2025-01-06', '2025-01-16');



