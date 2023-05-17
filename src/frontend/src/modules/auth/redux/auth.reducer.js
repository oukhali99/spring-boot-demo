import { createReducer } from "@reduxjs/toolkit";

import { actions as authActions } from "..";

const initialState = {};

export default createReducer(initialState, {
    [authActions.registerAction]: (state, action) => {
        console.log("Register reducer");
    }
})
