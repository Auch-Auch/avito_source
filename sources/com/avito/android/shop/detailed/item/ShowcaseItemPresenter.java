package com.avito.android.shop.detailed.item;

import com.avito.android.recycler.responsive.ResponsiveItemPresenter;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShowcaseItemView;", "Lcom/avito/android/shop/detailed/item/ShowcaseItem;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "invalidateState", "()V", "", "id", "", VKApiConst.POSITION, "onCurrentPositionChanged", "(Ljava/lang/String;I)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShowcaseItemPresenter extends ResponsiveItemPresenter<ShowcaseItemView, ShowcaseItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void viewAttached(@NotNull ShowcaseItemPresenter showcaseItemPresenter, @NotNull ShowcaseItemView showcaseItemView, int i) {
            Intrinsics.checkNotNullParameter(showcaseItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewAttached(showcaseItemPresenter, showcaseItemView, i);
        }

        public static void viewDetached(@NotNull ShowcaseItemPresenter showcaseItemPresenter, @NotNull ShowcaseItemView showcaseItemView, int i) {
            Intrinsics.checkNotNullParameter(showcaseItemView, "view");
            ResponsiveItemPresenter.DefaultImpls.viewDetached(showcaseItemPresenter, showcaseItemView, i);
        }
    }

    void invalidateState();

    void onCurrentPositionChanged(@NotNull String str, int i);

    @NotNull
    Kundle onSaveState();
}
