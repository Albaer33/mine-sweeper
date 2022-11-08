import './App.css'
import { useState, useEffect } from 'react'
import { Routes, Route } from 'react-router-dom'
import axios from 'axios'
import Home from './pages/Home'
import NewGame from './pages/NewGame'
import Game from './pages/Game'
import GameList from './pages/GameList'
import Login from './pages/Login'
import Logout from './pages/Logout'
import Error from './pages/Error'
import SharedLayout from './pages/SharedLayout'
import Games from './pages/Games'
import ProtectedRoute from './pages/ProtectedRoute'

const App = () => {

  const [user, setUser] = useState(null)

  useEffect(() => {

    axios.defaults.baseURL = 'http://localhost:8080/api/v1'
    axios.defaults.headers['Accept'] = 'application/json'
    axios.defaults.headers.post['Content-Type'] = 'application/json'
    axios.defaults.withCredentials = true

    axios.interceptors.response.use((response) => response, (error) => {
      console.log(error)
    })

    axios.defaults.auth = {
      username: user?.username,
      password: user?.password
    }

  }, [user])

  return (
    <Routes>
      <Route path='/' element={<SharedLayout user={user} />} >
        <Route index element={<Home />} />
        <Route path='/login' element={<Login setUser={setUser} />} />
        <Route path='/logout' element={<Logout setUser={setUser} />} />
        <Route path='/games' element={<ProtectedRoute user={user} />}>
          <Route index element={<Games user={user} />} />
          <Route path='new' element={<NewGame />} />
          <Route path=':gameId' element={<Game />} />
          <Route path='list' element={<GameList />} />
        </Route>
        <Route path='*' element={<Error />} />
      </Route>
    </Routes>
  )

}

export default App