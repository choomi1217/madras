import React from 'react';
import FixedExtensions from './FixedExtensions';
import CustomExtensions from './CustomExtensions';

const ExtensionManager = () => {
    return (
        <div>
            <h1>파일 확장자 차단 관리</h1>
            <FixedExtensions />
            <CustomExtensions />
        </div>
    );
};

export default ExtensionManager;
