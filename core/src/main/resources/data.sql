-- EXAMPLE USER DATA
INSERT INTO user(id ,email, last_name, password, name) VALUES (1,'johnny@doe.com', 'Doe', 'John', '12345678');
INSERT INTO user(id ,email, last_name, password, name) VALUES (2,'james@franco.com', 'Franco', 'James', '12345678');

-- EXAMPLE BOOK DATA
INSERT INTO book(id, author, isbn, release_date, title) VALUES (3,'Joshua Bloch', '9780134685991', '2018-01-06 01:00:00', 'Effective Java 3rd Edition');
INSERT INTO book(id, author, isbn, release_date, title) VALUES (4,'Robert C. Martin', '9780132350884', '2008-08-11 01:00:00', 'Clean Code: A Handbook of ' ||
                                                                                                                              'Agile ' ||
                                                                                                                            'Software Craftsmanship 1st Edition');
INSERT INTO book(id, author, isbn, release_date, title) VALUES (5, 'Craig Walls', '9781617294945', '2018-08-01 01:00:00', 'Spring in Action, Fifth Edition');
INSERT INTO book(id, author, isbn, release_date, title) VALUES (6,'Scott Oaks', '9781449358457', '2014-05-01 01:00:00', 'Java Performance: The Definitive ' ||
                                                                                                                      'Guide: Getting the Most Out of Your Code 1st Edition');
INSERT INTO book(id, author, isbn, release_date, title) VALUES (7,'Lasse Koskela', '9781932394856', '2007-10-22 01:00:00', 'Test Driven: TDD and Acceptance ' ||
                                                                                                                          'TDD' ||
                                                                                                                         ' for Java Developers ');

-- EXAMPLE RESERVATION DATA
INSERT INTO reservation(id, user_id, book_id, from_date, to_date) VALUES (8, 1, 4, '2018-12-30 01:00:00', '2019-01-30 01:00:00');
INSERT INTO reservation(id, user_id, book_id, from_date, to_date) VALUES (9, 1, 6, '2018-12-15 01:00:00', '2019-01-15 01:00:00');
INSERT INTO reservation(id, user_id, book_id, from_date, to_date) VALUES (10, 2, 5, '2018-12-23 01:00:00', '2019-02-23 01:00:00');
