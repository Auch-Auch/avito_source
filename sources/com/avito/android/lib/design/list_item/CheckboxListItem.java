package com.avito.android.lib.design.list_item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.widget.ImageViewCompat;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.toggle.Checkbox;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Views;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b:\u0010;B\u001d\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b:\u0010>B%\b\u0016\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010?\u001a\u00020\u0015¢\u0006\u0004\b:\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00042\b\b\u0003\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010\"\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010\u0018J\u001b\u0010(\u001a\u00020\u0004*\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00107\u001a\u0004\u0018\u0001028\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006A"}, d2 = {"Lcom/avito/android/lib/design/list_item/CheckboxListItem;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "Landroid/content/res/TypedArray;", "array", "", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "", "enabled", "setEnabled", "(Z)V", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onBindCheckedChangeListener", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;)V", "isChecked", "()Z", "toggle", "()V", "checked", "setChecked", "", "drawableRes", "setImageResource", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "color", "setImageColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "Landroid/view/View$OnClickListener;", "setImageClickedListener", "(Landroid/view/View$OnClickListener;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "Landroid/view/View;", "show", "setVisible", "(Landroid/view/View;Z)V", "Lcom/avito/android/lib/design/toggle/Checkbox;", "n", "Lcom/avito/android/lib/design/toggle/Checkbox;", "checkbox", "Landroid/widget/ImageView;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/ImageView;", "icon", "Landroid/widget/CompoundButton;", "o", "Landroid/widget/CompoundButton;", "getButtonView", "()Landroid/widget/CompoundButton;", "buttonView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckboxListItem extends CompoundButtonListItem {
    public final ImageView m;
    public final Checkbox n;
    @Nullable
    public final CompoundButton o;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ CheckboxListItem a;
        public final /* synthetic */ CompoundButtonListItem.OnCheckedChangeListener b;

        public a(CheckboxListItem checkboxListItem, CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener) {
            this.a = checkboxListItem;
            this.b = onCheckedChangeListener;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.onCheckedChanged(this.a, z);
        }
    }

    public CheckboxListItem(@Nullable Context context) {
        this(context, null);
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    private final void a(TypedArray typedArray) {
        Checkbox checkbox;
        int i = R.styleable.CheckboxListItem_listItem_checkboxStyle;
        if (typedArray.hasValue(i) && (checkbox = this.n) != null) {
            checkbox.setAppearance(typedArray.getResourceId(i, 0));
        }
        int i2 = R.styleable.CheckboxListItem_listItem_iconColor;
        if (typedArray.hasValue(i2)) {
            setImageColor(typedArray.getColorStateList(i2));
        }
        requestLayout();
    }

    public static /* synthetic */ void setImageDrawable$default(CheckboxListItem checkboxListItem, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            ImageView imageView = checkboxListItem.m;
            drawable = imageView != null ? imageView.getDrawable() : null;
        }
        checkboxListItem.setImageDrawable(drawable);
    }

    public static /* synthetic */ void setImageResource$default(CheckboxListItem checkboxListItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        checkboxListItem.setImageResource(i);
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem
    @Nullable
    public CompoundButton getButtonView() {
        return this.o;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        Checkbox checkbox = this.n;
        if (checkbox != null) {
            return checkbox.isChecked();
        }
        return false;
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem
    public void onBindCheckedChangeListener(@NotNull CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Checkbox checkbox = this.n;
        if (checkbox != null) {
            checkbox.setOnCheckedChangeListener(new a(this, onCheckedChangeListener));
        }
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem, com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        super.setAppearance(i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.CheckboxListItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Checkbox checkbox = this.n;
        if (checkbox != null) {
            checkbox.setChecked(z);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        Checkbox checkbox = this.n;
        if (checkbox != null) {
            checkbox.setEnabled(z);
        }
    }

    public final void setImageClickedListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setImageColor(@ColorInt int i) {
        setImageColor(ColorStateList.valueOf(i));
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        ImageView imageView = this.m;
        if (imageView != null) {
            ImageViewsKt.bindImageDrawable(imageView, drawable);
        }
        notifyLeftContainerVisibilityChanged();
    }

    public final void setImageResource(@DrawableRes int i) {
        Integer valueOf = Integer.valueOf(i);
        Drawable drawable = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            drawable = getContext().getDrawable(valueOf.intValue());
        }
        setImageDrawable(drawable);
    }

    public final void setVisible(@Nullable View view, boolean z) {
        if (z) {
            Views.show(view);
        } else {
            Views.conceal(view);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        Checkbox checkbox = this.n;
        if (checkbox != null) {
            checkbox.toggle();
        }
    }

    public CheckboxListItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setImageColor(@Nullable ColorStateList colorStateList) {
        ImageView imageView = this.m;
        if (imageView != null) {
            ImageViewCompat.setImageTintList(imageView, colorStateList);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CheckboxListItem(@org.jetbrains.annotations.Nullable android.content.Context r9, @org.jetbrains.annotations.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            int r1 = r0.intValue()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            r4 = 0
            if (r1 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r4
        L_0x0014:
            if (r0 == 0) goto L_0x001b
            int r0 = r0.intValue()
            goto L_0x001d
        L_0x001b:
            int r0 = com.avito.android.lib.design.R.attr.checkboxListItem
        L_0x001d:
            r8.<init>(r9, r10, r0)
            int r9 = com.avito.android.lib.design.R.id.design_item_icon
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r8.m = r9
            int r9 = com.avito.android.lib.design.R.id.design_item_checkbox
            android.view.View r9 = r8.findViewById(r9)
            com.avito.android.lib.design.toggle.Checkbox r9 = (com.avito.android.lib.design.toggle.Checkbox) r9
            r8.n = r9
            r8.o = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            int r11 = r9.intValue()
            if (r11 <= 0) goto L_0x0042
            r11 = 1
            goto L_0x0043
        L_0x0042:
            r11 = 0
        L_0x0043:
            if (r11 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r9 = r4
        L_0x0047:
            if (r9 == 0) goto L_0x004e
            int r9 = r9.intValue()
            goto L_0x0050
        L_0x004e:
            int r9 = com.avito.android.lib.design.R.attr.checkboxListItem
        L_0x0050:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            int r0 = r11.intValue()
            if (r0 <= 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            if (r2 == 0) goto L_0x005f
            r4 = r11
        L_0x005f:
            if (r4 == 0) goto L_0x0066
            int r11 = r4.intValue()
            goto L_0x0068
        L_0x0066:
            int r11 = com.avito.android.lib.design.R.style.Design_Widget_CheckboxListItem
        L_0x0068:
            android.content.Context r0 = r8.getContext()
            int[] r1 = com.avito.android.lib.design.R.styleable.CheckboxListItem
            android.content.res.TypedArray r9 = r0.obtainStyledAttributes(r10, r1, r9, r11)
            java.lang.String r10 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r8.a(r9)
            int r10 = com.avito.android.lib.design.R.styleable.CheckboxListItem_android_src
            android.graphics.drawable.Drawable r10 = r9.getDrawable(r10)
            r8.setImageDrawable(r10)
            int r10 = com.avito.android.lib.design.R.styleable.CheckboxListItem_listItem_checked
            boolean r10 = r9.getBoolean(r10, r3)
            r8.setChecked(r10)
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r10 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.CENTER
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.FIRST_LINE_CENTER
            r11 = 0
            r6 = 4
            r7 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            r1 = r10
            com.avito.android.lib.design.list_item.BaseListItem.setLeftAlignment$default(r0, r1, r2, r3, r4, r5)
            r2 = r10
            r3 = r11
            r4 = r6
            r5 = r7
            com.avito.android.lib.design.list_item.BaseListItem.setRightAlignment$default(r0, r1, r2, r3, r4, r5)
            r8.notifyLeftContainerVisibilityChanged()
            r8.notifyRightContainerVisibilityChanged()
            boolean r10 = r8.isEnabled()
            r8.setEnabled(r10)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.CheckboxListItem.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
