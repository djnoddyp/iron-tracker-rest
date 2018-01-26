DROP TABLE IF EXISTS Exercise;
DROP TABLE IF EXISTS ExerciseNames;
DROP TABLE IF EXISTS Workout;
DROP TABLE IF EXISTS Workout_Exercise;

CREATE TABLE Exercise (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  reps INT NOT NULL,
  sets INT NOT NULL, 
  PRIMARY KEY (id)
);

CREATE TABLE ExerciseNames (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE Workout (
  id INT NOT NULL AUTO_INCREMENT,
  date DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Workout_Exercise (
  workout_id INT NOT NULL,
  exercise_id INT NOT NULL,
  FOREIGN KEY (workout_id) REFERENCES Workout(id),
  FOREIGN KEY (exercise_id) REFERENCES Exercise(id),
  PRIMARY KEY (workout_id, exercise_id)
);