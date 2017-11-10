import React from 'react';

class CreateWorkoutForm extends React.Component {
  render() {
    return ( 
      <div class="Workout-form">
        <h2>create new workout</h2>
        <form onSubmit={this.handleSubmit}>
          workout date
          <input name="date" type="date" />
          <input type="submit" value="submit" />
        </form>
        <ExerciseDetails exercises={EXERCISES} />
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
    this.handleDelete = this.handleDelete.bind(this);
    this.state = {
      exercisesList: [],
      name: "shoulder raises",
      sets: 0,
      reps: 0,
      exId: 0,
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

  handleDelete(event) {
    const id = event.target.id;
    const list = this.state.exercisesList.slice();
    for (var i = 0; i < list.length; i++) {
      if (list[i].id == id) {
        list.splice(i, 1);
        break;
      }
    }
    this.setState({
      exercisesList: list,
    });
  }

  handleAddExercise(event) {
    const list = this.state.exercisesList.slice();
    var id = this.state.exId++;
    list.push({
      "id": this.state.exId,
      "name": this.state.name,
      "sets": this.state.sets,
      "reps": this.state.reps,
    });
    this.setState({
      exercisesList: list,
      exId: id,
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
        <input type="text" placeholder="sets" onChange={this.handleSetsChange} />
        <input type="text" placeholder="reps" onChange={this.handleRepsChange} />
        <button onClick={this.handleAddExercise}>add</button>
        <ExerciseTable 
          exercisesList={this.state.exercisesList}
          handleDelete={this.handleDelete} />
      </div>
    );
  }
}

class ExerciseTable extends React.Component {
  // shouldComponentUpdate(nextProps, nextState) {
  //   return false;
  // }

  render() {
    //alert(this.props.exercisesList);
    const list = [];
    this.props.exercisesList.forEach((exercise) => {
      list.push(
        <tr key={exercise.id}>
          <td>{exercise.name}</td>
          <td>{exercise.sets}</td>
          <td>{exercise.reps}</td>
          <td><button id={exercise.id} onClick={this.props.handleDelete}>delete</button></td>
        </tr>
      );
    }); 

    return (
      <div>
        <table id="exercises">
          <thead>
            <tr>
              <th>name</th>
              <th>sets</th>
              <th>reps</th>
            </tr>
          </thead>
          <tbody>
           {list}
          </tbody>
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