package com.avito.android.inline_filters.dialog.select.adapter;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.lib.design.toggle.Checkbox;
import com.avito.android.lib.design.toggle.RadioButton;
import com.avito.android.remote.model.Image;
import com.avito.android.select.R;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\"¨\u0006."}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogImageSelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "setSecondaryText", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnLayoutFinishedListener", "(Lkotlin/jvm/functions/Function0;)V", "", "enable", "enableMultiselect", "(Z)V", "isChecked", "setChecked", "setOnClickListener", "Lcom/avito/android/util/SimpleDraweeView;", "s", "Lcom/avito/android/util/SimpleDraweeView;", "imageView", "Lcom/avito/android/lib/design/toggle/RadioButton;", "t", "Lcom/avito/android/lib/design/toggle/RadioButton;", "radioButton", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "subtitleView", "Lcom/avito/android/lib/design/toggle/Checkbox;", "u", "Lcom/avito/android/lib/design/toggle/Checkbox;", "checkbox", VKApiConst.VERSION, "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogImageSelectItemView extends BaseViewHolder implements InlineFiltersDialogItemView {
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
        public final /* synthetic */ InlineFiltersDialogImageSelectItemView a;
        public final /* synthetic */ Function0 b;

        public b(InlineFiltersDialogImageSelectItemView inlineFiltersDialogImageSelectItemView, Function0 function0) {
            this.a = inlineFiltersDialogImageSelectItemView;
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
    public InlineFiltersDialogImageSelectItemView(@NotNull View view) {
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

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void enableMultiselect(boolean z) {
        Views.setVisible(this.t, !z);
        Views.setVisible(this.u, z);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setChecked(boolean z) {
        this.t.setChecked(z);
        this.u.setChecked(z);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setImage(@Nullable Image image) {
        Uri width = Images.fit$default(image, this.s, 0.0f, 0.0f, 2, 6, null).width();
        if (width == null) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.s.getHierarchy();
            if (genericDraweeHierarchy != null) {
                genericDraweeHierarchy.setPlaceholderImage(ResourcesCompat.getDrawable(this.s.getResources(), R.drawable.ic_image_select_stub, null));
                return;
            }
            return;
        }
        SimpleDraweeViewsKt.getRequestBuilder(this.s).uri(width).load();
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(0, function0));
        this.u.setOnClickListener(new a(1, function0));
        this.itemView.setOnClickListener(new b(this, function0));
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setOnLayoutFinishedListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(view, function0) { // from class: com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogImageSelectItemView$setOnLayoutFinishedListener$$inlined$runOnNextLayoutChange$1
            public final /* synthetic */ View a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@Nullable View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.b.invoke();
                this.a.removeOnLayoutChangeListener(this);
            }
        });
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setSecondaryText(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
    }

    @Override // com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.v.setText(str);
    }
}
