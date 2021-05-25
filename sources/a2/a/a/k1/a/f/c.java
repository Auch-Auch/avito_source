package a2.a.a.k1.a.f;

import com.avito.android.lib.design.picker.Picker;
public final class c implements Runnable {
    public final /* synthetic */ Picker.d a;

    public c(Picker.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Picker.d dVar = this.a;
        dVar.a.setValueForWheelByIndex(dVar.h, dVar.i);
    }
}
