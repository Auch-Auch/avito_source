package com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title;

import a2.b.a.a.a;
import com.avito.android.conveyor_shared_item.single_text.SingleTextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0005R\u001c\u0010\u001b\u001a\u00020\n8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleItem;", "Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/tab_screens/advert_list/shortcut_title/ShortcutTitleItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "stringId", "c", "getTitle", AuthSource.BOOKING_ORDER, "I", "getSpanCount", "spanCount", "<init>", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutTitleItem implements SingleTextItem, SerpItem {
    @NotNull
    public final String a = a.I2("UUID.randomUUID().toString()");
    public final int b = 1;
    @NotNull
    public final String c;

    public ShortcutTitleItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c = str;
    }

    public static /* synthetic */ ShortcutTitleItem copy$default(ShortcutTitleItem shortcutTitleItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shortcutTitleItem.getTitle();
        }
        return shortcutTitleItem.copy(str);
    }

    @NotNull
    public final String component1() {
        return getTitle();
    }

    @NotNull
    public final ShortcutTitleItem copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new ShortcutTitleItem(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ShortcutTitleItem) && Intrinsics.areEqual(getTitle(), ((ShortcutTitleItem) obj).getTitle());
        }
        return true;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SingleTextItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.conveyor_shared_item.single_text.SingleTextItem
    @NotNull
    public String getTitle() {
        return this.c;
    }

    public int hashCode() {
        String title = getTitle();
        if (title != null) {
            return title.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShortcutTitleItem(title=");
        L.append(getTitle());
        L.append(")");
        return L.toString();
    }
}
