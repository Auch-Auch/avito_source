package a2.g.s.t;

import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.login.widget.LoginButton;
import java.util.Objects;
public class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ LoginButton b;

    /* renamed from: a2.g.s.t.a$a  reason: collision with other inner class name */
    public class RunnableC0028a implements Runnable {
        public final /* synthetic */ FetchedAppSettings a;

        public RunnableC0028a(FetchedAppSettings fetchedAppSettings) {
            this.a = fetchedAppSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoginButton loginButton = a.this.b;
            FetchedAppSettings fetchedAppSettings = this.a;
            int i = LoginButton.v;
            Objects.requireNonNull(loginButton);
            if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && loginButton.getVisibility() == 0) {
                loginButton.a(fetchedAppSettings.getNuxContent());
            }
        }
    }

    public a(LoginButton loginButton, String str) {
        this.b = loginButton;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(this.a, false);
        LoginButton loginButton = this.b;
        int i = LoginButton.v;
        loginButton.getActivity().runOnUiThread(new RunnableC0028a(queryAppSettings));
    }
}
