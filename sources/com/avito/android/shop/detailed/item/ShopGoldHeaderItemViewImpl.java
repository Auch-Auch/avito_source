package com.avito.android.shop.detailed.item;

import android.view.View;
import com.avito.android.design.widget.ForegroundRelativeLayout;
import com.avito.android.image_loader.Picture;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItemView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemViewImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldHeaderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "logo", "", "setLogo", "(Lcom/avito/android/image_loader/Picture;)V", "hideLogo", "()V", "background", "setBackground", "hideBackground", "", "imageHeightPx", "setImageHeightPx", "(I)V", "Lcom/avito/android/design/widget/ForegroundRelativeLayout;", "t", "Lcom/avito/android/design/widget/ForegroundRelativeLayout;", "logoContainerView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "logoView", "u", "backgroundView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldHeaderItemViewImpl extends BaseViewHolder implements ShopGoldHeaderItemView {
    public final SimpleDraweeView s;
    public final ForegroundRelativeLayout t;
    public final SimpleDraweeView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopGoldHeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.logo);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.background_small_image_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.design.widget.ForegroundRelativeLayout");
        this.t = (ForegroundRelativeLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.background);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById3;
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldHeaderItemView
    public void hideBackground() {
        Views.hide(this.u);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldHeaderItemView
    public void hideLogo() {
        Views.hide(this.t);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShopGoldHeaderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldHeaderItemView
    public void setBackground(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "background");
        Views.show(this.u);
        SimpleDraweeViewsKt.loadPicture$default(this.u, picture, null, null, 6, null);
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldHeaderItemView
    public void setImageHeightPx(int i) {
        this.u.getLayoutParams().height = i;
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldHeaderItemView
    public void setLogo(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "logo");
        Views.show(this.t);
        SimpleDraweeViewsKt.loadPicture$default(this.s, picture, null, null, 6, null);
    }
}
