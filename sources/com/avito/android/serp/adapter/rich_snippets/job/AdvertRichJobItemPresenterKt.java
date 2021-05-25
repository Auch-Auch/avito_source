package com.avito.android.serp.adapter.rich_snippets.job;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;", "", "clearCallbacks", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;)V", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertRichJobItemPresenterKt {
    public static final void clearCallbacks(@NotNull AdvertRichJobItemView advertRichJobItemView) {
        Intrinsics.checkNotNullParameter(advertRichJobItemView, "$this$clearCallbacks");
        advertRichJobItemView.favoriteClicks(null);
        advertRichJobItemView.clearListeners();
        advertRichJobItemView.setUnbindListener(null);
    }
}
