import { Button, FormControlLabel, Radio, RadioGroup, TextField } from '@mui/material'
import { ErrorMessage, Field, Form, Formik } from 'formik'
import React, { useState } from 'react'
import * as Yup from "yup"
import { loginUserAction, registerUserAction } from '../../Redux/Auth/auth.action'
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router'


const initialValues={firstName:"",lastName:"", email:"",password:"",gender:""}
const validationSchema={email:Yup.string().email("Invalid email").required("Email Required"),
password:Yup.string().min(6,"passWord must be required at least 6 characters").required("paasword is required")
};

const Register = () => {
    const[gender,setGender]=useState("");
    const dispatch=useDispatch();
    const navigate=useNavigate();
    
     const handleSubmit=(values)=>{
        values.gender=gender;
        console.log("handle Submit",values);

       dispatch(registerUserAction  ({data:values})) 

     };  

     const handleChange = (event) => {
        setGender(event.target.value);
      };

  return (
    <>
     
     <Formik 
     onSubmit={handleSubmit}
    //  validationSchema={validationSchema}
     initialValues={initialValues}
     >
      
      <Form className="space-y-5">

        <div className="space-y-5">

        <div>
                <Field 
                   as={TextField}
                   name="firstName" 
                   placeholder="FirstName"
                   type="text" 
                   variant="outlined" 
                   fullWidth/>

                  <ErrorMessage
                   name="firstName"
                    component={"div"} 
                    className="text-red-500"/>
            </div>
            
            <div>
                <Field 
                   as={TextField}
                   name="lastName" 
                   placeholder="LastName"
                   type="text" 
                   variant="outlined" 
                   fullWidth/>

                  <ErrorMessage
                   name="lastName"
                    component={"div"}
                     className="text-red-500"/>
            </div>
          
            <div>
                <Field 
                   as={TextField}
                   name="email" 
                   placeholder="Email"
                   type="email" 
                   variant="outlined" 
                   fullWidth/>

                  <ErrorMessage 
                  name="email" 
                  component={"div"}
                 className="text-red-500"/>
            </div>

       
            <div>
                <Field 
                   as={TextField}
                   name="password" 
                   placeholder="password"
                   type="password" 
                   variant="outlined" 
                   fullWidth/>

                  <ErrorMessage
                   name="password"
                    component="div"
                     className="text-red-500"/>
            </div>

            <div>
            <RadioGroup  onChange={handleChange}  row aria-label="gender" name="gender"
      >
        <FormControlLabel value="female" control={<Radio />} label="Female" />
        <FormControlLabel value="male" control={<Radio />} label="Male" />
        
        <ErrorMessage
           name="gender"
           component="div"
            className="text-red-500"/> 

      </RadioGroup>
            </div>
             
        </div>

        <Button 
        sx={{padding: ".8rem 0rem"}} 
        fullWidth type='submit' 
        variant='contained'
        color='primary'>
          REGISTER
          </Button>

      </Form>
     </Formik>
     <div className='flex gap-2 items-center justify-center pt-5'>
        <p>if you already have account ?</p>
        <Button onClick={()=>navigate("/login")}>Login</Button>
      </div>

    </>
  )
}

export default Register