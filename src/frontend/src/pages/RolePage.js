import { React, useEffect, useState } from 'react';
import { RoleDetailCard } from '../components/RoleDetailCard';
import { RoleSmallCard } from '../components/RoleSmallCard';

export const RolePage = () => {

    const [role, setRole] = useState({});

    useEffect(
        () => {
            const fetchRoles = async () => {
                const response = await fetch('http://localhost:8080/roles/Software Engineer');
                const data = await response.json();
                // console.log(data);
                setRole(data);
            }
            fetchRoles();
        }, []
    );

  return (
    <div className="RolePage">
      <h1>{role.roleName}</h1>
      <h3>All skills</h3>
      <RoleDetailCard />
      {role.skills?.map((skill) => (
                <RoleSmallCard key={skill.skillId} role={skill} />
            ))}
    </div>
  );
}