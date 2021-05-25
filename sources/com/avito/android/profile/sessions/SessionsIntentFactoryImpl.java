package com.avito.android.profile.sessions;

import android.app.Application;
import android.content.Intent;
import com.avito.android.SessionsIntentFactory;
import com.avito.android.profile.sessions.info.SessionsInfoActvityKt;
import com.avito.android.profile.sessions.list.SessionsListActvityKt;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutActvityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.IntentsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile/sessions/SessionsIntentFactoryImpl;", "Lcom/avito/android/SessionsIntentFactory;", "", "source", "Landroid/content/Intent;", "sessionsListIntent", "(Ljava/lang/String;)Landroid/content/Intent;", ChannelContext.Item.USER_ID, "loginType", "sessionIdHash", "deviceId", "sessionsSocialLogoutIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "", "isForPasswordChange", "sessionsInfoIntent", "(Z)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsIntentFactoryImpl implements SessionsIntentFactory {
    @NotNull
    public final Application a;

    @Inject
    public SessionsIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @NotNull
    public final Application getContext() {
        return this.a;
    }

    @Override // com.avito.android.SessionsIntentFactory
    @NotNull
    public Intent sessionsInfoIntent(boolean z) {
        return SessionsInfoActvityKt.createSessionsInfoActivityIntent(this.a, z);
    }

    @Override // com.avito.android.SessionsIntentFactory
    @NotNull
    public Intent sessionsListIntent(@Nullable String str) {
        Intent createSessionsListActivityIntent = SessionsListActvityKt.createSessionsListActivityIntent(this.a, str);
        IntentsKt.withClearTopFlags(createSessionsListActivityIntent);
        return createSessionsListActivityIntent;
    }

    @Override // com.avito.android.SessionsIntentFactory
    @NotNull
    public Intent sessionsSocialLogoutIntent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return SessionsSocialLogoutActvityKt.createSessionsSocialLogoutActivityIntent(this.a, str, str2, str3, str4, str5);
    }
}
