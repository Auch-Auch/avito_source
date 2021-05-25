package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DfpBannerItem;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/ad/DfpBannerLoader;", "", "Lcom/avito/android/remote/model/DfpBannerItem;", "banner", "", "isFallback", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/ad/DfpBanner;", "loadBanner", "(Lcom/avito/android/remote/model/DfpBannerItem;Z)Lio/reactivex/rxjava3/core/Observable;", "DfpBannerLoadingException", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface DfpBannerLoader {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/ad/DfpBannerLoader$DfpBannerLoadingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "I", "getErrorCode", "()I", CommonKt.TAG_ERROR_CODE, "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class DfpBannerLoadingException extends Exception {
        public final int a;

        public DfpBannerLoadingException(int i) {
            this.a = i;
        }

        public final int getErrorCode() {
            return this.a;
        }
    }

    @NotNull
    Observable<DfpBanner> loadBanner(@NotNull DfpBannerItem dfpBannerItem, boolean z);
}
