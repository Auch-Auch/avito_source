package a2.a.a.n1.x0;

import com.avito.android.location_picker.view.LocationPickerViewImpl;
public final class c implements Runnable {
    public final /* synthetic */ LocationPickerViewImpl.i a;

    public c(LocationPickerViewImpl.i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LocationPickerViewImpl locationPickerViewImpl = this.a.a;
        LocationPickerViewImpl.access$scrollToEnd(locationPickerViewImpl, locationPickerViewImpl.n);
    }
}
