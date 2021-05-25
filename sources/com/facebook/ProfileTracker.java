package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Validate;
public abstract class ProfileTracker {
    public final BroadcastReceiver a;
    public final LocalBroadcastManager b;
    public boolean c = false;

    public class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ProfileManager.ACTION_CURRENT_PROFILE_CHANGED.equals(intent.getAction())) {
                ProfileTracker.this.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    public ProfileTracker() {
        Validate.sdkInitialized();
        this.a = new b(null);
        this.b = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        startTracking();
    }

    public boolean isTracking() {
        return this.c;
    }

    public abstract void onCurrentProfileChanged(Profile profile, Profile profile2);

    public void startTracking() {
        if (!this.c) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
            this.b.registerReceiver(this.a, intentFilter);
            this.c = true;
        }
    }

    public void stopTracking() {
        if (this.c) {
            this.b.unregisterReceiver(this.a);
            this.c = false;
        }
    }
}
