// import React, { useEffect, useRef } from 'react';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from "chart.js";
import { Bar } from "react-chartjs-2";

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
);

const mintGreenColour = getComputedStyle(document.documentElement).getPropertyValue('--mint-green-colour').trim();
const oceanColour = getComputedStyle(document.documentElement).getPropertyValue('--ocean-colour').trim();

export const Barchart = ({ userSalary, medianSalary, label1, label2 }) => {
    const options = {
        responsive: true,
        plugins: {
            legend: {
                display: false  // This will hide the legend
            }
        }
    }
    
    const data = {
        labels: [label1, label2],
        datasets: [
            {
                data: [userSalary, medianSalary], // Combine userSalary and medianSalary in one array
                backgroundColor: [mintGreenColour, oceanColour], // Use an array to set individual bar colors
            }
        ]
    
    }

  return (
        <>
            <Bar 
                options={options}
                data={data}
            />
        </>
    );
  }
