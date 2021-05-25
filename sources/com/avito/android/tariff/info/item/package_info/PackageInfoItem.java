package com.avito.android.tariff.info.item.package_info;

import a2.g.r.g;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010+\u001a\u00020&\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b,\u0010-R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/tariff/info/item/package_info/PackageInfoItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "j", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "getBarDescriptionStatus", "()Lcom/avito/android/paid_services/routing/TariffCountStatus;", "barDescriptionStatus", "c", "getSubcategories", "subcategories", "", g.a, "F", "getBarProgress", "()F", "barProgress", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "getLocations", "locations", "f", "getBarSubtitle", "barSubtitle", "i", "getBarDescription", "barDescription", "e", "getBarTitle", "barTitle", "Lcom/avito/android/paid_services/routing/ProgressState;", "h", "Lcom/avito/android/paid_services/routing/ProgressState;", "getBarState", "()Lcom/avito/android/paid_services/routing/ProgressState;", "barState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLcom/avito/android/paid_services/routing/ProgressState;Ljava/lang/String;Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PackageInfoItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @Nullable
    public final String f;
    public final float g;
    @NotNull
    public final ProgressState h;
    @Nullable
    public final String i;
    @NotNull
    public final TariffCountStatus j;

    public PackageInfoItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, float f2, @NotNull ProgressState progressState, @Nullable String str7, @NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str4, "locations");
        Intrinsics.checkNotNullParameter(str5, "barTitle");
        Intrinsics.checkNotNullParameter(progressState, "barState");
        Intrinsics.checkNotNullParameter(tariffCountStatus, "barDescriptionStatus");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = f2;
        this.h = progressState;
        this.i = str7;
        this.j = tariffCountStatus;
    }

    @Nullable
    public final String getBarDescription() {
        return this.i;
    }

    @NotNull
    public final TariffCountStatus getBarDescriptionStatus() {
        return this.j;
    }

    public final float getBarProgress() {
        return this.g;
    }

    @NotNull
    public final ProgressState getBarState() {
        return this.h;
    }

    @Nullable
    public final String getBarSubtitle() {
        return this.f;
    }

    @NotNull
    public final String getBarTitle() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getLocations() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubcategories() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }
}
