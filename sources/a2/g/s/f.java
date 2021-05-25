package a2.g.s;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;
public class f extends p {
    public static final Parcelable.Creator<f> CREATOR = new a();

    public static class a implements Parcelable.Creator<f> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public f(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public String b() {
        return "fb_lite_login";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a2.g.s.n
    public int f(LoginClient.Request request) {
        String g = LoginClient.g();
        Intent createFacebookLiteIntent = NativeProtocol.createFacebookLiteIntent(this.loginClient.e(), request.d, request.b, g, request.f, request.a(), request.c, getClientState(request.e), request.h);
        addLoggingExtra("e2e", g);
        int i = LoginClient.i();
        if (createFacebookLiteIntent != null) {
            try {
                this.loginClient.c.startActivityForResult(createFacebookLiteIntent, i);
                return 1;
            } catch (ActivityNotFoundException unused) {
            }
        }
        return 0;
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public f(Parcel parcel) {
        super(parcel);
    }
}
