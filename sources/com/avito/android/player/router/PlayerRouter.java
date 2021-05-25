package com.avito.android.player.router;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.rec.ScreenSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/player/router/PlayerRouter;", "", "", "url", "slug", "blockType", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "", "openPlayer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;)V", "closeScreen", "()V", "player_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerRouter {
    void closeScreen();

    void openPlayer(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource);
}
