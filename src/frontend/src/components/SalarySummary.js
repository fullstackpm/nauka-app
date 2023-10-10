import { React } from 'react';

import './SalarySummary.scss';

export const SalarySummary = ({userSalary, currency}) => {

  const formattedNumber = new Intl.NumberFormat('en-US', { style: 'currency', currency: currency.toUpperCase() }).format(userSalary);
  return (

    <div className="SalarySummary">
        <span>{formattedNumber}</span>
    </div>
  );
}