import React, { Component } from 'react';
import RecentWorkoutsTable from './RecentWorkouts.js';
import WorkoutForm from './NewWorkout.js';

import logo from './dumbbell.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      workoutData: getWorkouts(),
    }
  }

  // componentWillMount() {
  //   var data = getWorkouts();
  //   console.log('data1: ' + data);
  //   this.setState = {
  //     workoutData: data,
  //   }
  // }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">iron tracker</h1>
        </header>
        <RecentWorkoutsTable workouts={this.state.workoutData} />
        <WorkoutForm exercises={EXERCISES} />
      </div>
    );
  }
}

function getWorkouts() {
  let data;
  function reqListener() {
    data = this.responseText;
  }

  var req = new XMLHttpRequest();
  req.addEventListener("load", reqListener);
  req.open("GET", "http://localhost:8080/workouts", false);
  req.send();

  return data;
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
