package com.avito.android.developments_catalog.items.buildingProgress.image_list;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoView;", "Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoView;Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoItem;I)V", "Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoClickListener;", "getListener", "()Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/developments_catalog/items/buildingProgress/image_list/PhotoClickListener;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPresenter implements ItemPresenter<PhotoView, PhotoItem> {
    @NotNull
    public final PhotoClickListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhotoPresenter a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PhotoPresenter photoPresenter, int i) {
            super(0);
            this.a = photoPresenter;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getListener().onPhotoClick(this.b);
            return Unit.INSTANCE;
        }
    }

    public PhotoPresenter(@NotNull PhotoClickListener photoClickListener) {
        Intrinsics.checkNotNullParameter(photoClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = photoClickListener;
    }

    @NotNull
    public final PhotoClickListener getListener() {
        return this.a;
    }

    public void bindView(@NotNull PhotoView photoView, @NotNull PhotoItem photoItem, int i) {
        Intrinsics.checkNotNullParameter(photoView, "view");
        Intrinsics.checkNotNullParameter(photoItem, "item");
        photoView.setImage(photoItem.getImage());
        photoView.setClickListener(new a(this, i));
    }
}
