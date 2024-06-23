import { Route, Routes } from 'react-router-dom';
import Authentication from './pages/Authentication/Authentication';
import Message from './pages/Message/Message';
import HomePage from './pages/HomePage/HomePage';
import Login from './pages/Authentication/Login';
import Register from './pages/Authentication/Register';

function App() {
  return (
    <div className="App">
    
    <Routes>
      <Route path='/*' element={<HomePage/>}/>
      <Route path='/message' element={<Message />}/>
      <Route path='/*' element={<Authentication/>} />
        {/* <Route path='/login' element={<Login/>}></Route>
        <Route path='/register' element={<Register/>}></Route> */}
      {/* </Route> */}


    </Routes>

     
    </div>
  );
}

export default App;



// t
