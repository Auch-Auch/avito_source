package com.avito.android.lib.expected.video_preview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.R;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001TB1\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020\u0003\u0012\b\b\u0002\u0010Q\u001a\u00020\u0003¢\u0006\u0004\bR\u0010SJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR.\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R*\u0010!\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u001a8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R.\u0010-\u001a\u0004\u0018\u00010&2\b\u0010\f\u001a\u0004\u0018\u00010&8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u0010=\u001a\u0002062\u0006\u0010\f\u001a\u0002068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010A\u001a\u0004\u0018\u00010&2\b\u0010\f\u001a\u0004\u0018\u00010&8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b>\u0010(\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R\u0016\u0010C\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u00100R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006U"}, d2 = {"Lcom/avito/android/lib/expected/video_preview/VideoPreview;", "Landroidx/cardview/widget/CardView;", "Lcom/avito/android/design/ImageLoadable;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "", AuthSource.BOOKING_ORDER, "()V", "Landroid/graphics/drawable/Drawable;", "value", "p", "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "errorView", "n", "titleView", "Lcom/avito/android/design/State;", "r", "Lcom/avito/android/design/State;", "getState", "()Lcom/avito/android/design/State;", "setState", "(Lcom/avito/android/design/State;)V", "state", VKApiConst.Q, "getPlaceholderBackground", "setPlaceholderBackground", "placeholderBackground", "", "s", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "Landroid/view/View;", "u", "Landroid/view/View;", "getImageContainerView", "()Landroid/view/View;", "setImageContainerView", "(Landroid/view/View;)V", "imageContainerView", "Lcom/avito/android/lib/expected/video_preview/VideoPreview$PreviewState;", "o", "Lcom/avito/android/lib/expected/video_preview/VideoPreview$PreviewState;", "getPreviewState", "()Lcom/avito/android/lib/expected/video_preview/VideoPreview$PreviewState;", "setPreviewState", "(Lcom/avito/android/lib/expected/video_preview/VideoPreview$PreviewState;)V", "previewState", "t", "getError", "setError", "error", "l", "contentView", "Landroid/widget/ImageView;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ProgressBar;", "j", "Landroid/widget/ProgressBar;", "progressView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "PreviewState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class VideoPreview extends CardView implements ImageLoadable {
    public ProgressBar j;
    public TextView k;
    public View l;
    public ImageView m;
    public TextView n;
    @NotNull
    public PreviewState o;
    @Nullable
    public Drawable p;
    @Nullable
    public Drawable q;
    @NotNull
    public State r;
    @Nullable
    public String s;
    @Nullable
    public String t;
    @Nullable
    public View u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/expected/video_preview/VideoPreview$PreviewState;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "value", "", AuthSource.SEND_ABUSE, "[I", "getIntArray", "()[I", "intArray", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "LOADING", "CONTENT", "ERROR", "components_release"}, k = 1, mv = {1, 4, 2})
    public enum PreviewState {
        LOADING(null),
        CONTENT(null),
        ERROR(Integer.valueOf(R.attr.state_error));
        
        @NotNull
        public final int[] a;
        @Nullable
        public final Integer b;

        /* access modifiers changed from: public */
        PreviewState(Integer num) {
            this.b = num;
            this.a = num != null ? new int[]{num.intValue()} : new int[0];
        }

        @NotNull
        public final int[] getIntArray() {
            return this.a;
        }

        @Nullable
        public final Integer getValue() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            PreviewState.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            PreviewState previewState = PreviewState.ERROR;
            iArr2[2] = 1;
            PreviewState previewState2 = PreviewState.LOADING;
            iArr2[0] = 2;
            PreviewState previewState3 = PreviewState.CONTENT;
            iArr2[1] = 3;
        }
    }

    @JvmOverloads
    public VideoPreview(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public VideoPreview(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public VideoPreview(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoPreview(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? com.avito.android.lib.design.R.style.Widget_Avito_VideoPreview : i2);
    }

    public final void b() {
        int ordinal = getState().ordinal();
        if (ordinal == 0) {
            Drawable drawable = this.q;
            if (drawable != null) {
                this.m.setImageDrawable(drawable);
            }
        } else if (ordinal == 1) {
            this.m.setImageDrawable(this.q);
        } else if (ordinal == 2) {
            this.m.setImageDrawable(getImage());
        }
    }

    @Nullable
    public final String getError() {
        return this.t;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public Drawable getImage() {
        return this.p;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public View getImageContainerView() {
        return this.u;
    }

    @Nullable
    public final Drawable getPlaceholderBackground() {
        return this.q;
    }

    @NotNull
    public final PreviewState getPreviewState() {
        return this.o;
    }

    @Override // com.avito.android.design.ImageLoadable
    @NotNull
    public State getState() {
        return this.r;
    }

    @Nullable
    public final String getTitle() {
        return this.s;
    }

    @Override // android.view.View, android.view.ViewGroup
    @NotNull
    public int[] onCreateDrawableState(int i) {
        int[] mergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(i + this.o.getIntArray().length), this.o.getIntArray());
        Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "View.mergeDrawableStates…s, previewState.intArray)");
        return mergeDrawableStates;
    }

    public final void setError(@Nullable String str) {
        this.t = str;
        this.k.setText(str);
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImage(@Nullable Drawable drawable) {
        this.p = drawable;
        b();
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImageContainerView(@Nullable View view) {
        this.u = view;
    }

    public final void setPlaceholderBackground(@Nullable Drawable drawable) {
        this.q = drawable;
        b();
    }

    public final void setPreviewState(@NotNull PreviewState previewState) {
        Intrinsics.checkNotNullParameter(previewState, "value");
        this.o = previewState;
        int ordinal = previewState.ordinal();
        if (ordinal == 0) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(0);
        } else if (ordinal == 1) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.j.setVisibility(8);
        } else if (ordinal == 2) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
        }
        refreshDrawableState();
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "value");
        this.r = state;
        b();
    }

    public final void setTitle(@Nullable String str) {
        this.s = str;
        this.n.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VideoPreview(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.o = PreviewState.LOADING;
        this.r = State.LOADED;
        this.u = this;
        View inflate = LayoutInflater.from(context).inflate(com.avito.android.lib.design.R.layout.video_preview, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(com.avito.android.lib.design.R.id.video_loader);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.video_loader)");
        this.j = (ProgressBar) findViewById;
        View findViewById2 = inflate.findViewById(com.avito.android.lib.design.R.id.video_error);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.video_error)");
        this.k = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(com.avito.android.lib.design.R.id.video_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.video_content)");
        this.l = findViewById3;
        View findViewById4 = inflate.findViewById(com.avito.android.lib.design.R.id.video_preview_image);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.video_preview_image)");
        this.m = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(com.avito.android.lib.design.R.id.video_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.video_title)");
        this.n = (TextView) findViewById5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.VideoPreview, i, i2);
        setCardElevation(0.0f);
        setPreventCornerOverlap(false);
        setUseCompatPadding(false);
        Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.VideoPreview_videoPreview_backgroundColor), null, obtainStyledAttributes.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.VideoPreview_videoPreview_cornerRadius, 0), null, 0, 0, 0, 122, null));
        setPlaceholderBackground(obtainStyledAttributes.getDrawable(com.avito.android.lib.design.R.styleable.VideoPreview_videoPreview_placeholderBackground));
        obtainStyledAttributes.recycle();
    }
}
