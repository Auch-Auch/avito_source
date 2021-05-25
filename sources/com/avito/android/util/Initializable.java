package com.avito.android.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/util/Initializable;", "", "", "isInitialized", "()Z", "Lkotlin/Function0;", "", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public interface Initializable {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.util.Initializable */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initialize$default(Initializable initializable, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function0 = null;
                }
                initializable.initialize(function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
    }

    void initialize(@Nullable Function0<Unit> function0);

    boolean isInitialized();
}
