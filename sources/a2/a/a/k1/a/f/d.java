package a2.a.a.k1.a.f;

import com.avito.android.lib.design.picker.Wheel;
public final class d implements Runnable {
    public final /* synthetic */ Wheel a;

    public d(Wheel wheel) {
        this.a = wheel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Wheel.access$checkMiddlePositionOnly(this.a);
        this.a.a(true);
    }
}
