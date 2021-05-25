package com.facebook;

import a2.b.a.a.a;
public class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    public final FacebookRequestError a;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.a = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.a;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable, java.lang.Object
    public final String toString() {
        StringBuilder Q = a.Q("{FacebookServiceException: ", "httpResponseCode: ");
        Q.append(this.a.getRequestStatusCode());
        Q.append(", facebookErrorCode: ");
        Q.append(this.a.getErrorCode());
        Q.append(", facebookErrorType: ");
        Q.append(this.a.getErrorType());
        Q.append(", message: ");
        Q.append(this.a.getErrorMessage());
        Q.append("}");
        return Q.toString();
    }
}
