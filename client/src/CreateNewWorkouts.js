import React from 'react';

class CreateWorkoutForm extends React.Component {
  constructor(props) {
    super(props);
    this.handleSetsChange = this.handleSetsChange.bind(this);
    this.handleRepsChange = this.handleRepsChange.bind(this);
    this.handleAddExercise = this.handleAddExercise.bind(this);
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleDelete = this.handleDelete.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleDateChange = this.handleDateChange.bind(this);
    this.state = {
      date: {},
      exercisesList: [],
      name: "shoulder raises",
      sets: 0,
      reps: 0,
      exId: 0,
    };
    this.baseState = this.state;
  }

  handleSubmit(event) {
    console.log('submitted');
    const workout = {
      "date": this.state.date,
      "exercises": this.state.exercisesList,
    };

    sendFormData(workout);
    event.preventDefault();
    this.setState(this.baseState);
  }

  handleDateChange(event) {
    this.setState({
      date: event.target.value,
    });
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
    var id = ++this.state.exId;
    list.push({
      //"id": this.state.exId,
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
    const data = JSON.parse(getExerciseNames());
    data.forEach((ex) => {
      options.push(
        <option key={ex.id}>{ex.name}</option>
      );
    }); 

    return (
      <div className="Workout-form">
        <h2>create new workout</h2>
        <form onSubmit={this.handleSubmit}>
          workout date
          <input name="date" type="date" value={this.state.date} onChange={this.handleDateChange} />
          <input type="submit" value="submit" />
          <br/><br/>
          <p>add an exercise</p>
          <select onChange={this.handleNameChange}>
            {options}
          </select>
          <input type="number" value={this.state.sets} onChange={this.handleSetsChange} />
          <input type="number" value={this.state.reps} onChange={this.handleRepsChange} />
        </form>
        <button onClick={this.handleAddExercise}>add</button>
        <ExerciseTable 
            exercisesList={this.state.exercisesList}
            handleDelete={this.handleDelete} />
      </div>
    );
  }
}

class ExerciseTable extends React.Component {
  render() {
    const list = [];
    this.props.exercisesList.forEach((exercise) => {
      list.push(
        <tr key={exercise.id}>
          <td>{exercise.name}</td>
          <td>{exercise.sets}</td>
          <td>{exercise.reps}</td>
          {/* <td><button id={exercise.id} onClick={this.props.handleDelete}>delete</button></td> */}
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

function sendFormData(data) {
  var XHR = new XMLHttpRequest();
  var urlEncodedData = "";
  urlEncodedData = JSON.stringify(data);
  XHR.addEventListener('load', function(event) {
    console.log(this.responseText);
  });
  XHR.addEventListener('error', function(event) {
    alert('Oups! Something goes wrong.');
  });
  XHR.open('POST', 'http://localhost:8081/workouts', true);
  XHR.setRequestHeader('Content-Type', 'application/json');
  XHR.send(urlEncodedData);
}

function getExerciseNames() {
  let data;
  function reqListener() {
    data = this.responseText;
  }

  var req = new XMLHttpRequest();
  req.addEventListener("load", reqListener);
  req.open("GET", "http://localhost:8081/exerciseNames", false);
  req.send();

  return data;
}

export default CreateWorkoutForm;