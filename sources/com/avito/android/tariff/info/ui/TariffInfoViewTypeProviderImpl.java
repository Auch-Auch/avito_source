package com.avito.android.tariff.info.ui;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItem;
import com.avito.android.tariff.info.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint;
import com.avito.android.tariff.info.item.package_info.PackageInfoItem;
import com.avito.android.tariff.info.item.package_info.PackageInfoItemBlueprint;
import com.avito.android.tariff.info.item.package_title.PackageTitleItem;
import com.avito.android.tariff.info.item.package_title.PackageTitleItemBlueprint;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0019\u0010 \u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\u001d0\u001c¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR)\u0010 \u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProviderImpl;", "Lcom/avito/android/tariff/info/ui/TariffInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "getItemViewType", "(Lcom/avito/konveyor/blueprint/Item;)I", "Ljava/lang/Class;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "type", AuthSource.SEND_ABUSE, "(Ljava/lang/Class;)I", "c", "I", "getPackagesTitleViewType", "()I", "packagesTitleViewType", AuthSource.BOOKING_ORDER, "getInfoViewType", "infoViewType", "getHeaderViewType", "headerViewType", "e", "getDisclaimerViewType", "disclaimerViewType", "d", "getPackageViewType", "packageViewType", "", "Lkotlin/jvm/JvmSuppressWildcards;", "f", "Ljava/util/Set;", "blueprints", "<init>", "(Ljava/util/Set;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffInfoViewTypeProviderImpl implements TariffInfoViewTypeProvider {
    public final int a = a(PaidServiceHeaderBlueprint.class);
    public final int b = a(InfoItemBlueprint.class);
    public final int c = a(PackageTitleItemBlueprint.class);
    public final int d = a(PackageInfoItemBlueprint.class);
    public final int e = a(DisclaimerItemBlueprint.class);
    public final Set<ItemBlueprint<?, ?>> f;

    @Inject
    public TariffInfoViewTypeProviderImpl(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        this.f = set;
    }

    public final int a(Class<? extends ItemBlueprint<?, ?>> cls) {
        int i = 0;
        for (T t : this.f) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (cls.isInstance(t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider
    public int getDisclaimerViewType() {
        return this.e;
    }

    @Override // com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider
    public int getHeaderViewType() {
        return this.a;
    }

    @Override // com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider
    public int getInfoViewType() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ViewTypeProvider
    public int getItemViewType(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof PaidServiceHeaderItem) {
            return getHeaderViewType();
        }
        if (item instanceof InfoItem) {
            return getInfoViewType();
        }
        if (item instanceof PackageTitleItem) {
            return getPackagesTitleViewType();
        }
        if (item instanceof PackageInfoItem) {
            return getPackageViewType();
        }
        if (item instanceof DisclaimerItem) {
            return getDisclaimerViewType();
        }
        return -1;
    }

    @Override // com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider
    public int getPackageViewType() {
        return this.d;
    }

    @Override // com.avito.android.tariff.info.ui.TariffInfoViewTypeProvider
    public int getPackagesTitleViewType() {
        return this.c;
    }
}
