package com.avito.android.player.presenter.analytics.events;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.SimpleClickStreamEvent;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/avito/android/player/presenter/analytics/events/PlayerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "mediaName", "Lcom/avito/android/rec/ScreenSource;", "fromSource", "blockType", "slug", "<init>", "(Ljava/lang/String;Lcom/avito/android/rec/ScreenSource;Ljava/lang/String;Ljava/lang/String;II)V", "player_release"}, k = 1, mv = {1, 4, 2})
public class PlayerEvent implements ClickStreamEvent {
    @NotNull
    public final Map<String, Object> a;
    public final /* synthetic */ SimpleClickStreamEvent b;

    public PlayerEvent(@NotNull String str, @NotNull ScreenSource screenSource, @Nullable String str2, @Nullable String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "mediaName");
        Intrinsics.checkNotNullParameter(screenSource, "fromSource");
        this.b = new SimpleClickStreamEvent(i, i2);
        Map<String, Object> mutableMapOf = r.mutableMapOf(TuplesKt.to("media_name", str), TuplesKt.to("from_source", screenSource.getSource()));
        if (str2 != null) {
            mutableMapOf.put("block_type", str2);
        }
        if (str3 != null) {
            mutableMapOf.put("slug", str3);
        }
        Unit unit = Unit.INSTANCE;
        this.a = mutableMapOf;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.b.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.b.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a;
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.b.getVersion();
    }
}
