import { Avatar, Card, CardActions, CardContent, CardHeader, CardMedia, IconButton, Typography } from '@mui/material'
import { red } from '@mui/material/colors'
import React from 'react'
import MoreVertIcon from '@mui/icons-material/MoreVert';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import SendIcon from '@mui/icons-material/Send';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';

const PostCard = () => {
  return (
    <Card className=''>
         <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title="Sunit Singh"
        subheader="@Sunit Singh"
      />
       <CardMedia
        component="img"
        height="194"
        image="https://media.licdn.com/dms/image/D5603AQF4gsuHn7r46w/profile-displayphoto-shrink_800_800/0/1665420706285?e=1721260800&v=beta&t=ufHj6ZOoRZNUaspBsFdwex7DaT4v7Hhl2p95Ofi1JTk"
        alt="Paella dish"
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
         Don't Survive Just Thrive
        </Typography>
      </CardContent>

      <CardActions className='flex justify-between' disableSpacing>
         <div>
            <IconButton>
               {true?<FavoriteIcon/>:<FavoriteBorderIcon/>} 

            </IconButton>

            <IconButton>
          {<ChatBubbleIcon/>}
            </IconButton>

            <IconButton>
          {<SendIcon/>}
            </IconButton>

         </div>

         <div>
            <IconButton>
            {true?<BookmarkIcon/>:<BookmarkBorderIcon/>}

            </IconButton>
         </div>
      </CardActions>
    </Card>

  )
}

export default PostCard