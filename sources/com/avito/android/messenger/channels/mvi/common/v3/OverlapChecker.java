package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \b*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\bJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "", "KeyT", "key", "otherKey", "", "checkOverlap", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Companion", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface OverlapChecker<KeyT> {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ]\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0002*\u00020\u000128\b\u0004\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker$Companion;", "", "KeyT", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "otherKey", "", "checkOverlapBlock", "Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "create", "(Lkotlin/jvm/functions/Function2;)Lcom/avito/android/messenger/channels/mvi/common/v3/OverlapChecker;", "<init>", "()V", "mvi_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <KeyT> OverlapChecker<KeyT> create(@NotNull Function2<? super KeyT, ? super KeyT, Boolean> function2) {
            Intrinsics.checkNotNullParameter(function2, "checkOverlapBlock");
            return new OverlapChecker$Companion$create$1(function2);
        }
    }

    boolean checkOverlap(@NotNull KeyT keyt, @NotNull KeyT keyt2);
}
