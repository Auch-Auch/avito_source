package com.avito.android.calls.voximplant.rx;

import a2.a.a.z.a.g.h;
import a2.a.a.z.a.g.i;
import a2.a.a.z.a.g.j;
import com.avito.android.calls.CallClientPushTokenRegistration;
import com.avito.android.calls.voximplant.rx.core.VoxPushTokenRegistrationManager;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/calls/voximplant/rx/VoxCallClientPushTokenRegistration;", "Lcom/avito/android/calls/CallClientPushTokenRegistration;", "Lio/reactivex/rxjava3/core/Completable;", "register", "()Lio/reactivex/rxjava3/core/Completable;", "unregister", "Lcom/avito/android/calls_shared/storage/CallStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "Lcom/avito/android/calls/voximplant/rx/core/VoxPushTokenRegistrationManager;", "c", "Lcom/avito/android/calls/voximplant/rx/core/VoxPushTokenRegistrationManager;", "voxPushTokenRegistrationManager", "Lcom/avito/android/push/provider/PushTokenProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "<init>", "(Lcom/avito/android/calls_shared/storage/CallStorage;Lcom/avito/android/push/provider/PushTokenProvider;Lcom/avito/android/calls/voximplant/rx/core/VoxPushTokenRegistrationManager;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallClientPushTokenRegistration implements CallClientPushTokenRegistration {
    public final CallStorage a;
    public final PushTokenProvider b;
    public final VoxPushTokenRegistrationManager c;

    public static final class a<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ VoxCallClientPushTokenRegistration a;

        public a(VoxCallClientPushTokenRegistration voxCallClientPushTokenRegistration) {
            this.a = voxCallClientPushTokenRegistration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            Logs.debug$default(LogTagsKt.TAG_IAC, "Register push token in vox", null, 4, null);
            String lastRegisteredPushToken = this.a.a.getLastRegisteredPushToken();
            Logs.debug$default(LogTagsKt.TAG_IAC, a2.b.a.a.a.e("Actual token=[", str2, "], last registered=[", lastRegisteredPushToken, ']'), null, 4, null);
            Intrinsics.checkNotNullExpressionValue(str2, "actualToken");
            if ((!m.isBlank(str2)) && (!Intrinsics.areEqual(str2, lastRegisteredPushToken))) {
                return this.a.c.register(str2).andThen(Completable.fromAction(new i(this, str2)));
            }
            Logs.debug$default(LogTagsKt.TAG_IAC, "Register push token: nothing to do", null, 4, null);
            return Completable.complete();
        }
    }

    public static final class b<V> implements Callable<String> {
        public final /* synthetic */ VoxCallClientPushTokenRegistration a;

        public b(VoxCallClientPushTokenRegistration voxCallClientPushTokenRegistration) {
            this.a = voxCallClientPushTokenRegistration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() {
            Logs.debug$default(LogTagsKt.TAG_IAC, "Unregister push token in vox", null, 4, null);
            return this.a.a.getLastRegisteredPushToken();
        }
    }

    public static final class c<T, R> implements Function<String, CompletableSource> {
        public final /* synthetic */ VoxCallClientPushTokenRegistration a;

        public c(VoxCallClientPushTokenRegistration voxCallClientPushTokenRegistration) {
            this.a = voxCallClientPushTokenRegistration;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "registeredToken");
            if (!m.isBlank(str2)) {
                return this.a.c.unregister(str2).andThen(Completable.fromAction(new j(this)));
            }
            Logs.debug$default(LogTagsKt.TAG_IAC, "Unregister push token: nothing to do", null, 4, null);
            return Completable.complete();
        }
    }

    @Inject
    public VoxCallClientPushTokenRegistration(@NotNull CallStorage callStorage, @NotNull PushTokenProvider pushTokenProvider, @NotNull VoxPushTokenRegistrationManager voxPushTokenRegistrationManager) {
        Intrinsics.checkNotNullParameter(callStorage, "callStorage");
        Intrinsics.checkNotNullParameter(pushTokenProvider, "pushTokenProvider");
        Intrinsics.checkNotNullParameter(voxPushTokenRegistrationManager, "voxPushTokenRegistrationManager");
        this.a = callStorage;
        this.b = pushTokenProvider;
        this.c = voxPushTokenRegistrationManager;
    }

    @Override // com.avito.android.calls.CallClientPushTokenRegistration
    @NotNull
    public Completable register() {
        Single map = InteropKt.toV3(this.b.getPushToken(true)).map(h.a);
        Intrinsics.checkNotNullExpressionValue(map, "pushTokenProvider.getPus…          }\n            }");
        Completable flatMapCompletable = map.flatMapCompletable(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "getActualPushToken().fla…)\n            }\n        }");
        return flatMapCompletable;
    }

    @Override // com.avito.android.calls.CallClientPushTokenRegistration
    @NotNull
    public Completable unregister() {
        Completable flatMapCompletable = Single.fromCallable(new b(this)).flatMapCompletable(new c(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.fromCallable {\n  …)\n            }\n        }");
        return flatMapCompletable;
    }
}
