package com.facebook.login;

import a2.g.s.r;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;
public class CustomTabLoginMethodHandler extends r {
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new a();
    public static boolean calledThroughLoggedOutAppSwitch = false;
    public String c;
    public String d;
    public String e;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    }

    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.e = "";
        this.d = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        this.e = CustomTabUtils.getValidRedirectURI(super.getRedirectUrl());
    }

    @Override // a2.g.s.n
    public String b() {
        return "custom_tab";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3  */
    @Override // a2.g.s.n
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000c
            java.lang.String r1 = com.facebook.CustomTabMainActivity.NO_ACTIVITY_EXCEPTION
            boolean r1 = r9.getBooleanExtra(r1, r0)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 1
            if (r7 == r1) goto L_0x0010
            return r0
        L_0x0010:
            com.facebook.login.LoginClient r7 = r6.loginClient
            com.facebook.login.LoginClient$Request r7 = r7.g
            r2 = 0
            r3 = -1
            if (r8 != r3) goto L_0x00f1
            java.lang.String r8 = com.facebook.CustomTabMainActivity.EXTRA_URL
            java.lang.String r8 = r9.getStringExtra(r8)
            if (r8 == 0) goto L_0x00f0
            java.lang.String r9 = "fbconnect://cct."
            boolean r9 = r8.startsWith(r9)
            if (r9 != 0) goto L_0x0032
            java.lang.String r9 = super.getRedirectUrl()
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x00f0
        L_0x0032:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            java.lang.String r9 = r8.getQuery()
            android.os.Bundle r9 = com.facebook.internal.Utility.parseUrlQueryString(r9)
            java.lang.String r8 = r8.getFragment()
            android.os.Bundle r8 = com.facebook.internal.Utility.parseUrlQueryString(r8)
            r9.putAll(r8)
            java.lang.String r8 = "state"
            java.lang.String r8 = r9.getString(r8)     // Catch:{ JSONException -> 0x0064 }
            if (r8 != 0) goto L_0x0052
            goto L_0x0065
        L_0x0052:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
            r4.<init>(r8)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r8 = "7_challenge"
            java.lang.String r8 = r4.getString(r8)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r4 = r6.d     // Catch:{ JSONException -> 0x0064 }
            boolean r0 = r8.equals(r4)     // Catch:{ JSONException -> 0x0064 }
            goto L_0x0065
        L_0x0064:
        L_0x0065:
            if (r0 != 0) goto L_0x0073
            com.facebook.FacebookException r8 = new com.facebook.FacebookException
            java.lang.String r9 = "Invalid state parameter"
            r8.<init>(r9)
            super.onComplete(r7, r2, r8)
            goto L_0x00f0
        L_0x0073:
            java.lang.String r8 = "error"
            java.lang.String r8 = r9.getString(r8)
            if (r8 != 0) goto L_0x0081
            java.lang.String r8 = "error_type"
            java.lang.String r8 = r9.getString(r8)
        L_0x0081:
            java.lang.String r0 = "error_msg"
            java.lang.String r0 = r9.getString(r0)
            if (r0 != 0) goto L_0x008f
            java.lang.String r0 = "error_message"
            java.lang.String r0 = r9.getString(r0)
        L_0x008f:
            if (r0 != 0) goto L_0x0097
            java.lang.String r0 = "error_description"
            java.lang.String r0 = r9.getString(r0)
        L_0x0097:
            java.lang.String r4 = "error_code"
            java.lang.String r4 = r9.getString(r4)
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r4)
            if (r5 != 0) goto L_0x00a8
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x00a8 }
            goto L_0x00a9
        L_0x00a8:
            r4 = -1
        L_0x00a9:
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r8)
            if (r5 == 0) goto L_0x00bb
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r0)
            if (r5 == 0) goto L_0x00bb
            if (r4 != r3) goto L_0x00bb
            super.onComplete(r7, r9, r2)
            goto L_0x00f0
        L_0x00bb:
            if (r8 == 0) goto L_0x00d6
            java.lang.String r9 = "access_denied"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x00cd
            java.lang.String r9 = "OAuthAccessDeniedException"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x00d6
        L_0x00cd:
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            goto L_0x00f0
        L_0x00d6:
            r9 = 4201(0x1069, float:5.887E-42)
            if (r4 != r9) goto L_0x00e3
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            goto L_0x00f0
        L_0x00e3:
            com.facebook.FacebookRequestError r9 = new com.facebook.FacebookRequestError
            r9.<init>(r4, r8, r0)
            com.facebook.FacebookServiceException r8 = new com.facebook.FacebookServiceException
            r8.<init>(r9, r0)
            super.onComplete(r7, r2, r8)
        L_0x00f0:
            return r1
        L_0x00f1:
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.e(int, int, android.content.Intent):boolean");
    }

    @Override // a2.g.s.n
    public int f(LoginClient.Request request) {
        if (getRedirectUrl().isEmpty()) {
            return 0;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            addExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, "1");
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            CustomTabPrefetchHelper.mayLaunchUrl(CustomTab.getURIForAction("oauth", addExtraParameters));
        }
        Intent intent = new Intent(this.loginClient.e(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "oauth");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        String str = CustomTabMainActivity.EXTRA_CHROME_PACKAGE;
        String str2 = this.c;
        if (str2 == null) {
            str2 = CustomTabUtils.getChromePackage();
            this.c = str2;
        }
        intent.putExtra(str, str2);
        this.loginClient.c.startActivityForResult(intent, 1);
        return 1;
    }

    @Override // a2.g.s.r
    public AccessTokenSource g() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    @Override // a2.g.s.r
    public String getRedirectUrl() {
        return this.e;
    }

    @Override // a2.g.s.r
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    @Override // a2.g.s.n
    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.d);
    }

    @Override // a2.g.s.n
    public /* bridge */ /* synthetic */ boolean shouldKeepTrackOfMultipleIntents() {
        return super.shouldKeepTrackOfMultipleIntents();
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.d);
    }

    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e = "";
        this.d = parcel.readString();
    }
}
