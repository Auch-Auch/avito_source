package a2.g.s;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginFragment;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class h extends n {
    public static final Parcelable.Creator<h> CREATOR = new b();
    public g b;

    public class a implements PlatformServiceClient.CompletedListener {
        public final /* synthetic */ LoginClient.Request a;

        public a(LoginClient.Request request) {
            this.a = request;
        }

        @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
        public void completed(Bundle bundle) {
            h hVar = h.this;
            LoginClient.Request request = this.a;
            g gVar = hVar.b;
            if (gVar != null) {
                gVar.setCompletedListener(null);
            }
            hVar.b = null;
            LoginClient.b bVar = hVar.loginClient.e;
            if (bVar != null) {
                ((LoginFragment.b) bVar).a.setVisibility(8);
            }
            if (bundle != null) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                Set<String> set = request.b;
                if (stringArrayList == null || (set != null && !stringArrayList.containsAll(set))) {
                    HashSet hashSet = new HashSet();
                    for (String str : set) {
                        if (!stringArrayList.contains(str)) {
                            hashSet.add(str);
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        hVar.addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
                    }
                    Validate.notNull(hashSet, "permissions");
                    request.b = hashSet;
                } else {
                    String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
                    if (string == null || string.isEmpty()) {
                        LoginClient.b bVar2 = hVar.loginClient.e;
                        if (bVar2 != null) {
                            ((LoginFragment.b) bVar2).a.setVisibility(0);
                        }
                        Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new i(hVar, bundle, request));
                        return;
                    }
                    hVar.g(request, bundle);
                    return;
                }
            }
            hVar.loginClient.k();
        }
    }

    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new h[i];
        }
    }

    public h(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public void a() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.cancel();
            this.b.setCompletedListener(null);
            this.b = null;
        }
    }

    @Override // a2.g.s.n
    public String b() {
        return "get_token";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a2.g.s.n
    public int f(LoginClient.Request request) {
        g gVar = new g(this.loginClient.e(), request.d);
        this.b = gVar;
        if (!gVar.start()) {
            return 0;
        }
        LoginClient.b bVar = this.loginClient.e;
        if (bVar != null) {
            ((LoginFragment.b) bVar).a.setVisibility(0);
        }
        this.b.setCompletedListener(new a(request));
        return 1;
    }

    public void g(LoginClient.Request request, Bundle bundle) {
        AccessToken accessToken;
        AccessTokenSource accessTokenSource = AccessTokenSource.FACEBOOK_APPLICATION_SERVICE;
        String str = request.d;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string)) {
            accessToken = null;
        } else {
            accessToken = new AccessToken(string, str, bundle.getString(NativeProtocol.EXTRA_USER_ID), stringArrayList, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN));
        }
        this.loginClient.d(LoginClient.Result.d(this.loginClient.g, accessToken));
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public h(Parcel parcel) {
        super(parcel);
    }
}
