import React, { useState, useEffect } from 'react';
import api from '../services/api';

const CustomExtensions = () => {
    const [customExtensions, setCustomExtensions] = useState([]);
    const [newExtension, setNewExtension] = useState('');

    useEffect(() => {
        api.get('/custom-extensions').then(response => {
            setCustomExtensions(response.data);
        });
    }, []);

    const handleAdd = () => {
        if (newExtension.length > 0 && newExtension.length <= 20 && !customExtensions.includes(newExtension)) {
            const updatedExtensions = [...customExtensions, newExtension];
            setCustomExtensions(updatedExtensions);
            setNewExtension('');
            api.post('/custom-extensions', updatedExtensions); // 상태 저장 API 호출
        }
    };

    const handleRemove = (extension) => {
        const updatedExtensions = customExtensions.filter(ext => ext !== extension);
        setCustomExtensions(updatedExtensions);
        api.post('/custom-extensions', updatedExtensions); // 상태 저장 API 호출
    };

    return (
        <div>
            <h2>커스텀 확장자 관리</h2>
            <input
                type="text"
                value={newExtension}
                onChange={(e) => setNewExtension(e.target.value)}
                maxLength="20"
            />
            <button onClick={handleAdd}>추가</button>
            <ul>
                {customExtensions.map(extension => (
                    <li key={extension}>
                        {extension} <button onClick={() => handleRemove(extension)}>X</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CustomExtensions;
