import { React } from 'react';

export const RoleSmallCard = ({role}) => {
  return (
    <div className="RoleSmallCard">
      <p>{role.skillName}</p>
    </div>
  );
}