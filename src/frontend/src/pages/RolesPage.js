import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
// import { RoleDetailCard } from '../components/RoleDetailCard';
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

                    const response = await fetch(url);  // Make the fetch request with the created URL

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

    // useEffect(() => {
    //     const fetchRoles = async () => {
    //         const endpoint = 'http://localhost:8080/roles';
    //         try {
    //             const response = await fetch(endpoint);
                
    //             if (!response.ok) {
    //                 console.error(`Error fetching roles. Status: ${response.status} - Text: ${await response.text()}`);
    //                 return;
    //             }
                
    //             const data = await response.json();
    //             setRoles(data);
    //         } catch (error) {
    //             console.error("An error occurred:", error);
    //         }
    //     };
    
    //     fetchRoles();
    // }, []);
    

    
    return (
        <div className="RolesPage">
            <h1>Roles page</h1>
            {
                roles.map(role => <RolesCard key={role.roleId} role={role} />)
            }
        </div>
    );
}