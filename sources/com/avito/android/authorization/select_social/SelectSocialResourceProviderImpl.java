package com.avito.android.authorization.select_social;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.authorization.auth.AuthResourceProvider;
import com.avito.android.authorization.auth.AuthResourceProviderImpl;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0016\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialResourceProviderImpl;", "Lcom/avito/android/authorization/select_social/SelectSocialResourceProvider;", "Lcom/avito/android/authorization/auth/AuthResourceProvider;", "", "selectSocialMessage", "()Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getSocialAuthenticationError", "socialAuthenticationError", "getSmartLockError", "smartLockError", "<init>", "(Landroid/content/res/Resources;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectSocialResourceProviderImpl implements SelectSocialResourceProvider, AuthResourceProvider {
    public final Resources a;
    public final /* synthetic */ AuthResourceProviderImpl b;

    @Inject
    public SelectSocialResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = new AuthResourceProviderImpl(resources);
        this.a = resources;
    }

    @Override // com.avito.android.authorization.auth.AuthResourceProvider
    @NotNull
    public String getSmartLockError() {
        return this.b.getSmartLockError();
    }

    @Override // com.avito.android.authorization.auth.AuthResourceProvider
    @NotNull
    public String getSocialAuthenticationError() {
        return this.b.getSocialAuthenticationError();
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialResourceProvider
    @NotNull
    public String selectSocialMessage() {
        String string = this.a.getString(R.string.registration_select_social_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…on_select_social_message)");
        return string;
    }
}
