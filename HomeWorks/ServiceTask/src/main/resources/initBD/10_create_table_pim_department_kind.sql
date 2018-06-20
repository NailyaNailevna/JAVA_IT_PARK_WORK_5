CREATE SEQUENCE public.pim_department_kind_seq;

CREATE TABLE public.pim_department_kind (
  id INTEGER NOT NULL default nextval('public.pim_department_kind_seq'),
  code VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  parent_id INTEGER,
  CONSTRAINT pk_pim_department_kind PRIMARY KEY(id),
  CONSTRAINT pim_depart_kind_to_kind_fk FOREIGN KEY (parent_id)
    REFERENCES public.pim_department_kind(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pim_department_kind
IS 'Типы отделений';

COMMENT ON COLUMN public.pim_department_kind.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_department_kind.code
IS 'Код';

COMMENT ON COLUMN public.pim_department_kind.name
IS 'Наименование';

COMMENT ON COLUMN public.pim_department_kind.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.pim_department_kind.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.pim_department_kind.to_dt
IS 'Дата окончания действия';

COMMENT ON COLUMN public.pim_department_kind.parent_id
IS 'Родитель';