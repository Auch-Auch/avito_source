package com.avito.android.analytics_firebase;

import android.content.Context;
import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics_firebase/FirebaseImpl;", "Lcom/avito/android/analytics_firebase/Firebase;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "event", "trackEvent", "(Lcom/avito/android/analytics_firebase/FirebaseEvent;)V", AuthSource.SEND_ABUSE, "Z", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "analytics-firebase_release"}, k = 1, mv = {1, 4, 2})
public final class FirebaseImpl implements Firebase {
    public volatile boolean a;
    public final Context b;

    @Inject
    public FirebaseImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
    }

    @Override // com.avito.android.util.Initializable
    public synchronized void initialize(@Nullable Function0<Unit> function0) {
        if (!this.a) {
            FirebaseAnalytics.getInstance(this.b);
            Logs.verbose$default("FirebaseWrapper", "Firebase analytics initialized", null, 4, null);
            this.a = true;
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a;
    }

    @Override // com.avito.android.analytics_firebase.Firebase
    public void trackEvent(@NotNull FirebaseEvent firebaseEvent) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(firebaseEvent, "event");
        String name = firebaseEvent.getName();
        Map<String, Object> firebaseEventParams = firebaseEvent.getFirebaseEventParams();
        if (firebaseEventParams != null) {
            bundle = new Bundle(firebaseEventParams.size());
            for (Map.Entry<String, Object> entry : firebaseEventParams.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    bundle.putString(entry.getKey(), (String) value);
                } else if (value instanceof Double) {
                    bundle.putDouble(entry.getKey(), ((Number) value).doubleValue());
                }
            }
        } else {
            bundle = null;
        }
        FirebaseAnalytics.getInstance(this.b).logEvent(name, bundle);
        Logs.verbose$default("FirebaseWrapper", "Track event: " + name + ", " + bundle, null, 4, null);
    }
}
