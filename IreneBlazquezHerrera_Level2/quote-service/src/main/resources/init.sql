CREATE TABLE QUOTE(
  SYMBOL VARCHAR COMMENT 'The symbol the quote is for.',
  DAY DATE COMMENT 'The date of the quote.',
  BID DECIMAL COMMENT 'The bid of the quote.',
  ASK DECIMAL COMMENT 'The ask of the quote.',
  PRIMARY KEY(SYMBOL, DAY)
);

INSERT INTO QUOTE(SYMBOL, DAY, BID, ASK) VALUES
  -- Microsoft
  ('MSFT', '2020-01-01', 2.03, 2.60),
  ('MSFT', '2020-01-02', 2.91, 3.33),
  ('MSFT', '2020-01-03', 3.74, 4.33),
  ('MSFT', '2020-01-04', 3.87, 4.10),
  ('MSFT', '2020-01-05', 2.51, 2.96),

  -- Google
  ('GOOG', '2020-01-01', 3.11, 3.34),
  ('GOOG', '2020-01-02', 3.97, 4.56),
  ('GOOG', '2020-01-03', 5.59, 5.85),
  ('GOOG', '2020-01-04', 4.94, 5.28),
  ('GOOG', '2020-01-05', 0.67, 0.81),

  -- Facebook
  ('FB', '2020-01-01', 5.54, 5.66),
  ('FB', '2020-01-02', 4.89, 5.40),
  ('FB', '2020-01-03', 2.90, 3.31),
  ('FB', '2020-01-04', 6.12, 6.33),
  ('FB', '2020-01-05', 3.68, 3.93);
