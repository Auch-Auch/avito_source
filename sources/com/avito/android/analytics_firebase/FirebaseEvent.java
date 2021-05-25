package com.avito.android.analytics_firebase;

import com.avito.android.analytics.Event;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics_firebase/FirebaseEvent;", "Lcom/avito/android/analytics/Event;", "Lcom/avito/android/analytics_firebase/FirebaseEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics_firebase/FirebaseEventTracker;)V", "", "", "", "getFirebaseEventParams", "()Ljava/util/Map;", "firebaseEventParams", "getName", "()Ljava/lang/String;", "name", "analytics-firebase_release"}, k = 1, mv = {1, 4, 2})
public interface FirebaseEvent extends Event {
    void accept(@NotNull FirebaseEventTracker firebaseEventTracker);

    @Nullable
    Map<String, Object> getFirebaseEventParams();

    @NotNull
    String getName();
}
