CREATE SEQUENCE receipt.baby_food_norm_id_seq;

CREATE TABLE receipt.baby_food_norm (
  id INTEGER NOT NULL default nextval('receipt.baby_food_norm_id_seq'),
  age_category_id INTEGER NOT NULL,
  benefit_definition_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  rate NUMERIC(7,3),
  CONSTRAINT baby_food_norm_id_pk PRIMARY KEY(id),
  CONSTRAINT baby_food_norm_age_category_id_fk FOREIGN KEY (age_category_id)
    REFERENCES receipt.baby_food_age_category(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT baby_food_norm_benefit_definition_id_fk FOREIGN KEY (benefit_definition_id)
    REFERENCES public.pci_benefit_definition(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT baby_food_norm_product_id_fk FOREIGN KEY (product_id)
    REFERENCES receipt.baby_food_product(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE
);

COMMENT ON TABLE receipt.baby_food_norm
IS 'Нормы продуктов';

COMMENT ON COLUMN receipt.baby_food_norm.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.baby_food_norm.age_category_id
IS 'Возрастная категория';

COMMENT ON COLUMN receipt.baby_food_norm.benefit_definition_id
IS 'Льгота, по которой предоставляется продукт питания';

COMMENT ON COLUMN receipt.baby_food_norm.product_id
IS 'Продукт';

COMMENT ON COLUMN receipt.baby_food_norm.rate
IS 'Норма выдачи';

CREATE INDEX baby_food_norm_age_category_id_ix ON receipt.baby_food_norm
  USING btree (age_category_id);

CREATE INDEX baby_food_norm_benefit_definition_id_ix ON receipt.baby_food_norm
  USING btree (benefit_definition_id);

CREATE INDEX baby_food_norm_product_id_ix ON receipt.baby_food_norm
  USING btree (product_id);