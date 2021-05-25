package com.avito.android.advert.item.spare_parts;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemViewKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020\u001a¢\u0006\u0004\b/\u00100J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ%\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u001c\u0010)\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001c¨\u00061"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/SparePartsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/spare_parts/SparePartsView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "showLoading", "()V", "showContent", "hide", "clearSpareParts", "", "", "spareParts", "", "hideIcon", "addSpareParts", "(Ljava/util/List;Z)V", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "tvSubtitle", "Landroid/view/View;", "t", "Landroid/view/View;", "loading", "Landroid/widget/LinearLayout;", "u", "Landroid/widget/LinearLayout;", "content", VKApiConst.VERSION, "tvTitle", "Landroid/content/Context;", "y", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "x", "sparePartsContainer", "s", "divider", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsViewImpl extends BaseViewHolder implements SparePartsView {
    public final View s;
    public final View t;
    public final LinearLayout u;
    public final TextView v;
    public final TextView w;
    public final LinearLayout x;
    @NotNull
    public final Context y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SparePartsViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.divider);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(R.id.loading);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        View findViewById3 = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.u = linearLayout;
        View findViewById4 = linearLayout.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = linearLayout.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById5;
        View findViewById6 = linearLayout.findViewById(R.id.spare_parts_container);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.x = (LinearLayout) findViewById6;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.y = context;
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void addSpareParts(@NotNull List<? extends CharSequence> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "spareParts");
        for (T t2 : list) {
            View inflate = View.inflate(getContext(), com.avito.android.spare_parts.R.layout.spare_parts_list_item, null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setText(t2);
            if (z) {
                TextViews.setCompoundDrawables$default(textView, 0, 0, 0, 0, 11, (Object) null);
            }
            if (t2 instanceof Spannable) {
                SparePartsTextItemViewKt.dispatchClicksToClickableSpan$default(textView, t2, 0, 2, null);
            }
            this.x.addView(textView);
        }
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void clearSpareParts() {
        this.x.removeAllViews();
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    @NotNull
    public Context getContext() {
        return this.y;
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void hide() {
        Views.hide(this.s);
        Views.hide(this.t);
        Views.hide(this.u);
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.w, str, false, 2, null);
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.v.setText(str);
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void showContent() {
        Views.hide(this.t);
        Views.show(this.u);
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsView
    public void showLoading() {
        Views.show(this.t);
        Views.hide(this.u);
    }
}
