-- Run manually once against the same DB as application.yaml (e.g. psql testdb -f ...).
-- Hibernate ddl-auto=update never removes obsolete columns.
--
-- Optional: copy FK values from the old column before dropping (only if patient_id is NULL):
-- UPDATE surgery_details
-- SET patient_id = patient_details_from_id
-- WHERE patient_id IS NULL AND patient_details_from_id IS NOT NULL;

ALTER TABLE surgery_details DROP COLUMN IF EXISTS patient_details_from_id;

-- If an older typo column exists from a plain UUID field:
-- ALTER TABLE surgery_details DROP COLUMN IF EXISTS patien_id;
