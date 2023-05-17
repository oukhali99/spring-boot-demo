import { createAction } from "@reduxjs/toolkit";

export const registerAction = createAction("auth/registerAction");

export const register = (username, password) => async (dispatch, getState) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    };


    const result = await fetch("http://localhost:8080/api/v1/auth/register", requestOptions);
    const response = await result.text();
    console.log(response);

    dispatch(registerAction());
};
