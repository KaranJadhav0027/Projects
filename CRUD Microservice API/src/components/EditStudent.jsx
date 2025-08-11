import React, { useEffect, useState } from 'react';
import { getBatchById, updateBatch } from '../api/studentService';
import { useNavigate, useParams } from 'react-router-dom';

const EditStudent = () => {
  const { id } = useParams();
  const [form, setForm] = useState({ name: '', fees: '' });
  const navigate = useNavigate();

  useEffect(() => {
    getBatchById(id).then(res => {
      setForm(res.data);
    });
  }, [id]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    updateBatch(id, form).then(() => navigate('/'));
  };

  return (
    <div className="container">
      <h2>Edit Batch Entry</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" value={form.name} onChange={handleChange} className="form-control mb-2" />
        <input type="number" name="fees" value={form.fees} onChange={handleChange} className="form-control mb-2" />
        <button type="submit" className="btn btn-primary">Update</button>
      </form>
    </div>
  );
};

export default EditStudent;