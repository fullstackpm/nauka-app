import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { RoleDetailCard } from '../components/RoleDetailCard';
import { RoleSmallCard } from '../components/RoleSmallCard';

export const RolePage = () => {

    const [role, setRole] = useState({});
    const { roleName } = useParams();

    useEffect(
        () => {
            const fetchRoles = async () => {
                try {
                    const response = await fetch(`http://localhost:8080/roles/${roleName}`);
                    if (!response.ok) {
                        console.error(`Server responded with status: ${response.status}`);
                        return;
                    }
                    
                    const text = await response.text();
                    
                    if (!text) {
                        console.warn("Received empty response from server");
                        return;
                    }
                    
                    const data = JSON.parse(text);
                    setRole(data);
                } catch (error) {
                    console.error("An error occurred:", error);
                }
            };
            fetchRoles();
        },
        [roleName]
    );


    if (!role || !role.roleName) {
        return <h1>Role not found</h1>;
    }
    return (
        <div className="RolePage">
        <h1>{role.roleName}</h1>
        <h3>All skills</h3>
        {role.skills?.map((skill) => (
                    <RoleDetailCard key={skill.skillId} skill={skill} />
                ))}
        <h3>All salaries</h3>
        {role.salaries?.map((salary) => (
                    <RoleSmallCard key={salary.salaryId} salary={salary} />
                ))}
        </div>
    );
}