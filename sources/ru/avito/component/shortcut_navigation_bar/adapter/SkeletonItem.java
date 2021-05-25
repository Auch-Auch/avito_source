package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0017"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", "c", "Z", "isPrimary", "()Z", "", "deepLink", "Ljava/lang/Void;", "getDeepLink", "()Ljava/lang/Void;", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SkeletonItem extends ShortcutNavigationItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final boolean c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SkeletonItem(@NotNull String str, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.b = str;
        this.c = z;
        this.a = "";
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @Nullable
    public Void getDeepLink() {
        return null;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @NotNull
    public String getText() {
        return this.a;
    }

    public final boolean isPrimary() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SkeletonItem(String str, boolean z, int i, j jVar) {
        this(str, (i & 2) != 0 ? false : z);
    }
}
