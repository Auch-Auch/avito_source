package com.avito.android.lib.design.list_item;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.list_item.BaseListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107B\u001d\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00109\u001a\u0004\u0018\u000108¢\u0006\u0004\b6\u0010:B%\b\u0016\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00109\u001a\u0004\u0018\u000108\u0012\u0006\u0010;\u001a\u00020\u0012¢\u0006\u0004\b6\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00042\b\b\u0003\u0010\u0013\u001a\u00020\u00122\b\b\u0003\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0012H\u0016¢\u0006\u0004\b%\u0010\u001cJ\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010.¨\u0006="}, d2 = {"Lcom/avito/android/lib/design/list_item/ListItem;", "Lcom/avito/android/lib/design/list_item/BaseListItem;", "Landroid/content/res/TypedArray;", "array", "", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "setMessage", "setLink", "Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "alignment", "setAlignment", "(Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;)V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "setImageResource", "(II)V", "Landroid/graphics/drawable/Drawable;", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "color", "setLeftIconColor", "(I)V", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "setRightIconColor", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRighIconClickedListener", "(Landroid/view/View$OnClickListener;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "", "enabled", "setEnabled", "(Z)V", "d", "()V", "Landroid/widget/ImageView;", "l", "Landroid/widget/ImageView;", "rightIcon", "j", "Lcom/avito/android/lib/design/list_item/BaseListItem$Alignment;", "k", "leftIcon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ListItem extends BaseListItem {
    public BaseListItem.Alignment j;
    public final ImageView k;
    public final ImageView l;

    public ListItem(@Nullable Context context) {
        this(context, null);
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem
    private final void a(TypedArray typedArray) {
        int i = R.styleable.ListItem_listItem_iconLeftColor;
        if (typedArray.hasValue(i)) {
            setLeftIconColor(typedArray.getColorStateList(i));
        }
        int i2 = R.styleable.ListItem_listItem_iconRightColor;
        if (typedArray.hasValue(i2)) {
            setRightIconColor(typedArray.getColorStateList(i2));
        }
    }

    public static /* synthetic */ void setImageDrawable$default(ListItem listItem, Drawable drawable, Drawable drawable2, int i, Object obj) {
        if ((i & 1) != 0) {
            ImageView imageView = listItem.k;
            drawable = imageView != null ? imageView.getDrawable() : null;
        }
        if ((i & 2) != 0) {
            ImageView imageView2 = listItem.l;
            drawable2 = imageView2 != null ? imageView2.getDrawable() : null;
        }
        listItem.setImageDrawable(drawable, drawable2);
    }

    public static /* synthetic */ void setImageResource$default(ListItem listItem, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        listItem.setImageResource(i, i2);
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
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = r6.j
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.avito.android.lib.design.list_item.BaseListItem.setLeftAlignment$default(r0, r1, r2, r3, r4, r5)
            goto L_0x0079
        L_0x0061:
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r2 = r6.j
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
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.ListItem.d():void");
    }

    public final void setAlignment(@NotNull BaseListItem.Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.j = alignment;
        d();
    }

    @Override // com.avito.android.lib.design.list_item.BaseListItem, com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i) {
        super.setAppearance(i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.ListItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        ImageView imageView2 = this.l;
        if (imageView2 != null) {
            imageView2.setEnabled(z);
        }
    }

    public final void setImageDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        ImageView imageView = this.k;
        if (imageView != null) {
            ImageViewsKt.bindImageDrawable(imageView, drawable);
        }
        notifyLeftContainerVisibilityChanged();
        ImageView imageView2 = this.l;
        if (imageView2 != null) {
            ImageViewsKt.bindImageDrawable(imageView2, drawable2);
        }
        notifyRightContainerVisibilityChanged();
    }

    public final void setImageResource(@DrawableRes int i, @DrawableRes int i2) {
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        Drawable drawable = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        Drawable drawable2 = valueOf != null ? getContext().getDrawable(valueOf.intValue()) : null;
        Integer valueOf2 = Integer.valueOf(i2);
        if (valueOf2.intValue() <= 0) {
            z = false;
        }
        if (!z) {
            valueOf2 = null;
        }
        if (valueOf2 != null) {
            drawable = getContext().getDrawable(valueOf2.intValue());
        }
        setImageDrawable(drawable2, drawable);
    }

    public final void setLeftIconColor(@ColorInt int i) {
        setLeftIconColor(ColorStateList.valueOf(i));
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

    public final void setRighIconClickedListener(@Nullable View.OnClickListener onClickListener) {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setRightIconColor(@ColorInt int i) {
        setRightIconColor(ColorStateList.valueOf(i));
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

    public ListItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setLeftIconColor(@Nullable ColorStateList colorStateList) {
        ImageView imageView = this.k;
        if (imageView != null) {
            ImageViewsKt.setImageTintListCompat(imageView, colorStateList);
        }
    }

    public final void setRightIconColor(@Nullable ColorStateList colorStateList) {
        ImageView imageView = this.l;
        if (imageView != null) {
            ImageViewsKt.setImageTintListCompat(imageView, colorStateList);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ListItem(@org.jetbrains.annotations.Nullable android.content.Context r6, @org.jetbrains.annotations.Nullable android.util.AttributeSet r7, int r8) {
        /*
            r5 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
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
            int r0 = com.avito.android.lib.design.R.attr.listItem
        L_0x001d:
            r5.<init>(r6, r7, r0)
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r6 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.TWO_LINES_CENTER
            r5.j = r6
            int r0 = com.avito.android.lib.design.R.id.design_item_left_icon
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r5.k = r0
            int r0 = com.avito.android.lib.design.R.id.design_item_right_icon
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r5.l = r0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r0 = r8.intValue()
            if (r0 <= 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r8 = r4
        L_0x0049:
            if (r8 == 0) goto L_0x0050
            int r8 = r8.intValue()
            goto L_0x0052
        L_0x0050:
            int r8 = com.avito.android.lib.design.R.attr.listItem
        L_0x0052:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            int r1 = r0.intValue()
            if (r1 <= 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 == 0) goto L_0x0061
            r4 = r0
        L_0x0061:
            if (r4 == 0) goto L_0x0068
            int r0 = r4.intValue()
            goto L_0x006a
        L_0x0068:
            int r0 = com.avito.android.lib.design.R.style.Design_Widget_ListItem
        L_0x006a:
            android.content.Context r1 = r5.getContext()
            int[] r2 = com.avito.android.lib.design.R.styleable.ListItem
            android.content.res.TypedArray r7 = r1.obtainStyledAttributes(r7, r2, r8, r0)
            java.lang.String r8 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r5.a(r7)
            int r8 = com.avito.android.lib.design.R.styleable.ListItem_android_drawableLeft
            android.graphics.drawable.Drawable r8 = r7.getDrawable(r8)
            int r0 = com.avito.android.lib.design.R.styleable.ListItem_android_drawableRight
            android.graphics.drawable.Drawable r0 = r7.getDrawable(r0)
            r5.setImageDrawable(r8, r0)
            int r8 = com.avito.android.lib.design.R.styleable.ListItem_listItem_alignment
            int r8 = r7.getInt(r8, r3)
            if (r8 == 0) goto L_0x0095
            com.avito.android.lib.design.list_item.BaseListItem$Alignment r6 = com.avito.android.lib.design.list_item.BaseListItem.Alignment.FIRST_LINE_CENTER
        L_0x0095:
            r5.setAlignment(r6)
            r5.d()
            r5.notifyLeftContainerVisibilityChanged()
            r5.notifyRightContainerVisibilityChanged()
            r7.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.ListItem.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
