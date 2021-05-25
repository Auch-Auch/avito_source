package com.avito.android.messenger.map.sharing;

import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.map.sharing.SharingMapView;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SelectedSearchSuggestMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", "c", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", SocialButtonClickedEventKt.SUGGEST, "<init>", "(Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SelectedSearchSuggestMutator extends Mutator<SharingMapView.State> {
    public final GeoSearchSuggest c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectedSearchSuggestMutator(@NotNull GeoSearchSuggest geoSearchSuggest) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(geoSearchSuggest, SocialButtonClickedEventKt.SUGGEST);
        this.c = geoSearchSuggest;
    }

    @NotNull
    public SharingMapView.State invoke(@NotNull SharingMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        GeoSearchSuggest geoSearchSuggest = this.c;
        MessageBody.Location location = new MessageBody.Location(geoSearchSuggest.getLatitude(), geoSearchSuggest.getLongitude(), geoSearchSuggest.getTitle(), geoSearchSuggest.getKind(), null, 16, null);
        GeoSearchSuggest geoSearchSuggest2 = this.c;
        return new SharingMapView.State.Static.Loaded(location, new SharingMapView.CameraState(geoSearchSuggest2.getLatitude(), geoSearchSuggest2.getLongitude(), 18.0f), state.getUserPoint(), this.c.getTitle(), false, true);
    }
}
