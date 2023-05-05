import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Register from './Register';
import Navbar from './Navbar';
import Home from './Home';
import Login from './Login';

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

class App extends React.Component 
{
	render()
	{		
		return (
			<div className='main'>
				<Router>
					<Navbar/><br/>
					<Route path="/" exact component={Home}/>
					<Route path="/login" component={Login}/>
					<Route path="/register" component={Register}/>
				</Router>
			</div>
		);
	}
}
	
export default App;
	