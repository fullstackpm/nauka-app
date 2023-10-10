import { React } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.scss';
import { RolePage } from './pages/RolePage';
import { RolesPage } from './pages/RolesPage';
import { SalariesPage } from './pages/SalariesPage';
import { DisciplinePage } from './pages/DisciplinePage';
import { DemographicsPage } from './pages/DemographicsPage';


function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          <Route path="/roles/name/:roleName/overview" element={<RolePage />}/>
          <Route path="/roles/name/:roleName/salaries" element={<SalariesPage />}/>
          <Route path="/roles/name/:roleName/discipline" element={<DisciplinePage />}/>
          <Route path="/roles/name/:roleName/demographics" element={<DemographicsPage />}/>
          <Route path="/roles/name/:roleName/education" element={<DisciplinePage />}/>
          <Route path="/roles/:discipline" element={<RolesPage />}/>
          <Route path="/roles" element={<RolesPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
