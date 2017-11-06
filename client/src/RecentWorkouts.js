import React from 'react';

class RecentWorkoutsTable extends React.Component {
  // constructor(props) {
  //   super(props);
  //   this.setState({
  //     url: "http://localhost:8081/workouts",
  //     jsonData: {},
  //   });
  // }

  // componentDidMount() {
  //   function reqListener() {
  //     console.log(this.responseText);
  //     this.setState({
  //       jsonData: this.responseText,
  //     });
  //   }

  //   var req = new XMLHttpRequest();
  //   req.addEventListener("load", reqListener);
  //   req.open("GET", this.state.url, false);
  //   req.send();
  // }

  render() {
    const rows = [];

    this.props.workouts.forEach((workout) => {
      rows.push(
        <WorkoutRow
          workoutDate={workout.date}
          exercises={workout.exercises} />
      );
    });

    return(
      <div class='recent-workouts'>
        <h2>recent workouts</h2>
        <table>
          <thead>
            <tr>
              <th>date</th>
              <th>exercises</th>
            </tr>
          </thead>
          <tbody>{rows}</tbody>
        </table>
      </div>
    );
  }
}

class WorkoutRow extends React.Component {
  render() {
    const workoutDate = this.props.workoutDate;
    const exercises = this.props.exercises;

    return(
      <tr>
        <td>{workoutDate}</td>
        <td>{exercises}</td>
      </tr>
    );
  }
}

export default RecentWorkoutsTable;
