package com.my.target;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;
public class bn {
    @NonNull
    public final Rect a = new Rect();
    @NonNull
    public final Rect b = new Rect();
    @NonNull
    public final Rect c = new Rect();
    @NonNull
    public final Rect d = new Rect();
    @NonNull
    public final Rect e = new Rect();
    @NonNull
    public final Rect f = new Rect();
    @NonNull
    public final Rect g = new Rect();
    @NonNull
    public final Rect h = new Rect();
    @NonNull
    public final io i;

    public bn(@NonNull Context context) {
        this.i = io.af(context);
    }

    public static bn u(@NonNull Context context) {
        return new bn(context);
    }

    public void a(int i2, int i3) {
        this.a.set(0, 0, i2, i3);
        b(this.a, this.b);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.e.set(i2, i3, i4, i5);
        b(this.e, this.f);
    }

    @NonNull
    public Rect aS() {
        return this.d;
    }

    @NonNull
    public Rect aT() {
        return this.f;
    }

    @NonNull
    public Rect aU() {
        return this.h;
    }

    @NonNull
    public Rect aV() {
        return this.b;
    }

    public void b(int i2, int i3, int i4, int i5) {
        this.c.set(i2, i3, i4, i5);
        b(this.c, this.d);
    }

    public final void b(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set(this.i.N(rect.left), this.i.N(rect.top), this.i.N(rect.right), this.i.N(rect.bottom));
    }

    public void c(int i2, int i3, int i4, int i5) {
        this.g.set(i2, i3, i4, i5);
        b(this.g, this.h);
    }
}
