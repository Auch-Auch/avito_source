package com.avito.android.analytics.interactor;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/interactor/SnippetScrollDepthAnalyticsInteractor;", "", "", "offset", "", "", "ids", "advertsItemsCount", "xHash", "totalItemsCount", "", "sendUserScrolledToItemOnHome", "(ILjava/util/List;ILjava/lang/String;I)V", "sendUserScrolledToItemOnSerp", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetScrollDepthAnalyticsInteractor {
    void sendUserScrolledToItemOnHome(int i, @NotNull List<String> list, int i2, @NotNull String str, int i3);

    void sendUserScrolledToItemOnSerp(int i, @NotNull List<String> list, int i2, @NotNull String str, int i3);
}
