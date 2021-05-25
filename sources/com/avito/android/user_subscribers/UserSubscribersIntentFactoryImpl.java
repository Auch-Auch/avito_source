package com.avito.android.user_subscribers;

import android.content.Context;
import android.content.Intent;
import com.avito.android.UserSubscribersIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersIntentFactoryImpl;", "Lcom/avito/android/UserSubscribersIntentFactory;", "Landroid/content/Intent;", "userSubscribersActivityIntent", "()Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersIntentFactoryImpl implements UserSubscribersIntentFactory {
    @NotNull
    public final Context a;

    @Inject
    public UserSubscribersIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @Override // com.avito.android.UserSubscribersIntentFactory
    @NotNull
    public Intent userSubscribersActivityIntent() {
        return UserSubscribersActivityKt.createUserSubscribersActivityIntent(this.a);
    }
}
