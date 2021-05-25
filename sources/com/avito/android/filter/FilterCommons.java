package com.avito.android.filter;

import android.content.Intent;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/filter/FilterCommons;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/Intent;", "createResultIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "intent", "getResult", "(Landroid/content/Intent;)Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FilterCommons {
    @NotNull
    public final Intent createResultIntent(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent putExtra = new Intent().putExtra("result", deepLink);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(KEY_RESULT, deepLink)");
        return putExtra;
    }

    @NotNull
    public final DeepLink getResult(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Parcelable parcelableExtra = intent.getParcelableExtra("result");
        if (parcelableExtra != null) {
            return (DeepLink) parcelableExtra;
        }
        throw new IllegalArgumentException((intent + " should contain result field").toString());
    }
}
