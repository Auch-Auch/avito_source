package com.avito.android.remote.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/YandexBannerItem;", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "", "", "getContextTags", "()Ljava/util/List;", "contextTags", "", "getParams", "()Ljava/util/Map;", "params", "Lcom/avito/android/remote/model/Coordinates;", "getLocation", "()Lcom/avito/android/remote/model/Coordinates;", "location", "getHash", "()Ljava/lang/String;", "hash", "getPartnerId", "partnerId", "getQuery", "query", "getStatId", "statId", "models_release"}, k = 1, mv = {1, 4, 2})
public interface YandexBannerItem extends AdNetworkBannerItem<String> {
    @NotNull
    List<String> getContextTags();

    @Nullable
    String getHash();

    @Nullable
    Coordinates getLocation();

    @Nullable
    Map<String, String> getParams();

    @NotNull
    String getPartnerId();

    @Nullable
    String getQuery();

    @NotNull
    String getStatId();
}
