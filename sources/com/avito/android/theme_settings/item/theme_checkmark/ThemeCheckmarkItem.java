package com.avito.android.theme_settings.item.theme_checkmark;

import a2.b.a.a.a;
import android.graphics.drawable.Drawable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.viewmodel.ThemeModeItemState;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000e\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\tR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\fR\u001c\u0010(\u001a\u00020\u00148\u0016@\u0016XD¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0016R\u001c\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u0005¨\u0006-"}, d2 = {"Lcom/avito/android/theme_settings/item/theme_checkmark/ThemeCheckmarkItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/serp/adapter/SpannedItem;", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/graphics/drawable/Drawable;", "component3", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "component4", "()Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "stringId", "title", "image", "state", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;)Lcom/avito/android/theme_settings/item/theme_checkmark/ThemeCheckmarkItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getTitle", "d", "Landroid/graphics/drawable/Drawable;", "getImage", "e", "Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;", "getState", AuthSource.SEND_ABUSE, "I", "getSpanCount", "spanCount", AuthSource.BOOKING_ORDER, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/avito/android/theme_settings/viewmodel/ThemeModeItemState;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeCheckmarkItem implements Item, SpannedItem {
    public final int a = 1;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final Drawable d;
    @NotNull
    public final ThemeModeItemState e;

    public ThemeCheckmarkItem(@NotNull String str, @NotNull String str2, @NotNull Drawable drawable, @NotNull ThemeModeItemState themeModeItemState) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(drawable, "image");
        Intrinsics.checkNotNullParameter(themeModeItemState, "state");
        this.b = str;
        this.c = str2;
        this.d = drawable;
        this.e = themeModeItemState;
    }

    public static /* synthetic */ ThemeCheckmarkItem copy$default(ThemeCheckmarkItem themeCheckmarkItem, String str, String str2, Drawable drawable, ThemeModeItemState themeModeItemState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = themeCheckmarkItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = themeCheckmarkItem.c;
        }
        if ((i & 4) != 0) {
            drawable = themeCheckmarkItem.d;
        }
        if ((i & 8) != 0) {
            themeModeItemState = themeCheckmarkItem.e;
        }
        return themeCheckmarkItem.copy(str, str2, drawable, themeModeItemState);
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
    public final Drawable component3() {
        return this.d;
    }

    @NotNull
    public final ThemeModeItemState component4() {
        return this.e;
    }

    @NotNull
    public final ThemeCheckmarkItem copy(@NotNull String str, @NotNull String str2, @NotNull Drawable drawable, @NotNull ThemeModeItemState themeModeItemState) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(drawable, "image");
        Intrinsics.checkNotNullParameter(themeModeItemState, "state");
        return new ThemeCheckmarkItem(str, str2, drawable, themeModeItemState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThemeCheckmarkItem)) {
            return false;
        }
        ThemeCheckmarkItem themeCheckmarkItem = (ThemeCheckmarkItem) obj;
        return Intrinsics.areEqual(getStringId(), themeCheckmarkItem.getStringId()) && Intrinsics.areEqual(this.c, themeCheckmarkItem.c) && Intrinsics.areEqual(this.d, themeCheckmarkItem.d) && Intrinsics.areEqual(this.e, themeCheckmarkItem.e);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final Drawable getImage() {
        return this.d;
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
    public final String getTitle() {
        return this.c;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Drawable drawable = this.d;
        int hashCode3 = (hashCode2 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        ThemeModeItemState themeModeItemState = this.e;
        if (themeModeItemState != null) {
            i = themeModeItemState.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ThemeCheckmarkItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.c);
        L.append(", image=");
        L.append(this.d);
        L.append(", state=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }
}
