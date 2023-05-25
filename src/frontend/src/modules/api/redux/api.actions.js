import { actions as authActions } from "modules/auth";

export const request = (url, requestOptions) => async (dispatch, getState) => {
    const result = await fetch(url, requestOptions);

    const resJson = await result.json();
    console.log(resJson);

    const { success, payload } = resJson;
    if (!success) {
        const { errorCode } = payload;
        dispatch(handleErrorCode(errorCode));
    }

    return resJson;
};

const handleErrorCode = errorCode => (dispatch, getState) => {
    if (errorCode === "EXPIRED_JWT_TOKEN") {
        dispatch(authActions.resetToken);
    }
}
