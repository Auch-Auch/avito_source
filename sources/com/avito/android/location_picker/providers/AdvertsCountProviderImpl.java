package com.avito.android.location_picker.providers;

import androidx.collection.SimpleArrayMap;
import com.avito.android.remote.SearchRadiusApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.location_picker.AdvertsCountResult;
import com.avito.android.util.rx3.Maybies;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl;", "Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "", "", "searchParams", "radiusId", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/location_picker/AdvertsCountResult;", "getAdvertsCount", "(Ljava/util/Map;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)Lio/reactivex/rxjava3/core/Single;", "Landroidx/collection/SimpleArrayMap;", "Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl$RadiusPoint;", AuthSource.SEND_ABUSE, "Landroidx/collection/SimpleArrayMap;", "advertsCountCache", "Lcom/avito/android/remote/SearchRadiusApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/SearchRadiusApi;", "getApi", "()Lcom/avito/android/remote/SearchRadiusApi;", "api", "<init>", "(Lcom/avito/android/remote/SearchRadiusApi;)V", "RadiusPoint", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsCountProviderImpl implements AdvertsCountProvider {
    public final SimpleArrayMap<RadiusPoint, AdvertsCountResult> a = new SimpleArrayMap<>();
    @NotNull
    public final SearchRadiusApi b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl$RadiusPoint;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Coordinates;", "component2", "()Lcom/avito/android/remote/model/Coordinates;", "radiusId", "coordinates", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/location_picker/providers/AdvertsCountProviderImpl$RadiusPoint;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRadiusId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class RadiusPoint {
        @Nullable
        public final String a;
        @Nullable
        public final Coordinates b;

        public RadiusPoint(@Nullable String str, @Nullable Coordinates coordinates) {
            this.a = str;
            this.b = coordinates;
        }

        public static /* synthetic */ RadiusPoint copy$default(RadiusPoint radiusPoint, String str, Coordinates coordinates, int i, Object obj) {
            if ((i & 1) != 0) {
                str = radiusPoint.a;
            }
            if ((i & 2) != 0) {
                coordinates = radiusPoint.b;
            }
            return radiusPoint.copy(str, coordinates);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Coordinates component2() {
            return this.b;
        }

        @NotNull
        public final RadiusPoint copy(@Nullable String str, @Nullable Coordinates coordinates) {
            return new RadiusPoint(str, coordinates);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RadiusPoint)) {
                return false;
            }
            RadiusPoint radiusPoint = (RadiusPoint) obj;
            return Intrinsics.areEqual(this.a, radiusPoint.a) && Intrinsics.areEqual(this.b, radiusPoint.b);
        }

        @Nullable
        public final Coordinates getCoordinates() {
            return this.b;
        }

        @Nullable
        public final String getRadiusId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Coordinates coordinates = this.b;
            if (coordinates != null) {
                i = coordinates.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("RadiusPoint(radiusId=");
            L.append(this.a);
            L.append(", coordinates=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a<T> implements Consumer<AdvertsCountResult> {
        public final /* synthetic */ AdvertsCountProviderImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Coordinates c;

        public a(AdvertsCountProviderImpl advertsCountProviderImpl, String str, Coordinates coordinates) {
            this.a = advertsCountProviderImpl;
            this.b = str;
            this.c = coordinates;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertsCountResult advertsCountResult) {
            AdvertsCountResult advertsCountResult2 = advertsCountResult;
            if (advertsCountResult2 instanceof AdvertsCountResult.Ok) {
                this.a.a.put(new RadiusPoint(this.b, this.c), advertsCountResult2);
            }
        }
    }

    @Inject
    public AdvertsCountProviderImpl(@NotNull SearchRadiusApi searchRadiusApi) {
        Intrinsics.checkNotNullParameter(searchRadiusApi, "api");
        this.b = searchRadiusApi;
    }

    @Override // com.avito.android.location_picker.providers.AdvertsCountProvider
    @NotNull
    public Single<AdvertsCountResult> getAdvertsCount(@NotNull Map<String, String> map, @Nullable String str, @Nullable Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(map, "searchParams");
        Maybe maybe = Maybies.toMaybe(this.a.get(new RadiusPoint(str, coordinates)));
        Single<R> map2 = this.b.getAdvertsCount(map).firstOrError().map(a2.a.a.n1.w0.a.a);
        Intrinsics.checkNotNullExpressionValue(map2, "api.getAdvertsCount(sear…          }\n            }");
        Single<AdvertsCountResult> single = maybe.switchIfEmpty(map2.doOnSuccess(new a(this, str, coordinates)).toMaybe()).toSingle();
        Intrinsics.checkNotNullExpressionValue(single, "advertsCountCache[Radius…)\n            .toSingle()");
        return single;
    }

    @NotNull
    public final SearchRadiusApi getApi() {
        return this.b;
    }
}
