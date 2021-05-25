package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Random;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/DefaultRandomizationGenerator;", "Lcom/avito/android/util/RandomizationGenerator;", "", "min", "max", "nextLong", "(JJ)J", "Ljava/util/Random;", AuthSource.SEND_ABUSE, "Ljava/util/Random;", "random", "<init>", "()V", VKApiConst.LANG}, k = 1, mv = {1, 4, 2})
public final class DefaultRandomizationGenerator implements RandomizationGenerator {
    public final Random a = new Random(System.currentTimeMillis());

    @Override // com.avito.android.util.RandomizationGenerator
    public long nextLong(long j, long j2) {
        boolean z = true;
        if (j >= 0) {
            if (j2 >= 0) {
                int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i > 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("The max value must be greater than or equal to the min value".toString());
                } else if (i == 0) {
                    return j2;
                } else {
                    return (LongsKt.abs(this.a.nextLong()) % LongsKt.abs(j2 - j)) + j;
                }
            } else {
                throw new IllegalArgumentException("The max value must be 0 or greater".toString());
            }
        } else {
            throw new IllegalArgumentException("The min value must be 0 or greater".toString());
        }
    }
}
