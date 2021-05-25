package a2.g;

import android.content.SharedPreferences;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Validate;
import java.util.Objects;
import org.json.JSONException;
public class a {
    public final SharedPreferences a;
    public final C0024a b;
    public d c;

    /* renamed from: a2.g.a$a  reason: collision with other inner class name */
    public static class C0024a {
    }

    public a() {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0);
        C0024a aVar = new C0024a();
        this.a = sharedPreferences;
        this.b = aVar;
    }

    public final d a() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    Objects.requireNonNull(this.b);
                    this.c = new d(FacebookSdk.getApplicationContext());
                }
            }
        }
        return this.c;
    }

    public void b(AccessToken accessToken) {
        Validate.notNull(accessToken, SDKConstants.PARAM_ACCESS_TOKEN);
        try {
            this.a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.d().toString()).apply();
        } catch (JSONException unused) {
        }
    }
}
