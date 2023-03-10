import React, { createContext, useEffect, useState } from 'react'
import axios from 'axios'

export const BodyContext = createContext()

const BodyContextProvider = ({ children }) => {
  const [cars, setCars] = useState([])
  const [localizaciones, setLocalizaciones] = useState([])
  const [isLike, setIsLike] = useState(false);
  const [dateRange, setDateRange] = useState([null, null]);
  const [allDates, setAllDates] = useState([])
  const [categorias, setCategorias] = useState([])
  const [selectedCity, setSelectedCity] = useState(null)
  const [reservations, setReservations] = useState([])

  useEffect(() => {
    axios.get("http://localhost:5000/cars")
      .then(res => setCars(res.data))
      .catch(err => console.log(err))
  }, [])

  useEffect(() => {
    axios.get("http://localhost:5000/localizaciones")
      .then(res => setLocalizaciones(res.data))
      .catch(err => console.log(err))
  }, [])

  useEffect(() => {
    axios.get("http://localhost:5000/categorias")
      .then(res => setCategorias(res.data))
      .catch(err => console.log(err))
  }, [])

  useEffect(() => {
    axios.get("http://localhost:5000/reservations")
      .then(res => setReservations(res.data))
      .catch(err => console.log(err))
  }, [])

  const randomLocation = Math.floor(localizaciones.length * Math.random())

  const data = {
    cars,
    setCars,
    localizaciones,
    setLocalizaciones,
    isLike,
    setIsLike,
    randomLocation,
    dateRange,
    setDateRange,
    allDates,
    setAllDates,
    categorias,
    setCategorias,
    selectedCity,
    setSelectedCity,
    reservations,
    setReservations
  }

  return (
    <BodyContext.Provider value={data}>
      {children}
    </BodyContext.Provider>
  )
}

export default BodyContextProvider