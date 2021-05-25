package com.avito.android.in_app_calls.service;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.avito.android.in_app_calls.util.TelephonyKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/service/SystemCallStateProviderImpl;", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "", "isIdle", "()Z", "isOffHook", "Lio/reactivex/Observable;", "offHookStateChanges", "()Lio/reactivex/Observable;", "Landroid/telephony/TelephonyManager;", AuthSource.SEND_ABUSE, "Landroid/telephony/TelephonyManager;", "telephonyManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class SystemCallStateProviderImpl implements SystemCallStateProvider {
    public final TelephonyManager a;

    public static final class a<T, R> implements Function<Integer, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Integer num) {
            Integer num2 = num;
            Intrinsics.checkNotNullParameter(num2, "it");
            return Boolean.valueOf(num2.intValue() == 2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, Boolean> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.debug("SystemCallStateProvider", "Failed to check system call state", th2);
            return Boolean.FALSE;
        }
    }

    @Inject
    public SystemCallStateProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.a = (TelephonyManager) systemService;
    }

    @Override // com.avito.android.in_app_calls.service.SystemCallStateProvider
    public boolean isIdle() {
        try {
            return this.a.getCallState() == 0;
        } catch (Exception e) {
            Logs.debug("SystemCallStateProvider", "Failed to check system call state", e);
            return true;
        }
    }

    @Override // com.avito.android.in_app_calls.service.SystemCallStateProvider
    public boolean isOffHook() {
        try {
            return this.a.getCallState() == 2;
        } catch (Exception e) {
            Logs.debug("SystemCallStateProvider", "Failed to check system call state", e);
            return false;
        }
    }

    @Override // com.avito.android.in_app_calls.service.SystemCallStateProvider
    @NotNull
    public Observable<Boolean> offHookStateChanges() {
        Observable<R> onErrorReturn = TelephonyKt.callStateChanges(this.a).map(a.a).onErrorReturn(b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "telephonyManager.callSta…          false\n        }");
        return onErrorReturn;
    }
}
