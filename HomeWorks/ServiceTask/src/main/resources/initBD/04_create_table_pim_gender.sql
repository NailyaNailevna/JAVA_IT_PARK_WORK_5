CREATE SEQUENCE public.pim_gender_id_seq;

CREATE TABLE public.pim_gender (
  id INTEGER NOT NULL default nextval('public.pim_gender_id_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT pim_gender_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE public.pim_gender
IS 'Пол';

COMMENT ON COLUMN public.pim_gender.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_gender.code
IS 'Код';

COMMENT ON COLUMN public.pim_gender.name
IS 'Наименование';

COMMENT ON COLUMN public.pim_gender.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.pim_gender.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.pim_gender.to_dt
IS 'Дата окончания действия';