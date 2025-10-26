-- account_id: internal ID of the account
-- user_id: owner of the account
-- account_name: descriptive label
-- account_number: external reference
-- account_type: "SA" (Savings) or "CA" (Checking)
-- primary_flag: TRUE if it's the user's main account of that type
-- balance: reflects current balance
-- currency: ISO code (e.g., PHP, USD)
-- status: lifecycle state of the account ("ACTIVE" or "INACTIVE")

INSERT INTO account (
    account_id, user_id, account_name, account_number, account_type,
    primary_flag, balance, currency, status
) VALUES
(101, '9f8e7d6c', 'Main Payroll Account', 10020001, 'CA', TRUE, 24500.75, 'PHP', 'ACTIVE'),
(102, '9f8e7d6c', 'Vacation Savings Fund', 10020002, 'SA', TRUE, 18000.00, 'PHP', 'ACTIVE'),
(103, '9f8e7d6c', 'Travel Reserve Account', 10020002, 'SA', FALSE, 5000.00, 'PHP', 'INACTIVE'),

(104, 'X2aB7k9V', 'USD Checking Account', 20030001, 'CA', TRUE, 3200.50, 'USD', 'ACTIVE'),
(105, 'X2aB7k9V', 'Emergency Savings', 20030002, 'SA', TRUE, 5000.00, 'USD', 'INACTIVE'),
(106, 'X2aB7k9V', 'Holiday Gift Fund', 20030002, 'SA', FALSE, 2500.00, 'USD', 'ACTIVE'),

(107, '4d3c2b1a', 'Business Operating Account', 40050001, 'CA', TRUE, 120000.00, 'PHP', 'ACTIVE'),
(108, '4d3c2b1a', 'Tax Holding Account', 40050002, 'SA', TRUE, 75000.00, 'PHP', 'INACTIVE'),
(109, '4d3c2b1a', 'Investment Growth Fund', 40050002, 'SA', FALSE, 30000.00, 'PHP', 'ACTIVE'),

(110, '7e6d5c4b', 'Student Expense Account', 50060001, 'CA', TRUE, 1500.00, 'USD', 'ACTIVE'),
(111, '7e6d5c4b', 'Scholarship Savings', 50060002, 'SA', TRUE, 3000.00, 'USD', 'ACTIVE'),
(112, '7e6d5c4b', 'Book & Supplies Fund', 50060002, 'SA', FALSE, 1200.00, 'USD', 'INACTIVE');