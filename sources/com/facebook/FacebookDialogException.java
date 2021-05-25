package com.facebook;

import a2.b.a.a.a;
public class FacebookDialogException extends FacebookException {
    public static final long serialVersionUID = 1;
    public int a;
    public String b;

    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.a = i;
        this.b = str2;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getFailingUrl() {
        return this.b;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable, java.lang.Object
    public final String toString() {
        StringBuilder Q = a.Q("{FacebookDialogException: ", "errorCode: ");
        Q.append(getErrorCode());
        Q.append(", message: ");
        Q.append(getMessage());
        Q.append(", url: ");
        Q.append(getFailingUrl());
        Q.append("}");
        return Q.toString();
    }
}
