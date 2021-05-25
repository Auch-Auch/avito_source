package com.avito.android.user_adverts.root_screen.adverts_host.header;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProviderImpl;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderResourceProvider;", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "resources", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSoaShortTitle", "()Ljava/lang/String;", "soaShortTitle", "c", "getSmbOnboardingText", "smbOnboardingText", AuthSource.BOOKING_ORDER, "getSoaOnboardingText", "soaOnboardingText", "<init>", "(Landroid/content/res/Resources;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileHeaderResourceProviderImpl implements ProfileHeaderResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final Resources d;

    @Inject
    public ProfileHeaderResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.d = resources;
        String string = resources.getString(R.string.soa_short_text);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.soa_short_text)");
        this.a = string;
        String string2 = resources.getString(R.string.soa_onboarding_popup_text);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…oa_onboarding_popup_text)");
        this.b = string2;
        String string3 = resources.getString(R.string.smb_onboarding_popup_text);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…mb_onboarding_popup_text)");
        this.c = string3;
    }

    @NotNull
    public final Resources getResources() {
        return this.d;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProvider
    @NotNull
    public String getSmbOnboardingText() {
        return this.c;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProvider
    @NotNull
    public String getSoaOnboardingText() {
        return this.b;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProvider
    @NotNull
    public String getSoaShortTitle() {
        return this.a;
    }
}
