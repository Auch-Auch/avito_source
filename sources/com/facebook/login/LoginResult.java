package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;
public class LoginResult {
    public final AccessToken a;
    public final Set<String> b;
    public final Set<String> c;

    public LoginResult(AccessToken accessToken, Set<String> set, Set<String> set2) {
        this.a = accessToken;
        this.b = set;
        this.c = set2;
    }

    public AccessToken getAccessToken() {
        return this.a;
    }

    public Set<String> getRecentlyDeniedPermissions() {
        return this.c;
    }

    public Set<String> getRecentlyGrantedPermissions() {
        return this.b;
    }
}
