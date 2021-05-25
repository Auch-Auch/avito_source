package com.avito.android.in_app_calls.analytics;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "", "", AuthSource.SEND_ABUSE, "I", "getRatingValue", "()I", "ratingValue", "Bad", "Good", "Neutral", "Lcom/avito/android/in_app_calls/analytics/AppCallRating$Bad;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating$Neutral;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating$Good;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class AppCallRating {
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/AppCallRating$Bad;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Bad extends AppCallRating {
        @NotNull
        public static final Bad INSTANCE = new Bad();

        public Bad() {
            super(0, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/AppCallRating$Good;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Good extends AppCallRating {
        @NotNull
        public static final Good INSTANCE = new Good();

        public Good() {
            super(2, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/AppCallRating$Neutral;", "Lcom/avito/android/in_app_calls/analytics/AppCallRating;", "<init>", "()V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Neutral extends AppCallRating {
        @NotNull
        public static final Neutral INSTANCE = new Neutral();

        public Neutral() {
            super(1, null);
        }
    }

    public AppCallRating(int i, j jVar) {
        this.a = i;
    }

    public final int getRatingValue() {
        return this.a;
    }
}
