INSERT INTO lecture VALUES ( 100, 'Programming', 'WEDNESDAY', '12:00:00', '13:15:00' );
INSERT INTO lecture VALUES ( 101, 'Programming', 'FRIDAY', '12:00:00', '13:15:00' );
INSERT INTO lecture VALUES ( 102, 'Calculus', 'MONDAY', '14:00:00', '15:15:00' );
INSERT INTO lecture VALUES ( 103, 'Calculus', 'WEDNESDAY', '14:00:00', '15:15:00' );
INSERT INTO lecture VALUES ( 104, 'Physics', 'TUESDAY', '10:00:00', '11:15:00' );
INSERT INTO lecture VALUES ( 105, 'Physics', 'THURSDAY', '10:00:00', '11:15:00' );
INSERT INTO lecture VALUES ( 106, 'English', 'TUESDAY', '11:45:00', '13:00:00' );
INSERT INTO lecture VALUES ( 107, 'English', 'THURSDAY', '11:45:00', '13:00:00' );
INSERT INTO lecture VALUES ( 108, 'Dark Arts', 'WEDNESDAY', '15:45:00', '17:00:00' );
INSERT INTO lecture VALUES ( 109, 'Dark Arts', 'FRIDAY', '15:45:00', '17:00:00' );

INSERT INTO student VALUES ( 100, 'Harry', 'Potter' );
INSERT INTO student VALUES ( 101, 'Jessica', 'Jones' );
INSERT INTO student VALUES ( 102, 'Davy', 'Jones' );
INSERT INTO student VALUES ( 103, 'Jack', 'Sparrow' );
INSERT INTO student VALUES ( 104, 'Sherlock', 'Holmes' );

INSERT INTO classroom VALUES ( 100, 1, 1, 30 );
INSERT INTO classroom VALUES ( 101, 2, 1, 20 );
INSERT INTO classroom VALUES ( 102, 3, 1, 25 );
INSERT INTO classroom VALUES ( 103, 21, 2, 25 );
INSERT INTO classroom VALUES ( 104, 22, 2, 40 );
INSERT INTO classroom VALUES ( 105, 23, 2, 40 );

INSERT INTO instructor VALUES ( 100, 'Peter', 'Parker' );
INSERT INTO instructor VALUES ( 101, 'Bruce', 'Wayne' );
INSERT INTO instructor VALUES ( 102, 'Snape', 'Severus' );

INSERT INTO registration(student_id, lecture_id) VALUES ( 100, 108 );
INSERT INTO registration(student_id, lecture_id) VALUES ( 100, 109 );
INSERT INTO registration(student_id, lecture_id) VALUES ( 102, 104 );
INSERT INTO registration(student_id, lecture_id) VALUES ( 102, 105 );
INSERT INTO registration(student_id, lecture_id) VALUES ( 103, 100 );
INSERT INTO registration(student_id, lecture_id) VALUES ( 103, 101 );

INSERT INTO lecture_instructor(lecture_id, instructor_id) VALUES ( 105, 100 );
INSERT INTO lecture_instructor(lecture_id, instructor_id) VALUES ( 104, 100 );
INSERT INTO lecture_instructor(lecture_id, instructor_id) VALUES ( 108, 102 );
INSERT INTO lecture_instructor(lecture_id, instructor_id) VALUES ( 109, 102 );

INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 100, 100 );
INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 101, 100 );
INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 105, 101 );
INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 106, 101 );
INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 108, 103 );
INSERT INTO lecture_classroom(lecture_id, classroom_id) VALUES ( 109, 104 );