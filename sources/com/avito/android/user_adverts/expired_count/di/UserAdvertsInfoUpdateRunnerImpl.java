package com.avito.android.user_adverts.expired_count.di;

import android.content.Context;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.expired_count.UserAdvertsInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/di/UserAdvertsInfoUpdateRunnerImpl;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Landroid/content/Context;", "context", "", "requestUpdate", "(Landroid/content/Context;)V", "forceUpdate", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsInfoUpdateRunnerImpl implements UserAdvertsInfoUpdateRunner {
    @Override // com.avito.android.user_advert.UserAdvertsInfoUpdateRunner
    public void forceUpdate(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UserAdvertsInfoService.Companion.requestUpdate$user_adverts_release(context, true);
    }

    @Override // com.avito.android.user_advert.UserAdvertsInfoUpdateRunner
    public void requestUpdate(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UserAdvertsInfoService.Companion.requestUpdate$user_adverts_release$default(UserAdvertsInfoService.Companion, context, false, 2, null);
    }
}
