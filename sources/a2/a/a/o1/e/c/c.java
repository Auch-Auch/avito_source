package a2.a.a.o1.e.c;

import android.view.View;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
public final class c implements View.OnClickListener {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SharingMapPresenterImpl.d dVar = this.a.a;
        SharingMapPresenterImpl sharingMapPresenterImpl = dVar.a;
        AvitoMapCameraPosition avitoMapCameraPosition = dVar.c;
        sharingMapPresenterImpl.cameraDraggingStarted(false);
        sharingMapPresenterImpl.cameraPositionChanged(avitoMapCameraPosition, false);
    }
}
