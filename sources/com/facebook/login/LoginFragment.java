package com.facebook.login;

import a2.g.s.e;
import a2.g.s.f;
import a2.g.s.h;
import a2.g.s.j;
import a2.g.s.n;
import a2.g.s.s;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
public class LoginFragment extends Fragment {
    public String a;
    public LoginClient b;
    public LoginClient.Request c;

    public class a implements LoginClient.OnCompletedListener {
        public a() {
        }

        @Override // com.facebook.login.LoginClient.OnCompletedListener
        public void onCompleted(LoginClient.Result result) {
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.c = null;
            int i = result.a == LoginClient.Result.b.CANCEL ? 0 : -1;
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.facebook.LoginFragment:Result", result);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            if (loginFragment.isAdded()) {
                loginFragment.getActivity().setResult(i, intent);
                loginFragment.getActivity().finish();
            }
        }
    }

    public class b implements LoginClient.b {
        public final /* synthetic */ View a;

        public b(LoginFragment loginFragment, View view) {
            this.a = view;
        }
    }

    public LoginClient createLoginClient() {
        return new LoginClient(this);
    }

    @LayoutRes
    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LoginClient loginClient = this.b;
        loginClient.k++;
        if (loginClient.g == null) {
            return;
        }
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            loginClient.k();
        } else if (!loginClient.f().shouldKeepTrackOfMultipleIntents() || intent != null || loginClient.k >= loginClient.l) {
            loginClient.f().e(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            LoginClient loginClient = (LoginClient) bundle.getParcelable("loginClient");
            this.b = loginClient;
            if (loginClient.c == null) {
                loginClient.c = this;
            } else {
                throw new FacebookException("Can't set fragment once it is already set.");
            }
        } else {
            this.b = createLoginClient();
        }
        this.b.d = new a();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                this.a = callingActivity.getPackageName();
            }
            Intent intent = activity.getIntent();
            if (intent != null && (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) != null) {
                this.c = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.b.e = new b(this, findViewById);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        LoginClient loginClient = this.b;
        if (loginClient.b >= 0) {
            loginClient.f().a();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.a == null) {
            getActivity().finish();
            return;
        }
        LoginClient loginClient = this.b;
        LoginClient.Request request = this.c;
        LoginClient.Request request2 = loginClient.g;
        if (!(request2 != null && loginClient.b >= 0) && request != null) {
            if (request2 != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            } else if (!AccessToken.isCurrentAccessTokenActive() || loginClient.b()) {
                loginClient.g = request;
                ArrayList arrayList = new ArrayList();
                LoginBehavior loginBehavior = request.a;
                if (loginBehavior.a) {
                    arrayList.add(new h(loginClient));
                }
                if (loginBehavior.b) {
                    arrayList.add(new j(loginClient));
                }
                if (loginBehavior.f) {
                    arrayList.add(new f(loginClient));
                }
                if (loginBehavior.e) {
                    arrayList.add(new CustomTabLoginMethodHandler(loginClient));
                }
                if (loginBehavior.c) {
                    arrayList.add(new s(loginClient));
                }
                if (loginBehavior.d) {
                    arrayList.add(new e(loginClient));
                }
                n[] nVarArr = new n[arrayList.size()];
                arrayList.toArray(nVarArr);
                loginClient.a = nVarArr;
                loginClient.k();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.b);
    }
}
