import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Navbar from "./Navbar";
import Home from "./Home";

import { Login } from "modules/auth";
import { BooksList } from "modules/book";
import { AuthenticatedRoute } from "modules/common";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

class App extends React.Component {
    render() {
        return (
            <div className="main">
                <Router>
                    <Route path="/" exact component={Home} />
                    <Route path="/login" component={Login} />
                    <AuthenticatedRoute path="/books" component={BooksList} />
                </Router>
            </div>
        );
    }
}

export default App;
