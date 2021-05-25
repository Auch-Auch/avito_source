package com.avito.android.player.presenter.analytics.events;

import com.avito.android.rec.ScreenSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/player/presenter/analytics/events/PlayerMediaFirstQuartileEvent;", "Lcom/avito/android/player/presenter/analytics/events/PlayerEvent;", "", "mediaName", "Lcom/avito/android/rec/ScreenSource;", "fromSource", "blockType", "slug", "<init>", "(Ljava/lang/String;Lcom/avito/android/rec/ScreenSource;Ljava/lang/String;Ljava/lang/String;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerMediaFirstQuartileEvent extends PlayerEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerMediaFirstQuartileEvent(@NotNull String str, @NotNull ScreenSource screenSource, @Nullable String str2, @Nullable String str3) {
        super(str, screenSource, str2, str3, 4784, 2);
        Intrinsics.checkNotNullParameter(str, "mediaName");
        Intrinsics.checkNotNullParameter(screenSource, "fromSource");
    }
}
