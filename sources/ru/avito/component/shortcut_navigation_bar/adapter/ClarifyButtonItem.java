package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ClarifyButtonItem;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ClarifyButtonItem extends ShortcutNavigationItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final DeepLink c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClarifyButtonItem(@NotNull String str, @NotNull String str2, @Nullable DeepLink deepLink) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a = str;
        this.b = str2;
        this.c = deepLink;
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
}
