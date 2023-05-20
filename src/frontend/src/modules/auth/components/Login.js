import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Button, Form } from "react-bootstrap";
import styled from "styled-components";

import { actions as authActions, selectors as authSelectors } from "modules/auth";

const LoginContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
`;

const LoginForm = styled(Form)`
  width: 300px;
  padding: 20px;
  border-radius: 5px;
`;

const Login = () => {
    const dispatch = useDispatch();

    const isAuthenticated = useSelector(authSelectors.isAuthenticated);

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = () => {
        dispatch(authActions.authenticate(username, password));
    };

    const handleRegister = () => {
        dispatch(authActions.register(username, password));
    };

    if (isAuthenticated) {
        return (
            <div>
                Already authenticated
            </div>
        );
    }

    return (
        <LoginContainer>
            <LoginForm>
                <Form.Group controlId="formBasicUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </Form.Group>

                <Button variant="primary" onClick={handleLogin}>
                    Login
                </Button>

                <Button variant="primary" onClick={handleRegister}>
                    Register
                </Button>
            </LoginForm>
        </LoginContainer>
    );
};

export default Login;
