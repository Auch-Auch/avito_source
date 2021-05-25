package com.avito.android.tariff.fees_methods.items.high_demand;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FeeMethodBottomSheet;
import com.avito.android.remote.model.HighDemandIcon;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/high_demand/HighDemandItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "d", "Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "getBottomSheet", "()Lcom/avito/android/remote/model/FeeMethodBottomSheet;", "bottomSheet", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/HighDemandIcon;", "e", "Lcom/avito/android/remote/model/HighDemandIcon;", "getIcon", "()Lcom/avito/android/remote/model/HighDemandIcon;", "icon", "c", "getActionTitle", "actionTitle", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/FeeMethodBottomSheet;Lcom/avito/android/remote/model/HighDemandIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class HighDemandItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final AttributedText b;
    @Nullable
    public final String c;
    @Nullable
    public final FeeMethodBottomSheet d;
    @Nullable
    public final HighDemandIcon e;

    public HighDemandItem(@NotNull String str, @Nullable AttributedText attributedText, @Nullable String str2, @Nullable FeeMethodBottomSheet feeMethodBottomSheet, @Nullable HighDemandIcon highDemandIcon) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = attributedText;
        this.c = str2;
        this.d = feeMethodBottomSheet;
        this.e = highDemandIcon;
    }

    @Nullable
    public final String getActionTitle() {
        return this.c;
    }

    @Nullable
    public final FeeMethodBottomSheet getBottomSheet() {
        return this.d;
    }

    @Nullable
    public final HighDemandIcon getIcon() {
        return this.e;
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
    public final AttributedText getTitle() {
        return this.b;
    }
}
