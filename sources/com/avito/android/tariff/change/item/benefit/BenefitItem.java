package com.avito.android.tariff.change.item.benefit;

import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/tariff/change/item/benefit/BenefitItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;", "c", "Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;", "getIcon", "()Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/tariff/change/item/benefit/BenefitIcon;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final BenefitIcon c;

    public BenefitItem(@NotNull String str, @NotNull String str2, @NotNull BenefitIcon benefitIcon) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(benefitIcon, "icon");
        this.a = str;
        this.b = str2;
        this.c = benefitIcon;
    }

    @NotNull
    public final BenefitIcon getIcon() {
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

    @NotNull
    public final String getText() {
        return this.b;
    }
}
