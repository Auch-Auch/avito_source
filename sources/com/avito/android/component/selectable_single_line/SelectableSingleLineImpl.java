package com.avito.android.component.selectable_single_line;

import a2.g.r.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bB\u0010CJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0016¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010#\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0016¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u001bJ\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u001bR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010*R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010>R\u0016\u0010A\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u00103¨\u0006D"}, d2 = {"Lcom/avito/android/component/selectable_single_line/SelectableSingleLineImpl;", "Lcom/avito/android/component/selectable_single_line/SelectableSingleLine;", "", "value", "", "setValue", "(Ljava/lang/String;)V", "", ResidentialComplexModuleKt.VALUES, "setValues", "(Ljava/util/List;)V", "", "visible", "setClearButtonVisible", "(Z)V", "hasError", "setHasError", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "", "hintRes", "(I)V", "enabled", "setEnabled", "show", "()V", "hide", "Lio/reactivex/rxjava3/core/Observable;", "clearClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClearClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnClickListener", "removeOnClickListener", AuthSource.SEND_ABUSE, "Landroid/view/View;", "i", "Landroid/view/View;", "rootView", "d", "resetButton", "h", "Z", "hasValue", "Landroid/content/res/ColorStateList;", "f", "Landroid/content/res/ColorStateList;", "hintTextColor", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "hintView", "c", "valueView", "e", "iconView", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", g.a, "errorTextColor", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableSingleLineImpl implements SelectableSingleLine {
    public final Resources a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final View e;
    public final ColorStateList f;
    public final ColorStateList g;
    public boolean h;
    public final View i;

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

    public SelectableSingleLineImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.i = view;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.context.resources");
        this.a = resources;
        View findViewById = view.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.b = textView;
        View findViewById2 = view.findViewById(R.id.value);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.reset_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        ColorStateList textColors = textView.getTextColors();
        Intrinsics.checkNotNullExpressionValue(textColors, "hintView.textColors");
        this.f = textColors;
        ColorStateList colorStateList = ContextCompat.getColorStateList(view.getContext(), R.color.text_error_disableable);
        Intrinsics.checkNotNull(colorStateList);
        this.g = colorStateList;
    }

    public final void a() {
        Views.setVisible(this.e, !Views.isVisible(this.d) || !this.h);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    @NotNull
    public Observable<Unit> clearClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.i);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void hide() {
        Views.hide(this.i);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void removeOnClickListener() {
        this.i.setOnClickListener(null);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setClearButtonVisible(boolean z) {
        Views.setVisible(this.d, z);
        a();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setEnabled(boolean z) {
        Views.setViewHierarchyEnabled(this.i, z);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHasError(boolean z) {
        if (z) {
            this.b.setTextColor(this.g);
            this.c.setHintTextColor(this.g);
            return;
        }
        this.b.setTextColor(this.f);
        this.c.setHintTextColor(this.f);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "hint");
        this.b.setText(charSequence);
        this.c.setHint(charSequence);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setOnClearClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.i.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setValue(@Nullable String str) {
        setValues(CollectionsKt__CollectionsKt.listOfNotNull(str));
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setValues(@NotNull List<String> list) {
        String str;
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        TextView textView = this.c;
        if (list.size() <= 1) {
            str = (String) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        } else {
            int size = list.size();
            str = this.a.getQuantityString(R.plurals.selectable_single_line_selected, size, Integer.valueOf(size));
            Intrinsics.checkNotNullExpressionValue(str, "resources.getQuantityStr…valuesCount, valuesCount)");
        }
        textView.setText(str);
        boolean z = !list.isEmpty();
        this.h = z;
        Views.setVisible(this.b, z);
        TextView textView2 = this.c;
        boolean z2 = !this.h;
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (z2) {
            layoutParams2.addRule(15, -1);
        } else {
            layoutParams2.addRule(15, 0);
        }
        textView2.requestLayout();
        a();
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void show() {
        Views.show(this.i);
    }

    @Override // com.avito.android.component.selectable_single_line.SelectableSingleLine
    public void setHint(int i2) {
        this.b.setText(i2);
        this.c.setHint(i2);
    }
}
