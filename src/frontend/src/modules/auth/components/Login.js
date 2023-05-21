import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Button, Form } from "react-bootstrap";
import styled from "styled-components";
import { useHistory } from "react-router-dom";

import { actions as authActions, selectors as authSelectors } from "modules/auth";
import { ErrorMessage } from "modules/common";

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
    const history = useHistory();

    const isAuthenticated = useSelector(authSelectors.isAuthenticated);

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [response, setResponse] = useState("");

    const handleLogin = async () => {
        setResponse(await dispatch(authActions.authenticate(username, password)));
    };

    const handleRegister = async () => {
        setResponse(await dispatch(authActions.register(username, password)));
    };

    if (isAuthenticated) {
        history.push("/books");
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

            <ErrorMessage message={response} />
        </LoginContainer>
    );
};

export default Login;
