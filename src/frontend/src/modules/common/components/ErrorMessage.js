import React from "react";
import styled from "styled-components";

const StyledDiv = styled.div`
    color: ${ props => props.message.success ? "inherit" : "red" }
`;

const ErrorMessage = ({ message }) => {
    const { payload } = message;

    return (
        <StyledDiv message={message}>
            {JSON.stringify(payload)}
        </StyledDiv>
    )
}

export default ErrorMessage;
