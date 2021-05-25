package com.facebook;

import a2.g.e;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    public static volatile ProfileManager d;
    public final LocalBroadcastManager a;
    public final e b;
    public Profile c;

    public ProfileManager(LocalBroadcastManager localBroadcastManager, e eVar) {
        Validate.notNull(localBroadcastManager, "localBroadcastManager");
        Validate.notNull(eVar, "profileCache");
        this.a = localBroadcastManager;
        this.b = eVar;
    }

    public static ProfileManager a() {
        if (d == null) {
            synchronized (ProfileManager.class) {
                if (d == null) {
                    d = new ProfileManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new e());
                }
            }
        }
        return d;
    }

    public final void b(@Nullable Profile profile, boolean z) {
        Profile profile2 = this.c;
        this.c = profile;
        if (z) {
            if (profile != null) {
                e eVar = this.b;
                Objects.requireNonNull(eVar);
                Validate.notNull(profile, "profile");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", profile.a);
                    jSONObject.put("first_name", profile.b);
                    jSONObject.put("middle_name", profile.c);
                    jSONObject.put("last_name", profile.d);
                    jSONObject.put("name", profile.e);
                    Uri uri = profile.f;
                    if (uri != null) {
                        jSONObject.put("link_uri", uri.toString());
                    }
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    eVar.a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
                }
            } else {
                this.b.a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
            intent.putExtra(EXTRA_OLD_PROFILE, profile2);
            intent.putExtra(EXTRA_NEW_PROFILE, profile);
            this.a.sendBroadcast(intent);
        }
    }
}
