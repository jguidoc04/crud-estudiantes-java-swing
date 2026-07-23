-- public.estudiantes definition

-- Drop table

-- DROP TABLE public.estudiantes;

CREATE TABLE public.estudiantes (
	id serial4 NOT NULL,
	nombre varchar(100) NOT NULL,
	correo varchar(120) NOT NULL,
	promedio numeric(4, 2) DEFAULT 0.0 NULL,
	CONSTRAINT estudiantes_correo_key UNIQUE (correo),
	CONSTRAINT estudiantes_pkey PRIMARY KEY (id)
);