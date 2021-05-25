package com.avito.android.delivery.map.point_info.konveyor.service.single;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemView;
import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemViewHolder;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/single/ServiceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "label", "setLabel", "(Ljava/lang/String;)V", "", "subtitles", "setSubtitles", "(Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/util/text/AttributedTextFormatter;", "x", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/widget/LinearLayout;", "t", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "", VKApiConst.VERSION, "Ljava/util/List;", "subtitleViews", "Lcom/avito/android/delivery/utils/DrawableFactory;", "w", "Lcom/avito/android/delivery/utils/DrawableFactory;", "drawableFactory", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/delivery/utils/DrawableFactory;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceItemViewHolder extends BaseViewHolder implements ServiceItemView {
    public final LayoutInflater s;
    public final LinearLayout t;
    public final TextView u;
    public final List<TextView> v = new ArrayList();
    public final DrawableFactory w;
    public final AttributedTextFormatter x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceItemViewHolder(@NotNull View view, @NotNull DrawableFactory drawableFactory, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.w = drawableFactory;
        this.x = attributedTextFormatter;
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.t = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ServiceItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemView
    public void setLabel(@Nullable String str) {
        Drawable drawable;
        TextView textView = this.u;
        if (str != null) {
            drawable = this.w.getTextDrawable(R.layout.delivery_green_label, R.id.label, str);
        } else {
            drawable = null;
        }
        TextViews.setCompoundDrawables$default(textView, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemView
    public void setSubtitles(@NotNull List<AttributedText> list) {
        Intrinsics.checkNotNullParameter(list, "subtitles");
        this.t.removeAllViews();
        int i = 0;
        for (T t2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AttributedTextFormatter attributedTextFormatter = this.x;
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            CharSequence format = attributedTextFormatter.format(context, t2);
            if (format == null) {
                format = "";
            }
            if (this.v.size() <= i) {
                List<TextView> list2 = this.v;
                View inflate = this.s.inflate(R.layout.rds_delivery_service_subtitle, (ViewGroup) this.t, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                list2.add((TextView) inflate);
            }
            TextView textView = this.v.get(i);
            TextViews.bindText$default(textView, format, false, 2, null);
            this.t.addView(textView);
            i = i2;
        }
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.single.ServiceItemView
    public void setTitle(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.x;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }
}
