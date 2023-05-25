import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Button, Form, FormControl, FormGroup, FormLabel } from "react-bootstrap";

import { actions as bookActions, selectors as bookSelectors } from "..";

const BooksList = () => {
    const dispatch = useDispatch();

    const books = useSelector(bookSelectors.getBooks);

    useEffect(() => {
        dispatch(bookActions.fetchBooks);
    }, []);

    return (
        <div>
            <Button onClick={() => dispatch(bookActions.fetchBooks)}>Refresh</Button>
            {JSON.stringify(books)}

            <Form>
                <FormGroup>
                    <FormLabel>Test123</FormLabel>
                    <FormControl
                        type="password"
                        placeholder="Password"
                        //value={password}
                        //onChange={(e) => setPassword(e.target.value)}
                    />
                </FormGroup>
            </Form>
        </div>
    );
};

export default BooksList;
