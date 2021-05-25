package com.avito.android.social;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/social/LogoutableImpl;", "Lcom/avito/android/social/Logoutable;", "", "logout", "()V", "", "Lcom/avito/android/social/SignInSocialManager;", AuthSource.SEND_ABUSE, "[Lcom/avito/android/social/SignInSocialManager;", "signInSocialManagers", "<init>", "([Lcom/avito/android/social/SignInSocialManager;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class LogoutableImpl implements Logoutable {
    public final SignInSocialManager[] a;

    public LogoutableImpl(@NotNull SignInSocialManager... signInSocialManagerArr) {
        Intrinsics.checkNotNullParameter(signInSocialManagerArr, "signInSocialManagers");
        this.a = signInSocialManagerArr;
    }

    @Override // com.avito.android.social.Logoutable
    public void logout() {
        for (SignInSocialManager signInSocialManager : this.a) {
            signInSocialManager.logout();
        }
    }
}
