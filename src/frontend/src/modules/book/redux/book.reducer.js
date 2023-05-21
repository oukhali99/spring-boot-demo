import { createReducer } from "@reduxjs/toolkit";

import { actions as bookActions } from "..";

const initialState = {
    books: []  
};

export default createReducer(initialState, {
    [bookActions.fetchBooksSuccess]: (state, action) => {
        const { books } = action.payload;
        state.books = books;
    }
});
