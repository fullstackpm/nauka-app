import React from 'react';

export const RoleSmallCard = ({ salary }) => {

  const age = salary.age;
  const gender = salary.gender;
  const educationLevel = salary.educationLevel;
  const yearsOfExperience = salary.yearsOfExperience;
  const basicSalary = salary.basicSalary;
  const currency = salary.currency;

  return (
    <div className="RoleSmallCard">
      <p> Age = {age}, gender = {gender}, educationLevel = {educationLevel}, yearsOfExperience = {yearsOfExperience}, basicSalary = {basicSalary}, currency = {currency}</p>
    </div>
  );
};
