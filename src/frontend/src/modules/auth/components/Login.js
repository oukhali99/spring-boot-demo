import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { Container, Row, Col, Button, Form } from "react-bootstrap";

import { actions as authActions } from "modules/auth";

const Login = () => {
    const dispatch = useDispatch();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = () => {
        dispatch(authActions.register());
    }

    const handleRegister = () => {
        dispatch(authActions.register(username, password));
    }

    return (
        <Container>
            <Row>
                <Form>
                    <Form.Group controlId="formBasicUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" placeholder="Enter username" value={username} onChange={(e) => setUsername(e.target.value)} />
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </Form.Group>

                    
                    <Button variant="primary" onClick={handleLogin}>
                        Login
                    </Button>

                    <Button variant="primary" onClick={handleRegister}>
                        Register
                    </Button>
                </Form>
            </Row>
        </Container>
    );
};

export default Login;
