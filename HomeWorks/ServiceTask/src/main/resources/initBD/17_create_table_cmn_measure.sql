CREATE SEQUENCE public.cmn_measure_id_seq;

CREATE TABLE public.cmn_measure (
  id INTEGER NOT NULL default nextval('public.cmn_measure_id_seq'),
  code VARCHAR(3) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  measure_object_id INTEGER NOT NULL,
  from_dt DATE,
  to_dt DATE,
  code_enum VARCHAR,
  CONSTRAINT cmn_measure_pkey PRIMARY KEY(id),
  CONSTRAINT cmn_measure_measure_object_fk FOREIGN KEY (measure_object_id)
    REFERENCES public.cmn_measure_object(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) WITHOUT OIDS;

COMMENT ON TABLE public.cmn_measure
IS 'Единица измерения';

COMMENT ON COLUMN public.cmn_measure.id
IS 'Идентификатор';

COMMENT ON COLUMN public.cmn_measure.code
IS 'Код';

COMMENT ON COLUMN public.cmn_measure.name
IS 'Наименование единиц измерения ';

COMMENT ON COLUMN public.cmn_measure.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.cmn_measure.measure_object_id
IS 'Объект измерения';

COMMENT ON COLUMN public.cmn_measure.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.cmn_measure.to_dt
IS 'Дата окончания действия';