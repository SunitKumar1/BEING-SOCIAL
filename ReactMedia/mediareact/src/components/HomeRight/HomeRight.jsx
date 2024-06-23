import React from 'react'
import SearchUser from '../SearchUser/SearchUser'
import PopularUserCard from './PopularUserCard'
import { Card } from '@mui/material'

const popularUser=[1,2,2,3,4]
const HomeRight = () => {
  return (
    <div className='pr-5'>
        <SearchUser/>

        <Card>
        <div className='flex justify-between py-5 items-center'>
           <p className='font-semibold opacity-70'>Suggestions</p>
           <p className='text-xs font-semibold opacity-95 cursor-pointer'>View All</p>
        </div>

        
        <div className=''>
        {popularUser.map((item)=><PopularUserCard/>)}
        </div>

        </Card>

       

    </div>
  )
}

export default HomeRight