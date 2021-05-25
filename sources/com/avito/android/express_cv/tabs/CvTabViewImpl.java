package com.avito.android.express_cv.tabs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.TextView;
import com.avito.android.express_cv.R;
import com.avito.android.express_cv.tabs.CvTabView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/express_cv/tabs/CvTabViewImpl;", "Lcom/avito/android/express_cv/tabs/CvTabView;", "", "text", "", "bind", "(Ljava/lang/String;)V", "", "widthPx", "setWidth", "(I)V", "", "isSelected", "setSelected", "(Z)V", "c", "I", "tabSelectedTextColor", AuthSource.BOOKING_ORDER, "tabTextColor", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "title", "Landroid/view/View;", "d", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "view", "<init>", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ResourceType"})
public final class CvTabViewImpl implements CvTabView {
    public final TextView a;
    public final int b;
    public final int c;
    @NotNull
    public View d;

    public CvTabViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = getView().findViewById(R.id.tab_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        TypedArray obtainStyledAttributes = getView().getContext().obtainStyledAttributes(com.avito.android.ui_components.R.style.Widget_Avito_TabLayout, new int[]{com.google.android.material.R.attr.tabTextColor, com.google.android.material.R.attr.tabSelectedTextColor});
        Context context = getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int i = com.avito.android.lib.design.R.attr.black;
        this.b = obtainStyledAttributes.getColor(0, Contexts.getColorByAttr(context, i));
        Context context2 = getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.c = obtainStyledAttributes.getColor(1, Contexts.getColorByAttr(context2, i));
        obtainStyledAttributes.recycle();
    }

    @Override // com.avito.android.express_cv.tabs.CvTabView
    public void bind(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.a;
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        TextViews.bindText$default(textView, upperCase, false, 2, null);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    @NotNull
    public View getView() {
        return this.d;
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(int i, int i2, boolean z) {
        CvTabView.DefaultImpls.setSelected(this, i, i2, z);
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.d = view;
    }

    @Override // com.avito.android.express_cv.tabs.CvTabView
    public void setWidth(int i) {
        this.a.getLayoutParams().width = i;
        this.a.requestLayout();
    }

    @Override // com.avito.android.ui.adapter.tab.TabItemView
    public void setSelected(boolean z) {
        this.a.setTextColor(z ? this.c : this.b);
    }
}
