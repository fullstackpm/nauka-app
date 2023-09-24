import { React } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import { RolePage } from './pages/RolePage';
import { RolesPage } from './pages/RolesPage';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/roles/discipline/:discipline" element={<RolesPage />}/>
        <Route path="/roles/name/:roleName" element={<RolePage />}/>
        <Route path="/roles" element={<RolesPage />} />
      </Routes>
    </Router>
  );
}


// function App() {
//   return (
//     <Router>
//       <Routes>
//         <Route path="/roles/a/:discipline" element={<RolesPage />}/>
//         <Route path="/roles/:roleName" element={<RolePage />}/>
//       </Routes>
//     </Router>
//   );
// }

export default App;
