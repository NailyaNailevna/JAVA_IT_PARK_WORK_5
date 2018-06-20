CREATE SEQUENCE public.cmn_measure_object_seq;

CREATE TABLE public.cmn_measure_object (
  id INTEGER NOT NULL default nextval('public.cmn_measure_object_seq'),
  code VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT pk_cmn_measure_object PRIMARY KEY(id)
) WITHOUT OIDS;

COMMENT ON TABLE public.cmn_measure_object
IS 'Объект измерения';

COMMENT ON COLUMN public.cmn_measure_object.id
IS 'Идентификатор';

COMMENT ON COLUMN public.cmn_measure_object.code
IS 'Код';

COMMENT ON COLUMN public.cmn_measure_object.name
IS 'Наименование';

COMMENT ON COLUMN public.cmn_measure_object.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.cmn_measure_object.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.cmn_measure_object.to_dt
IS 'Дата окончания действия';