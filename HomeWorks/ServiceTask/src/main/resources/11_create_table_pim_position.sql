CREATE SEQUENCE public.pim_position_id_seq;

CREATE TABLE public.pim_position (
  id INTEGER NOT NULL default nextval('public.pim_position_id_seq'),
  code VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  organization_id INTEGER NOT NULL,
  department_id INTEGER NOT NULL,
  start_date DATE,
  end_date DATE,
  CONSTRAINT pim_position_pkey PRIMARY KEY(id),
  CONSTRAINT fk_pim_position_to_depart FOREIGN KEY (department_id)
    REFERENCES public.pim_department(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_pim_position_to_org FOREIGN KEY (organization_id)
    REFERENCES public.md_clinic(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pim_position
IS 'Должность по штатному расписанию организации';

COMMENT ON COLUMN public.pim_position.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_position.code
IS 'Код';

COMMENT ON COLUMN public.pim_position.name
IS 'Наименование';

COMMENT ON COLUMN public.pim_position.organization_id
IS 'Организация';

COMMENT ON COLUMN public.pim_position.department_id
IS 'Департамент';

COMMENT ON COLUMN public.pim_position.start_date
IS 'Дата создания';

COMMENT ON COLUMN public.pim_position.end_date
IS 'Дата удаления';

CREATE INDEX pim_position_department_id_idx ON public.pim_position
  USING btree (department_id);

CREATE INDEX pim_position_organization_id_idx ON public.pim_position
  USING btree (organization_id);