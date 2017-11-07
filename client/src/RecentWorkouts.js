import React from 'react';

class RecentWorkoutsTable extends React.Component {
  render() {
    const rows = [];
    const json = JSON.parse(this.props.workouts);
    json.forEach((workout) => {
      rows.push(
        <WorkoutRow
          workoutDate={workout.date}
          exercises={workout.exercises} />
      );
    });

    return(
      <div class='recent-workouts'>
        <h2>recent workouts</h2>
        <button onClick={this.props.onClick}>refresh</button>
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
    const exerciseList = this.props.exercises.map((ex) =>
      <li>{ex.name}</li>
    );

    return(
      <tr>
        <td>{workoutDate}</td>
        <td><ul>{exerciseList}</ul></td>
      </tr>
    );
  }
}

export default RecentWorkoutsTable;
