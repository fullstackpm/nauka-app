import { React } from 'react';

export const RoleDetailCard = ({skill}) => {
  return (
    <div className="RoleDetailCard">
      <p>{skill.skillName}</p>
    </div>
  );
}