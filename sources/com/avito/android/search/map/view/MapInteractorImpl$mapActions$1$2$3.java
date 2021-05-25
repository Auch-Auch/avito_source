package com.avito.android.search.map.view;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.view.MapInteractorImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/search/map/view/MapInteractorImpl$mapActions$1$2$3", "Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;", "Lcom/avito/android/avito_map/AvitoMapMoveReason;", "reason", "", "onMapMoveStarted", "(Lcom/avito/android/avito_map/AvitoMapMoveReason;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapInteractorImpl$mapActions$1$2$3 implements AvitoMap.MapMoveStartListener {
    public final /* synthetic */ MapInteractorImpl.a.b a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public MapInteractorImpl$mapActions$1$2$3(MapInteractorImpl.a.b bVar) {
        this.a = bVar;
    }

    @Override // com.avito.android.avito_map.AvitoMap.MapMoveStartListener
    public void onMapMoveStarted(@NotNull AvitoMapMoveReason avitoMapMoveReason) {
        Intrinsics.checkNotNullParameter(avitoMapMoveReason, "reason");
        AvitoMapMoveReason avitoMapMoveReason2 = AvitoMapMoveReason.GESTURE;
        if (avitoMapMoveReason == avitoMapMoveReason2 || (this.a.a.a.k)) {
            MapInteractorImpl.a.b bVar = this.a;
            bVar.b.onNext(new MapViewAction.MapChanges(bVar.a.a.k, avitoMapMoveReason == avitoMapMoveReason2));
            this.a.a.a.k = false;
            this.a.a.a.g = true;
            return;
        }
        this.a.a.a.g = false;
    }
}
