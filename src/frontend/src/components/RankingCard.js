import { React } from 'react';
import { DoughnutChart } from './charts/Doughnut';

import './RankingCard.scss';

export const RankingCard = ({roleName, rolePercentile, globalPercentile}) => {

    const roleTopPercentage = 100 - rolePercentile;
    let roleRanking = 0;
    if (roleTopPercentage === 0) {
        roleRanking = 1;
    } else {
        roleRanking = roleTopPercentage;
    };

    const globalTopPercentage = 100 - globalPercentile;
    let globalRanking = 0;
    if (globalTopPercentage === 0) {
        globalRanking = 1;
    } else {
        globalRanking = globalTopPercentage;
    }

  return (
    <div className="RankingCard">
      <div>
            {/* <p>Your salary is higher than {rolePercentile.toFixed(2)}% of salaries in your field.</p> */}
            <p>You are in the top {roleRanking}% of earners in your field.</p>
        </div>
        <div>
            {/* <p>Your salary is higher than {100 - globalPercentile.toFixed(2)}% of salaries across all fields.</p> */}
            <p>You are in the top {globalRanking}% of earners across all roles.</p>
        </div>
        <DoughnutChart roleName={roleName} rolePercentile={rolePercentile} globalPercentile={globalPercentile}/>
    </div>
  );
}