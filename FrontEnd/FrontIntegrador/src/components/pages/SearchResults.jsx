import { Box, IconButton, Link, Typography } from '@mui/material'
import React, { useContext, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import VehicleCard from '../commons/VehicleCard'
import { BodyContext } from '../contexts/BodyContext'
import styles from '../styles/Body.module.css'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';
import axios from 'axios'
import loadingGif from '../../assets/Loading1.gif'


const SearchResults = () => {
  const { setSelectedCity, selectedCity} = useContext(BodyContext)
  const [availableCars, setAvailableCars] = useState([])
  const [loading, setLoading] = useState(true)
  const navigate = useNavigate()
  const { fechaInicio,fechaFin, ubicacionId } = useParams()
  const handleClick = () => {
    navigate('/')
  }

  useEffect(() => {
    if (fechaInicio=="n"& fechaFin=="n") {
      axios.get(`http://ec2-3-138-67-153.us-east-2.compute.amazonaws.com:8080/api/producto/u/${ubicacionId}`)
      .then(res => {
      setAvailableCars(res.data)
      axios.get(`http://ec2-3-138-67-153.us-east-2.compute.amazonaws.com:8080/api/ubicacion/${ubicacionId}`).then(ubi=>{
        setSelectedCity(ubi.data)
        setLoading(false)
      })
      })
      .catch(err => console.log(err))
    } else if (ubicacionId=="n"){
      axios.get(`http://ec2-3-138-67-153.us-east-2.compute.amazonaws.com:8080/api/producto/dates/${fechaInicio}/${fechaFin}`)
      .then(res => {setAvailableCars(res.data)
        setLoading(false)
      })
      .catch(err => console.log(err))
    } else{
      axios.get(`http://ec2-3-138-67-153.us-east-2.compute.amazonaws.com:8080/api/producto/datesAndUbi/${fechaInicio}/${fechaFin}/${selectedCity.id}`)
      .then(res => {setAvailableCars(res.data)
        axios.get(`http://ec2-3-138-67-153.us-east-2.compute.amazonaws.com:8080/api/ubicacion/${ubicacionId}`).then(ubi=>{
        setSelectedCity(ubi.data)
        setLoading(false)
      })
      })
      .catch(err => console.log(err))
    }
  }, [])

  return (
    <>
      <div className={styles.headerCategory}>
        <div>
          <h1 style={{ paddingTop: '0' }}>Vehiculos disponibles {ubicacionId != "n"? `en ${selectedCity.nombre?? "..." }`:""} {fechaFin != "n"?`desde el ${fechaInicio} al ${fechaFin}`:""}</h1>
        </div>
        <IconButton disableRipple={true} sx={{ width: 175 }} onClick={handleClick}>
          <ArrowBackIosNewIcon fontSize='large' color='action' />
        </IconButton>
      </div>

      {loading? <Box display={"flex"} flexDirection="column" justifyContent={"center"} alignItems={"center"} width={"100vw"} height={"375px"} padding="20px" borderRadius={"10px"}>
      <img src={loadingGif} alt="Loading..." style={{height: "200px", width: "auto"}}/>
      </Box>:

      
      <div className={styles.homeContainer}>
        {availableCars.length ?availableCars.map(car => (
          <VehicleCard
            key={car.id}
            car={car}
          />
        ))
        :
        <Box display={"flex"} flexDirection="column" justifyContent={"center"} alignItems={"flex-start"} width={"375px"} height={"375px"} boxShadow={"0px 0px 10px gray"} padding="20px" borderRadius={"10px"} gap="10px">
          <Typography variant='h6'>No se pudo encontrar ningun vehiculo con los filtros aplicados</Typography>
          <Link variant="subtitle1" href='/'>Proba cambiando los filtros</Link>
        </Box>
        }
      </div>}
    </>
  )
}

export default SearchResults