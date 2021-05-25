package com.facebook.login;

import a2.g.s.k;
import a2.g.s.n;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new a();
    public n[] a;
    public int b;
    public Fragment c;
    public OnCompletedListener d;
    public b e;
    public boolean f;
    public Request g;
    public Map<String, String> h;
    public Map<String, String> i;
    public k j;
    public int k;
    public int l;

    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    public static class a implements Parcelable.Creator<LoginClient> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    }

    public interface b {
    }

    public LoginClient(Fragment fragment) {
        this.b = -1;
        this.k = 0;
        this.l = 0;
        this.c = fragment;
    }

    public static String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static int i() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    public final void a(String str, String str2, boolean z) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.h.containsKey(str) && z) {
            str2 = a2.b.a.a.a.u(new StringBuilder(), this.h.get(str), ",", str2);
        }
        this.h.put(str, str2);
    }

    public boolean b() {
        if (this.f) {
            return true;
        }
        if (e().checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            FragmentActivity e2 = e();
            c(Result.b(this.g, e2.getString(R.string.com_facebook_internet_permission_error_title), e2.getString(R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f = true;
        return true;
    }

    public void c(Result result) {
        n f2 = f();
        if (f2 != null) {
            j(f2.b(), result.a.a, result.c, result.d, f2.a);
        }
        Map<String, String> map = this.h;
        if (map != null) {
            result.loggingExtras = map;
        }
        Map<String, String> map2 = this.i;
        if (map2 != null) {
            result.extraData = map2;
        }
        this.a = null;
        this.b = -1;
        this.g = null;
        this.h = null;
        this.k = 0;
        this.l = 0;
        OnCompletedListener onCompletedListener = this.d;
        if (onCompletedListener != null) {
            onCompletedListener.onCompleted(result);
        }
    }

    public void d(Result result) {
        Result result2;
        if (result.b == null || !AccessToken.isCurrentAccessTokenActive()) {
            c(result);
        } else if (result.b != null) {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            AccessToken accessToken = result.b;
            if (!(currentAccessToken == null || accessToken == null)) {
                try {
                    if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                        result2 = Result.d(this.g, result.b);
                        c(result2);
                    }
                } catch (Exception e2) {
                    c(Result.b(this.g, "Caught exception", e2.getMessage()));
                    return;
                }
            }
            result2 = Result.b(this.g, "User logged in as different Facebook user.", null);
            c(result2);
        } else {
            throw new FacebookException("Can't validate without a token");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentActivity e() {
        return this.c.getActivity();
    }

    public n f() {
        int i2 = this.b;
        if (i2 >= 0) {
            return this.a[i2];
        }
        return null;
    }

    public final k h() {
        k kVar = this.j;
        if (kVar == null || !kVar.b.equals(this.g.d)) {
            this.j = new k(e(), this.g.d);
        }
        return this.j;
    }

    public final void j(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.g == null) {
            h().b("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            return;
        }
        k h2 = h();
        String str5 = this.g.e;
        Objects.requireNonNull(h2);
        Bundle c2 = k.c(str5);
        if (str2 != null) {
            c2.putString("2_result", str2);
        }
        if (str3 != null) {
            c2.putString("5_error_message", str3);
        }
        if (str4 != null) {
            c2.putString("4_error_code", str4);
        }
        if (map != null && !map.isEmpty()) {
            c2.putString("6_extras", new JSONObject(map).toString());
        }
        c2.putString("3_method", str);
        h2.a.logEventImplicitly("fb_mobile_login_method_complete", c2);
    }

    public void k() {
        boolean z;
        if (this.b >= 0) {
            j(f().b(), "skipped", null, null, f().a);
        }
        do {
            n[] nVarArr = this.a;
            if (nVarArr != null) {
                int i2 = this.b;
                boolean z2 = true;
                if (i2 < nVarArr.length - 1) {
                    this.b = i2 + 1;
                    n f2 = f();
                    z = false;
                    if (!f2.d() || b()) {
                        int f3 = f2.f(this.g);
                        this.k = 0;
                        if (f3 > 0) {
                            k h2 = h();
                            String str = this.g.e;
                            String b2 = f2.b();
                            Objects.requireNonNull(h2);
                            Bundle c2 = k.c(str);
                            c2.putString("3_method", b2);
                            h2.a.logEventImplicitly("fb_mobile_login_method_start", c2);
                            this.l = f3;
                        } else {
                            k h3 = h();
                            String str2 = this.g.e;
                            String b3 = f2.b();
                            Objects.requireNonNull(h3);
                            Bundle c3 = k.c(str2);
                            c3.putString("3_method", b3);
                            h3.a.logEventImplicitly("fb_mobile_login_method_not_tried", c3);
                            a("not_tried", f2.b(), true);
                        }
                        if (f3 <= 0) {
                            z2 = false;
                        }
                        z = z2;
                        continue;
                    } else {
                        a("no_internet_permission", "1", false);
                        continue;
                    }
                }
            }
            Request request = this.g;
            if (request != null) {
                c(Result.b(request, "Login attempt failed.", null));
                return;
            }
            return;
        } while (!z);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelableArray(this.a, i2);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.g, i2);
        Utility.writeStringMapToParcel(parcel, this.h);
        Utility.writeStringMapToParcel(parcel, this.i);
    }

    public LoginClient(Parcel parcel) {
        this.b = -1;
        this.k = 0;
        this.l = 0;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(n.class.getClassLoader());
        this.a = new n[readParcelableArray.length];
        for (int i2 = 0; i2 < readParcelableArray.length; i2++) {
            n[] nVarArr = this.a;
            nVarArr[i2] = (n) readParcelableArray[i2];
            n nVar = nVarArr[i2];
            if (nVar.loginClient == null) {
                nVar.loginClient = this;
            } else {
                throw new FacebookException("Can't set LoginClient if it is already set.");
            }
        }
        this.b = parcel.readInt();
        this.g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.h = Utility.readStringMapFromParcel(parcel);
        this.i = Utility.readStringMapFromParcel(parcel);
    }

    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new a();
        public final b a;
        public final AccessToken b;
        public final String c;
        public final String d;
        public final Request e;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;

        public static class a implements Parcelable.Creator<Result> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public enum b {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            public final String a;

            /* access modifiers changed from: public */
            b(String str) {
                this.a = str;
            }
        }

        public Result(Request request, b bVar, AccessToken accessToken, String str, String str2) {
            Validate.notNull(bVar, "code");
            this.e = request;
            this.b = accessToken;
            this.c = str;
            this.a = bVar;
            this.d = str2;
        }

        public static Result a(Request request, String str) {
            return new Result(request, b.CANCEL, null, str, null);
        }

        public static Result b(Request request, String str, String str2) {
            return c(request, str, str2, null);
        }

        public static Result c(Request request, String str, String str2, String str3) {
            return new Result(request, b.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(str, str2)), str3);
        }

        public static Result d(Request request, AccessToken accessToken) {
            return new Result(request, b.SUCCESS, accessToken, null, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a.name());
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeParcelable(this.e, i);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeStringMapToParcel(parcel, this.extraData);
        }

        public Result(Parcel parcel, a aVar) {
            this.a = b.valueOf(parcel.readString());
            this.b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
            this.extraData = Utility.readStringMapFromParcel(parcel);
        }
    }

    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new a();
        public final LoginBehavior a;
        public Set<String> b;
        public final DefaultAudience c;
        public final String d;
        public final String e;
        public boolean f = false;
        public String g;
        public String h;
        public String i;

        public static class a implements Parcelable.Creator<Request> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Request[] newArray(int i) {
                return new Request[i];
            }
        }

        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2, String str3) {
            this.a = loginBehavior;
            this.b = set == null ? new HashSet<>() : set;
            this.c = defaultAudience;
            this.h = str;
            this.d = str2;
            this.e = str3;
        }

        public boolean a() {
            for (String str : this.b) {
                if (LoginManager.b(str)) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            LoginBehavior loginBehavior = this.a;
            String str = null;
            parcel.writeString(loginBehavior != null ? loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.b));
            DefaultAudience defaultAudience = this.c;
            if (defaultAudience != null) {
                str = defaultAudience.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeByte(this.f ? (byte) 1 : 0);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
        }

        public Request(Parcel parcel, a aVar) {
            boolean z = false;
            String readString = parcel.readString();
            DefaultAudience defaultAudience = null;
            this.a = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.b = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.c = readString2 != null ? DefaultAudience.valueOf(readString2) : defaultAudience;
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readByte() != 0 ? true : z;
            this.g = parcel.readString();
            this.h = parcel.readString();
            this.i = parcel.readString();
        }
    }
}
