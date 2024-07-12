import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api/v1',
    withCredentials: true, // 자격 증명 허용
    headers: {
        'Content-Type': 'application/json',
    },
});

export default api;
