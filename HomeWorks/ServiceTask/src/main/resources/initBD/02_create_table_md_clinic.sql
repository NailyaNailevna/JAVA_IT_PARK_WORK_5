CREATE SEQUENCE public.pim_party_id_seq;

CREATE TABLE public.md_clinic (
  id INTEGER NOT NULL default nextval('public.pim_party_id_seq'),
  code VARCHAR(255),
  note VARCHAR(255),
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  full_name VARCHAR(800),
  short_name VARCHAR(250),
  reg_dt DATE,
  parent_id INTEGER,
  close_dt DATE,
  CONSTRAINT md_clinic_pkey PRIMARY KEY(id),
  CONSTRAINT md_clinic_parent_fk FOREIGN KEY (parent_id)
    REFERENCES public.md_clinic(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.md_clinic
IS 'Клиника';

COMMENT ON COLUMN public.md_clinic.id
IS 'Идентификатор';

COMMENT ON COLUMN public.md_clinic.code
IS 'Код клиники';

COMMENT ON COLUMN public.md_clinic.note
IS 'Краткая информация';

COMMENT ON COLUMN public.md_clinic.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.md_clinic.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.md_clinic.to_dt
IS 'Дата окончания действия';

COMMENT ON COLUMN public.md_clinic.full_name
IS 'Полное наименование';

COMMENT ON COLUMN public.md_clinic.short_name
IS 'Краткое наименование';

COMMENT ON COLUMN public.md_clinic.reg_dt
IS 'Дата регистрации';

COMMENT ON COLUMN public.md_clinic.close_dt
IS 'Дата окончания регистрации';