package com.avito.android.profile.cards.phones;

import android.content.res.Resources;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProviderImpl;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;", "", "phonesNumber", "", "morePhonesText", "(I)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesCardItemResourceProviderImpl implements PhonesCardItemResourceProvider {
    public final Resources a;

    public PhonesCardItemResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.cards.phones.PhonesCardItemResourceProvider
    @NotNull
    public String morePhonesText(int i) {
        String quantityString = this.a.getQuantityString(R.plurals.some_more_phones, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…onesNumber, phonesNumber)");
        return quantityString;
    }
}
