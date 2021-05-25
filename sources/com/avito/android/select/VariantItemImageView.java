package com.avito.android.select;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.lib.design.toggle.Checkbox;
import com.avito.android.lib.design.toggle.RadioButton;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010&¨\u00062"}, d2 = {"Lcom/avito/android/select/VariantItemImageView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/VariantItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "enable", "enableMultiselect", "(Z)V", "selected", "setSelected", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setWidth", "(I)V", "Lcom/avito/android/lib/design/toggle/RadioButton;", "t", "Lcom/avito/android/lib/design/toggle/RadioButton;", "radioButton", "Lcom/avito/android/lib/design/toggle/Checkbox;", "u", "Lcom/avito/android/lib/design/toggle/Checkbox;", "checkbox", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/util/SimpleDraweeView;", "s", "Lcom/avito/android/util/SimpleDraweeView;", "imageView", "w", "subtitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class VariantItemImageView extends BaseViewHolder implements VariantItemView {
    public final SimpleDraweeView s;
    public final RadioButton t;
    public final Checkbox u;
    public final TextView v;
    public final TextView w;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.b).invoke();
            } else if (i == 1) {
                ((Function0) this.b).invoke();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VariantItemImageView a;
        public final /* synthetic */ Function0 b;

        public b(VariantItemImageView variantItemImageView, Function0 function0) {
            this.a = variantItemImageView;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.t.toggle();
            this.a.u.toggle();
            this.b.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariantItemImageView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.radio_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.toggle.RadioButton");
        this.t = (RadioButton) findViewById2;
        View findViewById3 = view.findViewById(R.id.checkbox);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.toggle.Checkbox");
        this.u = (Checkbox) findViewById3;
        View findViewById4 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
    }

    @Override // com.avito.android.select.VariantItemView
    public void enableMultiselect(boolean z) {
        Views.setVisible(this.t, !z);
        Views.setVisible(this.u, z);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setImage(@Nullable Image image) {
        Uri width = Images.fit$default(image, this.s, 0.0f, 0.0f, 2, 6, null).width();
        if (width == null) {
            this.s.setActualImageResource(R.drawable.ic_image_select_stub);
        } else {
            SimpleDraweeViewsKt.getRequestBuilder(this.s).uri(width).load();
        }
    }

    @Override // com.avito.android.select.VariantItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(0, function0));
        this.u.setOnClickListener(new a(1, function0));
        this.itemView.setOnClickListener(new b(this, function0));
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSelected(boolean z) {
        this.t.setChecked(z);
        this.u.setChecked(z);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
    }

    public final void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintMaxWidth = i;
    }
}
