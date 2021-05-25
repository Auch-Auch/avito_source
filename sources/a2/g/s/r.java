package a2.g.s;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.util.Locale;
public abstract class r extends n {
    public String b;

    public r(LoginClient loginClient) {
        super(loginClient);
    }

    public Bundle addExtraParameters(Bundle bundle, LoginClient.Request request) {
        bundle.putString("redirect_uri", getRedirectUrl());
        bundle.putString("client_id", request.d);
        bundle.putString("e2e", LoginClient.g());
        bundle.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        bundle.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        bundle.putString("auth_type", request.h);
        bundle.putString(ServerProtocol.DIALOG_PARAM_LOGIN_BEHAVIOR, request.a.name());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", FacebookSdk.getSdkVersion()));
        if (getSSODevice() != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_SSO_DEVICE, getSSODevice());
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CUSTOM_TABS_PREFETCHING, FacebookSdk.hasCustomTabsPrefetching ? "1" : "0");
        return bundle;
    }

    public abstract AccessTokenSource g();

    public Bundle getParameters(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!Utility.isNullOrEmpty(request.b)) {
            String join = TextUtils.join(",", request.b);
            bundle.putString("scope", join);
            addLoggingExtra("scope", join);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, request.c.getNativeProtocolAudience());
        bundle.putString("state", getClientState(request.e));
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        String str = "1";
        if (token == null || !token.equals(this.loginClient.e().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", ""))) {
            Utility.clearFacebookCookies(this.loginClient.e());
            addLoggingExtra("access_token", "0");
        } else {
            bundle.putString("access_token", token);
            addLoggingExtra("access_token", str);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CBT, String.valueOf(System.currentTimeMillis()));
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            str = "0";
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_IES, str);
        return bundle;
    }

    public String getRedirectUrl() {
        StringBuilder L = a.L("fb");
        L.append(FacebookSdk.getApplicationId());
        L.append("://authorize");
        return L.toString();
    }

    public String getSSODevice() {
        return null;
    }

    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        String str;
        this.b = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.b = bundle.getString("e2e");
            }
            try {
                AccessToken createAccessTokenFromWebBundle = n.createAccessTokenFromWebBundle(request.b, bundle, g(), request.d);
                result = LoginClient.Result.d(this.loginClient.g, createAccessTokenFromWebBundle);
                CookieSyncManager.createInstance(this.loginClient.e()).sync();
                this.loginClient.e().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", createAccessTokenFromWebBundle.getToken()).apply();
            } catch (FacebookException e) {
                result = LoginClient.Result.b(this.loginClient.g, null, e.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = LoginClient.Result.a(this.loginClient.g, "User canceled log in.");
        } else {
            this.b = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, "%d", Integer.valueOf(requestError.getErrorCode()));
                message = requestError.toString();
            } else {
                str = null;
            }
            result = LoginClient.Result.c(this.loginClient.g, null, message, str);
        }
        if (!Utility.isNullOrEmpty(this.b)) {
            logWebLoginCompleted(this.b);
        }
        this.loginClient.d(result);
    }

    public r(Parcel parcel) {
        super(parcel);
    }
}
