import axios from 'axios';

const BASE_URL = 'http://localhost:8080/batches';

export const getAllBatches = () => axios.get(BASE_URL);
export const getBatchById = (id) => axios.get(`${BASE_URL}/id/${id}`);
export const createBatch = (data) => axios.post(BASE_URL, data);
export const updateBatch = (id, data) => axios.put(`${BASE_URL}/id/${id}`, data);
export const deleteBatch = (id) => axios.delete(`${BASE_URL}/id/${id}`);