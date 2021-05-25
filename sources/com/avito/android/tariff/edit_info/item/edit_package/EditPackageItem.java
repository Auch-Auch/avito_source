package com.avito.android.tariff.edit_info.item.edit_package;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010/\u001a\u00020*\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b3\u00104R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R!\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006¨\u00065"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageItem;", "Lcom/avito/conveyor_item/Item;", "", "h", "Ljava/lang/String;", "getBarDescription", "()Ljava/lang/String;", "barDescription", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.SEND_ABUSE, "getStringId", "stringId", "c", "getLocations", "locations", "d", "getBarTitle", "barTitle", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getMicroCategories", "()Ljava/util/List;", "microCategories", "", "f", "F", "getBarProgress", "()F", "barProgress", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "i", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "getBarDescriptionStatus", "()Lcom/avito/android/paid_services/routing/TariffCountStatus;", "barDescriptionStatus", "Lcom/avito/android/paid_services/routing/ProgressState;", g.a, "Lcom/avito/android/paid_services/routing/ProgressState;", "getBarState", "()Lcom/avito/android/paid_services/routing/ProgressState;", "barState", "e", "getBarSubtitle", "barSubtitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLcom/avito/android/paid_services/routing/ProgressState;Ljava/lang/String;Lcom/avito/android/paid_services/routing/TariffCountStatus;Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditPackageItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final List<EditPackageMicroCategoryItem> b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    public final float f;
    @NotNull
    public final ProgressState g;
    @Nullable
    public final String h;
    @NotNull
    public final TariffCountStatus i;
    @NotNull
    public final DeepLink j;

    public EditPackageItem(@NotNull String str, @Nullable List<EditPackageMicroCategoryItem> list, @NotNull String str2, @NotNull String str3, @Nullable String str4, float f2, @NotNull ProgressState progressState, @Nullable String str5, @NotNull TariffCountStatus tariffCountStatus, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "locations");
        Intrinsics.checkNotNullParameter(str3, "barTitle");
        Intrinsics.checkNotNullParameter(progressState, "barState");
        Intrinsics.checkNotNullParameter(tariffCountStatus, "barDescriptionStatus");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = f2;
        this.g = progressState;
        this.h = str5;
        this.i = tariffCountStatus;
        this.j = deepLink;
    }

    @Nullable
    public final String getBarDescription() {
        return this.h;
    }

    @NotNull
    public final TariffCountStatus getBarDescriptionStatus() {
        return this.i;
    }

    public final float getBarProgress() {
        return this.f;
    }

    @NotNull
    public final ProgressState getBarState() {
        return this.g;
    }

    @Nullable
    public final String getBarSubtitle() {
        return this.e;
    }

    @NotNull
    public final String getBarTitle() {
        return this.d;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getLocations() {
        return this.c;
    }

    @Nullable
    public final List<EditPackageMicroCategoryItem> getMicroCategories() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
