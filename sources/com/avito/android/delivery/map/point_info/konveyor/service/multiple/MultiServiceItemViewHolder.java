package com.avito.android.delivery.map.point_info.konveyor.service.multiple;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView;
import com.avito.android.delivery.utils.DrawableFactory;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010,¨\u0006<"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemViewHolder;", "Lcom/avito/android/delivery/map/point_info/konveyor/service/multiple/MultiServiceItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "label", "setLabel", "(Ljava/lang/String;)V", "", "subtitles", "setSubtitles", "(Ljava/util/List;)V", "id", "Lio/reactivex/rxjava3/functions/Consumer;", "clickConsumer", "setClickConsumer", "(Ljava/lang/String;Lio/reactivex/rxjava3/functions/Consumer;)V", "", "selected", "setSelected", "(Z)V", "", "Landroid/widget/TextView;", "w", "Ljava/util/List;", "subtitleViews", "Lcom/avito/android/util/text/AttributedTextFormatter;", "z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/widget/LinearLayout;", "t", "Landroid/widget/LinearLayout;", "container", "Lcom/avito/android/delivery/utils/DrawableFactory;", "y", "Lcom/avito/android/delivery/utils/DrawableFactory;", "drawableFactory", "Landroid/view/View;", "x", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "rootView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "u", "Landroid/widget/TextView;", "titleView", VKApiConst.VERSION, "icon", "<init>", "(Landroid/view/View;Lcom/avito/android/delivery/utils/DrawableFactory;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class MultiServiceItemViewHolder extends BaseViewHolder implements MultiServiceItemView {
    public final LayoutInflater s;
    public final LinearLayout t;
    public final TextView u;
    public final View v;
    public final List<TextView> w = new ArrayList();
    @NotNull
    public final View x;
    public final DrawableFactory y;
    public final AttributedTextFormatter z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Consumer a;
        public final /* synthetic */ String b;

        public a(Consumer consumer, String str) {
            this.a = consumer;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.accept(this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiServiceItemViewHolder(@NotNull View view, @NotNull DrawableFactory drawableFactory, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(drawableFactory, "drawableFactory");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.x = view;
        this.y = drawableFactory;
        this.z = attributedTextFormatter;
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.t = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.v = findViewById3;
    }

    @NotNull
    public final View getRootView() {
        return this.x;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MultiServiceItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView
    public void setClickConsumer(@NotNull String str, @NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.x.setOnClickListener(new a(consumer, str));
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView
    public void setLabel(@Nullable String str) {
        TextViews.setCompoundDrawables$default(this.u, (Drawable) null, (Drawable) null, str != null ? this.y.getTextDrawable(R.layout.delivery_green_label, R.id.label, str) : null, (Drawable) null, 11, (Object) null);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView
    public void setSelected(boolean z2) {
        View view = this.x;
        if (z2) {
            Views.setBackgroundCompat(view, Views.getDrawable(view, R.drawable.delivery_selected_service_bg));
            Views.show(this.v);
            return;
        }
        Views.setBackgroundCompat(view, Views.getDrawable(view, R.drawable.delivery_unselected_service_bg));
        this.v.setVisibility(4);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView
    public void setSubtitles(@NotNull List<AttributedText> list) {
        Intrinsics.checkNotNullParameter(list, "subtitles");
        this.t.removeAllViews();
        int i = 0;
        for (T t2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AttributedTextFormatter attributedTextFormatter = this.z;
            Context context = this.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            CharSequence format = attributedTextFormatter.format(context, t2);
            if (format == null) {
                format = "";
            }
            if (this.w.size() <= i) {
                List<TextView> list2 = this.w;
                View inflate = this.s.inflate(R.layout.rds_delivery_service_subtitle, (ViewGroup) this.t, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                list2.add((TextView) inflate);
            }
            TextView textView = this.w.get(i);
            TextViews.bindText$default(textView, format, false, 2, null);
            this.t.addView(textView);
            i = i2;
        }
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.service.multiple.MultiServiceItemView
    public void setTitle(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.z;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }
}
