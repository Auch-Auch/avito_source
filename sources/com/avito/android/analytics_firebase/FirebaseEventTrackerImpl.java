package com.avito.android.analytics_firebase;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Initializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics_firebase/FirebaseEventTrackerImpl;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "Lcom/avito/android/util/Initializable;", "Lcom/avito/android/analytics_firebase/FirebaseEvent;", "event", "", "trackEvent", "(Lcom/avito/android/analytics_firebase/FirebaseEvent;)V", "Lkotlin/Function0;", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", "isInitialized", "()Z", "Lcom/avito/android/analytics_firebase/Firebase;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics_firebase/Firebase;", "firebase", "<init>", "(Lcom/avito/android/analytics_firebase/Firebase;)V", "analytics-firebase_release"}, k = 1, mv = {1, 4, 2})
public final class FirebaseEventTrackerImpl implements FirebaseEventTracker, Initializable {
    public final Firebase a;

    @Inject
    public FirebaseEventTrackerImpl(@NotNull Firebase firebase) {
        Intrinsics.checkNotNullParameter(firebase, "firebase");
        this.a = firebase;
    }

    @Override // com.avito.android.util.Initializable
    public void initialize(@Nullable Function0<Unit> function0) {
        this.a.initialize(function0);
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.a.isInitialized();
    }

    @Override // com.avito.android.analytics_firebase.FirebaseEventTracker
    public void trackEvent(@NotNull FirebaseEvent firebaseEvent) {
        Intrinsics.checkNotNullParameter(firebaseEvent, "event");
        this.a.trackEvent(firebaseEvent);
    }
}
