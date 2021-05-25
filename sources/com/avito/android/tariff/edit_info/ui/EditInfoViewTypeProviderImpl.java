package com.avito.android.tariff.edit_info.ui;

import a2.g.r.g;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItem;
import com.avito.android.tariff.edit_info.item.add_category.AddCategoryItemBlueprint;
import com.avito.android.tariff.edit_info.item.button.ButtonItem;
import com.avito.android.tariff.edit_info.item.button.ButtonItemBlueprint;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItem;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItemBlueprint;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallBlueprint;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallItem;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItem;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItemBlueprint;
import com.avito.android.tariff.edit_info.item.tabs.TabsItem;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemBlueprint;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.android.tariff.info.item.info.InfoItemBlueprint;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B$\b\u0007\u0012\u0019\u0010\u0010\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\r0\f¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR)\u0010\u0010\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b¢\u0006\u0002\b\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010!\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001c\u0010$\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u001c\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001c\u0010)\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001c\u0010,\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014¨\u0006/"}, d2 = {"Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProviderImpl;", "Lcom/avito/android/tariff/edit_info/ui/EditInfoViewTypeProvider;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "getItemViewType", "(Lcom/avito/konveyor/blueprint/Item;)I", "Ljava/lang/Class;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "type", AuthSource.SEND_ABUSE, "(Ljava/lang/Class;)I", "", "Lkotlin/jvm/JvmSuppressWildcards;", "j", "Ljava/util/Set;", "blueprints", "h", "I", "getManagerCallViewType", "()I", "managerCallViewType", "i", "getAddCategoryViewType", "addCategoryViewType", "e", "getPackagesTitleViewType", "packagesTitleViewType", AuthSource.BOOKING_ORDER, "getTabsViewType", "tabsViewType", g.a, "getButtonViewType", "buttonViewType", "c", "getInfoViewType", "infoViewType", "getHeaderViewType", "headerViewType", "f", "getEditPackageViewType", "editPackageViewType", "d", "getProlongationViewType", "prolongationViewType", "<init>", "(Ljava/util/Set;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoViewTypeProviderImpl implements EditInfoViewTypeProvider {
    public final int a = a(PaidServiceHeaderBlueprint.class);
    public final int b = a(TabsItemBlueprint.class);
    public final int c = a(InfoItemBlueprint.class);
    public final int d = a(TariffProlongationItemBlueprint.class);
    public final int e = a(PackageTitleItemBlueprint.class);
    public final int f = a(EditPackageItemBlueprint.class);
    public final int g = a(ButtonItemBlueprint.class);
    public final int h = a(ManagerCallBlueprint.class);
    public final int i = a(AddCategoryItemBlueprint.class);
    public final Set<ItemBlueprint<?, ?>> j;

    @Inject
    public EditInfoViewTypeProviderImpl(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        this.j = set;
    }

    public final int a(Class<? extends ItemBlueprint<?, ?>> cls) {
        int i2 = 0;
        for (T t : this.j) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (cls.isInstance(t)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getAddCategoryViewType() {
        return this.i;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getButtonViewType() {
        return this.g;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getEditPackageViewType() {
        return this.f;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getHeaderViewType() {
        return this.a;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getInfoViewType() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.ViewTypeProvider
    public int getItemViewType(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof PaidServiceHeaderItem) {
            return getHeaderViewType();
        }
        if (item instanceof TabsItem) {
            return getTabsViewType();
        }
        if (item instanceof InfoItem) {
            return getInfoViewType();
        }
        if (item instanceof TariffProlongationItem) {
            return getProlongationViewType();
        }
        if (item instanceof PackageTitleItem) {
            return getPackagesTitleViewType();
        }
        if (item instanceof EditPackageItem) {
            return getEditPackageViewType();
        }
        if (item instanceof ButtonItem) {
            return getButtonViewType();
        }
        if (item instanceof AddCategoryItem) {
            return getAddCategoryViewType();
        }
        if (item instanceof ManagerCallItem) {
            return getManagerCallViewType();
        }
        return -1;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getManagerCallViewType() {
        return this.h;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getPackagesTitleViewType() {
        return this.e;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getProlongationViewType() {
        return this.d;
    }

    @Override // com.avito.android.tariff.edit_info.ui.EditInfoViewTypeProvider
    public int getTabsViewType() {
        return this.b;
    }
}
