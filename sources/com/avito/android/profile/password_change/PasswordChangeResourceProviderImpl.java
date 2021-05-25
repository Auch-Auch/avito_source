package com.avito.android.profile.password_change;

import android.content.res.Resources;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeResourceProviderImpl;", "Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;", "", "getHideShowDelayMs", "()I", "hideShowDelayMs", "", "getServerErrorText", "()Ljava/lang/String;", "serverErrorText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeResourceProviderImpl implements PasswordChangeResourceProvider {
    public final Resources a;

    @Inject
    public PasswordChangeResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeResourceProvider
    public int getHideShowDelayMs() {
        return this.a.getInteger(17694720);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeResourceProvider
    @NotNull
    public String getServerErrorText() {
        String string = this.a.getString(R.string.password_change_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…word_change_server_error)");
        return string;
    }
}
