package com.avito.android.rating.publish;

import com.avito.android.remote.abuse.AbuseSendingResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/rating/publish/StateConsumer;", "", "", "itemId", "", "stageId", "", "score", AbuseSendingResult.COMMENT, "", "consumeState", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface StateConsumer {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void consumeState$default(StateConsumer stateConsumer, String str, Long l, Integer num, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    l = null;
                }
                if ((i & 4) != 0) {
                    num = null;
                }
                if ((i & 8) != 0) {
                    str2 = null;
                }
                stateConsumer.consumeState(str, l, num, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consumeState");
        }
    }

    void consumeState(@Nullable String str, @Nullable Long l, @Nullable Integer num, @Nullable String str2);
}
