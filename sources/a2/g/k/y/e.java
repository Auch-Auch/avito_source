package a2.g.k.y;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.SourceApplicationInfo;
import java.util.Objects;
import java.util.UUID;
public class e {
    public Long a;
    public Long b;
    public int c;
    public Long d;
    public SourceApplicationInfo e;
    public UUID f;

    public e(Long l, Long l2) {
        UUID randomUUID = UUID.randomUUID();
        this.a = l;
        this.b = l2;
        this.f = randomUUID;
    }

    public void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.a.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.b.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.c);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.e;
        if (sourceApplicationInfo != null) {
            Objects.requireNonNull(sourceApplicationInfo);
            SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit2.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", sourceApplicationInfo.a);
            edit2.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", sourceApplicationInfo.b);
            edit2.apply();
        }
    }
}
