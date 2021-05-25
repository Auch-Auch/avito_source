package com.avito.android.delivery.map.point_info.konveyor.attribute;

import android.view.View;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.point_info.konveyor.attribute.AttributeItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemViewHolder;", "Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "descriptionView", "s", "titleView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class AttributeItemViewHolder extends BaseViewHolder implements AttributeItemView {
    public final TextView s;
    public final TextView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AttributeItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.attribute_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.attribute_description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AttributeItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.attribute.AttributeItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.t.setText(str);
    }

    @Override // com.avito.android.delivery.map.point_info.konveyor.attribute.AttributeItemView
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
