package a2.a.a.o1.e.d;

import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl;
import com.avito.android.messenger.map.viewing.view.Pin;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<PlatformMapView.State, PlatformMapView.State> {
    public final /* synthetic */ PlatformMapPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PlatformMapPresenterImpl platformMapPresenterImpl) {
        super(1);
        this.a = platformMapPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public PlatformMapView.State invoke(PlatformMapView.State state) {
        Object obj;
        T t;
        MapBottomSheet.State state2;
        PlatformMapView.State state3 = state;
        Intrinsics.checkNotNullParameter(state3, "oldState");
        if (!PlatformMapPresenterImpl.access$isCloseable$p(this.a, state3.getBottomSheetState())) {
            return state3;
        }
        Iterator<T> it = state3.getPins().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.isSelected()) {
                break;
            }
        }
        if (t == null) {
            return state3;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t2 : state3.getPins()) {
            if (t2.isSelected()) {
                t2 = (T) Pin.copy$default(t2, null, null, null, null, false, 15, null);
            }
            linkedHashSet.add(t2);
        }
        Iterator it2 = linkedHashSet.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Pin) next).isSelected()) {
                obj = next;
                break;
            }
        }
        Pin pin = (Pin) obj;
        if (pin != null) {
            state2 = new MapBottomSheet.State.Expanded(pin.getTitle(), pin.getDescription(), linkedHashSet.size() > 1, true, false, false, 48, null);
        } else {
            state2 = MapBottomSheet.State.Closed.INSTANCE;
        }
        return PlatformMapView.State.copy$default(state3, linkedHashSet, state2, null, null, false, false, false, 124, null);
    }
}
