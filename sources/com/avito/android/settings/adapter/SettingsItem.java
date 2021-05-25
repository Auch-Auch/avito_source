package com.avito.android.settings.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Category", "Divider", "Info", "InfoWithProgress", "ListItem", "LogoWithVersion", "Select", "Lcom/avito/android/settings/adapter/SettingsItem$Info;", "Lcom/avito/android/settings/adapter/SettingsItem$Select;", "Lcom/avito/android/settings/adapter/SettingsItem$ListItem;", "Lcom/avito/android/settings/adapter/SettingsItem$Category;", "Lcom/avito/android/settings/adapter/SettingsItem$LogoWithVersion;", "Lcom/avito/android/settings/adapter/SettingsItem$InfoWithProgress;", "Lcom/avito/android/settings/adapter/SettingsItem$Divider;", "settings_release"}, k = 1, mv = {1, 4, 2})
public abstract class SettingsItem implements Item {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$Category;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Category extends SettingsItem {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Category(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$Divider;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", "id", "<init>", "(Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Divider extends SettingsItem {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Divider(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$Info;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info extends SettingsItem {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Info(@NotNull String str, @NotNull String str2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$InfoWithProgress;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "Z", "getShowProgress", "()Z", "showProgress", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class InfoWithProgress extends SettingsItem {
        @NotNull
        public final String b;
        public final boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InfoWithProgress(@NotNull String str, @NotNull String str2, boolean z) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = z;
        }

        public final boolean getShowProgress() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$ListItem;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getValue", "value", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class ListItem extends SettingsItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ListItem(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super(str, null);
            a.Z0(str, "id", str2, "title", str3, "value");
            this.b = str2;
            this.c = str3;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @NotNull
        public final String getValue() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$LogoWithVersion;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", "c", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", AuthSource.BOOKING_ORDER, "getVersionId", "versionId", "logoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class LogoWithVersion extends SettingsItem {
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogoWithVersion(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super(str, null);
            a.Z0(str, "logoId", str2, "versionId", str3, "version");
            this.b = str2;
            this.c = str3;
        }

        @NotNull
        public final String getVersion() {
            return this.c;
        }

        @NotNull
        public final String getVersionId() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/settings/adapter/SettingsItem$Select;", "Lcom/avito/android/settings/adapter/SettingsItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getValue", "value", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Select extends SettingsItem {
        @NotNull
        public final String b;
        @Nullable
        public final String c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Select(String str, String str2, String str3, int i, j jVar) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Nullable
        public final String getValue() {
            return this.c;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(@NotNull String str, @NotNull String str2, @Nullable String str3) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = str3;
        }
    }

    public SettingsItem(String str, j jVar) {
        this.a = str;
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
}
