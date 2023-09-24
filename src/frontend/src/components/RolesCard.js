import React from 'react';

export const RolesCard = ({ role }) => {

  const name = role.roleName;
  const discipline = role.roleDiscipline;

  return (
    <div className="RolesCard">
      <p> Role name = {name}, Discipline = {discipline}</p>
    </div>
  );
};