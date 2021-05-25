package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemImpl;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "", "d", "Z", "isPrimary", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", AuthSource.BOOKING_ORDER, "getText", "text", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationItemImpl extends ShortcutNavigationItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final DeepLink c;
    public final boolean d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortcutNavigationItemImpl(@NotNull String str, @NotNull String str2, @Nullable DeepLink deepLink, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a = str;
        this.b = str2;
        this.c = deepLink;
        this.d = z;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @Nullable
    public DeepLink getDeepLink() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @NotNull
    public String getText() {
        return this.b;
    }

    public final boolean isPrimary() {
        return this.d;
    }
}
