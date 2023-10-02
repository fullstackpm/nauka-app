import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { RolesCard } from '../components/RolesCard';

export const RolesPage = () => {

    const [roles, setRoles] = useState([]);
    const { discipline } = useParams();

    useEffect(
        () => {
            const fetchRoles = async () => {
                try {
                    const url = discipline 
                        ? `http://localhost:8080/roles?discipline=${discipline}`
                        : 'http://localhost:8080/roles';

                    // const response = await fetch(url);  // Make the fetch request with the created URL
                   
                    const response = await fetch(url);
                    // console.log("Fetching URL: ", response); // Debug the constructed URL

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
                    setRoles(data);
                } catch (error) {
                    console.error("An error occurred:", error);
                }
            };
            fetchRoles();
        },
        [discipline]
    )
    
    return (
        <div className="RolesPage">
            <h1>Roles page</h1>
            {
                roles.map(role => <RolesCard key={role.roleId} role={role} />)
            }
        </div>
    );
}