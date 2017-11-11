import React, { Component } from 'react';
import RecentWorkoutsTable from './RecentWorkouts.js';
import CreateWorkoutForm from './CreateNewWorkouts.js';

import logo from './dumbbell.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.handleRefreshWorkouts = this.handleRefreshWorkouts.bind(this);
    this.state = {
      workoutData: getWorkouts(),
    }
  }

  handleRefreshWorkouts() {
    const data = getWorkouts();
    this.setState({
      workoutData: data,
    });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">iron tracker</h1>
        </header>
        <RecentWorkoutsTable 
          workouts={this.state.workoutData}
          onClick={this.handleRefreshWorkouts} />
        <CreateWorkoutForm />
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

export default App;
