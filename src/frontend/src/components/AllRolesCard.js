  import * as React from 'react';
  import Table from '@mui/material/Table';
  import TableBody from '@mui/material/TableBody';
  import TableCell from '@mui/material/TableCell';
  import TableContainer from '@mui/material/TableContainer';
  import TableHead from '@mui/material/TableHead';
  import TableRow from '@mui/material/TableRow';
  import Paper from '@mui/material/Paper';

  import './AllRolesCard.scss';

  export const AllRolesCard = ({ role }) => {

    return (
      <div className='AllRolesCard'>

        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Education Level</TableCell>
                <TableCell>Years of Experience</TableCell>
                <TableCell>Age</TableCell>
                <TableCell>Gender</TableCell>
                <TableCell>Salary</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
            {
                role.salaries?.map((salary) => (
                    <TableRow key={salary.id}> {/* Assuming you have an id in the salary object */}
                        <TableCell>{salary.educationLevel}</TableCell>
                        <TableCell>{salary.yearsOfExperience}</TableCell>
                        <TableCell>{salary.age}</TableCell>
                        <TableCell>{salary.gender}</TableCell>
                        <TableCell>{new Intl.NumberFormat('en-US', { style: 'currency', currency: 'GBP' }).format(salary.basicSalary)}</TableCell>
                    </TableRow>
                ))
            }
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    );
  };
