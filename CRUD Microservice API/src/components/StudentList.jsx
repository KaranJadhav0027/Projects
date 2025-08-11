import React, { useEffect, useState } from 'react';
import { getAllBatches, deleteBatch } from '../api/studentService';
import { Link } from 'react-router-dom';

const StudentList = () => {
  const [batches, setBatches] = useState([]);

  const fetchBatches = () => {
    getAllBatches()
      .then(res => setBatches(res.data))
      .catch(err => console.error('Error:', err));
  };

  useEffect(() => {
    fetchBatches();
  }, []);

  const handleDelete = (id) => {
    if (window.confirm('Are you sure you want to delete this entry?')) {
      deleteBatch(id).then(() => fetchBatches());
    }
  };

  return (
    <div className="container">
      <h2>Batch Entries</h2>
      <Link to="/add" className="btn btn-primary mb-2">Add Entry</Link>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>Fees</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {batches.map(batch => (
            <tr key={batch.id}>
              <td>{batch.name}</td>
              <td>{batch.fees}</td>
              <td>
                <Link to={`/edit/${batch.id}`} className="btn btn-warning btn-sm mx-1">Edit</Link>
                <button onClick={() => handleDelete(batch.id)} className="btn btn-danger btn-sm">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;