import { Avatar, Box, Button, Card, Tab, Tabs } from '@mui/material';
import React from 'react'
import { useParams } from 'react-router-dom'
import PostCard from '../../components/Post/PostCard';
import UserReelCard from '../../components/Reels/UserReelCard';

const tabs=[
    {value:"post",name:"post"},
    {value:"reels",name:"Reels"},
    {value:"saved",name:"Saved"},
    {value:"repost",name:"repost"},
]
const posts=[1,1,1,11,1];
const reels=[1,1,1,11,1];
const savepost=[1,1,1,11,1];


const Profile = () => {
    const {id}=useParams();
    const [value, setValue] = React.useState('post');

    const handleChange = (event , newValue) => {
      setValue(newValue);
    };
  

  return (
    <Card className='my-10 w-[70%]'>

        <div className='rounded-md'>
            <div className='h-[15rem]'>
              <img
              className='w-full h-full rounded-t-md'
               src="https://img.freepik.com/free-vector/young-programmer-working-laptop-computer-cartoon-character_24797-2123.jpg?w=740&t=st=1715623581~exp=1715624181~hmac=aacfab210fa6e3e6fa008f0d431671179fdf2f7ec5c513c61bb6df9043f85efb" alt="Sunit" />
            </div>
            <div className='px-5 flex justify-between items-start mt-5 h-[5rem]'>

                <Avatar className='transform -translate-y-24'
                sx={{width:"10rem",height:"10rem"}}
                src='https://media.licdn.com/dms/image/D5603AQF4gsuHn7r46w/profile-displayphoto-shrink_800_800/0/1665420706285?e=1721260800&v=beta&t=ufHj6ZOoRZNUaspBsFdwex7DaT4v7Hhl2p95Ofi1JTk'/>
                
                {true? (<Button sx={{borderRadius:"20px"}} 
                variant='outlined'>Edit Profile</Button>
             ):(
                <Button sx={{borderRadius:"20px"}} 
                variant='outlined'>Follow</Button>)}
            </div>
            <div className='p-5'>
              
              <div>
                <h1 className='py-1 font-bold text-xl'>Sunit Singh</h1>
                <p>@SUNIT SINGH</p>
              </div>
              <div className='flex gap-5 items-center py-3'>
                   
                   <span>41 post</span>
                   <span>5 followers</span>
                   <span>41 following</span>

              </div>
              <div>
                <p>Lorem ipsum dolor sit amet  Ea cumque minus, sa
                epe, ad, excepturi praesentium aliquam vero dolor
                em nisi explicabo placeat sequi. Nisi?</p>
                </div>
            </div>

      <section>
            <Box sx={{ width: '100%' ,borderBottom:1,
                borderColor:"divider"
            }}>
          <Tabs
             value={value}
             onChange={handleChange}
             aria-label="wrapped label tabs example"
           >

          {tabs.map((item)=>(<Tab value={item.value} 
          label={item.name} wrapped/>))}
          </Tabs>
        </Box>

        <div className='flex justify-center'>
          {value==="post"?(<div className='space-y-5 w-[70%] my-10'>    
                          {posts.map((item)=>(<div className='border border-slate-500 rounded-md'><PostCard/>
                          </div> ))}

          </div>
        ):value==="reels"?<div className='flex justify-center flex-wrap gap-2 my-10'>
               {reels.map((item)=><UserReelCard/>)}

          </div> 
          :value==="saved"?<div className='space-y-5 w-[70%] my-10'>
               {savepost.map((item)=><PostCard/>)}
          </div>:(
            <div>Repost</div>
          )}
        </div>
    </section>
            
        </div> 


    </Card>
  )
}

export default Profile