import React, { Component } from 'react';
import RecentWorkoutsTable from './RecentWorkouts.js';
import WorkoutForm from './NewWorkout.js';

import logo from './dumbbell.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">iron tracker</h1>
        </header>
        <RecentWorkoutsTable workouts={WORKOUTS} />
        <WorkoutForm exercises={EXERCISES} />
      </div>
    );
  }
}

class GetWorkoutsButton extends Component {
  constructor(props) {
    super(props);
    this.getWorkouts = this.getWorkouts.bind(this);
  }

  render() {
    return (
      <div>
        <button onClick={this.getWorkouts}>Get workouts</button>
        <p id="result" className="App-para">Some result</p>
      </div>
    );
  }

  getWorkouts() {
    function reqListener() {
      console.log(this.responseText);
      //populateWorkouts(req.response);
      document.getElementById("result").innerHTML = req.responseText;
    }

    var req = new XMLHttpRequest();
    req.addEventListener("load", reqListener);
    req.open("GET", "http://localhost:8081/workouts", false);
    req.send();
  }
}

const WORKOUTS = [
  {
		"date": 1508540400000,
		"exercises": "Shoulder raises"
	},
	{
		"date": 1508713200000,
		"exercises": "Pull ups"
	},
  {
    "date": 1508713200000,
    "exercises": "Bench Press"
  }
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
export default App;
