package com.avito.android.authorization.select_profile.social_login;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsResourceProviderImpl;", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsResourceProvider;", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCreateProfileMessage", "()Ljava/lang/String;", "createProfileMessage", AuthSource.SEND_ABUSE, "getSelectProfileMessage", "selectProfileMessage", "<init>", "(Landroid/content/res/Resources;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsResourceProviderImpl implements SocialRegistrationSuggestsResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final Resources c;

    @Inject
    public SocialRegistrationSuggestsResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.c = resources;
        String string = resources.getString(R.string.social_registration_suggests_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…tration_suggests_message)");
        this.a = string;
        String string2 = resources.getString(R.string.social_registration_suggests_create);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…stration_suggests_create)");
        this.b = string2;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsResourceProvider
    @NotNull
    public String getCreateProfileMessage() {
        return this.b;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsResourceProvider
    @NotNull
    public String getSelectProfileMessage() {
        return this.a;
    }
}
