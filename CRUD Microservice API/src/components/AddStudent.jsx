import React, { useState } from 'react';
import { createBatch } from '../api/studentService';
import { useNavigate } from 'react-router-dom';

const AddStudent = () => {
  const [form, setForm] = useState({ name: '', fees: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    createBatch(form)
      .then(() => navigate('/'))
      .catch(err => console.error(err));
  };

  return (
    <div className="container">
      <h2>Add Batch Entry</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" value={form.name} onChange={handleChange} placeholder="Name" className="form-control mb-2" required />
        <input type="number" name="fees" value={form.fees} onChange={handleChange} placeholder="Fees" className="form-control mb-2" required />
        <button type="submit" className="btn btn-success">Save</button>
      </form>
    </div>
  );
};

export default AddStudent;