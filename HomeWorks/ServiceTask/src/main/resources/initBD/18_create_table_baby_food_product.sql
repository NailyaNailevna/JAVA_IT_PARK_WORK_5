CREATE SEQUENCE receipt.baby_food_product_id_seq;

CREATE TABLE receipt.baby_food_product (
  id INTEGER NOT NULL default nextval('receipt.baby_food_product_id_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  measure_id INTEGER,
  CONSTRAINT baby_food_product_id_pk PRIMARY KEY(id),
  CONSTRAINT baby_food_product_measure_id_fk FOREIGN KEY (measure_id)
    REFERENCES public.cmn_measure(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE
);

COMMENT ON TABLE receipt.baby_food_product
IS 'Продукт питания';

COMMENT ON COLUMN receipt.baby_food_product.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.baby_food_product.code
IS 'Код';

COMMENT ON COLUMN receipt.baby_food_product.name
IS 'Наименование';

COMMENT ON COLUMN receipt.baby_food_product.e_code
IS 'Код эталонный';

COMMENT ON COLUMN receipt.baby_food_product.measure_id
IS 'Единица измерения';