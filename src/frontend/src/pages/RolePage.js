import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { RoleDetailCard } from '../components/RoleDetailCard';
import { RoleSmallCard } from '../components/RoleSmallCard';
import { RankingCard } from '../components/RankingCard';
import { BenchmarkCard } from '../components/BenchmarkCard';
import { ExpectedSalary } from '../components/ExpectedSalary';
import { InfluentialFactors } from '../components/InfluentialFactors';
import { SalarySummary } from '../components/SalarySummary';

export const RolePage = () => {

    const [role, setRole] = useState({});
    const [global, setGlobal] = useState({});
    const { roleName } = useParams();

    useEffect(
        () => {
            const fetchRolesAndGlobals = async () => {
                try {
                    const response1 = await fetch(`http://localhost:8080/roles/${roleName}`);
                    const response2 = await fetch('http://localhost:8080/roles/global-stats'); // 
                    
                    const [res1, res2] = await Promise.all([response1, response2]);

            if (!res1.ok) {
                console.error(`Server responded with status: ${res1.status} for roles`);
            }
            if (!res2.ok) {
                console.error(`Server responded with status: ${res2.status} for other data`);
            }

            const data1 = res1.ok ? await res1.json() : null; 
            const data2 = res2.ok ? await res2.json() : null;

            setRole(data1);
            setGlobal(data2);
        } catch (error) {
            console.error("An error occurred:", error);
        }
    };

    fetchRolesAndGlobals();
}, [roleName]);


    if (!role || !role.roleName) {
        return <h1>Role not found</h1>;
    }
    return (
        <div className="RolePage">
        <h1>{role.roleName}</h1>
        <h3>Summary</h3>
        {
            <SalarySummary userSalary={role.userSalary} medSalary={role.medSalary} minSalary={role.minSalary} maxSalary={role.maxSalary}/>
        }
        <h3>Ranking</h3>
        {
            <RankingCard rolePercentile={role.rolePercentile} globalPercentile={global.percentile}/>
        }
        <h3>Benchmark</h3>
        {
            <BenchmarkCard diffMedSalary={role.diffMedSalary} diffMinSalary={role.diffMinSalary} diffMaxSalary={role.diffMaxSalary}/>
        }
        <h3>Expected salary</h3>
        {
            <ExpectedSalary />
        }
        <h3>Influential factors</h3>
        {
            <InfluentialFactors />
        }
        <h3>All skills</h3>
        {
            role.skills?.map((skill) => (<RoleDetailCard key={skill.skillId} skill={skill} />))
        }
        <h3>All salaries</h3>
        {
            role.salaries?.map((salary) => (<RoleSmallCard key={salary.salaryId} salary={salary} />))
        }
        <h3>Industry salaries</h3>
            <p>LinkedIn median salary</p>
            <p>Glassdoor median salary</p>
        <h3>Available jobs</h3>
            <p>LinkedIn median salary based on current jobs</p>
            <p>Glassdoor median salary based on current jobs</p>
        </div>
    );
}


// roleDTO.setRoleId(role.getRoleId());
//             roleDTO.setRoleName(role.getRoleName());
//             roleDTO.setRoleDiscipline(role.getRoleDiscipline());
//             roleDTO.setSkills(role.getSkills()); // Include the skills
//             roleDTO.setSalaries(role.getSalaries());
//             roleDTO.setUserSalary(userSalary);
//             roleDTO.setMedSalary(medSalary);
//             roleDTO.setMinSalary(minSalary);
//             roleDTO.setMaxSalary(maxSalary);
//             roleDTO.setDiffMedSalary(diffMedSalary);
//             roleDTO.setDiffMinSalary(diffMinSalary);
//             roleDTO.setDiffMaxSalary(diffMaxSalary);
//             roleDTO.setRolePercentile(salaryPercentile);