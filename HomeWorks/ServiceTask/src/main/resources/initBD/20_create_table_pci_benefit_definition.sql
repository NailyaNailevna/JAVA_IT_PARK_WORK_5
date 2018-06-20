CREATE SEQUENCE public.pci_benefit_definition_id_seq;

CREATE TABLE public.pci_benefit_definition (
  id INTEGER NOT NULL default nextval('public.pci_benefit_definition_id_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  benefit_type_id INTEGER NOT NULL,
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT pci_benefit_definition_pkey PRIMARY KEY(id),
  CONSTRAINT pci_benefit_definition_benefit_type_fk FOREIGN KEY (benefit_type_id)
    REFERENCES public.pci_benefit_type(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
);

COMMENT ON TABLE public.pci_benefit_definition
IS 'Определение льготы';

COMMENT ON COLUMN public.pci_benefit_definition.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pci_benefit_definition.code
IS 'Код';

COMMENT ON COLUMN public.pci_benefit_definition.name
IS 'Наименование';

COMMENT ON COLUMN public.pci_benefit_definition.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.pci_benefit_definition.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.pci_benefit_definition.to_dt
IS 'Дата окончания действия';

COMMENT ON COLUMN public.pci_benefit_definition.benefit_type_id
IS 'Тип льготы';

CREATE INDEX pci_benefit_definition_benefit_type_id_idx ON public.pci_benefit_definition
  USING btree (benefit_type_id);