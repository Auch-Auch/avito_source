package com.avito.android.authorization.auth;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/authorization/auth/AuthResourceProviderImpl;", "Lcom/avito/android/authorization/auth/AuthResourceProvider;", "", "getSocialAuthenticationError", "()Ljava/lang/String;", "socialAuthenticationError", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getSmartLockError", "smartLockError", "<init>", "(Landroid/content/res/Resources;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthResourceProviderImpl implements AuthResourceProvider {
    public final Resources a;

    @Inject
    public AuthResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.authorization.auth.AuthResourceProvider
    @NotNull
    public String getSmartLockError() {
        String string = this.a.getString(R.string.smartlock_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.smartlock_error)");
        return string;
    }

    @Override // com.avito.android.authorization.auth.AuthResourceProvider
    @NotNull
    public String getSocialAuthenticationError() {
        String string = this.a.getString(com.avito.android.social.R.string.social_error_authentication);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(soci…ial_error_authentication)");
        return string;
    }
}
