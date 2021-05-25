package com.avito.android.id_overlay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/id_overlay/IdOverlayView;", "Landroid/gesture/GestureOverlayView;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "Lcom/avito/android/id_overlay/ViewOverlay;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "overlays", AuthSource.BOOKING_ORDER, "Lcom/avito/android/id_overlay/ViewOverlay;", "rootOverlay", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "activity", "Landroid/gesture/GestureLibrary;", "c", "Landroid/gesture/GestureLibrary;", "gestureLibrary", "<init>", "(Landroid/app/Activity;)V", "id-overlay_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ViewConstructor"})
public final class IdOverlayView extends GestureOverlayView {
    public final List<ViewOverlay> a = new ArrayList();
    public final ViewOverlay b;
    public final GestureLibrary c;
    public final Activity d;

    public static final class a implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ IdOverlayView a;

        public a(IdOverlayView idOverlayView) {
            this.a = idOverlayView;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.a.postInvalidate();
        }
    }

    public static final class b implements GestureOverlayView.OnGesturePerformedListener {
        public final /* synthetic */ IdOverlayView a;

        public b(IdOverlayView idOverlayView) {
            this.a = idOverlayView;
        }

        @Override // android.gesture.GestureOverlayView.OnGesturePerformedListener
        public final void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
            IdOverlayView idOverlayView = this.a;
            Intrinsics.checkNotNullExpressionValue(gesture, "gesture");
            IdOverlayView.access$checkGesture(idOverlayView, gesture);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IdOverlayView(@NotNull Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.d = activity;
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        this.b = new ViewOverlay(simpleName, decorView);
        GestureLibrary fromRawResource = GestureLibraries.fromRawResource(activity, R.raw.round_above);
        Intrinsics.checkNotNullExpressionValue(fromRawResource, "GestureLibraries.fromRaw…ivity, R.raw.round_above)");
        this.c = fromRawResource;
        View peekDecorView = activity.getWindow().peekDecorView();
        Intrinsics.checkNotNullExpressionValue(peekDecorView, "activity.window.peekDecorView()");
        peekDecorView.getViewTreeObserver().addOnDrawListener(new a(this));
        if (!fromRawResource.load()) {
            Logs.error$default("IdOverlayView", "Cannot load gestures", null, 4, null);
        }
        addOnGesturePerformedListener(new b(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00be A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$checkGesture(com.avito.android.id_overlay.IdOverlayView r8, android.gesture.Gesture r9) {
        /*
            android.gesture.GestureLibrary r0 = r8.c
            java.util.ArrayList r0 = r0.recognize(r9)
            java.lang.String r1 = "gestureLibrary.recognize(gesture)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r0.next()
            r3 = r2
            android.gesture.Prediction r3 = (android.gesture.Prediction) r3
            double r3 = r3.score
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x002b
            r3 = 1
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x0014
            r1.add(r2)
            goto L_0x0014
        L_0x0032:
            com.avito.android.id_overlay.IdOverlayView$checkGesture$$inlined$sortedBy$1 r0 = new com.avito.android.id_overlay.IdOverlayView$checkGesture$$inlined$sortedBy$1
            r0.<init>()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, r0)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0)
            android.gesture.Prediction r0 = (android.gesture.Prediction) r0
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r0.name
            java.lang.String r1 = "round_above"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x00ca
            android.graphics.RectF r0 = r9.getBoundingBox()
            float r0 = r0.centerX()
            int r0 = (int) r0
            android.graphics.RectF r9 = r9.getBoundingBox()
            float r9 = r9.centerY()
            int r9 = (int) r9
            java.util.List<com.avito.android.id_overlay.ViewOverlay> r1 = r8.a
            r1.clear()
            android.app.Activity r1 = r8.d
            android.view.Window r1 = r1.getWindow()
            java.lang.String r2 = "activity.window"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.view.View r1 = r1.getDecorView()
            java.lang.String r2 = "null cannot be cast to non-null type android.view.ViewGroup"
            java.util.Objects.requireNonNull(r1, r2)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.view.View r9 = com.avito.android.id_overlay.ViewExtensionsKt.findViewAt(r1, r0, r9)
        L_0x007e:
            if (r9 == 0) goto L_0x00c2
            r0 = 0
            android.app.Activity r1 = r8.d     // Catch:{ Exception -> 0x0092 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0092 }
            if (r1 == 0) goto L_0x0092
            int r2 = r9.getId()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r1 = r1.getResourceEntryName(r2)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0093
        L_0x0092:
            r1 = r0
        L_0x0093:
            if (r1 == 0) goto L_0x00b4
            java.util.List<com.avito.android.id_overlay.ViewOverlay> r2 = r8.a
            com.avito.android.id_overlay.ViewOverlay r3 = new com.avito.android.id_overlay.ViewOverlay
            java.lang.String r4 = " : "
            java.lang.StringBuilder r1 = a2.b.a.a.a.Q(r1, r4)
            java.lang.Class r4 = r9.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r3.<init>(r1, r9)
            r2.add(r3)
        L_0x00b4:
            android.view.ViewParent r9 = r9.getParent()
            boolean r1 = r9 instanceof android.view.View
            if (r1 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r0 = r9
        L_0x00be:
            r9 = r0
            android.view.View r9 = (android.view.View) r9
            goto L_0x007e
        L_0x00c2:
            java.util.List<com.avito.android.id_overlay.ViewOverlay> r9 = r8.a
            t6.n.j.reverse(r9)
            r8.postInvalidate()
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.id_overlay.IdOverlayView.access$checkGesture(com.avito.android.id_overlay.IdOverlayView, android.gesture.Gesture):void");
    }

    @Override // android.gesture.GestureOverlayView, android.view.View, android.view.ViewGroup
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return this.d.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        ViewOverlay.paintOn$default(this.b, canvas, 0, getTop(), 2, null);
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            ViewOverlay.paintOn$default(it.next(), canvas, 0, 0, 6, null);
        }
    }
}
