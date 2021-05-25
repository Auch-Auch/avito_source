package com.avito.android.tariff.fees_methods.items.bar;

import a2.g.r.g;
import com.avito.android.paid_services.routing.ProgressState;
import com.avito.android.paid_services.routing.TariffCountStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/bar/BarItem;", "Lcom/avito/conveyor_item/Item;", "", "d", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "e", "Lcom/avito/android/paid_services/routing/TariffCountStatus;", "getDescriptionStatus", "()Lcom/avito/android/paid_services/routing/TariffCountStatus;", "descriptionStatus", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/paid_services/routing/ProgressState;", g.a, "Lcom/avito/android/paid_services/routing/ProgressState;", "getProgressState", "()Lcom/avito/android/paid_services/routing/ProgressState;", "progressState", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "f", "F", "getProgress", "()F", "progress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/paid_services/routing/TariffCountStatus;FLcom/avito/android/paid_services/routing/ProgressState;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BarItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final TariffCountStatus e;
    public final float f;
    @NotNull
    public final ProgressState g;

    public BarItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable TariffCountStatus tariffCountStatus, float f2, @NotNull ProgressState progressState) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(progressState, "progressState");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = tariffCountStatus;
        this.f = f2;
        this.g = progressState;
    }

    @Nullable
    public final String getDescription() {
        return this.d;
    }

    @Nullable
    public final TariffCountStatus getDescriptionStatus() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final float getProgress() {
        return this.f;
    }

    @NotNull
    public final ProgressState getProgressState() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubtitle() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }
}
