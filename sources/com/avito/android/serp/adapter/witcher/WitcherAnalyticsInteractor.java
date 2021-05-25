package com.avito.android.serp.adapter.witcher;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor;", "", "Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor$FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "", "sendClickWitcher", "(Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor$FromBlock;)V", "FromBlock", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface WitcherAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherAnalyticsInteractor$FromBlock;", "", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "BUTTON", "HEADER", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum FromBlock {
        BUTTON(0),
        HEADER(1);
        
        public final int a;

        /* access modifiers changed from: public */
        FromBlock(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    void sendClickWitcher(@NotNull FromBlock fromBlock);
}
