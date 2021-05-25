package com.google.firebase.dynamiclinks;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;
public abstract class FirebaseDynamicLinks {
    @NonNull
    public static synchronized FirebaseDynamicLinks getInstance() {
        FirebaseDynamicLinks instance;
        synchronized (FirebaseDynamicLinks.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    @NonNull
    public abstract DynamicLink.Builder createDynamicLink();

    @NonNull
    public abstract Task<PendingDynamicLinkData> getDynamicLink(@NonNull Intent intent);

    @NonNull
    public abstract Task<PendingDynamicLinkData> getDynamicLink(@NonNull Uri uri);

    @NonNull
    public static synchronized FirebaseDynamicLinks getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseDynamicLinks firebaseDynamicLinks;
        synchronized (FirebaseDynamicLinks.class) {
            firebaseDynamicLinks = (FirebaseDynamicLinks) firebaseApp.get(FirebaseDynamicLinks.class);
        }
        return firebaseDynamicLinks;
    }
}
