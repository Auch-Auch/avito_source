package com.avito.android.messenger.map.sharing;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getAddressForCoordinates", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Observable;", "", "reconnects", "()Lio/reactivex/rxjava3/core/Observable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SharingMapInteractor {
    @NotNull
    Single<MessageBody.Location> getAddressForCoordinates(@NotNull AvitoMapPoint avitoMapPoint);

    @NotNull
    Observable<Unit> reconnects();
}
