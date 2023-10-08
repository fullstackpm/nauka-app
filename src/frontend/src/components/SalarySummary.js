import { React } from 'react';

import './SalarySummary.scss';

export const SalarySummary = ({userSalary, medSalary, minSalary, maxSalary, currency}) => {

  const formattedNumber = new Intl.NumberFormat('en-US', { style: 'currency', currency: currency.toUpperCase() }).format(userSalary);
  return (

    <div className="SalarySummary">
        <span>{formattedNumber}</span>
        {/* <p>median salary: {medSalary}</p>
        <p>min salary: {minSalary}</p>
        <p>max salary: {maxSalary}</p> */}
    </div>
  );
}