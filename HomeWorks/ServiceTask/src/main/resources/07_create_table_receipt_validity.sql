CREATE SEQUENCE receipt.receipt_validity_id_seq;

CREATE TABLE receipt.receipt_validity (
  id integer not null default nextval('receipt.receipt_validity_id_seq'),
  code VARCHAR(255),
  name VARCHAR(255),
  days INTEGER,
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  CONSTRAINT receipt_validity_pk PRIMARY KEY(id)
);

COMMENT ON TABLE receipt.receipt_validity
IS 'Тип рецепт';

COMMENT ON COLUMN receipt.receipt_validity.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.receipt_validity.code
IS 'Код';

COMMENT ON COLUMN receipt.receipt_validity.name
IS 'Наименование';

COMMENT ON COLUMN receipt.receipt_validity.days
IS 'Количество дней';

COMMENT ON COLUMN receipt.receipt_validity.e_code
IS 'Код эталонный';

COMMENT ON COLUMN receipt.receipt_validity.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN receipt.receipt_validity.to_dt
IS 'Дата окончания действия';