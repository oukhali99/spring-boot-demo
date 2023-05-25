import { combineReducers } from "@reduxjs/toolkit";
import main from "./main";
import auth from "./auth";
import book from "./book";

export default combineReducers({
    main,
    auth,
    book,
});
