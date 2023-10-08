import { React } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.scss';
import { RolePage } from './pages/RolePage';
import { RolesPage } from './pages/RolesPage';


function App() {
  return (
    <div className='App'>
      <Router>
        <Routes>
          <Route path="/roles/name/:roleName" element={<RolePage />}/>
          <Route path="/roles/:discipline" element={<RolesPage />}/>
          <Route path="/roles" element={<RolesPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
