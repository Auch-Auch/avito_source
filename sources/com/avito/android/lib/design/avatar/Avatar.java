package com.avito.android.lib.design.avatar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KB\u001b\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bJ\u0010NB#\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010O\u001a\u00020\u0003¢\u0006\u0004\bJ\u0010PJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00148\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010#\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010'\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00148\u0006@FX\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR.\u0010+\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00148\u0006@FX\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR$\u00103\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R*\u0010?\u001a\u0002082\u0006\u0010\f\u001a\u0002088\u0016@VX\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010C\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b@\u0010\u001e\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R*\u0010G\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000e\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012¨\u0006Q"}, d2 = {"Lcom/avito/android/lib/design/avatar/Avatar;", "Landroidx/cardview/widget/CardView;", "Lcom/avito/android/design/ImageLoadable;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "d", "()V", "c", "value", AuthSource.OPEN_CHANNEL_LIST, "I", "getSize", "()I", "setSize", "(I)V", "size", "Landroid/graphics/drawable/Drawable;", "l", "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", "Landroid/content/res/ColorStateList;", VKApiConst.Q, "Landroid/content/res/ColorStateList;", "getTintColor", "()Landroid/content/res/ColorStateList;", "setTintColor", "(Landroid/content/res/ColorStateList;)V", "tintColor", "k", "getPlaceholderImage", "setPlaceholderImage", "placeholderImage", "j", "getPlaceholderBackground", "setPlaceholderBackground", "placeholderBackground", "Landroid/view/View;", "r", "Landroid/view/View;", "getImageContainerView", "()Landroid/view/View;", "setImageContainerView", "(Landroid/view/View;)V", "imageContainerView", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "imageView", "Lcom/avito/android/design/State;", "n", "Lcom/avito/android/design/State;", "getState", "()Lcom/avito/android/design/State;", "setState", "(Lcom/avito/android/design/State;)V", "state", "p", "getRippleColor", "setRippleColor", "rippleColor", "o", "getCornerRadius", "setCornerRadius", "cornerRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Avatar extends CardView implements ImageLoadable {
    @Nullable
    public Drawable j;
    @Nullable
    public Drawable k;
    @Nullable
    public Drawable l;
    public int m;
    @NotNull
    public State n;
    public int o;
    @NotNull
    public ColorStateList p;
    @NotNull
    public ColorStateList q;
    @Nullable
    public View r;
    public final ImageView s;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            State.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            State state = State.ERROR;
            iArr[1] = 1;
            State state2 = State.LOADED;
            iArr[2] = 2;
            State state3 = State.PLACEHOLDER;
            iArr[0] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Avatar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.n = State.LOADED;
        ColorStateList valueOf = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.TRANSPARENT)");
        this.p = valueOf;
        ColorStateList valueOf2 = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "ColorStateList.valueOf(Color.TRANSPARENT)");
        this.q = valueOf2;
        this.r = this;
        LayoutInflater.from(getContext()).inflate(R.layout.design_avatar, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.image_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.s = (ImageView) findViewById;
        setCardElevation(0.0f);
        setPreventCornerOverlap(false);
        setUseCompatPadding(false);
        b(this, null, 0, 0, 6);
    }

    public static void b(Avatar avatar, AttributeSet attributeSet, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        TypedArray obtainStyledAttributes = avatar.getContext().obtainStyledAttributes(attributeSet, R.styleable.DesignAvatar, i, i2);
        avatar.setImage(obtainStyledAttributes.getDrawable(R.styleable.DesignAvatar_android_src));
        avatar.setPlaceholderBackground(obtainStyledAttributes.getDrawable(R.styleable.DesignAvatar_avatar_placeholderBackground));
        avatar.setPlaceholderImage(obtainStyledAttributes.getDrawable(R.styleable.DesignAvatar_avatar_placeholderImage));
        avatar.setState(State.Companion.byId(obtainStyledAttributes.getInteger(R.styleable.DesignAvatar_avatar_state, avatar.getState().getId())));
        avatar.setCornerRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.DesignAvatar_avatar_cornerRadius, 0));
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.DesignAvatar_avatar_rippleColor);
        if (colorStateList == null) {
            colorStateList = avatar.p;
        }
        avatar.setRippleColor(colorStateList);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.DesignAvatar_avatar_tintColor);
        if (colorStateList2 == null) {
            colorStateList2 = avatar.q;
        }
        avatar.setTintColor(colorStateList2);
        obtainStyledAttributes.recycle();
    }

    public final void c() {
        int i = this.m;
        int i2 = this.o;
        setRadius(((float) i) / 2.0f <= ((float) i2) ? ((float) i) / 2.0f : (float) i2);
    }

    public final void d() {
        Drawable drawable;
        int ordinal = getState().ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                this.s.setImageDrawable(this.j);
            } else if (ordinal == 2) {
                this.s.setImageDrawable(getImage());
            }
        } else if (this.j != null && (drawable = this.k) != null) {
            this.s.setImageDrawable(new LayerDrawable(new Drawable[]{this.j, Contexts.getTintedDrawable(drawable, this.q.getDefaultColor())}));
        }
    }

    public final int getCornerRadius() {
        return this.o;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public Drawable getImage() {
        return this.l;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public View getImageContainerView() {
        return this.r;
    }

    @Nullable
    public final Drawable getPlaceholderBackground() {
        return this.j;
    }

    @Nullable
    public final Drawable getPlaceholderImage() {
        return this.k;
    }

    @NotNull
    public final ColorStateList getRippleColor() {
        return this.p;
    }

    public final int getSize() {
        return this.m;
    }

    @Override // com.avito.android.design.ImageLoadable
    @NotNull
    public State getState() {
        return this.n;
    }

    @NotNull
    public final ColorStateList getTintColor() {
        return this.q;
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setSize(getMeasuredHeight());
        c();
        if (this.m != 0) {
            setForeground(new RippleDrawable(this.p, null, null));
        }
        d();
    }

    public final void setCornerRadius(int i) {
        this.o = i;
        c();
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImage(@Nullable Drawable drawable) {
        this.l = drawable;
        d();
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImageContainerView(@Nullable View view) {
        this.r = view;
    }

    public final void setPlaceholderBackground(@Nullable Drawable drawable) {
        this.j = drawable;
        d();
    }

    public final void setPlaceholderImage(@Nullable Drawable drawable) {
        this.k = drawable;
        d();
    }

    public final void setRippleColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "value");
        this.p = colorStateList;
        if (this.m != 0) {
            setForeground(new RippleDrawable(this.p, null, null));
        }
    }

    public final void setSize(int i) {
        this.m = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i2 = this.m;
            layoutParams.height = i2;
            layoutParams.width = i2;
            requestLayout();
        }
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "value");
        this.n = state;
        d();
    }

    public final void setTintColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "value");
        this.q = colorStateList;
        d();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Avatar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.n = State.LOADED;
        ColorStateList valueOf = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.TRANSPARENT)");
        this.p = valueOf;
        ColorStateList valueOf2 = ColorStateList.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "ColorStateList.valueOf(Color.TRANSPARENT)");
        this.q = valueOf2;
        this.r = this;
        LayoutInflater.from(getContext()).inflate(R.layout.design_avatar, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.image_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.s = (ImageView) findViewById;
        setCardElevation(0.0f);
        setPreventCornerOverlap(false);
        setUseCompatPadding(false);
        b(this, attributeSet, 0, 0, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Avatar(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.Nullable android.util.AttributeSet r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            int r1 = r0.intValue()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001f
            int r0 = r0.intValue()
            goto L_0x0021
        L_0x001f:
            int r0 = com.avito.android.lib.design.R.attr.avatar
        L_0x0021:
            r4.<init>(r5, r6, r0)
            com.avito.android.design.State r5 = com.avito.android.design.State.LOADED
            r4.n = r5
            android.content.res.ColorStateList r5 = android.content.res.ColorStateList.valueOf(r3)
            java.lang.String r0 = "ColorStateList.valueOf(Color.TRANSPARENT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r4.p = r5
            android.content.res.ColorStateList r5 = android.content.res.ColorStateList.valueOf(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r4.q = r5
            r4.r = r4
            android.content.Context r5 = r4.getContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r0 = com.avito.android.lib.design.R.layout.design_avatar
            r5.inflate(r0, r4, r2)
            int r5 = com.avito.android.lib.design.R.id.image_view
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.ImageView"
            java.util.Objects.requireNonNull(r5, r0)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.s = r5
            r5 = 0
            r4.setCardElevation(r5)
            r4.setPreventCornerOverlap(r3)
            r4.setUseCompatPadding(r3)
            r5 = 4
            b(r4, r6, r7, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.avatar.Avatar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
