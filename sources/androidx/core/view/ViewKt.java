package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.avito.android.remote.model.Navigation;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\u001a9\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\u000b\u001a\u00020\n*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\r\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\r\u0010\b\u001a9\u0010\u000e\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000e\u0010\b\u001a<\u0010\u0014\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0010\u001a\u00020\u000f2\b\b\u0003\u0010\u0011\u001a\u00020\u000f2\b\b\u0003\u0010\u0012\u001a\u00020\u000f2\b\b\u0003\u0010\u0013\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a<\u0010\u0018\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010\u0016\u001a\u00020\u000f2\b\b\u0003\u0010\u0011\u001a\u00020\u000f2\b\b\u0003\u0010\u0017\u001a\u00020\u000f2\b\b\u0003\u0010\u0013\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0018\u0010\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u000fH\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010 \u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\b¢\u0006\u0004\b \u0010!\u001a,\u0010\"\u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\b¢\u0006\u0004\b\"\u0010!\u001a\u001b\u0010&\u001a\u00020%*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'\u001a-\u0010+\u001a\u00020\u0005*\u00020\u00002\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b)H\b¢\u0006\u0004\b+\u0010\b\u001a9\u0010+\u001a\u00020\u0005\"\n\b\u0000\u0010,\u0018\u0001*\u00020(*\u00020\u00002\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b)H\b¢\u0006\u0004\b-\u0010\b\"\u0018\u00100\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0018\u00102\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b1\u0010/\"*\u00105\u001a\u000203*\u00020\u00002\u0006\u00104\u001a\u0002038Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108\"\u0018\u0010:\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010/\"\u0018\u0010<\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010/\"*\u0010=\u001a\u000203*\u00020\u00002\u0006\u00104\u001a\u0002038Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\b=\u00106\"\u0004\b>\u00108\"\u0018\u0010@\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010/\"*\u0010A\u001a\u000203*\u00020\u00002\u0006\u00104\u001a\u0002038Æ\u0002@Æ\u0002X\u000e¢\u0006\f\u001a\u0004\bA\u00106\"\u0004\bB\u00108\"\u0018\u0010D\u001a\u00020\u000f*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bC\u0010/¨\u0006E"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "action", "doOnNextLayout", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "doOnLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)Landroidx/core/view/OneShotPreDrawListener;", "doOnAttach", "doOnDetach", "", Tracker.Events.CREATIVE_START, "top", "end", "bottom", "updatePaddingRelative", "(Landroid/view/View;IIII)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "updatePadding", "size", "setPadding", "(Landroid/view/View;I)V", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "postOnAnimationDelayed", "Landroid/graphics/Bitmap$Config;", Navigation.CONFIG, "Landroid/graphics/Bitmap;", "drawToBitmap", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "block", "updateLayoutParams", "T", "updateLayoutParamsTyped", "getMarginRight", "(Landroid/view/View;)I", "marginRight", "getMarginTop", "marginTop", "", "value", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "getMarginStart", "marginStart", "getMarginEnd", "marginEnd", "isInvisible", "setInvisible", "getMarginBottom", "marginBottom", "isVisible", "setVisible", "getMarginLeft", "marginLeft", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class ViewKt {
    public static final void doOnAttach(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnAttach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1) { // from class: androidx.core.view.ViewKt$doOnAttach$1
                public final /* synthetic */ View a;
                public final /* synthetic */ Function1 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                    this.a.removeOnAttachStateChangeListener(this);
                    this.b.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                }
            });
        }
    }

    public static final void doOnDetach(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnDetach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (!ViewCompat.isAttachedToWindow(view)) {
            function1.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1) { // from class: androidx.core.view.ViewKt$doOnDetach$1
                public final /* synthetic */ View a;
                public final /* synthetic */ Function1 b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View view2) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View view2) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                    this.a.removeOnAttachStateChangeListener(this);
                    this.b.invoke(view2);
                }
            });
        }
    }

    public static final void doOnLayout(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnLayout");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1) { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                public final /* synthetic */ Function1 a;

                {
                    this.a = r1;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    Intrinsics.checkParameterIsNotNull(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    this.a.invoke(view2);
                }
            });
        } else {
            function1.invoke(view);
        }
    }

    public static final void doOnNextLayout(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnNextLayout");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1) { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Intrinsics.checkParameterIsNotNull(view2, "view");
                view2.removeOnLayoutChangeListener(this);
                this.a.invoke(view2);
            }
        });
    }

    @NotNull
    public static final OneShotPreDrawListener doOnPreDraw(@NotNull View view, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$doOnPreDraw");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(view, new Runnable(view, function1) { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            public final /* synthetic */ View a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.invoke(this.a);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    @NotNull
    public static final Bitmap drawToBitmap(@NotNull View view, @NotNull Bitmap.Config config) {
        Intrinsics.checkParameterIsNotNull(view, "$this$drawToBitmap");
        Intrinsics.checkParameterIsNotNull(config, Navigation.CONFIG);
        if (ViewCompat.isLaidOut(view)) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginBottom");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginLeft");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginRight");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$marginTop");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isGone");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isInvisible");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View view, long j, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(function0, "action");
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new Runnable(function0) { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        };
        view.postDelayed(viewKt$postDelayed$runnable$1, j);
        return viewKt$postDelayed$runnable$1;
    }

    @RequiresApi(16)
    @NotNull
    public static final Runnable postOnAnimationDelayed(@NotNull View view, long j, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "$this$postOnAnimationDelayed");
        Intrinsics.checkParameterIsNotNull(function0, "action");
        ViewKt$postOnAnimationDelayed$runnable$1 viewKt$postOnAnimationDelayed$runnable$1 = new Runnable(function0) { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        };
        view.postOnAnimationDelayed(viewKt$postOnAnimationDelayed$runnable$1, j);
        return viewKt$postOnAnimationDelayed$runnable$1;
    }

    public static final void setGone(@NotNull View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isGone");
        view.setVisibility(z ? 8 : 0);
    }

    public static final void setInvisible(@NotNull View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isInvisible");
        view.setVisibility(z ? 4 : 0);
    }

    public static final void setPadding(@NotNull View view, @Px int i) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setPadding");
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(@NotNull View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "$this$isVisible");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void updateLayoutParams(@NotNull View view, @NotNull Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(@NotNull View view, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(@NotNull View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePadding");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePadding");
        view.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(@NotNull View view, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePaddingRelative");
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view, "$this$updatePaddingRelative");
        view.setPaddingRelative(i, i2, i3, i4);
    }
}
