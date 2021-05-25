package com.avito.android.autodeal_details;

import com.avito.android.util.architecture_components.SingleLiveEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/autodeal_details/WebViewAction;", "getWebViewAction", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "webViewAction", "", "getUrlChanges", "urlChanges", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutoDealDetailsViewModel {
    @NotNull
    SingleLiveEvent<String> getUrlChanges();

    @NotNull
    SingleLiveEvent<WebViewAction> getWebViewAction();
}
