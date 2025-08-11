// import { useState } from 'react'

// // import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
// import StudentList from './components/StudentList';
// import AddStudent from './components/AddStudent';
// import EditStudent from './components/EditStudent';

// function App() {
//   const [count, setCount] = useState(0)

//   return (
  
//       <Router>
//       <Routes>
//         <Route path="/" element={<StudentList />} />
//         <Route path="/add" element={<AddStudent />} />
//         <Route path="/edit/:id" element={<EditStudent />} />
//       </Routes>
//     </Router>
    
//   )
// }

// export default App
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import StudentList from './components/StudentList';
import AddStudent from './components/AddStudent';
import EditStudent from './components/EditStudent';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<StudentList />} />
        <Route path="/add" element={<AddStudent />} />
        <Route path="/edit/:id" element={<EditStudent />} />
      </Routes>
    </Router>
  );
}

export default App;