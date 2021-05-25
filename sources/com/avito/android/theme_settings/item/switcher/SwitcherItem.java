package com.avito.android.theme_settings.item.switcher;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.viewmodel.ThemeModeItemState;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00128\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010\u0005¨\u0006*"}, d2 = {"Lcom/avito/android/theme_settings/item/switcher/SwitcherItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "component4", "()Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "state", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;)Lcom/avito/android/theme_settings/item/switcher/SwitcherItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getSpanCount", "spanCount", "d", "Ljava/lang/String;", "getSubtitle", "e", "Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "getState", "c", "getTitle", AuthSource.BOOKING_ORDER, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItem implements Item, SpannedItem {
    public final int a = 2;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final ThemeModeItemState e;

    public SwitcherItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull ThemeModeItemState themeModeItemState) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(themeModeItemState, "state");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = themeModeItemState;
    }

    public static /* synthetic */ SwitcherItem copy$default(SwitcherItem switcherItem, String str, String str2, String str3, ThemeModeItemState themeModeItemState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = switcherItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = switcherItem.c;
        }
        if ((i & 4) != 0) {
            str3 = switcherItem.d;
        }
        if ((i & 8) != 0) {
            themeModeItemState = switcherItem.e;
        }
        return switcherItem.copy(str, str2, str3, themeModeItemState);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.c;
    }

    @NotNull
    public final String component3() {
        return this.d;
    }

    @NotNull
    public final ThemeModeItemState component4() {
        return this.e;
    }

    @NotNull
    public final SwitcherItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull ThemeModeItemState themeModeItemState) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(themeModeItemState, "state");
        return new SwitcherItem(str, str2, str3, themeModeItemState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitcherItem)) {
            return false;
        }
        SwitcherItem switcherItem = (SwitcherItem) obj;
        return Intrinsics.areEqual(getStringId(), switcherItem.getStringId()) && Intrinsics.areEqual(this.c, switcherItem.c) && Intrinsics.areEqual(this.d, switcherItem.d) && Intrinsics.areEqual(this.e, switcherItem.e);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.a;
    }

    @NotNull
    public final ThemeModeItemState getState() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final String getSubtitle() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ThemeModeItemState themeModeItemState = this.e;
        if (themeModeItemState != null) {
            i = themeModeItemState.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SwitcherItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", subtitle=");
        L.append(this.d);
        L.append(", state=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}
