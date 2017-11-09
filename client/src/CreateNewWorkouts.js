import React from 'react';

class CreateWorkoutForm extends React.Component {
  render() {
    return ( 
      <div class="Workout-form">
        <h2>create new workout</h2>
        <form onSubmit={this.handleSubmit}>
          workout date
          <input name="date" type="date" />
          <ExerciseDetails exercises={EXERCISES} />
          <input type="submit" value="submit" />
        </form>
      </div>
    );
  }
}

class ExerciseDetails extends React.Component {
  constructor(props) {
    super(props);
    this.handleSetsChange = this.handleSetsChange.bind(this);
    this.handleRepsChange = this.handleRepsChange.bind(this);
    this.handleAddExercise = this.handleAddExercise.bind(this);
    this.handleNameChange = this.handleNameChange.bind(this);
    this.state = {
      exercisesList: [],
      name: "",
      sets: 0,
      reps: 0,
    };
  }

  handleSetsChange(event) {
    this.setState({
      sets: event.target.value,
    });
  }

  handleRepsChange(event) {
    this.setState({
      reps: event.target.value,
    });
  }

  handleNameChange(event) {
    this.setState({
      name: event.target.value,
    });
  }

  handleAddExercise(event) {
    const list = [];
    list.push({
      "name": this.state.name,
      "sets": this.state.sets,
      "reps": this.state.reps,
    });
    this.setState({
      exercisesList: list,
    });
  }

  render() {
    const options = [];
    this.props.exercises.forEach((exercise) => {
      options.push(
        <option>{exercise.name}</option>
      );
    }); 

    return (
      <div>
        add exercises
        <select onChange={this.handleNameChange}>
          {options}
        </select>
        <input type="text" placeholder="sets" value={this.state.sets} onChange={this.handleSetsChange} />
        <input type="text" placeholder="reps" value={this.state.reps} onChange={this.handleRepsChange} />
        <button onClick={this.handleAddExercise}>add</button>
        <ExerciseTable exercisesList={this.state.exercisesList} />
      </div>
    );
  }
}

class ExerciseTable extends React.Component {
  render() {
    console.log('table: ' + this.props.exercisesList);
    const list = [];
    this.props.exercisesList.forEach((exercise) => {
      list.push(
        <tr>
          <td>{exercise.name}</td>
          <td>{exercise.sets}</td>
          <td>{exercise.reps}</td>
          <td><button>delete</button></td>
        </tr>
      );
    }); 

    return (
      <div>
        <table id="exercises">
          <tr>
            <th>name</th>
            <th>sets</th>
            <th>reps</th>
          </tr>
          {list}
        </table>
      </div>
    );
  }
}

export default CreateWorkoutForm;

const EXERCISES_LIST = [
  {
    "name": "dumbells",
    "sets": 3,
    "reps": 12,
  },
  {
    "name": "push ups",
    "sets": 4,
    "reps": 15,
  },
  {
    "name": "bench press",
    "sets": 3,
    "reps": 8,
  },
];

const EXERCISES = [
  {
		"name": "shoulder raises"
	},
	{
		"name": "pull ups"
	},
  {
    "name": "squats"
  },
  {
    "name": "bent over rows"
  },
  {
    "name": "bench press"
  }
];