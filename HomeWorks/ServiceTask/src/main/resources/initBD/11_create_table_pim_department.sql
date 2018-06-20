CREATE SEQUENCE public.pim_department_seq;

CREATE TABLE public.pim_department (
  id INTEGER NOT NULL default nextval('public.pim_department_seq'),
  code VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  org_id INTEGER NOT NULL,
  from_dt DATE,
  to_dt DATE,
  parent_id INTEGER,
  kind_id INTEGER,
  e_code VARCHAR(100),
  is_separate BOOLEAN,
  CONSTRAINT pim_department_pkey PRIMARY KEY(id),
  CONSTRAINT fk_pim_depart_to_depart FOREIGN KEY (parent_id)
    REFERENCES public.pim_department(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT fk_pim_department_to_org FOREIGN KEY (org_id)
    REFERENCES public.md_clinic(id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT pim_department_kind_fk FOREIGN KEY (kind_id)
    REFERENCES public.pim_department_kind(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pim_department
IS 'Подразделение';

COMMENT ON COLUMN public.pim_department.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pim_department.code
IS 'Код';

COMMENT ON COLUMN public.pim_department.name
IS 'Наименование';

COMMENT ON COLUMN public.pim_department.org_id
IS 'Организация';

COMMENT ON COLUMN public.pim_department.from_dt
IS 'Дата создания';

COMMENT ON COLUMN public.pim_department.to_dt
IS 'Дата удаления';

COMMENT ON COLUMN public.pim_department.parent_id
IS 'Вышестоящее подразделение';

COMMENT ON COLUMN public.pim_department.kind_id
IS 'Типы отделений';

COMMENT ON COLUMN public.pim_department.code
IS 'Эталонный код';

COMMENT ON COLUMN public.pim_department.is_separate
IS 'name: Обособленное подразделение
            description:
                Признак того, что подразделение является обособленным от основного МО.
                Обособленные подразделения самостоятельно отвечают за определенные бизнес процессы: сдают счета, рецепты, определенные отчетные формы и пр.
                Список полномочий обособленных подразделений варьируется в зависимости от регионов.';

CREATE INDEX pim_department_org_id_idx ON public.pim_department
  USING btree (org_id);

CREATE INDEX pim_department_parent_id_idx ON public.pim_department
  USING btree (parent_id);