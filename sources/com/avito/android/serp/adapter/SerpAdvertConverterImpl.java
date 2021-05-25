package com.avito.android.serp.adapter;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/serp/adapter/SerpAdvertConverterImpl;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "Lcom/avito/android/remote/model/SerpAdvert;", "serpAdvert", "", "isVip", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lcom/avito/android/serp/adapter/AdvertItem;", "convert", "(Lcom/avito/android/remote/model/SerpAdvert;ZLcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;", "itemSpanCountProvider", AuthSource.BOOKING_ORDER, "bigSpanCountProvider", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "c", "Z", "isTablet", "<init>", "(Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;Lcom/avito/android/serp/adapter/AdvertSpanCountProvider;ZLcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertConverterImpl implements SerpAdvertConverter {
    public final AdvertSpanCountProvider a;
    public final AdvertSpanCountProvider b;
    public final boolean c;
    public final Features d;

    public SerpAdvertConverterImpl(@NotNull AdvertSpanCountProvider advertSpanCountProvider, @NotNull AdvertSpanCountProvider advertSpanCountProvider2, boolean z, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertSpanCountProvider, "itemSpanCountProvider");
        Intrinsics.checkNotNullParameter(advertSpanCountProvider2, "bigSpanCountProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = advertSpanCountProvider;
        this.b = advertSpanCountProvider2;
        this.c = z;
        this.d = features;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ad  */
    @Override // com.avito.android.serp.adapter.SerpAdvertConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.serp.adapter.AdvertItem convert(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.SerpAdvert r63, boolean r64, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.SerpDisplayType r65) {
        /*
        // Method dump skipped, instructions count: 454
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.SerpAdvertConverterImpl.convert(com.avito.android.remote.model.SerpAdvert, boolean, com.avito.android.remote.model.SerpDisplayType):com.avito.android.serp.adapter.AdvertItem");
    }
}
