package com.avito.android.messenger.map.sharing;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerApi;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001c\b\u0007\u0012\u0011\u0010\u0011\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u0011\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/map/sharing/SharingMapInteractorImpl;", "Lcom/avito/android/messenger/map/sharing/SharingMapInteractor;", "Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getAddressForCoordinates", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Observable;", "", "reconnects", "()Lio/reactivex/rxjava3/core/Observable;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lru/avito/messenger/MessengerClient;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SharingMapInteractorImpl implements SharingMapInteractor {
    public final MessengerClient<AvitoMessengerApi> a;

    public static final class a<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends MessageBody.Location>> {
        public final /* synthetic */ AvitoMapPoint a;

        public a(AvitoMapPoint avitoMapPoint) {
            this.a = avitoMapPoint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends MessageBody.Location> apply(AvitoMessengerApi avitoMessengerApi) {
            AvitoMessengerApi avitoMessengerApi2 = avitoMessengerApi;
            Intrinsics.checkNotNullParameter(avitoMessengerApi2, "api");
            return MessengerApi.DefaultImpls.getGeoCodedLocationForCoordinates$default(avitoMessengerApi2, this.a.getLatitude(), this.a.getLongitude(), null, 4, null);
        }
    }

    public static final class b<T, R> implements Function<Boolean, Unit> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SharingMapInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.a = messengerClient;
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapInteractor
    @NotNull
    public Single<MessageBody.Location> getAddressForCoordinates(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, VKApiConst.POSITION);
        io.reactivex.Single<R> flatMap = this.a.withMessengerApi().flatMap(new a(avitoMapPoint));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…tion.longitude)\n        }");
        return InteropKt.toV3(flatMap);
    }

    @Override // com.avito.android.messenger.map.sharing.SharingMapInteractor
    @NotNull
    public Observable<Unit> reconnects() {
        io.reactivex.Observable<R> map = this.a.allReconnects().map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "client.allReconnects().map { Unit }");
        return InteropKt.toV3(map);
    }
}
