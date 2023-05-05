import { createAction } from "@reduxjs/toolkit";
import bcrypt from "bcryptjs"

export const registerAction = createAction("auth/registerAction");

export const register = (username, password) => async (dispatch, getState) => {
    const salt = bcrypt.genSaltSync(10);
    const passwordHash = bcrypt.hashSync(password, salt);

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, passwordHash })
    };


    const result = await fetch("http://localhost:8080/api/v1/user", requestOptions);
    const response = await result.json();
    console.log(response);

    dispatch(registerAction());
}
