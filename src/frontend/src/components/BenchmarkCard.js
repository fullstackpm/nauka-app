import { React } from 'react';

export const BenchmarkCard = ({diffMedSalary, diffMinSalary, diffMaxSalary}) => {

  return (

    <div className="BenchmarkCard">
      <p>Difference between median salary: {diffMedSalary}</p>
      <p>Difference between min salary: {diffMinSalary}</p>
      <p>Difference between max salary: {diffMaxSalary}</p>
    </div>
  );
}