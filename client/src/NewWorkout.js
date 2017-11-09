import React from 'react';

class WorkoutForm extends React.Component {
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSelectChange = this.handleSelectChange.bind(this);
    this.state = {
      date: new Date(),
      exercises: [],
    }
  }

  handleSubmit(event) {
    sendFormData(this.state);
    event.preventDefault();
  }

  handleInputChange(event) {
    this.setState({
      date: event.target.value,
    });
  }

  handleSelectChange(event) {
    var name = event.target.value;
    var obj = {"name": name};
    var e = this.state.exercises.slice();
    e.push(obj);
    this.setState({
      exercises: e,
    });
  }

  render() {
    const options = [];
    this.props.exercises.forEach((exercise) => {
      options.push(
        <ExerciseOption option={exercise.name} />
      );
    });
    return(
      <div class="Workout-form">
        <h2>create new workout</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="date"
            name="workoutDate"
            value={this.state.date}
            onChange={this.handleInputChange} />
          <select
            name="exercises"
            multiple={true}
            value={this.state.exercises}
            onChange={this.handleSelectChange}>
            {options}
          </select>
          <input type="submit" value="Submit" />
        </form>
      </div>
    );
  }
}

class ExerciseOption extends React.Component {
  render() {
    const exercise = this.props.option;
    return (
      <option>{exercise}</option>
    );
  }
}

function sendFormData(data) {
  var XHR = new XMLHttpRequest();
  var urlEncodedData = "";
  // var urlEncodedDataPairs = [];
  // var name;
  // for(name in data) {
  //   urlEncodedDataPairs.push(encodeURIComponent(name) + '=' + encodeURIComponent(data[name]));
  // }
  // // Combine the pairs into a single string and replace all %-encoded spaces to
  // // the '+' character; matches the behaviour of browser form submissions.
  // urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');
  urlEncodedData = JSON.stringify(data);
  XHR.addEventListener('load', function(event) {
    console.log(this.responseText);
  });
  XHR.addEventListener('error', function(event) {
    alert('Oups! Something goes wrong.');
  });
  XHR.open('POST', 'http://localhost:8080/workouts', true);
  XHR.setRequestHeader('Content-Type', 'application/json');
  XHR.send(urlEncodedData);
}

export default WorkoutForm;
