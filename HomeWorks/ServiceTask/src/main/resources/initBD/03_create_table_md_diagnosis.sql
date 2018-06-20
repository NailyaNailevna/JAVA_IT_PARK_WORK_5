CREATE SEQUENCE public.md_diagnosis_seq;

CREATE TABLE public.md_diagnosis (
  id INTEGER NOT NULL default nextval('public.md_diagnosis_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  parent_id INTEGER,
  level INTEGER,
  is_leaf BOOLEAN,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT md_diagnosis_pkey PRIMARY KEY(id),
  CONSTRAINT md_diagnosis_parent_fk FOREIGN KEY (parent_id)
    REFERENCES public.md_diagnosis(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.md_diagnosis
IS 'Диагноз МКБ-10';

COMMENT ON COLUMN public.md_diagnosis.id
IS 'Идентификатор';

COMMENT ON COLUMN public.md_diagnosis.code
IS 'Код МКБ-10';

COMMENT ON COLUMN public.md_diagnosis.name
IS 'Наименование';

COMMENT ON COLUMN public.md_diagnosis.parent_id
IS 'Родитель';

COMMENT ON COLUMN public.md_diagnosis.level
IS 'Уровень';

COMMENT ON COLUMN public.md_diagnosis.is_leaf
IS 'Листик';

COMMENT ON COLUMN public.md_diagnosis.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.md_diagnosis.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.md_diagnosis.to_dt
IS 'Дата окончания действия';