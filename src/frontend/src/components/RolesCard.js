import * as React from 'react';
import TableCell from '@mui/material/TableCell';
import TableRow from '@mui/material/TableRow';
import { Link } from 'react-router-dom';


export const RolesCard = ({ role }) => {

  const name = role.roleName;
  const discipline = role.roleDiscipline;
  const salary = "£80,000"

  return (
    <TableRow key={role.id || role.roleName}>
      <TableCell>
        <Link to={`/roles/name/${name}/overview`}>
          {name}
        </Link>
      </TableCell>
      <TableCell>{discipline}</TableCell>
      <TableCell>{salary}</TableCell>
    </TableRow>
  );
};
