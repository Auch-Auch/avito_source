package com.voximplant.sdk.client;
public class AuthParams {
    public int a;
    public String b;
    public int c;
    public String d;

    public AuthParams(int i, String str, int i2, String str2) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = str2;
    }

    public String getAccessToken() {
        return this.b;
    }

    public int getAccessTokenTimeExpired() {
        return this.a;
    }

    public String getRefreshToken() {
        return this.d;
    }

    public int getRefreshTokenTimeExpired() {
        return this.c;
    }
}
