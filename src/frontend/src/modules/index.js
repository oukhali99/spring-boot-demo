import { combineReducers } from "@reduxjs/toolkit";
import { default as main } from "./main";
import { default as auth } from "./auth";

export default combineReducers({
    main,
    auth
});
