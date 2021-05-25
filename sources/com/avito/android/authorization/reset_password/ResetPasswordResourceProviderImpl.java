package com.avito.android.authorization.reset_password;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProviderImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "", "login", "resetPasswordViaLinkText", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ResetPasswordResourceProviderImpl implements ResetPasswordResourceProvider {
    public final Resources a;

    @Inject
    public ResetPasswordResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordResourceProvider
    @NotNull
    public String resetPasswordViaLinkText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        String string = this.a.getString(R.string.link_sent_text, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.link_sent_text, login)");
        return string;
    }
}
