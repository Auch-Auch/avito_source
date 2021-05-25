package com.avito.android.messenger.map.viewing;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapCameraUpdate;
import com.avito.android.avito_map.PointsWithOffset;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.messenger.map.viewing.view.Pin;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "kotlin.jvm.PlatformType", "updatedPins", "", "accept", "(Ljava/util/Set;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class PlatformMapPresenterImpl$subscribeToPinUpdates$3<T> implements Consumer<Set<? extends Pin>> {
    public final /* synthetic */ PlatformMapPresenterImpl a;

    public PlatformMapPresenterImpl$subscribeToPinUpdates$3(PlatformMapPresenterImpl platformMapPresenterImpl) {
        this.a = platformMapPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Set<? extends Pin> set) {
        accept((Set<Pin>) set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(final Set<Pin> set) {
        Relay relay = this.a.getMutatorsRelay();
        Mutator mutator = new Mutator("PinsUpdated(updatedPins = " + set + ')', new Function1<PlatformMapView.State, PlatformMapView.State>(this) { // from class: com.avito.android.messenger.map.viewing.PlatformMapPresenterImpl$subscribeToPinUpdates$3.1
            public final /* synthetic */ PlatformMapPresenterImpl$subscribeToPinUpdates$3 a;

            {
                this.a = r1;
            }

            @NotNull
            public final PlatformMapView.State invoke(@NotNull PlatformMapView.State state) {
                T t;
                T t2;
                MapBottomSheet.State state2;
                AvitoMapCameraUpdate avitoMapCameraUpdate;
                AvitoMapCameraUpdate avitoMapCameraUpdate2;
                Intrinsics.checkNotNullParameter(state, "oldState");
                if (!(!Intrinsics.areEqual(set, state.getPins()))) {
                    return state;
                }
                PlatformMapPresenterImpl platformMapPresenterImpl = this.a.a;
                Set set2 = set;
                Intrinsics.checkNotNullExpressionValue(set2, "updatedPins");
                Iterator<T> it = set2.iterator();
                while (true) {
                    t = null;
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    t2 = it.next();
                    if (t2.isSelected()) {
                        break;
                    }
                }
                T t3 = t2;
                if (t3 != null) {
                    state2 = new MapBottomSheet.State.Expanded(t3.getTitle(), t3.getDescription(), set2.size() > 1, true, false, false, 48, null);
                } else {
                    state2 = MapBottomSheet.State.Closed.INSTANCE;
                }
                PlatformMapPresenterImpl platformMapPresenterImpl2 = this.a.a;
                Set<T> set3 = set;
                Intrinsics.checkNotNullExpressionValue(set3, "updatedPins");
                if (!set3.isEmpty()) {
                    Iterator<T> it2 = set3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next = it2.next();
                        if (next.isSelected()) {
                            t = next;
                            break;
                        }
                    }
                    T t4 = t;
                    if (t4 != null) {
                        avitoMapCameraUpdate2 = new AvitoMapCameraUpdate(new AvitoMapCameraPosition(t4.getPosition(), 18.0f, 0.0f, null, null, 28, null), null, null, 6, null);
                    } else if (set3.size() > 1) {
                        int i = platformMapPresenterImpl2.t;
                        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(set3, 10));
                        for (T t5 : set3) {
                            arrayList.add(t5.getPosition());
                        }
                        avitoMapCameraUpdate2 = new AvitoMapCameraUpdate(null, null, new PointsWithOffset(arrayList, i), 3, null);
                    } else {
                        avitoMapCameraUpdate2 = new AvitoMapCameraUpdate(new AvitoMapCameraPosition(((Pin) CollectionsKt___CollectionsKt.first(set3)).getPosition(), 18.0f, 0.0f, null, null, 28, null), null, null, 6, null);
                    }
                    avitoMapCameraUpdate = avitoMapCameraUpdate2;
                } else {
                    avitoMapCameraUpdate = null;
                }
                if (avitoMapCameraUpdate != null) {
                    Set set4 = set;
                    Intrinsics.checkNotNullExpressionValue(set4, "updatedPins");
                    return PlatformMapView.State.copy$default(state, set4, state2, avitoMapCameraUpdate, null, false, false, false, 120, null);
                }
                Set set5 = set;
                Intrinsics.checkNotNullExpressionValue(set5, "updatedPins");
                return PlatformMapView.State.copy$default(state, set5, state2, null, null, false, false, false, 124, null);
            }
        });
        relay.accept(new MutatorSingle(mutator.getName(), new PlatformMapPresenterImpl$subscribeToPinUpdates$3$$special$$inlined$plusAssign$1(mutator)));
    }
}
