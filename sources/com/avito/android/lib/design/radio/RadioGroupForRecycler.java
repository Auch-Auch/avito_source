package com.avito.android.lib.design.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.radio.RadioCheckable;
import com.avito.android.lib.design.radio.RadioGroupForRecycler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B\u0013\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)B\u001d\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B%\b\u0016\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b(\u0010.J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0019¨\u00060"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroupForRecycler;", "Landroid/widget/LinearLayout;", "", "title", MessengerShareContentUtility.SUBTITLE, "hint", "", "initField", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "Lcom/avito/android/lib/design/radio/Selectable;", "items", "Lcom/avito/android/lib/design/radio/RadioGroupForRecycler$OnSelectItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setData", "(Ljava/util/List;Lcom/avito/android/lib/design/radio/RadioGroupForRecycler$OnSelectItemListener;)V", "", "orientation", "setOrientation", "(I)V", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "subtitleView", "f", "I", "rightChildAdditionMargin", "c", "hintView", "", "Lcom/avito/android/lib/design/radio/RadioButton;", "d", "Ljava/util/List;", "radioButtons", AuthSource.SEND_ABUSE, "titleView", "e", "leftChildAdditionMargin", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnSelectItemListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupForRecycler extends LinearLayout {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final List<RadioButton> d = new ArrayList();
    public final int e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¨\u0006\u0005"}, d2 = {"Lcom/avito/android/lib/design/radio/RadioGroupForRecycler$OnSelectItemListener;", "Lkotlin/Function2;", "Lcom/avito/android/lib/design/radio/Selectable;", "", "", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnSelectItemListener extends Function2<Selectable, Boolean, Unit> {
    }

    public RadioGroupForRecycler(@Nullable Context context) {
        super(context);
        super.setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.design_radio_group_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hint)");
        TextView textView3 = (TextView) findViewById3;
        this.c = textView3;
        int paddingLeft = getPaddingLeft();
        this.e = paddingLeft;
        int paddingRight = getPaddingRight();
        this.f = paddingRight;
        Views.changePadding$default(this, 0, 0, 0, 0, 10, null);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams5 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams6 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin += paddingRight;
    }

    public final void initField(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextViews.bindText$default(this.a, charSequence, false, 2, null);
        TextViews.bindText$default(this.b, charSequence2, false, 2, null);
        TextViews.bindText$default(this.c, charSequence3, false, 2, null);
    }

    public final void setData(@NotNull List<? extends Selectable> list, @NotNull OnSelectItemListener onSelectItemListener) {
        int size;
        int i;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(onSelectItemListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.d.size() > list.size() && this.d.size() - 1 >= list.size() - 1) {
            while (true) {
                removeViewAt(getChildCount() - 1);
                this.d.remove(i);
                if (i == size) {
                    break;
                }
                i--;
            }
        }
        if (this.d.size() < list.size()) {
            int size2 = list.size();
            for (int size3 = this.d.size(); size3 < size2; size3++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                RadioButton radioButton = new RadioButton(context);
                Views.changePadding$default(radioButton, this.e, 0, this.f, 0, 10, null);
                addView(radioButton);
                this.d.add(radioButton);
            }
        }
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            RadioButton radioButton2 = this.d.get(i2);
            radioButton2.setTitle(t2.getTitle());
            radioButton2.setChecked(t2.isSelected());
            radioButton2.clearOnCheckChangeListener();
            radioButton2.addOnCheckChangeListener(new RadioCheckable.OnCheckedChangeListener(t2, this, onSelectItemListener) { // from class: com.avito.android.lib.design.radio.RadioGroupForRecycler$setData$$inlined$forEachIndexed$lambda$1
                public final /* synthetic */ Selectable a;
                public final /* synthetic */ RadioGroupForRecycler.OnSelectItemListener b;

                {
                    this.a = r1;
                    this.b = r3;
                }

                @Override // com.avito.android.lib.design.radio.RadioCheckable.OnCheckedChangeListener
                public void onCheckedChanged(@NotNull View view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "buttonView");
                    this.b.invoke(this.a, Boolean.valueOf(z));
                }
            });
            i2 = i3;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
    }

    public RadioGroupForRecycler(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.design_radio_group_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hint)");
        TextView textView3 = (TextView) findViewById3;
        this.c = textView3;
        int paddingLeft = getPaddingLeft();
        this.e = paddingLeft;
        int paddingRight = getPaddingRight();
        this.f = paddingRight;
        Views.changePadding$default(this, 0, 0, 0, 0, 10, null);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams5 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams6 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin += paddingRight;
    }

    public RadioGroupForRecycler(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.design_radio_group_layout, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = findViewById(R.id.subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.subtitle)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hint)");
        TextView textView3 = (TextView) findViewById3;
        this.c = textView3;
        int paddingLeft = getPaddingLeft();
        this.e = paddingLeft;
        int paddingRight = getPaddingRight();
        this.f = paddingRight;
        Views.changePadding$default(this, 0, 0, 0, 0, 10, null);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams4 = textView2.getLayoutParams();
        Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin += paddingRight;
        ViewGroup.LayoutParams layoutParams5 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin += paddingLeft;
        ViewGroup.LayoutParams layoutParams6 = textView3.getLayoutParams();
        Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin += paddingRight;
    }
}
