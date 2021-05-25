package a2.g.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginClient;
public class s extends r {
    public static final Parcelable.Creator<s> CREATOR = new b();
    public WebDialog c;
    public String d;

    public class a implements WebDialog.OnCompleteListener {
        public final /* synthetic */ LoginClient.Request a;

        public a(LoginClient.Request request) {
            this.a = request;
        }

        @Override // com.facebook.internal.WebDialog.OnCompleteListener
        public void onComplete(Bundle bundle, FacebookException facebookException) {
            s.this.h(this.a, bundle, facebookException);
        }
    }

    public static class b implements Parcelable.Creator<s> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public s createFromParcel(Parcel parcel) {
            return new s(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public s[] newArray(int i) {
            return new s[i];
        }
    }

    public static class c extends WebDialog.Builder {
        public String h;
        public String i;
        public String j = ServerProtocol.DIALOG_REDIRECT_URI;
        public LoginBehavior k = LoginBehavior.NATIVE_WITH_FALLBACK;

        public c(Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString("redirect_uri", this.j);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.h);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString("auth_type", this.i);
            parameters.putString(ServerProtocol.DIALOG_PARAM_LOGIN_BEHAVIOR, this.k.name());
            return WebDialog.newInstance(getContext(), "oauth", parameters, getTheme(), getListener());
        }
    }

    public s(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // a2.g.s.n
    public void a() {
        WebDialog webDialog = this.c;
        if (webDialog != null) {
            webDialog.cancel();
            this.c = null;
        }
    }

    @Override // a2.g.s.n
    public String b() {
        return "web_view";
    }

    @Override // a2.g.s.n
    public boolean d() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a2.g.s.n
    public int f(LoginClient.Request request) {
        Bundle parameters = getParameters(request);
        a aVar = new a(request);
        String g = LoginClient.g();
        this.d = g;
        addLoggingExtra("e2e", g);
        FragmentActivity e = this.loginClient.e();
        boolean isChromeOS = Utility.isChromeOS(e);
        c cVar = new c(e, request.d, parameters);
        cVar.h = this.d;
        cVar.j = isChromeOS ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
        cVar.i = request.h;
        cVar.k = request.a;
        this.c = cVar.setOnCompleteListener(aVar).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.c);
        facebookDialogFragment.show(e.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return 1;
    }

    @Override // a2.g.s.r
    public AccessTokenSource g() {
        return AccessTokenSource.WEB_VIEW;
    }

    public void h(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    @Override // a2.g.s.n, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.d);
    }

    public s(Parcel parcel) {
        super(parcel);
        this.d = parcel.readString();
    }
}
