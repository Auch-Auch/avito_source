package com.avito.android.ui.adapter.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.ShortcutTabView;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0017¨\u0006#"}, d2 = {"Lcom/avito/android/ui/adapter/tab/ShortcutTabViewImpl;", "Lcom/avito/android/ui/adapter/tab/ShortcutTabView;", "", "text", "", "count", "", "bind", "(Ljava/lang/String;Ljava/lang/Integer;)V", "", "isSelected", "setSelected", "(Z)V", "Landroid/view/View;", "f", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "delimiter", "d", "I", "tabTextColor", "e", "tabSelectedTextColor", AuthSource.SEND_ABUSE, "title", "c", "counter", "<init>", "ui-components_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ResourceType"})
public final class ShortcutTabViewImpl implements ShortcutTabView {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final int d;
    public final int e;
    @NotNull
    public View f;

    public ShortcutTabViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f = view;
        View findViewById = getView().findViewById(R.id.tab_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = getView().findViewById(R.id.tab_delimiter);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = getView().findViewById(R.id.tab_counter);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        TypedArray obtainStyledAttributes = getView().getContext().obtainStyledAttributes(R.style.Widget_Avito_TabLayout, new int[]{com.google.android.material.R.attr.tabTextColor, com.google.android.material.R.attr.tabSelectedTextColor});
        Context context = getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int i = com.avito.android.lib.design.R.attr.black;
        this.d = obtainStyledAttributes.getColor(0, Contexts.getColorByAttr(context, i));
        Context context2 = getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.e = obtainStyledAttributes.getColor(1, Contexts.getColorByAttr(context2, i));
        obtainStyledAttributes.recycle();
    }

    @Override // com.avito.android.ui.adapter.tab.ShortcutTabView
    public void bind(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.a;
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        TextViews.bindText$default(textView, upperCase, false, 2, null);
        TextViews.bindText$default(this.c, num != null ? String.valueOf(num.intValue()) : null, false, 2, null);
        this.b.setVisibility(this.c.getVisibility());
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    @NotNull
    public View getView() {
        return this.f;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(int i, int i2, boolean z) {
        ShortcutTabView.DefaultImpls.setSelected(this, i, i2, z);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f = view;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(boolean z) {
        int i = z ? this.e : this.d;
        this.a.setTextColor(i);
        this.b.setTextColor(i);
        this.c.setTextColor(i);
    }
}
