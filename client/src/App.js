import React, { Component } from 'react';
import RecentWorkoutsTable from './RecentWorkouts.js';
import CreateWorkoutForm from './CreateNewWorkouts.js';

import logo from './dumbbell.svg';
import './App.css';

class App extends Component {
  // constructor(props) {
  //   super(props);
  //   this.handleRefreshWorkouts = this.handleRefreshWorkouts.bind(this);
  // }

  // handleRefreshWorkouts() {
  //   const data = getWorkouts();
  //   this.setState({
  //     workoutData: data,
  //   });
  // }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">iron tracker</h1>
        </header>
        <CreateWorkoutForm />
      </div>
    );
  }
}

export default App;
