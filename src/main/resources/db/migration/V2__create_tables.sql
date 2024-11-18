CREATE TABLE leads (
                       id SERIAL PRIMARY KEY,           -- Identificador único para cada lead
                       name VARCHAR(255) NOT NULL,      -- Nombre del lead
                       email VARCHAR(255) NOT NULL,     -- Correo electrónico del lead
                       status VARCHAR(50) NOT NULL,     -- Estado del lead (ej. 'Pending', 'Converted')
                       created_at TIMESTAMP DEFAULT NOW(), -- Fecha de creación
                       updated_at TIMESTAMP DEFAULT NOW() -- Fecha de última actualización
);

CREATE TABLE activities (
                            id SERIAL PRIMARY KEY,             -- Identificador único para cada actividad
                            description TEXT NOT NULL,         -- Descripción de la actividad
                            timestamp TIMESTAMP NOT NULL,      -- Fecha y hora de la actividad
                            lead_id INT NOT NULL,              -- Relación con el lead al que pertenece
                            created_at TIMESTAMP DEFAULT NOW(), -- Fecha de creación
                            updated_at TIMESTAMP DEFAULT NOW(), -- Fecha de última actualización
                            CONSTRAINT fk_lead FOREIGN KEY (lead_id) REFERENCES leads (id) ON DELETE CASCADE
);
