package y6.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.R;
public final class d {
    public static final List<String> a = Arrays.asList("raw", "drawable", "mipmap");

    public static void a(int i, Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).setLoopCount(i);
        }
    }

    public static a b(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i, i2);
        int i3 = aVar.b;
        if (i3 >= 0) {
            a(i3, imageView.getDrawable());
            a(i3, imageView.getBackground());
        }
        return aVar;
    }

    public static boolean c(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new GifDrawable(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean d(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!a.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                GifDrawable gifDrawable = new GifDrawable(resources, i);
                if (z) {
                    imageView.setImageDrawable(gifDrawable);
                    return true;
                }
                imageView.setBackground(gifDrawable);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    public static class a extends b {
        public final int c;
        public final int d;

        public a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.c = a(imageView, attributeSet, true);
            this.d = a(imageView, attributeSet, false);
        }

        public static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (d.a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !d.d(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        public a() {
            this.c = 0;
            this.d = 0;
        }
    }

    public static class b {
        public boolean a;
        public final int b;

        public b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i, i2);
            this.a = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
            this.b = obtainStyledAttributes.getInt(R.styleable.GifView_loopCount, -1);
            obtainStyledAttributes.recycle();
        }

        public b() {
            this.a = false;
            this.b = -1;
        }
    }
}
