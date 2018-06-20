CREATE SEQUENCE receipt.receipt_id_seq;

CREATE TABLE receipt.receipt (
  id integer not null default nextval('receipt.receipt_id_seq'),
  clinic_id INTEGER NOT NULL,
  type_id INTEGER NOT NULL,
  series VARCHAR,
  num VARCHAR,
  issue_dt DATE NOT NULL,
  employee_position_id INTEGER NOT NULL,
  patient_id INTEGER NOT NULL,
  sign_id INTEGER NOT NULL,
  cito BOOLEAN DEFAULT false NOT NULL,
  diagnosis_id INTEGER,
  validity_id INTEGER,
  canceled BOOLEAN DEFAULT false NOT NULL,
  CONSTRAINT receipt_id_pk PRIMARY KEY(id),
  CONSTRAINT receipt_clinic_id_fk FOREIGN KEY (clinic_id)
    REFERENCES public.md_clinic(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_type_id_fk FOREIGN KEY (type_id)
    REFERENCES receipt.receipt_type(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_employee_position_id_fk FOREIGN KEY (employee_position_id)
    REFERENCES public.pim_employee_position(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_patient_id_fk FOREIGN KEY (patient_id)
    REFERENCES public.pim_individual(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_sign_id_fk FOREIGN KEY (sign_id)
    REFERENCES receipt.receipt_sign(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_diagnosis_id_fk FOREIGN KEY (diagnosis_id)
    REFERENCES public.md_diagnosis(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE,
  CONSTRAINT receipt_validity_id_fk FOREIGN KEY (validity_id)
    REFERENCES receipt.receipt_validity(id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    NOT DEFERRABLE
) WITHOUT OIDS;

COMMENT ON TABLE receipt.receipt
IS 'Рецепт';

COMMENT ON COLUMN receipt.receipt.id
IS 'Идентификатор';

COMMENT ON COLUMN receipt.receipt.clinic_id
IS 'МО, выписавшая рецепт';

COMMENT ON COLUMN receipt.receipt.type_id
IS 'Тип рецепта';

COMMENT ON COLUMN receipt.receipt.series
IS 'Серия рецепта';

COMMENT ON COLUMN receipt.receipt.num
IS 'Номер рецепта';

COMMENT ON COLUMN receipt.receipt.issue_dt
IS 'Дата выписки';

COMMENT ON COLUMN receipt.receipt.employee_position_id
IS 'Должность сотрудника';

COMMENT ON COLUMN receipt.receipt.patient_id
IS 'Пациент';

COMMENT ON COLUMN receipt.receipt.sign_id
IS 'Признак рецепта';

COMMENT ON COLUMN receipt.receipt.cito
IS 'Срочный отпуск';

COMMENT ON COLUMN receipt.receipt.diagnosis_id
IS 'Заболевание';

COMMENT ON COLUMN receipt.receipt.validity_id
IS 'Срок действия рецепта в днях';

COMMENT ON COLUMN receipt.receipt.canceled
IS 'Признак аннулирования рецепта';

CREATE INDEX receipt_clinic_id_ix ON receipt.receipt
  USING btree (clinic_id);

CREATE INDEX receipt_type_id_ix ON receipt.receipt
  USING btree (type_id);

CREATE INDEX receipt_employee_position_id_ix ON receipt.receipt
  USING btree (employee_position_id);

CREATE INDEX receipt_patient_id_ix ON receipt.receipt
  USING btree (patient_id);

CREATE INDEX receipt_sign_id_ix ON receipt.receipt
  USING btree (sign_id);

CREATE INDEX receipt_diagnosis_id_ix ON receipt.receipt
  USING btree (diagnosis_id);

CREATE INDEX receipt_validity_id_ix ON receipt.receipt
  USING btree (validity_id);