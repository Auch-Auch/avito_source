package a2.g.s;

import a2.b.a.a.a;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
public class m implements PlatformServiceClient.CompletedListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ k b;
    public final /* synthetic */ LoginStatusCallback c;
    public final /* synthetic */ String d;

    public m(LoginManager loginManager, String str, k kVar, LoginStatusCallback loginStatusCallback, String str2) {
        this.a = str;
        this.b = kVar;
        this.c = loginStatusCallback;
        this.d = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
    public void completed(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                String str = this.a;
                k kVar = this.b;
                LoginStatusCallback loginStatusCallback = this.c;
                Set<String> set = LoginManager.e;
                FacebookException facebookException = new FacebookException(a.e3(string, ": ", string2));
                Objects.requireNonNull(kVar);
                Bundle c2 = k.c(str);
                c2.putString("2_result", "error");
                c2.putString("5_error_message", facebookException.toString());
                kVar.a.logEventImplicitly("fb_mobile_login_status_complete", c2);
                loginStatusCallback.onError(facebookException);
                return;
            }
            String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle.getString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN);
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            String str2 = null;
            if (!Utility.isNullOrEmpty(string4)) {
                str2 = n.c(string4);
            }
            if (Utility.isNullOrEmpty(string3) || stringArrayList == null || stringArrayList.isEmpty() || Utility.isNullOrEmpty(str2)) {
                this.b.a(this.a);
                this.c.onFailure();
                return;
            }
            AccessToken accessToken = new AccessToken(string3, this.d, str2, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
            k kVar2 = this.b;
            String str3 = this.a;
            Objects.requireNonNull(kVar2);
            Bundle c3 = k.c(str3);
            c3.putString("2_result", "success");
            kVar2.a.logEventImplicitly("fb_mobile_login_status_complete", c3);
            this.c.onCompleted(accessToken);
            return;
        }
        this.b.a(this.a);
        this.c.onFailure();
    }
}
