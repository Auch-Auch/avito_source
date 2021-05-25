package com.avito.android.publish_limits_info.history.tab.advert;

import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.publish_limits_info.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "setPrice", "hint", "setHint", "", "isAutoPublishing", "setAutoPublish", "(Z)V", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "autoPublishView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "w", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "t", "priceView", "s", "titleView", "u", "hintView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class HistoryAdvertItemViewImpl extends BaseViewHolder implements HistoryAdvertItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final SimpleDraweeView w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HistoryAdvertItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.autoPublish);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.w = (SimpleDraweeView) findViewById5;
    }

    @Override // com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemView
    public void setAutoPublish(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemView
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemView
    public void setImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        SimpleDraweeViewsKt.getRequestBuilder(this.w).picture(picture).sourcePlace(ImageRequest.SourcePlace.SNIPPET).load();
    }

    @Override // com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemView
    public void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "price");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
