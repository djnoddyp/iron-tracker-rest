import React from 'react';

class RecentWorkoutsTable extends React.Component {
  render() {
    const rows = [];
    const json = JSON.parse(this.props.workouts);
    json.forEach((workout) => {
      rows.push(
        <WorkoutRow
          key={workout.id}
          workoutDate={workout.date}
          exercises={workout.exercises} />
      );
    });

    return(
      <div className="recent-workouts">
        <h2>recent workouts</h2>
        <table id="exercises">
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
      <tr key={ex.id}>
        <td>{ex.name}</td>
        <td>{ex.sets}</td>
        <td>{ex.reps}</td>
      </tr>
    );

    return(
      <tr>
        <td>{workoutDate}</td>
        <td>
          <table>
            <thead>
              <tr>
                <th>exercise</th>
                <th>sets</th>
                <th>reps</th>
              </tr>
            </thead>
            <tbody>{exerciseList}</tbody>
          </table>
        </td>
      </tr>
    );
  }
}

export default RecentWorkoutsTable;
