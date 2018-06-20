CREATE TABLE receipt.baby_food_receipt (
  id INTEGER NOT NULL default nextval('receipt.receipt_id_seq'),
  benefit_definition_id INTEGER NOT NULL,
  kitchen_id INTEGER,
  begin_dt DATE NOT NULL,
  end_dt DATE NOT NULL,
  CONSTRAINT baby_food_receipt_id_pk PRIMARY KEY(id),
  CONSTRAINT baby_food_receipt_benefit_definition_id_fk FOREIGN KEY (benefit_definition_id)
    REFERENCES public.pci_benefit_definition(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT baby_food_receipt_id_fk FOREIGN KEY (id)
    REFERENCES receipt.receipt(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    NOT DEFERRABLE,
  CONSTRAINT baby_food_receipt_kitchen_id_fk FOREIGN KEY (kitchen_id)
    REFERENCES public.pim_department(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE
);

COMMENT ON TABLE receipt.baby_food_receipt
IS 'Детское питание';

COMMENT ON COLUMN receipt.baby_food_receipt.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.baby_food_receipt.benefit_definition_id
IS 'Льгота';

COMMENT ON COLUMN receipt.baby_food_receipt.kitchen_id
IS 'Пункт детской молочной кухни';

COMMENT ON COLUMN receipt.baby_food_receipt.begin_dt
IS 'Начало периода выдачи питания';

COMMENT ON COLUMN receipt.baby_food_receipt.end_dt
IS 'Окончания периода выдачи питания';

CREATE INDEX baby_food_receipt_benefit_definition_id_ix ON receipt.baby_food_receipt
  USING btree (benefit_definition_id);

CREATE INDEX baby_food_receipt_kitchen_id_ix ON receipt.baby_food_receipt
  USING btree (kitchen_id);