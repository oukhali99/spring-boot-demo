import React from "react";
import styled from "styled-components";

const StyledDiv = styled.div`
    color: ${ props => props.success ? "inherit" : "red" }
`;

const ErrorMessage = ({ message }) => {
    const { success, payload } = message;

    return (
        <StyledDiv success={success}>
            {JSON.stringify(payload)}
        </StyledDiv>
    )
}

export default ErrorMessage;
