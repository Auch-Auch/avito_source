package com.avito.android.publish.details.adapter.objects.old;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J9\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001f¨\u0006*"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/old/ObjectsViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/details/adapter/objects/old/ObjectsItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "clearItems", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAddMoreClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "visible", "setAddMoreButtonVisible", "(Z)V", "setAddMoreButtonTitle", "firstSubtitle", "secondSubtitle", "clickListener", "addItem", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "addMoreButton", "Landroid/widget/LinearLayout;", "t", "Landroid/widget/LinearLayout;", "container", "u", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsViewHolder extends BaseViewHolder implements ObjectsItemView {
    public final LayoutInflater s;
    public final LinearLayout t;
    public final TextView u;
    public final TextView v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(ObjectsViewHolder objectsViewHolder, int i, String str, String str2, String str3, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObjectsViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.t = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.add_more_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById3;
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void addItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.container_horizontal_padding);
        View inflate = this.s.inflate(com.avito.android.ui_components.R.layout.list_item_3_0, (ViewGroup) this.t, false);
        inflate.setBackgroundResource(com.avito.android.ui_components.R.drawable.bg_btn_flat);
        Views.changePadding$default(inflate, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
        View findViewById = inflate.findViewById(com.avito.android.ui_components.R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(str);
        View findViewById2 = inflate.findViewById(com.avito.android.ui_components.R.id.first_line_subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById2, str2, false, 2, null);
        View findViewById3 = inflate.findViewById(com.avito.android.ui_components.R.id.second_line_subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById3, str3, false, 2, null);
        inflate.setOnClickListener(new a(this, dimensionPixelSize, str, str2, str3, function0));
        LinearLayout linearLayout = this.t;
        linearLayout.addView(inflate, linearLayout.getChildCount() - 1);
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void clearItems() {
        LinearLayout linearLayout = this.t;
        linearLayout.removeViews(1, linearLayout.getChildCount() - 2);
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void setAddMoreButtonTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void setAddMoreButtonVisible(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void setOnAddMoreClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.publish.details.adapter.objects.old.ObjectsItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.u.setText(str);
    }
}
