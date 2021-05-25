package l6.b.d;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
public class d {
    @NonNull
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public d(@NonNull CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.a);
        if (buttonDrawable == null) {
            return;
        }
        if (this.d || this.e) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.d) {
                DrawableCompat.setTintList(mutate, this.b);
            }
            if (this.e) {
                DrawableCompat.setTintMode(mutate, this.c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(@androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R.styleable.CompoundButton
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.getWrappedTypeArray()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.hasValue(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x003a
            int r10 = r0.getResourceId(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x003a
            android.widget.CompoundButton r11 = r9.a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            if (r10 != 0) goto L_0x0058
            int r10 = androidx.appcompat.R.styleable.CompoundButton_android_button
            boolean r11 = r0.hasValue(r10)
            if (r11 == 0) goto L_0x0058
            int r10 = r0.getResourceId(r10, r8)
            if (r10 == 0) goto L_0x0058
            android.widget.CompoundButton r11 = r9.a
            android.content.Context r1 = r11.getContext()
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r10)
            r11.setButtonDrawable(r10)
        L_0x0058:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTint
            boolean r11 = r0.hasValue(r10)
            if (r11 == 0) goto L_0x0069
            android.widget.CompoundButton r11 = r9.a
            android.content.res.ColorStateList r10 = r0.getColorStateList(r10)
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r11, r10)
        L_0x0069:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode
            boolean r11 = r0.hasValue(r10)
            if (r11 == 0) goto L_0x0080
            android.widget.CompoundButton r11 = r9.a
            r1 = -1
            int r10 = r0.getInt(r10, r1)
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r10, r1)
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r11, r10)
        L_0x0080:
            r0.recycle()
            return
        L_0x0084:
            r10 = move-exception
            r0.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.b.d.d.b(android.util.AttributeSet, int):void");
    }
}
