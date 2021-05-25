package com.avito.android.calls_shared;

import androidx.annotation.GuardedBy;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u001e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/calls_shared/CallUuidProviderImpl;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "", "Lcom/avito/android/calls_shared/CallId;", "nextCallUuid", "()Ljava/lang/String;", "Lcom/avito/android/util/RandomKeyProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/RandomKeyProvider;", "generator", "getCurrentCallUuid", "currentCallUuid", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "callUuid", "Ljava/util/Locale;", "c", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/util/RandomKeyProvider;Ljava/util/Locale;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallUuidProviderImpl implements CallUuidProvider {
    @GuardedBy("this")
    public volatile String a;
    public final RandomKeyProvider b;
    public final Locale c;

    @Inject
    public CallUuidProviderImpl(@NotNull RandomKeyProvider randomKeyProvider, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(randomKeyProvider, "generator");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.b = randomKeyProvider;
        this.c = locale;
    }

    @Override // com.avito.android.calls_shared.CallUuidProvider
    @NotNull
    public String getCurrentCallUuid() {
        String str = this.a;
        if (str == null) {
            synchronized (this) {
                str = this.a;
                if (str == null) {
                    str = nextCallUuid();
                }
            }
        }
        return str;
    }

    @Override // com.avito.android.calls_shared.CallUuidProvider
    @NotNull
    public String nextCallUuid() {
        String lowerCase;
        synchronized (this) {
            String generateKey = this.b.generateKey();
            Locale locale = this.c;
            if (generateKey != null) {
                lowerCase = generateKey.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                this.a = lowerCase;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return lowerCase;
    }
}
