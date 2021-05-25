package a2.g.s;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
public abstract class p extends n {
    public p(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public boolean e(int i, int i2, Intent intent) {
        LoginClient.Result result;
        LoginClient.Request request = this.loginClient.g;
        if (intent == null) {
            result = LoginClient.Result.a(request, "Operation canceled");
        } else {
            String str = null;
            if (i2 == 0) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("error");
                if (string == null) {
                    string = extras.getString("error_type");
                }
                if (extras.get("error_code") != null) {
                    str = extras.get("error_code").toString();
                }
                if (ServerProtocol.errorConnectionFailure.equals(str)) {
                    String string2 = extras.getString("error_message");
                    if (string2 == null) {
                        string2 = extras.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                    }
                    result = LoginClient.Result.c(request, string, string2, str);
                } else {
                    result = LoginClient.Result.a(request, string);
                }
            } else if (i2 != -1) {
                result = LoginClient.Result.b(request, "Unexpected resultCode from authorization.", null);
            } else {
                Bundle extras2 = intent.getExtras();
                String string3 = extras2.getString("error");
                if (string3 == null) {
                    string3 = extras2.getString("error_type");
                }
                String obj = extras2.get("error_code") != null ? extras2.get("error_code").toString() : null;
                String string4 = extras2.getString("error_message");
                if (string4 == null) {
                    string4 = extras2.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                String string5 = extras2.getString("e2e");
                if (!Utility.isNullOrEmpty(string5)) {
                    logWebLoginCompleted(string5);
                }
                if (string3 == null && obj == null && string4 == null) {
                    try {
                        result = LoginClient.Result.d(request, n.createAccessTokenFromWebBundle(request.b, extras2, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.d));
                    } catch (FacebookException e) {
                        result = LoginClient.Result.b(request, null, e.getMessage());
                    }
                } else {
                    if (string3.equals("logged_out")) {
                        CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
                    } else if (!ServerProtocol.errorsProxyAuthDisabled.contains(string3)) {
                        if (ServerProtocol.errorsUserCanceled.contains(string3)) {
                            result = LoginClient.Result.a(request, null);
                        } else {
                            result = LoginClient.Result.c(request, string3, string4, obj);
                        }
                    }
                    result = null;
                }
            }
        }
        if (result != null) {
            this.loginClient.d(result);
        } else {
            this.loginClient.k();
        }
        return true;
    }

    public p(Parcel parcel) {
        super(parcel);
    }
}
