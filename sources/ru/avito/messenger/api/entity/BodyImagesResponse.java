package ru.avito.messenger.api.entity;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/messenger/api/entity/BodyImagesResponse;", "", "", "", "Lru/avito/messenger/api/entity/Image;", "images", "Ljava/util/Map;", "getImages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BodyImagesResponse {
    @NotNull
    public final Map<String, Image> images;

    public BodyImagesResponse(@NotNull Map<String, Image> map) {
        Intrinsics.checkNotNullParameter(map, "images");
        this.images = map;
    }

    @NotNull
    public final Map<String, Image> getImages() {
        return this.images;
    }
}
