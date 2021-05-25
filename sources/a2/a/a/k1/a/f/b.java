package a2.a.a.k1.a.f;

import com.avito.android.lib.design.picker.Picker;
public final class b implements Runnable {
    public final /* synthetic */ Picker.a a;

    public b(Picker.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Picker.a aVar = this.a;
        aVar.a.setValueForWheelByIndex(aVar.h, aVar.i);
    }
}
