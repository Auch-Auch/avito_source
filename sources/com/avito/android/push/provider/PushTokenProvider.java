package com.avito.android.push.provider;

import arrow.core.Option;
import com.avito.android.push.PushToken;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/push/provider/PushTokenProvider;", "", "", "needFresh", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/push/PushToken;", "getPushToken", "(Z)Lio/reactivex/Single;", "Dummy", "push_release"}, k = 1, mv = {1, 4, 2})
public interface PushTokenProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single getPushToken$default(PushTokenProvider pushTokenProvider, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return pushTokenProvider.getPushToken(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPushToken");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/push/provider/PushTokenProvider$Dummy;", "Lcom/avito/android/push/provider/PushTokenProvider;", "", "needFresh", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/push/PushToken;", "getPushToken", "(Z)Lio/reactivex/Single;", "<init>", "()V", "push_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dummy implements PushTokenProvider {
        @Override // com.avito.android.push.provider.PushTokenProvider
        @NotNull
        public Single<Option<PushToken>> getPushToken(boolean z) {
            Single<Option<PushToken>> just = Single.just(Option.Companion.empty());
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(Option.empty())");
            return just;
        }
    }

    @NotNull
    Single<Option<PushToken>> getPushToken(boolean z);
}
