import { createAction } from "@reduxjs/toolkit";

import { actions as apiActions } from "modules/api";

export const setToken = createAction("auth/setToken");

export const register = (username, password) => async (dispatch, getState) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    };

    const resJson = await dispatch(apiActions.request("http://localhost:8080/api/v1/auth/register", requestOptions));

    const { success, payload } = resJson;    
    if (success) {
        const { token } = payload;
        dispatch(setToken({ token }));
    }

    return resJson;
};

export const authenticate = (username, password) => async (dispatch, getState) => {
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    };

    const resJson = await dispatch(apiActions.request("http://localhost:8080/api/v1/auth/authenticate", requestOptions));

    const { success, payload } = resJson;
    if (success) {
        const { token } = payload;
        dispatch(setToken({ token }));
    }

    return resJson;
};

export const resetToken = (dispatch, getState) => {
    dispatch(setToken({ token: undefined }));
}
