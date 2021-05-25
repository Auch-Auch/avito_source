package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;
public abstract class SharedElementCallback {
    public Matrix a;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        Bitmap bitmap;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (drawable != null && background == null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    bitmap = null;
                } else {
                    float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
                    if (!(drawable instanceof BitmapDrawable) || min != 1.0f) {
                        int i = (int) (((float) intrinsicWidth) * min);
                        int i2 = (int) (((float) intrinsicHeight) * min);
                        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        Rect bounds = drawable.getBounds();
                        int i3 = bounds.left;
                        int i4 = bounds.top;
                        int i5 = bounds.right;
                        int i6 = bounds.bottom;
                        drawable.setBounds(0, 0, i, i2);
                        drawable.draw(canvas);
                        drawable.setBounds(i3, i4, i5, i6);
                        bitmap = createBitmap;
                    } else {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                    }
                }
                if (bitmap != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sharedElement:snapshot:bitmap", bitmap);
                    bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        Matrix imageMatrix = imageView.getImageMatrix();
                        float[] fArr = new float[9];
                        imageMatrix.getValues(fArr);
                        bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                    }
                    return bundle;
                }
            }
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
        int i7 = (int) (((float) round) * min2);
        int i8 = (int) (((float) round2) * min2);
        if (this.a == null) {
            this.a = new Matrix();
        }
        this.a.set(matrix);
        this.a.postTranslate(-rectF.left, -rectF.top);
        this.a.postScale(min2, min2);
        Bitmap createBitmap2 = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        canvas2.concat(this.a);
        view.draw(canvas2);
        return createBitmap2;
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
            if (bitmap == null) {
                return null;
            }
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return imageView;
            }
            float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
            Matrix matrix = new Matrix();
            matrix.setValues(floatArray);
            imageView.setImageMatrix(matrix);
            return imageView;
        } else if (!(parcelable instanceof Bitmap)) {
            return null;
        } else {
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageBitmap((Bitmap) parcelable);
            return imageView2;
        }
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
    }

    public void onRejectSharedElements(List<View> list) {
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
        onSharedElementsReadyListener.onSharedElementsReady();
    }
}
