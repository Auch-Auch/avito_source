package a2.g.m.c;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableParent;
public class a implements DrawableParent {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayDrawable b;

    public a(ArrayDrawable arrayDrawable, int i) {
        this.b = arrayDrawable;
        this.a = i;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable getDrawable() {
        return this.b.getDrawable(this.a);
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable setDrawable(Drawable drawable) {
        return this.b.setDrawable(this.a, drawable);
    }
}
