import { Avatar } from '@mui/material'
import React from 'react'
import AddIcon from '@mui/icons-material/Add';


const StoryCircle = () => {
  return (
    <div>
         <div className='flex flex-col items-center mr-4  cursor-pointer'>  

    <Avatar  sx={{width:"5rem",height:"5rem"}}
     src='https://media.licdn.com/dms/image/D5603AQF4gsuHn7r46w/profile-displayphoto-shrink_800_800/0/1665420706285?e=1721260800&v=beta&t=ufHj6ZOoRZNUaspBsFdwex7DaT4v7Hhl2p95Ofi1JTk'>
     </Avatar>
     <p>Sunit...</p>
  </div>
    </div>
  )
}

export default StoryCircle