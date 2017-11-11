INSERT INTO Exercise (name, sets, reps) VALUES ('Dumbells', 3, 10);
INSERT INTO Exercise (name, sets, reps) VALUES ('Push ups', 4, 15);
INSERT INTO Exercise (name, sets, reps) VALUES ('Pull ups', 4, 8);
INSERT INTO Exercise (name, sets, reps) VALUES ('Shoulder raises', 3, 8);

INSERT INTO Workout (date) VALUES ('2017-10-21');
INSERT INTO Workout (date) VALUES ('2017-10-23');

INSERT INTO Workout_Exercise (workout_id, exercise_id) VALUES (1, 1);
INSERT INTO Workout_Exercise (workout_id, exercise_id) VALUES (1, 4);
INSERT INTO Workout_Exercise (workout_id, exercise_id) VALUES (2, 2);
INSERT INTO Workout_Exercise (workout_id, exercise_id) VALUES (2, 3);

