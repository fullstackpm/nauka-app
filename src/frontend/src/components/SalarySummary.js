import { React } from 'react';

export const SalarySummary = ({userSalary, medSalary, minSalary, maxSalary}) => {

  return (

    <div className="SalarySummary">
        <p>your salary: {userSalary}</p>
        <p>median salary: {medSalary}</p>
        <p>min salary: {minSalary}</p>
        <p>max salary: {maxSalary}</p>
    </div>
  );
}