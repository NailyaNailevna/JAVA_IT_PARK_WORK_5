CREATE SEQUENCE public.pim_employee_position_id_seq;

CREATE TABLE public.pim_employee_position (
  id INTEGER NOT NULL default nextval('public.pim_employee_position_id_seq'),
  code VARCHAR(10),
  start_date DATE NOT NULL,
  end_date DATE,
  employee_id INTEGER NOT NULL,
  position_id INTEGER NOT NULL,
  CONSTRAINT pim_employee_position_pkey PRIMARY KEY(id),
  CONSTRAINT fk_pim_empl_position_to_empl FOREIGN KEY (employee_id)
    REFERENCES public.pim_employee(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_pim_empl_pos_to_pos FOREIGN KEY (position_id)
    REFERENCES public.pim_position(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pim_employee_position
IS 'было pim_employee_to_position
Связь сотрудника и должности';

COMMENT ON COLUMN public.pim_employee_position.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_employee_position.code
IS 'Код';

COMMENT ON COLUMN public.pim_employee_position.employee_id
IS 'Сотрудник';

COMMENT ON COLUMN public.pim_employee_position.position_id
IS 'Должность';

COMMENT ON COLUMN public.pim_employee_position.start_date
IS 'Дата создания';

COMMENT ON COLUMN public.pim_employee_position.end_date
IS 'Дата удаления';

CREATE INDEX pim_employee_position_employee_id_idx ON public.pim_employee_position
  USING btree (employee_id);

CREATE INDEX pim_employee_position_position_id_idx ON public.pim_employee_position
  USING btree (position_id);