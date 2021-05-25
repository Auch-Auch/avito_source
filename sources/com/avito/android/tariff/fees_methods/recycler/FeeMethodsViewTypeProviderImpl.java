package com.avito.android.tariff.fees_methods.recycler;

import a2.g.r.g;
import com.avito.android.publish_limits_info.item.LimitsInfoItem;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.fees_methods.items.FeeMethodBlueprint;
import com.avito.android.tariff.fees_methods.items.FeeMethodItem;
import com.avito.android.tariff.fees_methods.items.bar.BarItem;
import com.avito.android.tariff.fees_methods.items.bar.BarItemBlueprint;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItem;
import com.avito.android.tariff.fees_methods.items.description.FeeDescriptionItemBlueprint;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandBlueprint;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandItem;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageBlueprint;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageItem;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItem;
import com.avito.android.tariff.fees_methods.items.title.FeeTitleItemBlueprint;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0019\u0010\u0015\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\u00120\u0011¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0015\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u001d\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010#\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR\u001c\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f¨\u0006)"}, d2 = {"Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProviderImpl;", "Lcom/avito/android/tariff/fees_methods/recycler/FeeMethodsViewTypeProvider;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "getItemViewType", "(Lcom/avito/konveyor/blueprint/Item;)I", "Ljava/lang/Class;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "type", AuthSource.SEND_ABUSE, "(Ljava/lang/Class;)I", "c", "I", "getDescriptionViewType", "()I", "descriptionViewType", "", "Lkotlin/jvm/JvmSuppressWildcards;", "h", "Ljava/util/Set;", "blueprints", "getTitleViewType", "titleViewType", g.a, "getLimitsInfoViewType", "limitsInfoViewType", "f", "getFeePackageViewType", "feePackageViewType", AuthSource.BOOKING_ORDER, "getBarViewType", "barViewType", "e", "getHighDemandViewType", "highDemandViewType", "d", "getFeeMethodViewType", "feeMethodViewType", "<init>", "(Ljava/util/Set;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsViewTypeProviderImpl implements FeeMethodsViewTypeProvider {
    public final int a = a(FeeTitleItemBlueprint.class);
    public final int b = a(BarItemBlueprint.class);
    public final int c = a(FeeDescriptionItemBlueprint.class);
    public final int d = a(FeeMethodBlueprint.class);
    public final int e = a(HighDemandBlueprint.class);
    public final int f = a(FeeMethodPackageBlueprint.class);
    public final int g = a(LimitsInfoItemBlueprint.class);
    public final Set<ItemBlueprint<?, ?>> h;

    @Inject
    public FeeMethodsViewTypeProviderImpl(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        this.h = set;
    }

    public final int a(Class<? extends ItemBlueprint<?, ?>> cls) {
        int i = 0;
        for (T t : this.h) {
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

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getBarViewType() {
        return this.b;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getDescriptionViewType() {
        return this.c;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getFeeMethodViewType() {
        return this.d;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getFeePackageViewType() {
        return this.f;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getHighDemandViewType() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.ViewTypeProvider
    public int getItemViewType(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof FeeTitleItem) {
            return getTitleViewType();
        }
        if (item instanceof FeeDescriptionItem) {
            return getDescriptionViewType();
        }
        if (item instanceof BarItem) {
            return getBarViewType();
        }
        if (item instanceof FeeMethodItem) {
            return getFeeMethodViewType();
        }
        if (item instanceof HighDemandItem) {
            return getHighDemandViewType();
        }
        if (item instanceof FeeMethodPackageItem) {
            return getFeePackageViewType();
        }
        if (item instanceof LimitsInfoItem) {
            return getLimitsInfoViewType();
        }
        return -1;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getLimitsInfoViewType() {
        return this.g;
    }

    @Override // com.avito.android.tariff.fees_methods.recycler.FeeMethodsViewTypeProvider
    public int getTitleViewType() {
        return this.a;
    }
}
