package com.avito.android.fees.refactor.item;

import com.avito.android.fees.refactor.PackageClickListener;
import com.avito.android.fees.refactor.PackageSelectionListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertFeesEntity;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/fees/refactor/item/PackageItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/fees/refactor/item/PackageItemView;", "Lcom/avito/android/fees/refactor/item/PackageItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/fees/refactor/item/PackageItemView;Lcom/avito/android/fees/refactor/item/PackageItem;I)V", "Lcom/avito/android/fees/refactor/PackageClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/fees/refactor/PackageClickListener;", "clickListener", "Lcom/avito/android/fees/refactor/PackageSelectionListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/fees/refactor/PackageSelectionListener;", "selectionListener", "<init>", "(Lcom/avito/android/fees/refactor/PackageClickListener;Lcom/avito/android/fees/refactor/PackageSelectionListener;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageItemPresenter implements ItemPresenter<PackageItemView, PackageItem> {
    public final PackageClickListener a;
    public final PackageSelectionListener b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((PackageItemPresenter) this.b).b.onPackageSelected(((PackageItem) this.c).getLocation(), ((PackageItem) this.c).getRestrictions());
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((PackageItemPresenter) this.b).a.onPackageClick(((PackageItem) this.c).getPackageId());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public PackageItemPresenter(@NotNull PackageClickListener packageClickListener, @NotNull PackageSelectionListener packageSelectionListener) {
        Intrinsics.checkNotNullParameter(packageClickListener, "clickListener");
        Intrinsics.checkNotNullParameter(packageSelectionListener, "selectionListener");
        this.a = packageClickListener;
        this.b = packageSelectionListener;
    }

    public void bindView(@NotNull PackageItemView packageItemView, @NotNull PackageItem packageItem, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(packageItemView, "view");
        Intrinsics.checkNotNullParameter(packageItem, "item");
        packageItemView.setCountDetails(packageItem.getCountDetails());
        packageItemView.setDaysLeft(packageItem.getDaysLeft());
        packageItemView.setLocation(packageItem.getLocation().getTitle());
        AdvertFeesEntity advertFeesEntity = (AdvertFeesEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) packageItem.getRestrictions());
        if (advertFeesEntity == null) {
            packageItemView.hideCategory();
        } else {
            packageItemView.showCategory(advertFeesEntity.getTitle());
        }
        if (packageItem.canShowDetails()) {
            packageItemView.showDetails(new a(0, this, packageItem));
        } else {
            packageItemView.hideDetails();
        }
        int countPercentage = packageItem.getCountPercentage();
        if (countPercentage >= 0 && 10 >= countPercentage) {
            i2 = R.drawable.fees_progress_red;
        } else if (11 <= countPercentage && 30 >= countPercentage) {
            i2 = R.drawable.fees_progress_orange;
        } else {
            i2 = R.drawable.fees_progress_green;
        }
        packageItemView.showProgress(100, countPercentage, i2);
        packageItemView.setOnClickListener(new a(1, this, packageItem));
    }
}
