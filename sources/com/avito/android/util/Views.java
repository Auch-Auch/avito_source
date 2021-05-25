package com.avito.android.util;

import a2.a.a.n3.s;
import a2.a.a.n3.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.snackbar.proxy.SnackbarProxyKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001b\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0010\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u0000*\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u0013\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0013\u0010\u0019\u001a\u00020\u000b*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0019\u0010\r\u001a\u001b\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001d\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u001d\u0010\u0003\u001a9\u0010\"\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#\u001a\u0019\u0010\"\u001a\u00020\u0001*\u00020\u00002\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0014\u001ai\u0010.\u001a\u00020-*\u00020\u00002\b\b\u0001\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u00072\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010(\u001a\u00020\u00072\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010)2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010)2\b\b\u0003\u0010,\u001a\u00020\u0007H\u0007¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\b0\u0010#\u001aq\u0010.\u001a\u00020-*\u00020\u00002\u0006\u0010%\u001a\u0002012\b\b\u0002\u0010&\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u0001022\b\b\u0002\u0010(\u001a\u00020\u00072\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010)j\u0004\u0018\u0001`32\u0012\b\u0002\u0010+\u001a\f\u0012\u0004\u0012\u00020\u00010)j\u0002`32\b\b\u0003\u0010,\u001a\u00020\u0007H\u0007¢\u0006\u0004\b.\u00104\u001ag\u00108\u001a\u00020-*\u00020\u00002\b\b\u0001\u00105\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u0002012\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0003\u00106\u001a\u00020\u00072\b\b\u0003\u00107\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010)j\u0004\u0018\u0001`3¢\u0006\u0004\b8\u00109\u001a*\u0010:\u001a\u00028\u0000\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0007H\b¢\u0006\u0004\b:\u0010\u0011\u001a,\u0010;\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u0000*\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\u0007H\b¢\u0006\u0004\b;\u0010\u0011\u001a\u0019\u0010=\u001a\u00020\u0001*\u00020\u00002\u0006\u0010<\u001a\u00020\u000b¢\u0006\u0004\b=\u0010\u0016\u001a)\u0010@\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u000b2\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000>\"\u00020\u0000¢\u0006\u0004\b@\u0010A\u001a\u0011\u0010B\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\bB\u0010\u0003\u001a\u001d\u0010D\u001a\u00020\u0007*\u00020\u00002\b\b\u0001\u0010C\u001a\u00020\u0007H\u0007¢\u0006\u0004\bD\u0010E\u001a\u001b\u0010G\u001a\u00020F*\u00020\u00002\b\b\u0001\u0010C\u001a\u00020\u0007¢\u0006\u0004\bG\u0010H\u001a\u001b\u0010J\u001a\u00020\u0001*\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010F¢\u0006\u0004\bJ\u0010K\u001a\u001b\u0010J\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010L\u001a\u00020\u0007¢\u0006\u0004\bJ\u0010\u0014\u001a%\u0010N\u001a\u00020\u0001*\u00020\u00002\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u0002020>\"\u000202¢\u0006\u0004\bN\u0010O\u001a\u0019\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u0002020>*\u00020\u0000¢\u0006\u0004\bP\u0010Q\u001a)\u0010U\u001a\u00020T*\u00020\u00002\b\b\u0002\u0010R\u001a\u00020\u000b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0004\bU\u0010V\u001a\u001f\u0010X\u001a\u00020\u0001*\u00020\u00002\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000b0)¢\u0006\u0004\bX\u0010Y\u001a\u001f\u0010[\u001a\u00020\u0001*\u00020\u00002\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0004\b[\u0010Y\u001a\u0011\u0010\\\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\\\u0010\r\u001a)\u0010_\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010]\u001a\u00020\u000b2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0004\b_\u0010`\u001a!\u0010d\u001a\u00020\u0001*\u00020\u00002\u0006\u0010a\u001a\u00020\u00002\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010e\u001a\u0019\u0010f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bf\u0010g\u001a\u0019\u0010h\u001a\u00020\u0001*\u00020\u00002\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bh\u0010g\u001a/\u0010k\u001a\u00020j*\u00020\u00002\u0006\u0010i\u001a\u00020b2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0000¢\u0006\u0004\bk\u0010l\u001a\u0015\u0010n\u001a\u0004\u0018\u00010m*\u00020\u0000H\u0002¢\u0006\u0004\bn\u0010o\u001a'\u0010p\u001a\u00020\u0001*\u00020\u00002\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0000¢\u0006\u0004\bp\u0010Y\u001a\u0019\u0010r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010q\u001a\u00020\u0007¢\u0006\u0004\br\u0010\u0014\u001a\u0019\u0010t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010s\u001a\u00020\u0007¢\u0006\u0004\bt\u0010E\u001a\u0019\u0010t\u001a\u00020\u0007*\u00020u2\u0006\u0010s\u001a\u00020\u0007¢\u0006\u0004\bt\u0010v\u001a\u0011\u0010w\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\bw\u0010x\"\u0017\u0010z\u001a\u00020\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\by\u0010x\"\u0016\u0010{\u001a\u00020b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b{\u0010|\"\u0017\u0010~\u001a\u00020\u0007*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b}\u0010x*\u0016\u0010\"\b\u0012\u0004\u0012\u00020\u00010)2\b\u0012\u0004\u0012\u00020\u00010)\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Landroid/view/View;", "", "show", "(Landroid/view/View;)V", "hide", "conceal", "Landroid/widget/RelativeLayout$LayoutParams;", "", "verb", "deleteRule", "(Landroid/widget/RelativeLayout$LayoutParams;I)V", "", "isVisible", "(Landroid/view/View;)Z", "T", "id", "findById", "(Landroid/view/View;I)Landroid/view/View;", "degree", "rotateByShortestPath", "(Landroid/view/View;I)V", "setVisible", "(Landroid/view/View;Z)V", "enable", "disable", "fitsIntoParent", "content", "hideIfDoesNotFitIntoParent", "(Landroid/view/View;Landroid/view/View;)V", "removeFromParent", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "changePadding", "(Landroid/view/View;IIII)V", "padding", "message", "length", "actionTitle", "maxLines", "Lkotlin/Function0;", "action", "dismissAction", "backgroundColor", "Lcom/google/android/material/snackbar/Snackbar;", "showSnackBar", "(Landroid/view/View;IILjava/lang/Integer;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;I)Lcom/google/android/material/snackbar/Snackbar;", "changeMargin", "", "", "Lcom/avito/android/util/ActionHandler;", "(Landroid/view/View;Ljava/lang/CharSequence;ILjava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;I)Lcom/google/android/material/snackbar/Snackbar;", "layoutRes", "textViewId", "actionViewId", "showCustomSnackbar", "(Landroid/view/View;ILjava/lang/CharSequence;IIILjava/lang/String;Lkotlin/jvm/functions/Function0;)Lcom/google/android/material/snackbar/Snackbar;", "findView", "findViewOpt", "enabled", "setViewHierarchyEnabled", "", "view", "setViewsEnabled", "(Z[Landroid/view/View;)V", "setDefaultValues", "resId", "getColor", "(Landroid/view/View;I)I", "Landroid/graphics/drawable/Drawable;", "getDrawable", "(Landroid/view/View;I)Landroid/graphics/drawable/Drawable;", "drawable", "setBackgroundCompat", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "resourceId", "hints", "setAutofillHintsCompat", "(Landroid/view/View;[Ljava/lang/String;)V", "getAutofillHintsCompat", "(Landroid/view/View;)[Ljava/lang/String;", "canProceed", "block", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "withPreDrawListener", "(Landroid/view/View;ZLkotlin/jvm/functions/Function0;)Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "runOnPreDraw", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "onGlobalLayout", "runOnGlobalLayout", "isMeasured", "cancelOnDetach", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ensureMeasured", "(Landroid/view/View;ZLkotlin/jvm/functions/Function0;)V", "fadeOutView", "", "duration", "crossfade", "(Landroid/view/View;Landroid/view/View;J)V", "fadeIn", "(Landroid/view/View;J)V", "fadeOut", "delayInMillis", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "Lcom/avito/android/util/ViewPreDrawListener;", AuthSource.SEND_ABUSE, "(Landroid/view/View;)Lcom/avito/android/util/ViewPreDrawListener;", "runOnNextLayoutChange", "extraSpacePx", "extendTouchableArea", "dp", "dpToPx", "Landroid/content/Context;", "(Landroid/content/Context;I)I", "heightWithMargins", "(Landroid/view/View;)I", "getDefinedWidth", "definedWidth", "SEARCH_QUERY_DEBOUNCE_DURATION_MS", "J", "getDefinedHeight", "definedHeight", "ActionHandler", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Views")
public final class Views {
    public static final long SEARCH_QUERY_DEBOUNCE_DURATION_MS = 600;

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            this.a.invoke();
            return Boolean.TRUE;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setAlpha(0.0f);
            Views.show(this.a);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        public d(View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!Views.fitsIntoParent(this.b)) {
                Views.hide(this.a);
            }
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Snackbar b;

