package com.google.android.material.transition.platform;

import a2.j.b.d.v.l.h;
import a2.j.b.d.v.l.i;
import a2.j.b.d.v.l.j;
import a2.j.b.d.v.l.n;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    @Nullable
    public static WeakReference<View> f;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    @Nullable
    public Rect d;
    @Nullable
    public ShapeProvider e = new ShapeableViewShapeProvider();

    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View view);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View view) {
            if (view instanceof Shapeable) {
                return ((Shapeable) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    public static void a(Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        return this.e;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.c;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.b;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view, @NonNull Matrix matrix, @NonNull RectF rectF) {
        f = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        ShapeAppearanceModel provideShape;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (!(onCreateSnapshotView == null || (weakReference = f) == null || this.e == null || (view = weakReference.get()) == null || (provideShape = this.e.provideShape(view)) == null)) {
            onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, provideShape);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view;
        Activity activity;
        if (!list.isEmpty() && !map.isEmpty() && (view = map.get(list.get(0))) != null && (activity = ContextUtils.getActivity(view.getContext())) != null) {
            Window window = activity.getWindow();
            if (this.a) {
                Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
                if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
                    MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
                    if (!this.c) {
                        window.setSharedElementReenterTransition(null);
                    }
                    if (this.b) {
                        window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
                        materialContainerTransform.addListener(new h(this, window));
                        return;
                    }
                    return;
                }
                return;
            }
            Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
            if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
                MaterialContainerTransform materialContainerTransform2 = (MaterialContainerTransform) sharedElementReturnTransition;
                materialContainerTransform2.setHoldAtEndEnabled(true);
                materialContainerTransform2.addListener(new i(this, activity));
                if (this.b) {
                    window.setTransitionBackgroundFadeDuration(materialContainerTransform2.getDuration());
                    materialContainerTransform2.addListener(new j(this, window));
                }
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty()) {
            int i = R.id.mtrl_motion_snapshot_view;
            if (list2.get(0).getTag(i) instanceof View) {
                list2.get(0).setTag(i, null);
            }
        }
        if (!this.a && !list2.isEmpty()) {
            View view = list2.get(0);
            RectF rectF = n.a;
            this.d = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        this.a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (!this.a && !list2.isEmpty() && this.d != null) {
            View view = list2.get(0);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.d.height(), 1073741824));
            Rect rect = this.d;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void setShapeProvider(@Nullable ShapeProvider shapeProvider) {
        this.e = shapeProvider;
    }

    public void setSharedElementReenterTransitionEnabled(boolean z) {
        this.c = z;
    }

    public void setTransparentWindowBackgroundEnabled(boolean z) {
        this.b = z;
    }
}
