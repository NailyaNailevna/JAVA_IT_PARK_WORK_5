CREATE TABLE public.pim_individual (
  id INTEGER NOT NULL default nextval('public.pim_party_id_seq'),
  surname VARCHAR(50),
  name VARCHAR(50),
  patr_name VARCHAR(50),
  birth_dt DATE,
  death_dt TIMESTAMP WITHOUT TIME ZONE,
  gender_id INTEGER,
  CONSTRAINT pim_individual_pkey PRIMARY KEY(id),
  CONSTRAINT pim_individual_gender_fk FOREIGN KEY (gender_id)
    REFERENCES public.pim_gender(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pim_individual
IS 'Физическое лицо';

COMMENT ON COLUMN public.pim_individual.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_individual.surname
IS 'Фамилия';

COMMENT ON COLUMN public.pim_individual.name
IS 'Имя';

COMMENT ON COLUMN public.pim_individual.patr_name
IS 'Отчество';

COMMENT ON COLUMN public.pim_individual.birth_dt
IS 'Дата рождения';

COMMENT ON COLUMN public.pim_individual.death_dt
IS 'Дата смерти';

COMMENT ON COLUMN public.pim_individual.gender_id
IS 'Пол';