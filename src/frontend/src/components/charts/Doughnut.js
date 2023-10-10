import { 
    Chart as ChartJS, 
    ArcElement,
    Tooltip, 
    Legend 
} from "chart.js";
import { Doughnut } from "react-chartjs-2";
ChartJS.register(
    ArcElement,
    Tooltip,
    Legend
);

const mintGreenColour = getComputedStyle(document.documentElement).getPropertyValue('--mint-green-colour').trim();
const paleOrangeColour = getComputedStyle(document.documentElement).getPropertyValue('--pale-orange-colour').trim();

export const DoughnutChart = ({ roleName, rolePercentile, globalPercentile }) => {

    const data1 = {
        labels: ['Higher', 'Lower'],
        datasets: [{
            label: 'Percentile',
            data: [100-(rolePercentile), rolePercentile],
            backgroundColor: [mintGreenColour, paleOrangeColour] 
        }]
    };
    
    const data2 = {
        labels: ['Higher', 'Lower'],
        datasets: [{
            label: 'Percentile',
            data: [100-(globalPercentile), globalPercentile],
            backgroundColor: [mintGreenColour, paleOrangeColour] 
        }]
    };

    const options = {

    }

    const textCenterRole = {
        id: 'textCenter',
        beforeDatasetsDraw(chart,args,pluginOptions) {
            const {ctx} = chart;

            ctx.save();
            ctx.font = 'bolder 10px sans-serif';
            ctx.textAlign = 'center';
            ctx.textBaseline = 'middle';
            ctx.fillText(`${roleName}`, chart.getDatasetMeta(0).data[0].x, chart.getDatasetMeta(0).data[0].y);
        }
    }

    const textCenterGlobal = {
        id: 'textCenter',
        beforeDatasetsDraw(chart,args,pluginOptions) {
            const {ctx} = chart;

            ctx.save();
            ctx.font = 'bolder 10px sans-serif';
            ctx.textAlign = 'center';
            ctx.textBaseline = 'middle';
            ctx.fillText('All Roles', chart.getDatasetMeta(0).data[0].x, chart.getDatasetMeta(0).data[0].y);
        }
    }

  return (
        <div className="doughnut-container">
            <Doughnut 
                options={options}
                data={data1}
                plugins={[textCenterRole]}
            />
            <Doughnut 
                options={options}
                data={data2}
                plugins={[textCenterGlobal]}
            />
        </div>
    );
  }