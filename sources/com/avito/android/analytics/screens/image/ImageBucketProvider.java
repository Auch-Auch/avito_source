package com.avito.android.analytics.screens.image;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.audio.AacUtil;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getBucket", "(II)Ljava/lang/String;", "Impl", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public interface ImageBucketProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/screens/image/ImageBucketProvider$Impl;", "Lcom/avito/android/analytics/screens/image/ImageBucketProvider;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getBucket", "(II)Ljava/lang/String;", "Ljava/util/SortedMap;", AuthSource.SEND_ABUSE, "Ljava/util/SortedMap;", "buckets", "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements ImageBucketProvider {
        public final SortedMap<Integer, String> a = q.sortedMapOf(TuplesKt.to(10000, "10000"), TuplesKt.to(50000, "50000"), TuplesKt.to(Integer.valueOf((int) AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND), "100000"), TuplesKt.to(250000, "250000"), TuplesKt.to(500000, "500000"), TuplesKt.to(750000, "750000"), TuplesKt.to(1000000, "1000000"), TuplesKt.to(1500000, "1500000"), TuplesKt.to(2000000, "2000000"), TuplesKt.to(4000000, "4000000"));

        @Override // com.avito.android.analytics.screens.image.ImageBucketProvider
        @NotNull
        public String getBucket(int i, int i2) {
            int i3 = i * i2;
            for (Map.Entry<Integer, String> entry : this.a.entrySet()) {
                Integer key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "bucket.key");
                if (i3 < key.intValue()) {
                    String value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "bucket.value");
                    return value;
                }
            }
            return "big";
        }
    }

    @NotNull
    String getBucket(int i, int i2);
}
