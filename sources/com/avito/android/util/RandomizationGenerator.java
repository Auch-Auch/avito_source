package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/RandomizationGenerator;", "", "", "min", "max", "nextLong", "(JJ)J", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public interface RandomizationGenerator {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ long nextLong$default(RandomizationGenerator randomizationGenerator, long j, long j2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = 0;
                }
                if ((i & 2) != 0) {
                    j2 = Long.MAX_VALUE;
                }
                return randomizationGenerator.nextLong(j, j2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextLong");
        }
    }

    long nextLong(long j, long j2);
}
