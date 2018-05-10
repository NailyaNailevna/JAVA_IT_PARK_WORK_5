CREATE SEQUENCE receipt.receipt_type_id_seq;

CREATE TABLE receipt.receipt_type (
  id integer not null default nextval('receipt.receipt_type_id_seq'),
  code VARCHAR(255),
  name VARCHAR(255),
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  is_regular BOOLEAN,
  CONSTRAINT receipt_type_pk PRIMARY KEY(id)
);

COMMENT ON TABLE receipt.receipt_type
IS 'Тип рецепт';

COMMENT ON COLUMN receipt.receipt_type.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.receipt_type.code
IS 'Код';

COMMENT ON COLUMN receipt.receipt_type.name
IS 'Наименование';

COMMENT ON COLUMN receipt.receipt_type.e_code
IS 'Код эталонный';

COMMENT ON COLUMN receipt.receipt_type.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN receipt.receipt_type.to_dt
IS 'Дата окончания действия';

COMMENT ON COLUMN receipt.receipt_type.is_regular
IS 'Обычный тип';