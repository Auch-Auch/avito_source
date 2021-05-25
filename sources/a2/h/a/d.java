package a2.h.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.getkeepsafe.taptargetview.TapTarget;
public class d extends TapTarget {
    public final View C;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[2];
            d.this.C.getLocationOnScreen(iArr);
            d.this.e = new Rect(iArr[0], iArr[1], d.this.C.getWidth() + iArr[0], d.this.C.getHeight() + iArr[1]);
            d dVar = d.this;
            if (dVar.f == null && dVar.C.getWidth() > 0 && d.this.C.getHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(d.this.C.getWidth(), d.this.C.getHeight(), Bitmap.Config.ARGB_8888);
                d.this.C.draw(new Canvas(createBitmap));
                d.this.f = new BitmapDrawable(d.this.C.getContext().getResources(), createBitmap);
                Drawable drawable = d.this.f;
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), d.this.f.getIntrinsicHeight());
            }
            this.a.run();
        }
    }

    public d(View view, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(charSequence, charSequence2);
        if (view != null) {
            this.C = view;
            return;
        }
        throw new IllegalArgumentException("Given null view to target");
    }

    @Override // com.getkeepsafe.taptargetview.TapTarget
    public void onReady(Runnable runnable) {
        AppCompatDelegateImpl.i.q1(this.C, new a(runnable));
    }
}
