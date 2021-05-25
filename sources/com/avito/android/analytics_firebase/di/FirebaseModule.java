package com.avito.android.analytics_firebase.di;

import com.avito.android.analytics.EventObserver;
import com.avito.android.analytics_firebase.Firebase;
import com.avito.android.analytics_firebase.FirebaseEventObserver;
import com.avito.android.analytics_firebase.FirebaseEventTracker;
import com.avito.android.analytics_firebase.FirebaseEventTrackerImpl;
import com.avito.android.analytics_firebase.FirebaseImpl;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH!¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH!¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics_firebase/di/FirebaseModule;", "", "Lcom/avito/android/analytics_firebase/FirebaseImpl;", "firebase", "Lcom/avito/android/analytics_firebase/Firebase;", "bindFirebase$analytics_firebase_release", "(Lcom/avito/android/analytics_firebase/FirebaseImpl;)Lcom/avito/android/analytics_firebase/Firebase;", "bindFirebase", "Lcom/avito/android/analytics_firebase/FirebaseEventTrackerImpl;", "firebaseEventTracker", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "bindFirebaseEventTracker$analytics_firebase_release", "(Lcom/avito/android/analytics_firebase/FirebaseEventTrackerImpl;)Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "bindFirebaseEventTracker", "Lcom/avito/android/analytics_firebase/FirebaseEventObserver;", "firebaseEventObserver", "Lcom/avito/android/analytics/EventObserver;", "bindFirebaseEventObserver$analytics_firebase_release", "(Lcom/avito/android/analytics_firebase/FirebaseEventObserver;)Lcom/avito/android/analytics/EventObserver;", "bindFirebaseEventObserver", "<init>", "()V", "analytics-firebase_release"}, k = 1, mv = {1, 4, 2})
@Module
public abstract class FirebaseModule {
    @Singleton
    @Binds
    @NotNull
    public abstract Firebase bindFirebase$analytics_firebase_release(@NotNull FirebaseImpl firebaseImpl);

    @Binds
    @IntoSet
    @NotNull
    @Singleton
    public abstract EventObserver bindFirebaseEventObserver$analytics_firebase_release(@NotNull FirebaseEventObserver firebaseEventObserver);

    @Singleton
    @Binds
    @NotNull
    public abstract FirebaseEventTracker bindFirebaseEventTracker$analytics_firebase_release(@NotNull FirebaseEventTrackerImpl firebaseEventTrackerImpl);
}
