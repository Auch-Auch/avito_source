package com.avito.android.advert.item.auto_catalog;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/auto_catalog/AdvertDetailsAutoCatalogView;", "", "title", "Landroid/view/View$OnClickListener;", "clickListener", "", "show", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "hide", "()V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "modelSpecificationsButton", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutoCatalogViewImpl extends BaseViewHolder implements AdvertDetailsAutoCatalogView {
    public final TextView s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAutoCatalogViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        View findViewById = view.findViewById(R.id.auto_catalog_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.auto_catalog_button)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogView
    public void hide() {
        this.s.setText((CharSequence) null);
        Views.hide(this.s);
        Views.hide(this.t);
    }

    @Override // com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogView
    public void show(@NotNull String str, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(str, "title");
        Views.show(this.t);
        this.s.setText(str);
        Views.show(this.s);
        if (onClickListener != null) {
            this.s.setOnClickListener(onClickListener);
        }
    }
}
