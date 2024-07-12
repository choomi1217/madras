import React, { useState, useEffect } from 'react';
import api from '../services/api';

const FixedExtensions = () => {
    const [extensions, setExtensions] = useState([]);

    useEffect(() => {
        api.get('/fixed-extensions').then(response => {
            setExtensions(response.data);
        });
    }, []);

    const handleToggle = (extension) => {
        const updatedExtensions = extensions.map(ext =>
            ext.name === extension.name ? { ...ext, checked: !ext.checked } : ext
        );
        setExtensions(updatedExtensions);
        api.post('/fixed-extensions/' + extension.extension, updatedExtensions);
    };

    return (
        <div>
            <h2>고정 확장자 관리</h2>
            <ul>
                {extensions.map(extension => (
                    <li key={extension.name}>
                        <label>
                            <input
                                type="checkbox"
                                checked={extension.checked}
                                onChange={() => handleToggle(extension)}
                            />
                            {extension.extension}
                        </label>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FixedExtensions;
