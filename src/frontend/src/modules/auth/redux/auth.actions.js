import { createAction } from "@reduxjs/toolkit";

export const setToken = createAction("auth/setToken");

export const register = (username, password) => async (dispatch, getState) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    };


    const result = await fetch("http://localhost:8080/api/v1/auth/register", requestOptions);

    const resJson = await result.json();
    console.log(resJson);

    const { success, payload } = resJson;    
    if (success) {
        const { token } = payload;
        dispatch(setToken({ token }));
    }
};

export const authenticate = (username, password) => async (dispatch, getState) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    };


    const result = await fetch("http://localhost:8080/api/v1/auth/authenticate", requestOptions);

    const resJson = await result.json();
    console.log(resJson);

    const { success, payload } = resJson;    
    if (success) {
        const { token } = payload;
        dispatch(setToken({ token }));
    }
};
