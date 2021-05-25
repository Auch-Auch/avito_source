package a2.g;

import android.content.SharedPreferences;
import com.facebook.AccessTokenManager;
import com.facebook.FacebookSdk;
public final class e {
    public final SharedPreferences a = FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0);
}
