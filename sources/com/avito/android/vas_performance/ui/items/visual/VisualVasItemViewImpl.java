package com.avito.android.vas_performance.ui.items.visual;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.vas_performance.R;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00103\u001a\u000200¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010 R\u0016\u00107\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010 ¨\u0006:"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemViewImpl;", "Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "setDescription", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "price", "setPrice", "oldPrice", "setOldPrice", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "selected", "setSelected", "(Z)V", "toggleSelection", "()V", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "priceOldView", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "u", "priceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "w", "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "Landroid/widget/CheckBox;", "x", "Landroid/widget/CheckBox;", "checkBox", "Lcom/avito/android/util/text/AttributedTextFormatter;", "z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "s", "titleView", "t", "descriptionView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVasItemViewImpl extends BaseViewHolder implements VisualVasItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final SimpleDraweeView w;
    public final CheckBox x;
    public final View y;
    public final AttributedTextFormatter z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VisualVasItemViewImpl a;
        public final /* synthetic */ Function0 b;

        public a(VisualVasItemViewImpl visualVasItemViewImpl, Function0 function0) {
            this.a = visualVasItemViewImpl;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.invoke();
            this.a.toggleSelection();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisualVasItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.y = view;
        this.z = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.price_old);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.w = (SimpleDraweeView) findViewById5;
        View findViewById6 = view.findViewById(R.id.checkbox);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.CheckBox");
        this.x = (CheckBox) findViewById6;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VisualVasItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y.setOnClickListener(new a(this, function0));
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setDescription(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        AttributedTextFormatter attributedTextFormatter = this.z;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setOldPrice(@Nullable AttributedText attributedText) {
        TextView textView = this.v;
        AttributedTextFormatter attributedTextFormatter = this.z;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.w, picture);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setPrice(@Nullable AttributedText attributedText) {
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.z;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setSelected(boolean z2) {
        this.x.setChecked(z2);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.vas_performance.ui.items.visual.VisualVasItemView
    public void toggleSelection() {
        CheckBox checkBox = this.x;
        checkBox.setChecked(!checkBox.isChecked());
    }
}
