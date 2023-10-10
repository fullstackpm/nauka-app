import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import './RoleNavbar.scss';

export const RoleNavbar = ({ role }) => {
    const location = useLocation();
    
    const isActive = (path) => {
        return location.pathname.includes(path);
    };

    return (
        <nav>
            <ul>
                <li className={isActive('/overview') ? 'active' : ''}>
                    <Link to={`/roles/name/${role.roleName}/overview`}>Overview</Link>
                </li>
                <li className={isActive('/salaries') ? 'active' : ''}>
                    <Link to={`/roles/name/${role.roleName}/salaries`}>Salaries</Link>
                </li>
                <li className={isActive('/discipline') ? 'active' : ''}>
                    <Link to={`/roles/name/${role.roleName}/discipline`}>Discipline</Link>
                </li>
                <li className={isActive('/demographics') ? 'active' : ''}>
                    <Link to={`/roles/name/${role.roleName}/demographics`}>Demographics</Link>
                </li>
                <li className={isActive('/education') ? 'active' : ''}>
                    <Link to={`/roles/name/${role.roleName}/education`}>Education</Link>
                </li>
            </ul>
        </nav>
    );
};
