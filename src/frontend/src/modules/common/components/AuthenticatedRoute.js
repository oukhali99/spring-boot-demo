import React from 'react';
import { useSelector } from "react-redux";
import { Route, Redirect } from 'react-router-dom';

import { selectors as authSelectors } from "modules/auth";

const AuthenticatedRoute = ({ component: Component, ...rest }) => {
    const isAuthenticated = useSelector(authSelectors.isAuthenticated);

    return (
        <Route
            {...rest}
            render = {props =>
                isAuthenticated ? (
                    <Component {...props} />
                ) : (
                    <Redirect to="/login" />
                )
            }
        />
    );
};

export default AuthenticatedRoute;
