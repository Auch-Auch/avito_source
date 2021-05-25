package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.analytics.provider.crashlytics_initialization.FirebaseCrashlyticsInitialization;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Initializable;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0007J\"\u0010\u0019\u001a\u00020\u00052\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsImpl;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "Lcom/avito/android/util/Initializable;", "", "message", "", "log", "(Ljava/lang/String;)V", "", "cause", "trackException", "(Ljava/lang/Throwable;)V", "key", "", "value", "setInt", "(Ljava/lang/String;I)V", "setString", "(Ljava/lang/String;Ljava/lang/String;)V", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "identifier", "setUserIdentifier", "Lkotlin/Function0;", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "", "isInitialized", "()Z", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "()Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "firebaseCrashlytics", "", "Ljava/util/Map;", Navigation.ATTRIBUTES, "Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;", "initialization", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics_initialization/FirebaseCrashlyticsInitialization;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class FirebaseCrashlyticsImpl implements FirebaseCrashlytics, Initializable {
    public final Map<String, String> a = new ConcurrentHashMap();
    public final Lazy b = c.lazy(LazyThreadSafetyMode.NONE, (Function0) a.a);
    public final /* synthetic */ FirebaseCrashlyticsInitialization c;

    public static final class a extends Lambda implements Function0<FirebaseCrashlytics> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public FirebaseCrashlytics invoke() {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "FirebaseCrashlyticsThirdApp.getInstance()");
            return instance;
        }
    }

    @Inject
    public FirebaseCrashlyticsImpl(@NotNull FirebaseCrashlyticsInitialization firebaseCrashlyticsInitialization) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsInitialization, "initialization");
        this.c = firebaseCrashlyticsInitialization;
    }

    public final FirebaseCrashlytics a() {
        return (FirebaseCrashlytics) this.b.getValue();
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.get(str);
    }

    @Override // com.avito.android.util.Initializable
    public void initialize(@Nullable Function0<Unit> function0) {
        this.c.initialize(function0);
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return this.c.isInitialized();
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void log(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        a().log(str);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        a().setCustomKey(str, i);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        a().setCustomKey(str, str2);
        this.a.put(str, str2);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setUserIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        a().setUserId(str);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void trackException(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "cause");
        a().recordException(th);
    }
}
