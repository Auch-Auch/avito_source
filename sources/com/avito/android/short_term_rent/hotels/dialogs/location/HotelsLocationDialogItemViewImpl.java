package com.avito.android.short_term_rent.hotels.dialogs.location;

import android.view.View;
import android.widget.TextView;
import com.avito.android.short_term_rent.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemViewImpl;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialogItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "bindSubtitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "t", "subTitle", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsLocationDialogItemViewImpl extends BaseViewHolder implements ItemView, HotelsLocationDialogItemView {
    public final TextView s;
    public final TextView t;
    public final View u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotelsLocationDialogItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.hotels_location_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.hotels_location_item_title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.hotels_location_item_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.h…s_location_item_subtitle)");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItemView
    public void bindSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