        public e(Function0 function0, Snackbar snackbar) {
            this.a = function0;
            this.b = snackbar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            this.b.dismiss();
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final ViewPreDrawListener a(View view) {
        Object tag = view.getTag(R.id.pre_draw_listener_tag);
        if (!(tag instanceof ViewPreDrawListener)) {
            tag = null;
        }
        return (ViewPreDrawListener) tag;
    }

    public static final void access$associatePreDrawListener(View view, ViewPreDrawListener viewPreDrawListener) {
        view.setTag(R.id.pre_draw_listener_tag, viewPreDrawListener);
    }

    public static final void changeMargin(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "$this$changeMargin");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            boolean z = false;
            boolean z2 = true;
            if (i < 0 || i == marginLayoutParams.leftMargin) {
                i = marginLayoutParams.leftMargin;
            } else {
                z = true;
            }
            if (i2 < 0 || i2 == marginLayoutParams.topMargin) {
                i2 = marginLayoutParams.topMargin;
            } else {
                z = true;
            }
            if (i3 < 0 || i3 == marginLayoutParams.rightMargin) {
                i3 = marginLayoutParams.rightMargin;
            } else {
                z = true;
            }
            if (i4 < 0 || i4 == marginLayoutParams.bottomMargin) {
                i4 = marginLayoutParams.bottomMargin;
                z2 = z;
            }
            if (z2) {
                marginLayoutParams.setMargins(i, i2, i3, i4);
                view.requestLayout();
            }
        }
    }

    public static /* synthetic */ void changeMargin$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = -1;
        }
        if ((i5 & 2) != 0) {
            i2 = -1;
        }
        if ((i5 & 4) != 0) {
            i3 = -1;
        }
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        changeMargin(view, i, i2, i3, i4);
    }

    public static final void changePadding(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "$this$changePadding");
        view.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void changePadding$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
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
        changePadding(view, i, i2, i3, i4);
    }

    public static final void conceal(@Nullable View view) {
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
    }

    public static final void crossfade(@NotNull View view, @NotNull View view2, long j) {
        Intrinsics.checkNotNullParameter(view, "$this$crossfade");
        Intrinsics.checkNotNullParameter(view2, "fadeOutView");
        fadeIn(view, j);
        fadeOut(view2, j);
    }

    public static final void deleteRule(@Nullable RelativeLayout.LayoutParams layoutParams, int i) {
        if (layoutParams != null) {
            layoutParams.addRule(i, 0);
        }
    }

    public static final void disable(@Nullable View view) {
        if (view != null && view.isEnabled()) {
            view.setEnabled(false);
        }
    }

    public static final int dpToPx(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$dpToPx");
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (((float) i) * resources.getDisplayMetrics().density);
    }

    public static final void enable(@Nullable View view) {
        if (view != null && !view.isEnabled()) {
            view.setEnabled(true);
        }
    }

    public static final void ensureMeasured(@NotNull View view, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$ensureMeasured");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (isMeasured(view)) {
            function0.invoke();
            return;
        }
        a aVar = new a(function0);
        ViewPreDrawListener a3 = a(view);
        if (a3 == null) {
            a3 = new ViewPreDrawListener(view, aVar, z);
        }
        Intrinsics.checkNotNullParameter(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a3.d = new s(aVar);
        a3.a();
        view.setTag(R.id.pre_draw_listener_tag, a3);
    }

    public static /* synthetic */ void ensureMeasured$default(View view, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        ensureMeasured(view, z, function0);
    }

    public static final void extendTouchableArea(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$extendTouchableArea");
        ViewParent parent = view.getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view2 = (View) parent;
        if (view2 != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            if (rect.isEmpty()) {
                Logs.verbose$default("Views", "extendTouchableArea(): Hit rect is empty! Has the view been laid out?", null, 4, null);
            }
            rect.top -= i;
            rect.bottom += i;
            rect.left -= i;
            rect.right += i;
            view2.setTouchDelegate(new TouchDelegate(rect, view));
            return;
        }
        Logs.debug$default("Views", "extendTouchableArea(): view doesn't not have parent", null, 4, null);
    }

    public static final void fadeIn(@NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(view, "$this$fadeIn");
        if (view.getVisibility() != 0 || view.getAlpha() != 1.0f) {
            view.animate().alpha(1.0f).setDuration(j).withStartAction(new b(view));
        }
    }

    public static final void fadeOut(@NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(view, "$this$fadeOut");
        if (view.getAlpha() != 0.0f && view.getVisibility() != 8) {
            view.animate().alpha(0.0f).setDuration(j).withEndAction(new v(new Function0<Unit>(view) { // from class: com.avito.android.util.Views.c
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    Views.hide((View) this.receiver);
                    return Unit.INSTANCE;
                }
            }));
        }
    }

    public static final <T extends View> T findById(@NotNull View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findById");
        return (T) view.findViewById(i);
    }

    public static final /* synthetic */ <T extends View> T findView(View view, @IdRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$findView");
        T t = (T) view.findViewById(i);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }

    public static final boolean fitsIntoParent(@Nullable View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        boolean z = view.getTop() >= viewGroup.getPaddingTop();
        boolean z2 = view.getBottom() <= viewGroup.getHeight() - viewGroup.getPaddingBottom();
        boolean z3 = view.getLeft() >= viewGroup.getPaddingLeft();
        boolean z4 = view.getRight() <= viewGroup.getWidth() - viewGroup.getPaddingRight();
        if (!z || !z2 || !z3 || !z4) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String[] getAutofillHintsCompat(@NotNull View view) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(view, "$this$getAutofillHintsCompat");
        if (Build.VERSION.SDK_INT < 26) {
            return new String[0];
        }
        String[] autofillHints = view.getAutofillHints();
        if (autofillHints == null || (filterNotNull = ArraysKt___ArraysKt.filterNotNull(autofillHints)) == null) {
            return new String[0];
        }
        Object[] array = filterNotNull.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @ColorInt
    public static final int getColor(@NotNull View view, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$getColor");
        return ContextCompat.getColor(view.getContext(), i);
    }

    public static final int getDefinedHeight(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$definedHeight");
        if (view.getHeight() != 0) {
            return view.getHeight();
        }
        if (view.getMeasuredHeight() != 0) {
            return view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return Math.max(layoutParams != null ? layoutParams.height : 0, 0);
    }

    public static final int getDefinedWidth(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$definedWidth");
        if (view.getWidth() != 0) {
            return view.getWidth();
        }
        if (view.getMeasuredWidth() != 0) {
            return view.getMeasuredWidth();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return Math.max(layoutParams != null ? layoutParams.width : 0, 0);
    }

    @NotNull
    public static final Drawable getDrawable(@NotNull View view, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$getDrawable");
        Drawable drawable = view.getContext().getDrawable(i);
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
        return drawable;
    }

    public static final int heightWithMargins(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$heightWithMargins");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static final void hide(@Nullable View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static final void hideIfDoesNotFitIntoParent(@Nullable View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "content");
        if (view != null) {
            view2.post(new d(view, view2));
        }
    }

    public static final boolean isMeasured(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isMeasured");
        return getDefinedWidth(view) > 0 && getDefinedHeight(view) > 0;
    }

    public static final boolean isVisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull View view, long j, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$postDelayed");
        Intrinsics.checkNotNullParameter(function0, "action");
        Views$postDelayed$runnable$1 views$postDelayed$runnable$1 = new Runnable(function0) { // from class: com.avito.android.util.Views$postDelayed$runnable$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();
            }
        };
        view.postDelayed(views$postDelayed$runnable$1, j);
        return views$postDelayed$runnable$1;
    }

    public static final void removeFromParent(@Nullable View view) {
        ViewParent parent;
        if (view != null && (parent = view.getParent()) != null) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static final void rotateByShortestPath(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$rotateByShortestPath");
        if (Math.abs(((float) i) - view.getRotation()) > ((float) 180)) {
            i = (i - 360) % 360;
        }
        view.animate().rotation((float) i);
    }

    public static final void runOnGlobalLayout(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$runOnGlobalLayout");
        Intrinsics.checkNotNullParameter(function0, "onGlobalLayout");
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Views$runOnGlobalLayout$listener$1 views$runOnGlobalLayout$listener$1 = new ViewTreeObserver.OnGlobalLayoutListener(viewTreeObserver, function0) { // from class: com.avito.android.util.Views$runOnGlobalLayout$listener$1
            public final /* synthetic */ ViewTreeObserver a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver2 = this.a;
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver2, "treeObserver");
                if (viewTreeObserver2.isAlive()) {
                    ViewTreeObserver viewTreeObserver3 = this.a;
                    Intrinsics.checkNotNullExpressionValue(viewTreeObserver3, "treeObserver");
                    ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver3, this);
                }
                this.b.invoke();
            }
        };
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "treeObserver");
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(views$runOnGlobalLayout$listener$1);
        }
    }

    public static final void runOnNextLayoutChange(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$runOnNextLayoutChange");
        Intrinsics.checkNotNullParameter(function0, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(view, function0) { // from class: com.avito.android.util.Views$runOnNextLayoutChange$1
            public final /* synthetic */ View a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@Nullable View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.b.invoke();
                this.a.removeOnLayoutChangeListener(this);
            }
        });
    }

    public static final void runOnPreDraw(@NotNull View view, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$runOnPreDraw");
        Intrinsics.checkNotNullParameter(function0, "onPreDraw");
        ViewPreDrawListener a3 = a(view);
        if (a3 == null) {
            a3 = new ViewPreDrawListener(view, function0, true);
        }
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a3.d = new s(function0);
        a3.a();
        view.setTag(R.id.pre_draw_listener_tag, a3);
    }

    public static final void setAutofillHintsCompat(@NotNull View view, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(view, "$this$setAutofillHintsCompat");
        Intrinsics.checkNotNullParameter(strArr, "hints");
        if (Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public static final void setBackgroundCompat(@NotNull View view, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "$this$setBackgroundCompat");
        view.setBackground(drawable);
    }

    public static final void setDefaultValues(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$setDefaultValues");
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setPivotY((float) (view.getMeasuredHeight() / 2));
        view.setPivotX((float) (view.getMeasuredWidth() / 2));
        ViewPropertyAnimatorCompat interpolator = ViewCompat.animate(view).setInterpolator(null);
        Intrinsics.checkNotNullExpressionValue(interpolator, "ViewCompat.animate(this).setInterpolator(null)");
        interpolator.setStartDelay(0);
    }

    public static final void setViewHierarchyEnabled(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$this$setViewHierarchyEnabled");
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int childCount = viewGroup.getChildCount() - 1;
            if (childCount >= 0) {
                while (true) {
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    setViewHierarchyEnabled(childAt, z);
                    if (i != childCount) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static final void setViewsEnabled(boolean z, @NotNull View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "view");
        for (View view : viewArr) {
            view.setEnabled(z);
        }
    }

    public static final void setVisible(@Nullable View view, boolean z) {
        if (z) {
            show(view);
        } else {
            hide(view);
        }
    }

    public static final void show(@Nullable View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    @NotNull
    public static final Snackbar showCustomSnackbar(@NotNull View view, @LayoutRes int i, @NotNull CharSequence charSequence, int i2, @IdRes int i3, @IdRes int i4, @Nullable String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$showCustomSnackbar");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        Snackbar make$default = AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, view, charSequence, i2, null, 0, null, null, 0, 0, 0, 1016, null);
        View view2 = make$default.getView();
        Objects.requireNonNull(view2, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view2;
        View findViewById = snackbarLayout.findViewById(R.id.snackbar_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setVisibility(4);
        TextView textView = null;
        View inflate = LayoutInflater.from(view.getContext()).inflate(i, (ViewGroup) null);
        if (i3 != 0) {
            View findViewById2 = inflate.findViewById(i3);
            if (!(findViewById2 instanceof TextView)) {
                findViewById2 = null;
            }
            TextView textView2 = (TextView) findViewById2;
            if (textView2 != null) {
                TextViews.bindText$default(textView2, charSequence, false, 2, null);
            }
        }
        if (i4 != 0) {
            View findViewById3 = inflate.findViewById(i4);
            if (findViewById3 != null) {
                findViewById3.setOnClickListener(new e(function0, make$default));
            }
            if (str != null) {
                if (findViewById3 instanceof TextView) {
                    textView = findViewById3;
                }
                TextView textView3 = textView;
                if (textView3 != null) {
                    textView3.setText(str);
                }
            }
        }
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        make$default.show();
        return make$default;
    }

    public static /* synthetic */ Snackbar showCustomSnackbar$default(View view, int i, CharSequence charSequence, int i2, int i3, int i4, String str, Function0 function0, int i5, Object obj) {
        String str2 = (i5 & 2) != 0 ? "" : charSequence;
        int i6 = 0;
        int i7 = (i5 & 4) != 0 ? 0 : i2;
        int i8 = (i5 & 8) != 0 ? 0 : i3;
        if ((i5 & 16) == 0) {
            i6 = i4;
        }
        Function0 function02 = null;
        String str3 = (i5 & 32) != 0 ? null : str;
        if ((i5 & 64) == 0) {
            function02 = function0;
        }
        return showCustomSnackbar(view, i, str2, i7, i8, i6, str3, function02);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i) {
        return showSnackBar$default(view, i, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2) {
        return showSnackBar$default(view, i, i2, (Integer) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2, @StringRes @Nullable Integer num) {
        return showSnackBar$default(view, i, i2, num, 0, (Function0) null, (Function0) null, 0, 120, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2, @StringRes @Nullable Integer num, int i3) {
        return showSnackBar$default(view, i, i2, num, i3, (Function0) null, (Function0) null, 0, 112, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2, @StringRes @Nullable Integer num, int i3, @Nullable Function0<Unit> function0) {
        return showSnackBar$default(view, i, i2, num, i3, function0, (Function0) null, 0, 96, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2, @StringRes @Nullable Integer num, int i3, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        return showSnackBar$default(view, i, i2, num, i3, function0, function02, 0, 64, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @StringRes int i, int i2, @StringRes @Nullable Integer num, int i3, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02, @ColorRes int i4) {
        String str;
        int i5;
        Intrinsics.checkNotNullParameter(view, "$this$showSnackBar");
        Intrinsics.checkNotNullParameter(function02, "dismissAction");
        String string = view.getResources().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(message)");
        if (num != null) {
            str = view.getResources().getString(num.intValue());
        } else {
            str = null;
        }
        if (i4 == 0) {
            i5 = 0;
        } else {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            i5 = Contexts.getColorCompat(context, i4);
        }
        return showSnackBar(view, string, i2, str, i3, function0, function02, i5);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence) {
        return showSnackBar$default(view, charSequence, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i) {
        return showSnackBar$default(view, charSequence, i, (String) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str) {
        return showSnackBar$default(view, charSequence, i, str, 0, (Function0) null, (Function0) null, 0, 120, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str, int i2) {
        return showSnackBar$default(view, charSequence, i, str, i2, (Function0) null, (Function0) null, 0, 112, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str, int i2, @Nullable Function0<Unit> function0) {
        return showSnackBar$default(view, charSequence, i, str, i2, function0, (Function0) null, 0, 96, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str, int i2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        return showSnackBar$default(view, charSequence, i, str, i2, function0, function02, 0, 64, (Object) null);
    }

    public static /* synthetic */ Snackbar showSnackBar$default(View view, int i, int i2, Integer num, int i3, Function0 function0, Function0 function02, int i4, int i5, Object obj) {
        int i6 = (i5 & 2) != 0 ? -1 : i2;
        Function0 function03 = null;
        Integer num2 = (i5 & 4) != 0 ? null : num;
        int i7 = (i5 & 8) != 0 ? 2 : i3;
        if ((i5 & 16) == 0) {
            function03 = function0;
        }
        return showSnackBar(view, i, i6, num2, i7, function03, (i5 & 32) != 0 ? f.a : function02, (i5 & 64) != 0 ? 0 : i4);
    }

    @NotNull
    public static final ViewTreeObserver.OnPreDrawListener withPreDrawListener(@NotNull View view, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$withPreDrawListener");
        Intrinsics.checkNotNullParameter(function0, "block");
        Views$withPreDrawListener$listener$1 views$withPreDrawListener$listener$1 = new ViewTreeObserver.OnPreDrawListener(view, function0, z) { // from class: com.avito.android.util.Views$withPreDrawListener$listener$1
            public final /* synthetic */ View a;
            public final /* synthetic */ Function0 b;
            public final /* synthetic */ boolean c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
                if (viewTreeObserver.isAlive()) {
                    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                this.b.invoke();
                return this.c;
            }
        };
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
        if (viewTreeObserver.isAlive()) {
            view.getViewTreeObserver().addOnPreDrawListener(views$withPreDrawListener$listener$1);
        }
        return views$withPreDrawListener$listener$1;
    }

    public static /* synthetic */ ViewTreeObserver.OnPreDrawListener withPreDrawListener$default(View view, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return withPreDrawListener(view, z, function0);
    }

    public static final void changePadding(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$changePadding");
        changePadding(view, i, i, i, i);
    }

    public static final int dpToPx(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$dpToPx");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (((float) i) * resources.getDisplayMetrics().density);
    }

    public static final void setBackgroundCompat(@NotNull View view, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(view, "$this$setBackgroundCompat");
        setBackgroundCompat(view, view.getContext().getDrawable(i));
    }

    public static /* synthetic */ Snackbar showSnackBar$default(View view, CharSequence charSequence, int i, String str, int i2, Function0 function0, Function0 function02, int i3, int i4, Object obj) {
        int i5 = (i4 & 2) != 0 ? -1 : i;
        Function0 function03 = null;
        String str2 = (i4 & 4) != 0 ? null : str;
        int i6 = (i4 & 8) != 0 ? 2 : i2;
        if ((i4 & 16) == 0) {
            function03 = function0;
        }
        return showSnackBar(view, charSequence, i5, str2, i6, function03, (i4 & 32) != 0 ? g.a : function02, (i4 & 64) != 0 ? 0 : i3);
    }

    @JvmOverloads
    @NotNull
    public static final Snackbar showSnackBar(@NotNull View view, @NotNull CharSequence charSequence, int i, @Nullable String str, int i2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02, @ColorInt int i3) {
        Intrinsics.checkNotNullParameter(view, "$this$showSnackBar");
        Intrinsics.checkNotNullParameter(charSequence, "message");
        Intrinsics.checkNotNullParameter(function02, "dismissAction");
        Snackbar make$default = AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, view, charSequence, i, str, i2, function0, function02, i3, 0, 0, 768, null);
        SnackbarProxyKt.showSnackbar(make$default);
        return make$default;
    }
}
