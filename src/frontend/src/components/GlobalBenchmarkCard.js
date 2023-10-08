import { React } from 'react';
import { Barchart } from './charts/Barchart';

export const GlobalBenchmarkCard = ({userSalary, medianSalary}) => {

    const diffValue = userSalary - medianSalary;

    const formattedNumber = new Intl.NumberFormat('en-US', { style: 'currency', currency: 'GBP' }).format(diffValue);

  return (

    <div className="RoleBenchmarkCard">
      <p>Difference between median salary: {formattedNumber}</p>
      {/* <p>Difference between min salary: {diffMinSalary}</p>
      <p>Difference between max salary: {diffMaxSalary}</p> */}
      <Barchart userSalary={userSalary} medianSalary={medianSalary} label1={"You"} label2={"Global Median"}/>
    </div>
  );
}