package com.avito.android.publish.details.item_wrapper;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.details.ItemWrapper;
import com.avito.android.publish.details.PublishDetailsResourceProvider;
import com.avito.android.publish.details.VideoInteractor;
import com.avito.android.publish.details.VideoItemWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactoryImpl;", "Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;", "Lcom/avito/conveyor_item/Item;", "item", "Lcom/avito/android/publish/details/ItemWrapper;", "createItemWrapper", "(Lcom/avito/conveyor_item/Item;)Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "resourceProvider", "Lcom/avito/android/publish/details/VideoInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/details/VideoInteractor;", "videoInteractor", "<init>", "(Lcom/avito/android/publish/details/VideoInteractor;Lcom/avito/android/publish/details/PublishDetailsResourceProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemWrapperFactoryImpl implements ItemWrapperFactory {
    public final VideoInteractor a;
    public final PublishDetailsResourceProvider b;

    @Inject
    public ItemWrapperFactoryImpl(@NotNull VideoInteractor videoInteractor, @NotNull PublishDetailsResourceProvider publishDetailsResourceProvider) {
        Intrinsics.checkNotNullParameter(videoInteractor, "videoInteractor");
        Intrinsics.checkNotNullParameter(publishDetailsResourceProvider, "resourceProvider");
        this.a = videoInteractor;
        this.b = publishDetailsResourceProvider;
    }

    @Override // com.avito.android.publish.details.item_wrapper.ItemWrapperFactory
    @Nullable
    public ItemWrapper<?> createItemWrapper(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof ParameterElement.Video) {
            return new VideoItemWrapper(this.a, this.b);
        }
        return null;
    }
}
