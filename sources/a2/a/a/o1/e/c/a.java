package a2.a.a.o1.e.c;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.messenger.map.sharing.SharingMapPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
public final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<AvitoMapCameraPosition, Unit> {
    public a(SharingMapPresenterImpl sharingMapPresenterImpl) {
        super(1, sharingMapPresenterImpl, SharingMapPresenterImpl.class, "retry", "retry(Lcom/avito/android/avito_map/AvitoMapCameraPosition;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AvitoMapCameraPosition avitoMapCameraPosition) {
        AvitoMapCameraPosition avitoMapCameraPosition2 = avitoMapCameraPosition;
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition2, "p1");
        SharingMapPresenterImpl sharingMapPresenterImpl = (SharingMapPresenterImpl) this.receiver;
        sharingMapPresenterImpl.cameraDraggingStarted(false);
        sharingMapPresenterImpl.cameraPositionChanged(avitoMapCameraPosition2, false);
        return Unit.INSTANCE;
    }
}
