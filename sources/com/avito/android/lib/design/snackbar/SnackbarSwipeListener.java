package com.avito.android.lib.design.snackbar;

import android.view.MotionEvent;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/snackbar/SnackbarSwipeListener;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "", "value", "", "onStart", "(F)V", "onMove", "onFinish", "()V", AuthSource.SEND_ABUSE, "F", "previousY", "<init>", "components_release"}, k = 1, mv = {1, 4, 2})
public class SnackbarSwipeListener implements View.OnTouchListener {
    public float a;

    public void onFinish() {
    }

    public void onMove(float f) {
    }

    public void onStart(float f) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            onStart(motionEvent.getY());
        } else if (action == 1) {
            onFinish();
        } else if (action == 2) {
            onMove(motionEvent.getY() - this.a);
        }
        this.a = motionEvent.getY();
        return true;
    }
}
