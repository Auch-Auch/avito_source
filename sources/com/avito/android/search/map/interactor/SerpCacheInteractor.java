package com.avito.android.search.map.interactor;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0015J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "", "", "key", "", "columns", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/interactor/SerpDataSources;", "getElements", "(Ljava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "subscriptionId", "appendElements", "(Ljava/lang/String;Ljava/util/List;ILcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Completable;", "removeAtPosition", "(Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Completable;", "recalculatePositions", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "adBanner", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "replaceAds", "(Lcom/avito/android/serp/adapter/SerpCommercialBanner;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "getSubscriptionId", "(Ljava/lang/String;)Ljava/lang/String;", "", "setSubscriptionId", "(Ljava/lang/String;Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public interface SerpCacheInteractor {
    @NotNull
    Observable<SerpDataSources> appendElements(@NotNull String str, @NotNull List<? extends SerpElement> list, int i, @NotNull SerpDisplayType serpDisplayType, @Nullable String str2);

    @NotNull
    Observable<SerpDataSources> getElements(@NotNull String str, int i, @NotNull SerpDisplayType serpDisplayType);

    @Nullable
    String getSubscriptionId(@NotNull String str);

    @NotNull
    Completable recalculatePositions(@NotNull String str, int i);

    @NotNull
    Completable removeAtPosition(@NotNull String str, int i);

    @NotNull
    Observable<ViewTypeSerpItem> replaceAds(@NotNull SerpCommercialBanner serpCommercialBanner, @NotNull String str, @NotNull SerpDisplayType serpDisplayType);

    void setSubscriptionId(@NotNull String str, @Nullable String str2);
}
