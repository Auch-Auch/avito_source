package com.avito.android.util;

import a2.g.r.g;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/avito/android/util/KeyboardVisibilitySubscription;", "Lcom/avito/android/util/KeyboardSubscription;", "", "dispose", "()V", "", "isDisposed", "()Z", "", AuthSource.SEND_ABUSE, "I", "activityConstHeight", "c", "Z", "disposed", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "displayRect", "", "e", "F", "visibleThresholdPx", AuthSource.BOOKING_ORDER, "wasOpened", "Landroid/view/ViewTreeObserver;", "f", "Landroid/view/ViewTreeObserver;", "viewTreeObserver", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", g.a, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "layoutListener", "Landroid/view/View;", "rootView", "wasInitiallyOpened", "Lkotlin/Function1;", "callback", "<init>", "(Landroid/view/View;ZLkotlin/jvm/functions/Function1;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class KeyboardVisibilitySubscription implements KeyboardSubscription {
    public int a;
    public boolean b;
    public boolean c;
    public final Rect d = new Rect();
    public final float e;
    public final ViewTreeObserver f;
    public final ViewTreeObserver.OnGlobalLayoutListener g;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ KeyboardVisibilitySubscription a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function1 d;

        public a(KeyboardVisibilitySubscription keyboardVisibilitySubscription, View view, boolean z, Function1 function1) {
            this.a = keyboardVisibilitySubscription;
            this.b = view;
            this.c = z;
            this.d = function1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.a.a == 0) {
                KeyboardVisibilitySubscription keyboardVisibilitySubscription = this.a;
                View rootView = this.b.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView.rootView");
                keyboardVisibilitySubscription.a = rootView.getHeight();
            }
            Rect rect = this.a.d;
            this.b.getWindowVisibleDisplayFrame(rect);
            int height = this.a.a - rect.height();
            boolean z = true;
            if (!this.c ? ((float) height) <= this.a.e : ((float) height) > this.a.e) {
                z = false;
            }
            if (z != this.a.b) {
                this.d.invoke(Boolean.valueOf(z));
            }
            this.a.b = z;
        }
    }

    public KeyboardVisibilitySubscription(@NotNull View view, boolean z, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.b = z;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        this.e = resources.getDisplayMetrics().density * ((float) 128);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "rootView.viewTreeObserver");
        this.f = viewTreeObserver;
        a aVar = new a(this, view, z, function1);
        this.g = aVar;
        function1.invoke(Boolean.valueOf(this.b));
        viewTreeObserver.addOnGlobalLayoutListener(aVar);
    }

    @Override // com.avito.android.util.KeyboardSubscription, io.reactivex.disposables.Disposable
    public void dispose() {
        if (!this.c) {
            this.c = true;
            ViewTreeObservers.removeGlobalLayoutListener(this.f, this.g);
        }
    }

    @Override // com.avito.android.util.KeyboardSubscription, io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.c;
    }
}
