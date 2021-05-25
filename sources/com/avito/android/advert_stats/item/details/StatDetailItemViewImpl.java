package com.avito.android.advert_stats.item.details;

import a2.b.a.a.a;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_stats.R;
import com.avito.android.advert_stats.item.details.StatDetailItemView;
import com.avito.android.image_loader.Picture;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/advert_stats/item/details/StatDetailItemViewImpl;", "Lcom/avito/android/advert_stats/item/details/StatDetailItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "drawableResId", "setImageDrawable", "(I)V", "hidePicture", "()V", "", "text", "setText", "(Ljava/lang/String;)V", "", "isHidden", "iconEnabled", "setHidden", "(ZZ)V", "u", "Z", "isStatusView", "()Z", "setStatusView", "(Z)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "title", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatDetailItemViewImpl extends BaseViewHolder implements StatDetailItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public boolean u = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatDetailItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.icon)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void hidePicture() {
        Views.hide(this.s);
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public boolean isStatusView() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        StatDetailItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void setHidden(boolean z, boolean z2) {
        if (z) {
            Views.conceal(this.t);
        } else {
            Views.show(this.t);
        }
        if (!z2 || z) {
            Views.hide(this.s);
        } else {
            Views.show(this.s);
        }
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void setImageDrawable(int i) {
        this.s.setImageResource(i);
        Views.show(this.s);
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a.L0(this.s, picture);
        Views.show(this.s);
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void setStatusView(boolean z) {
        this.u = z;
    }

    @Override // com.avito.android.advert_stats.item.details.StatDetailItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.t.setText(str);
    }
}
