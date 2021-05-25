package com.otaliastudios.cameraview.markers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.R;
public class DefaultAutoFocusMarker implements AutoFocusMarker {
    @VisibleForTesting
    public View a;
    @VisibleForTesting
    public View b;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            DefaultAutoFocusMarker.a(DefaultAutoFocusMarker.this.a, 1.36f, 0.0f, 200, 1000, null);
        }
    }

    public static void a(@NonNull View view, float f, float f2, long j, long j2, @Nullable Animator.AnimatorListener animatorListener) {
        view.animate().scaleX(f).scaleY(f).alpha(f2).setDuration(j).setStartDelay(j2).setListener(animatorListener).start();
    }

    @Override // com.otaliastudios.cameraview.markers.Marker
    @Nullable
    public View onAttach(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_layout_focus_marker, viewGroup, false);
        this.a = inflate.findViewById(R.id.focusMarkerContainer);
        this.b = inflate.findViewById(R.id.focusMarkerFill);
        return inflate;
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public void onAutoFocusEnd(@NonNull AutoFocusTrigger autoFocusTrigger, boolean z, @NonNull PointF pointF) {
        if (autoFocusTrigger != AutoFocusTrigger.METHOD) {
            if (z) {
                a(this.a, 1.0f, 0.0f, 500, 0, null);
                a(this.b, 1.0f, 0.0f, 500, 0, null);
                return;
            }
            a(this.b, 0.0f, 0.0f, 500, 0, null);
            a(this.a, 1.36f, 1.0f, 500, 0, new a());
        }
    }

    @Override // com.otaliastudios.cameraview.markers.AutoFocusMarker
    public void onAutoFocusStart(@NonNull AutoFocusTrigger autoFocusTrigger, @NonNull PointF pointF) {
        if (autoFocusTrigger != AutoFocusTrigger.METHOD) {
            this.a.clearAnimation();
            this.b.clearAnimation();
            this.a.setScaleX(1.36f);
            this.a.setScaleY(1.36f);
            this.a.setAlpha(1.0f);
            this.b.setScaleX(0.0f);
            this.b.setScaleY(0.0f);
            this.b.setAlpha(1.0f);
            a(this.a, 1.0f, 1.0f, 300, 0, null);
            a(this.b, 1.0f, 1.0f, 300, 0, null);
        }
    }
}
