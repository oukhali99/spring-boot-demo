import { createAction } from "@reduxjs/toolkit";

export const fetchBooksSuccess = createAction("book/fetchBooksSuccess");

export const fetchBooks = async (dispatch, getState) => {
    const requestOptions = {
        method: "GET",
    };

    const result = await fetch("http://localhost:8080/api/v1/book", requestOptions);

    const resJson = await result.json();
    console.log(resJson);

    const { success, payload } = resJson;
    if (success) {
        const books = payload;
        dispatch(fetchBooksSuccess({ books }));
    }

    return resJson;
};
