package com.avito.android.brandspace.items.marketplace.snippet;

import android.view.View;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0013\u0010\u0011J#\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Landroid/view/View$OnClickListener;", "clickListener", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/avito/android/remote/model/Image;", "image", "setAdvertPreviewImage", "(Lcom/avito/android/remote/model/Image;)V", "", "hasDelivery", "(Z)V", "", "text", "setAdvertName", "(Ljava/lang/String;)V", "price", "setPrice", "oldPrice", "discountPercent", "setDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "setBadges", "(Ljava/util/List;)V", "", "any", "setTag", "(Ljava/lang/Object;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceSnippetItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceSnippetItemView marketplaceSnippetItemView) {
            ItemView.DefaultImpls.onUnbind(marketplaceSnippetItemView);
        }
    }

    void hasDelivery(boolean z);

    void setAdvertName(@NotNull String str);

    void setAdvertPreviewImage(@NotNull Image image);

    void setBadges(@Nullable List<SerpBadge> list);

    void setDiscount(@Nullable String str, @Nullable String str2);

    void setOnClickListener(@NotNull View.OnClickListener onClickListener);

    void setPrice(@NotNull String str);

    void setTag(@Nullable Object obj);
}
