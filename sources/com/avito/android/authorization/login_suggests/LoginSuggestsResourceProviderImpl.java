package com.avito.android.authorization.login_suggests;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProviderImpl;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsResourceProvider;", "", "facebookTitle", "()Ljava/lang/String;", "vkontakteTitle", "odnoklassnikiTitle", "googleTitle", "appleTitle", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsResourceProviderImpl implements LoginSuggestsResourceProvider {
    public final Resources a;

    @Inject
    public LoginSuggestsResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider
    @NotNull
    public String appleTitle() {
        String string = this.a.getString(R.string.apple);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.apple)");
        return string;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider
    @NotNull
    public String facebookTitle() {
        String string = this.a.getString(R.string.facebook);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.facebook)");
        return string;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider
    @NotNull
    public String googleTitle() {
        String string = this.a.getString(R.string.google);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.google)");
        return string;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider
    @NotNull
    public String odnoklassnikiTitle() {
        String string = this.a.getString(R.string.odnoklassniki);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.odnoklassniki)");
        return string;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider
    @NotNull
    public String vkontakteTitle() {
        String string = this.a.getString(R.string.vkontakte);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.vkontakte)");
        return string;
    }
}
