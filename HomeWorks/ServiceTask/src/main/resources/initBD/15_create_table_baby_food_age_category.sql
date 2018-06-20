CREATE SEQUENCE receipt.baby_food_age_category_id_seq;

CREATE TABLE receipt.baby_food_age_category (
  id INTEGER NOT NULL default nextval('receipt.baby_food_age_category_id_seq'),
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  e_code VARCHAR(100),
  begin_age INTEGER,
  end_age INTEGER,
  CONSTRAINT baby_food_age_category_pk PRIMARY KEY(id)
);

COMMENT ON TABLE receipt.baby_food_age_category
IS 'Возрастная категория';

COMMENT ON COLUMN receipt.baby_food_age_category.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.baby_food_age_category.code
IS 'Код';

COMMENT ON COLUMN receipt.baby_food_age_category.name
IS 'Наименование';

COMMENT ON COLUMN receipt.baby_food_age_category.e_code
IS 'Код эталонный';

COMMENT ON COLUMN receipt.baby_food_age_category.begin_age
IS 'Возраст, с которого считается категория';

COMMENT ON COLUMN receipt.baby_food_age_category.end_age
IS 'Возраст, на котором оканчивается категория';