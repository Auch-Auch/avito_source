package com.avito.android.developments_catalog.items.buildingProgress;

import com.avito.android.developments_catalog.DevelopmentsCatalogRouter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenterImpl;", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressPresenter;", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressView;", "view", "Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressView;Lcom/avito/android/developments_catalog/items/buildingProgress/BuildingProgressItem;I)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "<init>", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class BuildingProgressPresenterImpl implements BuildingProgressPresenter {
    public DevelopmentsCatalogRouter a;

    public static final class a extends Lambda implements Function2<Integer, List<? extends Image>, Unit> {
        public final /* synthetic */ BuildingProgressPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BuildingProgressPresenterImpl buildingProgressPresenterImpl) {
            super(2);
            this.a = buildingProgressPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.developments_catalog.DevelopmentsCatalogRouter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Integer num, List<? extends Image> list) {
            int intValue = num.intValue();
            List<? extends Image> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "images");
            DevelopmentsCatalogRouter developmentsCatalogRouter = this.a.a;
            if (developmentsCatalogRouter != 0) {
                developmentsCatalogRouter.showFullscreenGallery(intValue, list2, null, null);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenter
    public void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter) {
        this.a = developmentsCatalogRouter;
    }

    @Override // com.avito.android.developments_catalog.items.buildingProgress.BuildingProgressPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void bindView(@NotNull BuildingProgressView buildingProgressView, @NotNull BuildingProgressItem buildingProgressItem, int i) {
        Intrinsics.checkNotNullParameter(buildingProgressView, "view");
        Intrinsics.checkNotNullParameter(buildingProgressItem, "item");
        buildingProgressView.setData(buildingProgressItem.getBuildingProgress());
        buildingProgressView.setBuildingProgressImageClickListener(new a(this));
    }
}
