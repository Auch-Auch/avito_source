package com.avito.android.auto_catalog;

import android.os.Bundle;
import com.avito.android.advert_core.RetryListener;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorListener;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "Lcom/avito/android/advert_core/RetryListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorListener;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/auto_catalog/AutoCatalogView;", "view", "", "attachView", "(Lcom/avito/android/auto_catalog/AutoCatalogView;)V", "detachView", "()V", "Lcom/avito/android/auto_catalog/AutoCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/auto_catalog/AutoCatalogRouter;)V", "detachRouter", "onStart", "onStop", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "", "isZeroSerp", "onSerpButtonClick", "(Z)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogPresenter extends RetryListener, AppendingListener, SpecsSelectorListener, AdvertItemListener {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onMoreActionsClicked(@NotNull AutoCatalogPresenter autoCatalogPresenter, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            AdvertItemListener.DefaultImpls.onMoreActionsClicked(autoCatalogPresenter, str);
        }

        public static /* synthetic */ void onSerpButtonClick$default(AutoCatalogPresenter autoCatalogPresenter, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                autoCatalogPresenter.onSerpButtonClick(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSerpButtonClick");
        }
    }

    void attachRouter(@Nullable AutoCatalogRouter autoCatalogRouter);

    void attachView(@NotNull AutoCatalogView autoCatalogView);

    void detachRouter();

    void detachView();

    void onSerpButtonClick(boolean z);

    void onStart();

    void onStop();

    void restoreState(@Nullable Bundle bundle);

    @NotNull
    Bundle saveState();
}
