CREATE SEQUENCE public.pim_employee_id_seq;

CREATE TABLE public.pim_employee (
  id INTEGER NOT NULL default nextval('public.pim_employee_id_seq'),
  number VARCHAR(255),
  individual_id INTEGER NOT NULL,
  organization_id INTEGER NOT NULL,
  employment_dt DATE,
  is_dismissed BOOLEAN,
  dismissal_dt DATE,
  note VARCHAR(1000),
  CONSTRAINT pim_employee_pkey PRIMARY KEY(id),
  CONSTRAINT pim_employee_org_fk FOREIGN KEY (organization_id)
    REFERENCES public.md_clinic(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT pim_employee_indiv_fk FOREIGN KEY (individual_id)
    REFERENCES public.pim_individual(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    DEFERRABLE
    INITIALLY IMMEDIATE
);

COMMENT ON TABLE public.pim_employee
IS 'Сотрудник';

COMMENT ON COLUMN public.pim_employee.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_employee.number
IS 'Табельный номер';

COMMENT ON COLUMN public.pim_employee.individual_id
IS 'Физ. лицо';

COMMENT ON COLUMN public.pim_employee.organization_id
IS 'Организация';

COMMENT ON COLUMN public.pim_employee.employment_dt
IS 'Дата принятия на работу';

COMMENT ON COLUMN public.pim_employee.is_dismissed
IS 'Сотрудник уволен';

COMMENT ON COLUMN public.pim_employee.dismissal_dt
IS 'Дата увольнения';

COMMENT ON COLUMN public.pim_employee.note
IS 'Примечание';

CREATE INDEX pim_employee_individual_id_idx ON public.pim_employee
  USING btree (individual_id);

CREATE INDEX pim_employee_organization_id_idx ON public.pim_employee
  USING btree (organization_id);