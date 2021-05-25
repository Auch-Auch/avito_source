package com.avito.android.shop.detailed;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.vk.sdk.api.VKApiConst;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop/detailed/ShopItemVisibilityTrackerImpl;", "Lcom/avito/android/shop/detailed/ShopItemVisibilityTracker;", "", VKApiConst.POSITION, "", "onItemBecomeVisible", "(I)V", "onItemBecomeInvisible", "Lcom/avito/android/shop/detailed/ShopItemsVisibilityData;", "getAndClearItemsData", "()Lcom/avito/android/shop/detailed/ShopItemsVisibilityData;", "", "time", AuthSource.SEND_ABUSE, "(IJ)V", "Lcom/avito/android/server_time/TimeSource;", "c", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "Ljava/util/Map;", "intermediateTimes", AuthSource.BOOKING_ORDER, "visibleTimes", "<init>", "(Lcom/avito/android/server_time/TimeSource;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItemVisibilityTrackerImpl implements ShopItemVisibilityTracker {
    public final Map<Integer, Long> a = new LinkedHashMap();
    public final Map<Integer, Long> b = new LinkedHashMap();
    public final TimeSource c;

    @Inject
    public ShopItemVisibilityTrackerImpl(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.c = timeSource;
    }

    public final void a(int i, long j) {
        long now = this.c.now() - j;
        Long l = this.b.get(Integer.valueOf(i));
        if (l == null) {
            this.b.put(Integer.valueOf(i), Long.valueOf(now));
        } else {
            this.b.put(Integer.valueOf(i), Long.valueOf(l.longValue() + now));
        }
    }

    @Override // com.avito.android.shop.detailed.ShopItemVisibilityProvider
    @NotNull
    public ShopItemsVisibilityData getAndClearItemsData() {
        for (Map.Entry<Integer, Long> entry : this.a.entrySet()) {
            a(entry.getKey().intValue(), entry.getValue().longValue());
        }
        int i = 0;
        int i2 = 0;
        for (Map.Entry<Integer, Long> entry2 : this.b.entrySet()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(entry2.getValue().longValue());
            double d = (double) seconds;
            if (d > 1.5d && seconds < ((long) 5)) {
                i++;
            } else if (d >= 5.0d) {
                i2++;
            }
        }
        this.a.clear();
        this.b.clear();
        return new ShopItemsVisibilityData(i, i2);
    }

    @Override // com.avito.android.shop.detailed.ShopItemVisibilityRecorder
    public void onItemBecomeInvisible(int i) {
        Long l = this.a.get(Integer.valueOf(i));
        if (l != null) {
            a(i, l.longValue());
        }
        this.a.remove(Integer.valueOf(i));
    }

    @Override // com.avito.android.shop.detailed.ShopItemVisibilityRecorder
    public void onItemBecomeVisible(int i) {
        this.a.put(Integer.valueOf(i), Long.valueOf(this.c.now()));
    }
}
