import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { RoleNavbar } from '../components/RoleNavbar';

export const DisciplinePage = () => {
    const [role, setRole] = useState({});
    const { roleName } = useParams();

    useEffect(() => {
        const fetchRole = async () => {
            try {
                const response = await fetch(`http://localhost:8080/roles/${roleName}`);
                if (!response.ok) {
                    console.error(`Server responded with status: ${response.status}`);
                }
                const data = response.ok ? await response.json() : null;
                setRole(data);
            } catch (error) {
                console.error("An error occurred:", error);
            }
        };
        fetchRole();
    }, [roleName]);

    if (!role || !role.roleName) {
        return <h1>Role not found</h1>;
    }

    return (
        <div className="DisciplinePage">
            <div className='page-body'>
                <div className='role-name-section'>
                    <h1>{role.roleName}</h1>
                </div>
                <div className='role-navbar-section'>
                    <RoleNavbar role={role} />
                </div>
                <div className='discipline-content-section'>
                    {/* Demographics content goes here */}
                </div>
            </div>
        </div>
    );
}
