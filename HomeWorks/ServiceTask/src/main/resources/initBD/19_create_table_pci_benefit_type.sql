CREATE SEQUENCE public.pci_benefit_type_id_seq;

CREATE TABLE public.pci_benefit_type (
  id INTEGER NOT NULL default nextval('public.pci_benefit_type_id_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT pci_benefit_type_pkey PRIMARY KEY(id)
);

COMMENT ON TABLE public.pci_benefit_type
IS 'Тип льготы';

COMMENT ON COLUMN public.pci_benefit_type.id
IS 'Идентификатор';

COMMENT ON COLUMN public.pci_benefit_type.code
IS 'Код';

COMMENT ON COLUMN public.pci_benefit_type.name
IS 'Наименование';

COMMENT ON COLUMN public.pci_benefit_type.e_code
IS 'Код эталонный';

COMMENT ON COLUMN public.pci_benefit_type.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN public.pci_benefit_type.to_dt
IS 'Дата окончания действия';