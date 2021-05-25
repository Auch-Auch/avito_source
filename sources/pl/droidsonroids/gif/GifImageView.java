package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import y6.a.a.c;
import y6.a.a.d;
public class GifImageView extends ImageView {
    public boolean a;

    public GifImageView(Context context) {
        super(context);
    }

    public final void a(d.a aVar) {
        this.a = aVar.a;
        int i = aVar.c;
        if (i > 0) {
            super.setImageResource(i);
        }
        int i2 = aVar.d;
        if (i2 > 0) {
            super.setBackgroundResource(i2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        cVar.a(getDrawable(), 0);
        cVar.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.a ? getDrawable() : null;
        if (this.a) {
            drawable = getBackground();
        }
        return new c(super.onSaveInstanceState(), drawable2, drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (!d.d(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public void setFreezesAnimation(boolean z) {
        this.a = z;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (!d.d(this, true, i)) {
            super.setImageResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!d.c(this, uri)) {
            super.setImageURI(uri);
        }
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(d.b(this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(d.b(this, attributeSet, i, 0));
    }

    @RequiresApi(21)
    public GifImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(d.b(this, attributeSet, i, i2));
    }
}
