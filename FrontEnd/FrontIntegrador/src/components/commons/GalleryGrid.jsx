import { IconButton, Modal } from '@mui/material';
import { Box } from '@mui/system';
import React, { useState } from 'react'
import styles from '../styles/Body.module.css'
import 'react-image-gallery/styles/css/image-gallery.css'
import CloseIcon from '@mui/icons-material/Close';
import Gallery from './Gallery';

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 900,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

const GalleryGrid = ({ selectedCar }) => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);
  const imagesArray = selectedCar.imagen.length > 5 ? selectedCar.imagen.slice(4) : selectedCar.image

  return (

    <div className={styles.photosContainer}>
      {imagesArray.map(item => (
        <div className={styles.bigPhoto}>
          <img src={item.imagen[0].url_img} />
        </div>
      ))}


      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box height={'600px'} sx={style}>
          <div className={styles.closeBtnContainer}>
            <IconButton sx={{ display: 'flex', justifyContent: 'flex-end' }} disableRipple={true} onClick={handleClose}>
              <CloseIcon />
            </IconButton>
          </div>
          <Gallery selectedCar={selectedCar} />
        </Box>
      </Modal>
    </div>
  )
}

export default GalleryGrid