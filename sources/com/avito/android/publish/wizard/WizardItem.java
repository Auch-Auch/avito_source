package com.avito.android.publish.wizard;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/avito/android/publish/wizard/WizardItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Navigation;", "component3", "()Lcom/avito/android/remote/model/Navigation;", "title", MessengerShareContentUtility.SUBTITLE, "navigation", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/publish/wizard/WizardItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "c", "getSubtitle", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final Navigation d;

    public WizardItem(@NotNull String str, @Nullable String str2, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        this.b = str;
        this.c = str2;
        this.d = navigation;
        this.a = navigation.toString();
    }

    public static /* synthetic */ WizardItem copy$default(WizardItem wizardItem, String str, String str2, Navigation navigation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wizardItem.b;
        }
        if ((i & 2) != 0) {
            str2 = wizardItem.c;
        }
        if ((i & 4) != 0) {
            navigation = wizardItem.d;
        }
        return wizardItem.copy(str, str2, navigation);
    }

    @NotNull
    public final String component1() {
        return this.b;
    }

    @Nullable
    public final String component2() {
        return this.c;
    }

    @NotNull
    public final Navigation component3() {
        return this.d;
    }

    @NotNull
    public final WizardItem copy(@NotNull String str, @Nullable String str2, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        return new WizardItem(str, str2, navigation);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WizardItem)) {
            return false;
        }
        WizardItem wizardItem = (WizardItem) obj;
        return Intrinsics.areEqual(this.b, wizardItem.b) && Intrinsics.areEqual(this.c, wizardItem.c) && Intrinsics.areEqual(this.d, wizardItem.d);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.d;
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

    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Navigation navigation = this.d;
        if (navigation != null) {
            i = navigation.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("WizardItem(title=");
        L.append(this.b);
        L.append(", subtitle=");
        L.append(this.c);
        L.append(", navigation=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardItem(String str, String str2, Navigation navigation, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, navigation);
    }
}
