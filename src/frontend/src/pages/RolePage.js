import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
// import { RoleDetailCard } from '../components/RoleDetailCard';
import { RoleSmallCard } from '../components/RoleSmallCard';
import { RankingCard } from '../components/RankingCard';
import { RoleBenchmarkCard } from '../components/RoleBenchmarkCard';
import { GlobalBenchmarkCard } from '../components/GlobalBenchmarkCard';
import { ExpectedSalary } from '../components/ExpectedSalary';
// import { InfluentialFactors } from '../components/InfluentialFactors';
import { SalarySummary } from '../components/SalarySummary';

import './RolePage.scss';

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
            <div className='role-name-section'>
                <h1>{role.roleName}</h1>
            </div>
            <div className='page-body'>
                <div className='salary-summary-section'>
                <h3>Summary</h3>
                {
                    <SalarySummary userSalary={role.userSalary} currency={role.currency} medSalary={role.medSalary} minSalary={role.minSalary} maxSalary={role.maxSalary}/>
                }
                </div>
                <div className='expected-salary-section'>
                    <h3>Expected salary</h3>
                    {
                        <ExpectedSalary />
                    }
                </div>
                <div className='salary-ranking-section'>
                    <h3>Ranking</h3>
                    {
                        <RankingCard rolePercentile={role.rolePercentile} globalPercentile={global.percentile}/>
                    }
                </div>
                <div className='role-benchmark-section'>
                    <h3>Role benchmark</h3>
                    {
                        <RoleBenchmarkCard userSalary={role.userSalary} medianSalary={role.medSalary} diffMedSalary={role.diffMedSalary}/>
                    }
                </div>
                <div className='global-benchmark-section'>
                    <h3>Global benchmark</h3>
                    {
                        <GlobalBenchmarkCard userSalary={role.userSalary} medianSalary={global.globalMedianSalary}/>
                    }
                </div>
                {/* <div>
                    <h3>Influential factors</h3>
                    {
                        <InfluentialFactors />
                    }
                </div>
                <div>
                    <h3>All skills</h3>
                    {
                        role.skills?.map((skill) => (<RoleDetailCard key={skill.skillId} skill={skill} />))
                    }
                </div> */}
                <div className='all-salaries-section'>
                    <h3>All salaries</h3>
                    {
                        role.salaries?.map((salary) => (<RoleSmallCard key={salary.salaryId} salary={salary} />))
                    }
                </div>
                {/* <div>
                    <h3>Industry salaries</h3>
                    <p>LinkedIn median salary</p>
                    <p>Glassdoor median salary</p>
                </div>
                <div>
                    <h3>Available jobs</h3>
                    <p>LinkedIn median salary based on current jobs</p>
                    <p>Glassdoor median salary based on current jobs</p>
                </div> */}
                </div>
        </div>
    );
}