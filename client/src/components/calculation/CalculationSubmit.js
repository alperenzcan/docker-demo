import axios from 'axios'
import React, { useEffect, useState } from 'react'

const CalculationSubmit = () => {

  const [form, setForm] = useState({ num1: '', num2: '' })
  const [calculations, setCalculations] = useState([])

  useEffect(() => {
    loadCalculations()
  }, [])

  const onChange = (event) => {
    const { name, value } = event.target
    setForm(prevState => ({ ...prevState, [name]: value }))
  }

  const onClickSubmit = () => {
    axios.post('/api/v1.0/calculations', form)
      .then(resp => {
        setForm(prevState => ({ ...prevState, sum: resp.data }))
      })
  }

  const loadCalculations = () => {
    axios.get('/api/v1.0/calculations')
      .then(resp => {
        setCalculations(resp.data)
      })
  }

  return (
    <div className='p-5'>
      <div className='row align-items-center mb-3'>
        <div className='col-1'>
          <input className='form-control' type='number' name='num1' value={form.num1} onChange={onChange} />
        </div>
        <div className='col-1 text-center'>
          +
        </div>
        <div className='col-1'>
          <input className='form-control' type='number' name='num2' value={form.num2} onChange={onChange} />
        </div>
        <div className='col-1 text-center'>
          =
        </div>
        <div className='col-1'>
          <input className='form-control' value={form.sum} />
        </div>
      </div>
      <button className='btn btn-primary mb-5' onClick={onClickSubmit}> Hesapla </button>
      {
        calculations.map(calculation => (
          <div key={calculation.id}>
            <label>{calculation.num1}+{calculation.num2}={calculation.sum} </label>
          </div>
        ))
      }
    </div>
  )
}

export default CalculationSubmit