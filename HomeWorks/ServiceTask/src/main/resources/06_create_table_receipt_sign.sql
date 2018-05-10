CREATE SEQUENCE receipt.receipt_sign_id_seq;

CREATE TABLE receipt.receipt_sign (
  id integer not null default nextval('receipt.receipt_sign_id_seq'),
  code VARCHAR(255),
  name VARCHAR(255),
  e_code VARCHAR(100),
  from_dt DATE,
  to_dt DATE,
  is_adult BOOLEAN,
  is_child BOOLEAN,
  CONSTRAINT receipt_sign_pk PRIMARY KEY(id)
);

COMMENT ON TABLE receipt.receipt_sign
IS 'Тип рецепт';

COMMENT ON COLUMN receipt.receipt_sign.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.receipt_sign.code
IS 'Код';

COMMENT ON COLUMN receipt.receipt_sign.name
IS 'Наименование';

COMMENT ON COLUMN receipt.receipt_sign.e_code
IS 'Код эталонный';

COMMENT ON COLUMN receipt.receipt_sign.from_dt
IS 'Дата начала действия';

COMMENT ON COLUMN receipt.receipt_sign.to_dt
IS 'Дата окончания действия';

COMMENT ON COLUMN receipt.receipt_sign.is_adult
IS 'Взрослый';

COMMENT ON COLUMN receipt.receipt_sign.is_child
IS 'Детский';