import React from 'react';

export const RolesCard = ({ role }) => {

  const name = role.roleName;
  const discipline = role.roleDiscipline;
  const salary = "£50,000"

  return (
    <div className="RolesCard">
      <p> Role name = {name}, Discipline = {discipline}, Median Salary = {salary}</p> {/* the salary will be replaced by the median salary */}
    </div>
  );
};