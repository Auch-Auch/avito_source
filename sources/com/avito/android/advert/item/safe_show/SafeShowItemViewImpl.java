package com.avito.android.advert.item.safe_show;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.safe_show.SafeShowItemView;
import com.avito.android.advert_core.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert/item/safe_show/SafeShowItemViewImpl;", "Lcom/avito/android/advert/item/safe_show/SafeShowItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "showText", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", "onClickListener", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "item", "onContactButtonClickListener", "showBottomBar", "(Lcom/avito/android/advert/item/safe_show/SafeShowItem;Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "Lcom/avito/android/advert/item/safe_show/SafeShowAdvertDetailsDialogFactory;", "t", "Lcom/avito/android/advert/item/safe_show/SafeShowAdvertDetailsDialogFactory;", "dialogFactory", "Landroid/view/View;", "view", "<init>", "(Lcom/avito/android/advert/item/safe_show/SafeShowAdvertDetailsDialogFactory;Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowItemViewImpl extends BaseViewHolder implements SafeShowItemView {
    @NotNull
    public final TextView s;
    public final SafeShowAdvertDetailsDialogFactory t;

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
    public SafeShowItemViewImpl(@NotNull SafeShowAdvertDetailsDialogFactory safeShowAdvertDetailsDialogFactory, @NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(safeShowAdvertDetailsDialogFactory, "dialogFactory");
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = safeShowAdvertDetailsDialogFactory;
        View findViewById = view.findViewById(R.id.safe_show_teaser_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @NotNull
    public final TextView getText() {
        return this.s;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SafeShowItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert.item.safe_show.SafeShowItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClickListener");
        this.itemView.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert.item.safe_show.SafeShowItemView
    public void showBottomBar(@NotNull SafeShowItem safeShowItem, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(safeShowItem, "item");
        Intrinsics.checkNotNullParameter(function0, "onContactButtonClickListener");
        SafeShowAdvertDetailsDialogFactory safeShowAdvertDetailsDialogFactory = this.t;
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        safeShowAdvertDetailsDialogFactory.show(context, safeShowItem, function0);
    }

    @Override // com.avito.android.advert.item.safe_show.SafeShowItemView
    public void showText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.s.setText(charSequence);
    }
}
