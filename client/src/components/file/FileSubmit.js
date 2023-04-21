import axios from 'axios';
import React, { useState } from 'react'

const FileSubmit = () => {

  const [file, setFile] = useState()

  const onChangeFile = event => {
    if (event.target.files.length < 1) {
      return;
    }
    const file = event.target.files[0];
    const fileReader = new FileReader();
    fileReader.onloadend = () => {
      axios.post('/api/v1.0/files', { name: fileReader.result.split(',')[1] })
        .then(resp => {
          setFile(resp.data)
        });
    };
    fileReader.readAsDataURL(file);
  };

  return (
    <div className='container'>
      <input type='file' className='form-control mb-3' onChange={onChangeFile} />
      <img src={`/file-storage/app/files/${file?.name}`} className='col-6' />
      {/* <img src={process.env.PUBLIC_URL + '/files/' + file.name} /> */}
    </div>
  )
}

export default FileSubmit