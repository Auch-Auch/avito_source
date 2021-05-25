package com.avito.android.tariff.edit_info.item.prolongation;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProviderImpl;", "Lcom/avito/android/tariff/edit_info/item/prolongation/ResourceProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAutoProlongInProgress", "()Ljava/lang/String;", "autoProlongInProgress", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ResourceProviderImpl implements ResourceProvider {
    @NotNull
    public final String a;

    @Inject
    public ResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.tariff_payment_in_progress);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…riff_payment_in_progress)");
        this.a = string;
    }

    @Override // com.avito.android.tariff.edit_info.item.prolongation.ResourceProvider
    @NotNull
    public String getAutoProlongInProgress() {
        return this.a;
    }
}
