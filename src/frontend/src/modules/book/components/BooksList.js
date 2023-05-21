import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Button } from "react-bootstrap";

import { actions as bookActions, selectors as bookSelectors } from "..";

const BooksList = () => {
    const dispatch = useDispatch();

    const books = useSelector(bookSelectors.getBooks);

    useEffect(() => {
        dispatch(bookActions.fetchBooks);
    }, []);

    return (
        <div>
            <Button onClick={() => dispatch(bookActions.fetchBooks)}>
                Refresh
            </Button>
            {JSON.stringify(books)}
        </div>
    );
}

export default BooksList;
