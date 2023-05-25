import { createReducer } from "@reduxjs/toolkit";

import { actions as authActions } from "..";

const initialState = {
    token: undefined,
};

export default createReducer(initialState, {
    [authActions.setToken]: (state, action) => {
        const { token } = action.payload;
        state.token = token;
    },
});
