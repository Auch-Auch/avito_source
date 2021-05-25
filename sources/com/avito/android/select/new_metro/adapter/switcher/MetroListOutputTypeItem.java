package com.avito.android.select.new_metro.adapter.switcher;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;", "component2", "()Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;", "stringId", "selectedType", "copy", "(Ljava/lang/String;Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;)Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;", "getSelectedType", "setSelectedType", "(Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;)V", "<init>", "(Ljava/lang/String;Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;)V", "OutputType", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroListOutputTypeItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public OutputType b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/switcher/MetroListOutputTypeItem$OutputType;", "", "<init>", "(Ljava/lang/String;I)V", "ByAlphabet", "ByLines", "select_release"}, k = 1, mv = {1, 4, 2})
    public enum OutputType {
        ByAlphabet,
        ByLines
    }

    public MetroListOutputTypeItem(@NotNull String str, @NotNull OutputType outputType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(outputType, "selectedType");
        this.a = str;
        this.b = outputType;
    }

    public static /* synthetic */ MetroListOutputTypeItem copy$default(MetroListOutputTypeItem metroListOutputTypeItem, String str, OutputType outputType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metroListOutputTypeItem.getStringId();
        }
        if ((i & 2) != 0) {
            outputType = metroListOutputTypeItem.b;
        }
        return metroListOutputTypeItem.copy(str, outputType);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final OutputType component2() {
        return this.b;
    }

    @NotNull
    public final MetroListOutputTypeItem copy(@NotNull String str, @NotNull OutputType outputType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(outputType, "selectedType");
        return new MetroListOutputTypeItem(str, outputType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetroListOutputTypeItem)) {
            return false;
        }
        MetroListOutputTypeItem metroListOutputTypeItem = (MetroListOutputTypeItem) obj;
        return Intrinsics.areEqual(getStringId(), metroListOutputTypeItem.getStringId()) && Intrinsics.areEqual(this.b, metroListOutputTypeItem.b);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final OutputType getSelectedType() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        OutputType outputType = this.b;
        if (outputType != null) {
            i = outputType.hashCode();
        }
        return hashCode + i;
    }

    public final void setSelectedType(@NotNull OutputType outputType) {
        Intrinsics.checkNotNullParameter(outputType, "<set-?>");
        this.b = outputType;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MetroListOutputTypeItem(stringId=");
        L.append(getStringId());
        L.append(", selectedType=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
