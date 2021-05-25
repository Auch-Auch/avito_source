package com.avito.android.user_advert.advert;

import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverterImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "advert", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "convert", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails;)Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "Lcom/avito/android/html_formatter/HtmlCleaner;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "c", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/html_formatter/HtmlRenderer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "<init>", "(Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlRenderOptions;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsConverterImpl implements MyAdvertDetailsConverter {
    public final HtmlRenderer a;
    public final HtmlCleaner b;
    public final HtmlRenderOptions c;

    @Inject
    public MyAdvertDetailsConverterImpl(@NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        this.a = htmlRenderer;
        this.b = htmlCleaner;
        this.c = htmlRenderOptions;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0179, code lost:
        if (r2 != null) goto L_0x0191;
     */
    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.user_advert.advert.MyAdvertDetailsItem convert(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.adverts.MyAdvertDetails r60) {
        /*
        // Method dump skipped, instructions count: 539
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.MyAdvertDetailsConverterImpl.convert(com.avito.android.remote.model.adverts.MyAdvertDetails):com.avito.android.user_advert.advert.MyAdvertDetailsItem");
    }
}
