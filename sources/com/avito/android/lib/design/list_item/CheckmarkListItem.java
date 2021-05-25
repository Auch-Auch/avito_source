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
import com.avito.android.lib.design.list_item.BaseListItem;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.toggle.Checkmark;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Views;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DB\u001d\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bC\u0010GB%\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\u0006\u0010H\u001a\u00020\u0016¢\u0006\u0004\bC\u0010IJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010\u0011J\u0017\u0010'\u001a\u00020\u00042\b\b\u0003\u0010&\u001a\u00020\u0016¢\u0006\u0004\b'\u0010\u0019J\u0019\u0010*\u001a\u00020\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0016H\u0016¢\u0006\u0004\b-\u0010\u0019J\u001b\u00100\u001a\u00020\u0004*\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u000e¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u0010#R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010>\u001a\u0004\u0018\u0001098\u0014@\u0014X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010;¨\u0006J"}, d2 = {"Lcom/avito/android/lib/design/list_item/CheckmarkListItem;", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem;", "Landroid/content/res/TypedArray;", "array", "", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "setMessage", "setLink", "", "enabled", "setEnabled", "(Z)V", "Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "alignment", "setAlignment", "(Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;)V", "", "color", "setImageColor", "(I)V", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onBindCheckedChangeListener", "(Lcom/avito/android/lib/design/list_item/CompoundButtonListItem$OnCheckedChangeListener;)V", "isChecked", "()Z", "toggle", "()V", "checked", "setChecked", "drawableRes", "setImageResource", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "Landroid/view/View;", "show", "setVisible", "(Landroid/view/View;Z)V", "d", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "Landroid/widget/ImageView;", "n", "Landroid/widget/ImageView;", "icon", "Lcom/avito/android/lib/design/toggle/Checkmark;", "p", "Lcom/avito/android/lib/design/toggle/Checkmark;", "getButtonView", "()Lcom/avito/android/lib/design/toggle/Checkmark;", "buttonView", "o", "checkmark", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckmarkListItem extends CompoundButtonListItem {
    public BaseListItem.Alignment m;
    public final ImageView n;
    public final Checkmark o;
    @Nullable
    public final Checkmark p;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ CheckmarkListItem a;
        public final /* synthetic */ CompoundButtonListItem.OnCheckedChangeListener b;

        public a(CheckmarkListItem checkmarkListItem, CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener) {
            this.a = checkmarkListItem;
            this.b = onCheckedChangeListener;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.b.onCheckedChanged(this.a, z);
        }
    }

    public CheckmarkListItem(@Nullable Context context) {
        this(context, null);
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    private final void a(TypedArray typedArray) {
        Checkmark checkmark;
        int i = R.styleable.CheckmarkListItem_listItem_checkmarkStyle;
        if (typedArray.hasValue(i) && (checkmark = this.o) != null) {
            checkmark.setAppearance(typedArray.getResourceId(i, 0));
        }
        int i2 = R.styleable.CheckmarkListItem_listItem_iconColor;
        if (typedArray.hasValue(i2)) {
            setImageColor(typedArray.getColorStateList(i2));
        }
        requestLayout();
    }

    public static /* synthetic */ void setImageDrawable$default(CheckmarkListItem checkmarkListItem, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            ImageView imageView = checkmarkListItem.n;
            drawable = imageView != null ? imageView.getDrawable() : null;
        }
        checkmarkListItem.setImageDrawable(drawable);
    }

    public static /* synthetic */ void setImageResource$default(CheckmarkListItem checkmarkListItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        checkmarkListItem.setImageResource(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r6 = this;
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = r6.getTitle()
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = r6.getSubtitle()
            r3 = 1
            r0[r3] = r1
            java.lang.String r1 = r6.getMessage()
            r4 = 2
            r0[r4] = r1
            java.lang.String r1 = r6.getLink()
            r4 = 3
            r0[r4] = r1
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r0.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0048
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0043
            r5 = 1
            goto L_0x0044
        L_0x0043:
            r5 = 0
        L_0x0044:
            if (r5 == 0) goto L_0x0048
            r5 = 1
            goto L_0x0049
        L_0x0048:
            r5 = 0
        L_0x0049:
            if (r5 == 0) goto L_0x002c
            r1.add(r4)
            goto L_0x002c
        L_0x004f:
            int r0 = r1.size()
            if (r0 > r3) goto L_0x0061
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r1 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.CENTER
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = r6.m
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.avito.android.lib.design.list_item.BaseListItem.setLeftAlignment$default(r0, r1, r2, r3, r4, r5)
            goto L_0x0079
        L_0x0061:
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = r6.m
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r0 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.FIRST_LINE_CENTER
            if (r2 != r0) goto L_0x0070
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            r1 = r2
            com.avito.android.lib.design.list_item.BaseListItem.setLeftAlignment$default(r0, r1, r2, r3, r4, r5)
            goto L_0x0079
        L_0x0070:
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r1 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.CENTER
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.avito.android.lib.design.list_item.BaseListItem.setLeftAlignment$default(r0, r1, r2, r3, r4, r5)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.CheckmarkListItem.d():void");
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        Checkmark checkmark = this.o;
        if (checkmark != null) {
            return checkmark.isChecked();
        }
        return false;
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem
    public void onBindCheckedChangeListener(@NotNull CompoundButtonListItem.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Checkmark checkmark = this.o;
        if (checkmark != null) {
            checkmark.setOnCheckedChangeListener(new a(this, onCheckedChangeListener));
        }
    }

    public final void setAlignment(@NotNull BaseListItem.Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.m = alignment;
        d();
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem, com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        super.setAppearance(i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.CheckmarkListItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        Checkmark checkmark = this.o;
        if (checkmark != null) {
            checkmark.setChecked(z);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        Checkmark checkmark = this.o;
        if (checkmark != null) {
            checkmark.setEnabled(z);
        }
    }

    public final void setImageColor(@ColorInt int i) {
        setImageColor(ColorStateList.valueOf(i));
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        ImageView imageView = this.n;
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

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    public void setLink(@Nullable CharSequence charSequence) {
        super.setLink(charSequence);
        d();
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    public void setMessage(@Nullable CharSequence charSequence) {
        super.setMessage(charSequence);
        d();
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    public void setSubtitle(@Nullable CharSequence charSequence) {
        super.setSubtitle(charSequence);
        d();
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    public void setTitle(@Nullable CharSequence charSequence) {
        super.setTitle(charSequence);
        d();
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
        Checkmark checkmark = this.o;
        if (checkmark != null) {
            checkmark.toggle();
        }
    }

    public CheckmarkListItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem
    @Nullable
    public Checkmark getButtonView() {
        return this.p;
    }

    public final void setImageColor(@Nullable ColorStateList colorStateList) {
        ImageView imageView = this.n;
        if (imageView != null) {
            ImageViewCompat.setImageTintList(imageView, colorStateList);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CheckmarkListItem(@org.jetbrains.annotations.Nullable android.content.Context r7, @org.jetbrains.annotations.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
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
            int r0 = com.avito.android.lib.design.R.attr.checkmarkListItem
        L_0x001d:
            r6.<init>(r7, r8, r0)
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r7 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.TWO_LINES_CENTER
            r6.m = r7
            int r0 = com.avito.android.lib.design.R.id.design_item_icon
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r6.n = r0
            int r0 = com.avito.android.lib.design.R.id.design_item_checkmark
            android.view.View r0 = r6.findViewById(r0)
            com.avito.android.lib.design.toggle.Checkmark r0 = (com.avito.android.lib.design.toggle.Checkmark) r0
            r6.o = r0
            r6.p = r0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r0 = r9.intValue()
            if (r0 <= 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r9 = r4
        L_0x004b:
            if (r9 == 0) goto L_0x0052
            int r9 = r9.intValue()
            goto L_0x0054
        L_0x0052:
            int r9 = com.avito.android.lib.design.R.attr.checkmarkListItem
        L_0x0054:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            int r1 = r0.intValue()
            if (r1 <= 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            if (r2 == 0) goto L_0x0063
            r4 = r0
        L_0x0063:
            if (r4 == 0) goto L_0x006a
            int r0 = r4.intValue()
            goto L_0x006c
        L_0x006a:
            int r0 = com.avito.android.lib.design.R.style.Design_Widget_CheckmarkListItem
        L_0x006c:
            android.content.Context r1 = r6.getContext()
            int[] r2 = com.avito.android.lib.design.R.styleable.CheckmarkListItem
            android.content.res.TypedArray r8 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            java.lang.String r9 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r6.a(r8)
            int r9 = com.avito.android.lib.design.R.styleable.CheckmarkListItem_android_src
            android.graphics.drawable.Drawable r9 = r8.getDrawable(r9)
            r6.setImageDrawable(r9)
            int r9 = com.avito.android.lib.design.R.styleable.CheckmarkListItem_listItem_alignment
            int r9 = r8.getInt(r9, r3)
            if (r9 == 0) goto L_0x0091
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r7 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.FIRST_LINE_CENTER
        L_0x0091:
            r6.m = r7
            int r7 = com.avito.android.lib.design.R.styleable.CheckmarkListItem_listItem_checked
            boolean r7 = r8.getBoolean(r7, r3)
            r6.setChecked(r7)
            r6.d()
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.CENTER
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            r1 = r2
            com.avito.android.lib.design.list_item.BaseListItem.setRightAlignment$default(r0, r1, r2, r3, r4, r5)
            r6.notifyLeftContainerVisibilityChanged()
            r6.notifyRightContainerVisibilityChanged()
            boolean r7 = r6.isEnabled()
            r6.setEnabled(r7)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.CheckmarkListItem.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
