package com.avito.android.serp;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/SerpElementReplacement;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", VKApiConst.POSITION, "Lcom/avito/android/remote/model/SerpElement;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SerpElement;", "getElement", "()Lcom/avito/android/remote/model/SerpElement;", "element", "<init>", "(Ljava/lang/Integer;Lcom/avito/android/remote/model/SerpElement;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpElementReplacement {
    @Nullable
    public final Integer a;
    @Nullable
    public final SerpElement b;

    public SerpElementReplacement(@Nullable Integer num, @Nullable SerpElement serpElement) {
        this.a = num;
        this.b = serpElement;
    }

    @Nullable
    public final SerpElement getElement() {
        return this.b;
    }

    @Nullable
    public final Integer getPosition() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpElementReplacement(Integer num, SerpElement serpElement, int i, j jVar) {
        this((i & 1) != 0 ? null : num, serpElement);
    }
}
