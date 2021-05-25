package com.avito.android.lib.expected.badge_bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020'¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u00178\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u0006,"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/ImageLoadableView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/avito/android/design/ImageLoadable;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/design/State;", "value", "e", "Lcom/avito/android/design/State;", "getState", "()Lcom/avito/android/design/State;", "setState", "(Lcom/avito/android/design/State;)V", "state", "Landroid/view/View;", "f", "Landroid/view/View;", "getImageContainerView", "()Landroid/view/View;", "setImageContainerView", "(Landroid/view/View;)V", "imageContainerView", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", "c", "getPlaceholderDrawable", "setPlaceholderDrawable", "placeholderDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageLoadableView extends AppCompatImageView implements ImageLoadable {
    @Nullable
    public Drawable c;
    @Nullable
    public Drawable d;
    @NotNull
    public State e;
    @Nullable
    public View f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            State.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            State state = State.LOADED;
            iArr[2] = 1;
        }
    }

    @JvmOverloads
    public ImageLoadableView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public ImageLoadableView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public ImageLoadableView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageLoadableView(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.imageLoadableView : i, (i3 & 8) != 0 ? R.style.Design_Widget_ImageLoadableView : i2);
    }

    public final void a() {
        if (getState().ordinal() != 2) {
            setImageDrawable(this.c);
        } else {
            setImageDrawable(getImage());
        }
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public Drawable getImage() {
        return this.d;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public View getImageContainerView() {
        return this.f;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.c;
    }

    @Override // com.avito.android.design.ImageLoadable
    @NotNull
    public State getState() {
        return this.e;
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImage(@Nullable Drawable drawable) {
        this.d = drawable;
        a();
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImageContainerView(@Nullable View view) {
        this.f = view;
    }

    public final void setPlaceholderDrawable(@Nullable Drawable drawable) {
        this.c = drawable;
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "value");
        this.e = state;
        a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageLoadableView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageLoadableView, i, i2);
        int i3 = R.styleable.ImageLoadableView_imageLoadableView_placeholder;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.c = ContextCompat.getDrawable(context, obtainStyledAttributes.getResourceId(i3, 0));
        }
        obtainStyledAttributes.recycle();
        this.e = State.PLACEHOLDER;
        this.f = this;
    }
}
