package com.avito.android.tariff.landing.item.icon;

import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.tariff.R;
import com.avito.android.tariff.landing.item.icon.IconItemView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/tariff/landing/item/icon/IconItemViewImpl;", "Lcom/avito/android/tariff/landing/item/icon/IconItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class IconItemViewImpl extends BaseViewHolder implements IconItemView {
    public final SimpleDraweeView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.icon)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        IconItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.landing.item.icon.IconItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        SimpleDraweeViewsKt.loadPicture$default(this.s, picture, null, null, 6, null);
    }

    @Override // com.avito.android.tariff.landing.item.icon.IconItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }
}
