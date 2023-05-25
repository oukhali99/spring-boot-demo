import React from "react";
import styled from "styled-components";

const StyledDiv = styled.div`
    color: ${(props) => (props.message.success ? "inherit" : "red")};
`;

const ErrorMessage = ({ message }) => {
    return <StyledDiv message={message}>{JSON.stringify(message)}</StyledDiv>;
};

export default ErrorMessage;
