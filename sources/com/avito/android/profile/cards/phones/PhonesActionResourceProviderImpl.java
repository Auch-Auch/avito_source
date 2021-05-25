package com.avito.android.profile.cards.phones;

import android.content.res.Resources;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesActionResourceProviderImpl;", "Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;", "", "getSetForAll", "()Ljava/lang/String;", "setForAll", "getRemovePhone", "removePhone", "getVerifyPhone", "verifyPhone", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesActionResourceProviderImpl implements PhonesActionResourceProvider {
    public final Resources a;

    public PhonesActionResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.cards.phones.PhonesActionResourceProvider
    @NotNull
    public String getRemovePhone() {
        String string = this.a.getString(R.string.phone_action_remove);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_action_remove)");
        return string;
    }

    @Override // com.avito.android.profile.cards.phones.PhonesActionResourceProvider
    @NotNull
    public String getSetForAll() {
        String string = this.a.getString(R.string.phone_action_set_for_all);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…phone_action_set_for_all)");
        return string;
    }

    @Override // com.avito.android.profile.cards.phones.PhonesActionResourceProvider
    @NotNull
    public String getVerifyPhone() {
        String string = this.a.getString(R.string.phone_action_verify);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.phone_action_verify)");
        return string;
    }
}
