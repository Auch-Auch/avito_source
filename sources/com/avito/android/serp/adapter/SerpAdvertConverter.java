package com.avito.android.serp.adapter;

import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "", "Lcom/avito/android/remote/model/SerpAdvert;", "serpAdvert", "", "isVip", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/AdvertItem;", "convert", "(Lcom/avito/android/remote/model/SerpAdvert;ZLcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/AdvertItem;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ AdvertItem convert$default(SerpAdvertConverter serpAdvertConverter, SerpAdvert serpAdvert, boolean z, SerpDisplayType serpDisplayType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    serpDisplayType = SerpDisplayType.Grid;
                }
                return serpAdvertConverter.convert(serpAdvert, z, serpDisplayType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @NotNull
    AdvertItem convert(@NotNull SerpAdvert serpAdvert, boolean z, @NotNull SerpDisplayType serpDisplayType);
}
