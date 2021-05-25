package com.facebook;

import a2.b.a.a.a;
public class FacebookGraphResponseException extends FacebookException {
    public final GraphResponse a;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.a = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.a;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable, java.lang.Object
    public final String toString() {
        GraphResponse graphResponse = this.a;
        FacebookRequestError error = graphResponse != null ? graphResponse.getError() : null;
        StringBuilder L = a.L("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            L.append(message);
            L.append(" ");
        }
        if (error != null) {
            L.append("httpResponseCode: ");
            L.append(error.getRequestStatusCode());
            L.append(", facebookErrorCode: ");
            L.append(error.getErrorCode());
            L.append(", facebookErrorType: ");
            L.append(error.getErrorType());
            L.append(", message: ");
            L.append(error.getErrorMessage());
            L.append("}");
        }
        return L.toString();
    }
}
