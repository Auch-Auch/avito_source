package ru.avito.component.appbar.floating_toolbar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import androidx.core.view.GestureDetectorCompat;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lru/avito/component/appbar/floating_toolbar/FloatingToolbarScrollViewOnTouchListener;", "Landroid/view/View$OnTouchListener;", "Lru/avito/component/appbar/floating_toolbar/ToolbarScrollManager;", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "showToolbar", "()V", "isScrolled", "()Z", "Landroid/widget/ScrollView;", "d", "Landroid/widget/ScrollView;", "scrollView", "Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", "floatingToolbar", "Landroidx/core/view/GestureDetectorCompat;", "c", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "", AuthSource.SEND_ABUSE, "I", "verticalOffset", "toolbarContainer", "toolbar", "shadow", "needToHideShadow", "<init>", "(Landroid/widget/ScrollView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingToolbarScrollViewOnTouchListener implements View.OnTouchListener, ToolbarScrollManager {
    public int a;
    public final FloatingToolbar b;
    public final GestureDetectorCompat c;
    public final ScrollView d;

    public FloatingToolbarScrollViewOnTouchListener(@NotNull ScrollView scrollView, @NotNull View view, @NotNull View view2, @NotNull View view3, boolean z) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(view, "toolbarContainer");
        Intrinsics.checkNotNullParameter(view2, "toolbar");
        Intrinsics.checkNotNullParameter(view3, "shadow");
        this.d = scrollView;
        this.b = new FloatingToolbarImpl(view, view2, view3, z);
        this.c = new GestureDetectorCompat(scrollView.getContext(), new GestureDetector.SimpleOnGestureListener(this) { // from class: ru.avito.component.appbar.floating_toolbar.FloatingToolbarScrollViewOnTouchListener$gestureDetector$1
            public final /* synthetic */ FloatingToolbarScrollViewOnTouchListener a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f, float f2) {
                Intrinsics.checkNotNullParameter(motionEvent, "e1");
                Intrinsics.checkNotNullParameter(motionEvent2, "e2");
                FloatingToolbarScrollViewOnTouchListener floatingToolbarScrollViewOnTouchListener = this.a;
                floatingToolbarScrollViewOnTouchListener.a = floatingToolbarScrollViewOnTouchListener.d.getScrollY();
                this.a.b.onContentScroll((int) f2, this.a.a);
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
        });
    }

    @Override // ru.avito.component.appbar.floating_toolbar.ToolbarScrollManager
    public boolean isScrolled() {
        return this.a != 0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, VKApiConst.VERSION);
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getAction() == 1) {
            this.b.adjustToolbarVisibility();
            view.performClick();
        }
        return this.c.onTouchEvent(motionEvent);
    }

    @Override // ru.avito.component.appbar.floating_toolbar.ToolbarScrollManager
    public void showToolbar() {
        this.b.showToolbar();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatingToolbarScrollViewOnTouchListener(ScrollView scrollView, View view, View view2, View view3, boolean z, int i, j jVar) {
        this(scrollView, view, view2, view3, (i & 16) != 0 ? true : z);
    }
}
