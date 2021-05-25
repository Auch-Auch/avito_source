package com.avito.android.tariff.tariff_package_info.recycler.header;

import a2.g.r.g;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/header/TariffPackageHeaderItem;", "Lcom/avito/conveyor_item/Item;", "", "f", "Ljava/lang/String;", "getBarDescription", "()Ljava/lang/String;", "barDescription", "Lcom/avito/android/paid_services/routing/ProgressState;", "e", "Lcom/avito/android/paid_services/routing/ProgressState;", "getBarState", "()Lcom/avito/android/paid_services/routing/ProgressState;", "barState", "c", "getBarTitle", "barTitle", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "", "d", "F", "getBarProgress", "()F", "barProgress", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", g.a, "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "getBarDescriptionStatus", "()Lcom/avito/android/paid_services/routing/TariffCountStatus;", "barDescriptionStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLcom/avito/android/paid_services/routing/ProgressState;Ljava/lang/String;Lcom/avito/android/paid_services/routing/TariffCountStatus;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageHeaderItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @NotNull
    public final String c;
    public final float d;
    @NotNull
    public final ProgressState e;
    @Nullable
    public final String f;
    @NotNull
    public final TariffCountStatus g;

    public TariffPackageHeaderItem(@NotNull String str, @Nullable String str2, @NotNull String str3, float f2, @NotNull ProgressState progressState, @Nullable String str4, @NotNull TariffCountStatus tariffCountStatus) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str3, "barTitle");
        Intrinsics.checkNotNullParameter(progressState, "barState");
        Intrinsics.checkNotNullParameter(tariffCountStatus, "barDescriptionStatus");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = f2;
        this.e = progressState;
        this.f = str4;
        this.g = tariffCountStatus;
    }

    @Nullable
    public final String getBarDescription() {
        return this.f;
    }

    @NotNull
    public final TariffCountStatus getBarDescriptionStatus() {
        return this.g;
    }

    public final float getBarProgress() {
        return this.d;
    }

    @NotNull
    public final ProgressState getBarState() {
        return this.e;
    }

    @NotNull
    public final String getBarTitle() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }
}
