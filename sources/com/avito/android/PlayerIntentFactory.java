package com.avito.android;

import android.content.Intent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.rec.ScreenSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JM\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/PlayerIntentFactory;", "", "", "url", "slug", "blockType", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "playerIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent playerIntent$default(PlayerIntentFactory playerIntentFactory, String str, String str2, String str3, TreeClickStreamParent treeClickStreamParent, ScreenSource screenSource, NavigationTab navigationTab, int i, Object obj) {
            if (obj == null) {
                return playerIntentFactory.playerIntent(str, str2, str3, (i & 8) != 0 ? null : treeClickStreamParent, (i & 16) != 0 ? ScreenSource.EMPTY.INSTANCE : screenSource, (i & 32) != 0 ? null : navigationTab);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playerIntent");
        }
    }

    @NotNull
    Intent playerIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource, @Nullable NavigationTab navigationTab);
}
