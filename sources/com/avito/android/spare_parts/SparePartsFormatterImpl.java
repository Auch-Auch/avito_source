package com.avito.android.spare_parts;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017JI\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/spare_parts/SparePartsFormatterImpl;", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "Landroid/content/Context;", "context", "", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", "groups", "Lcom/avito/android/remote/models/SparePartsResponse$Specification;", "specifications", "Lcom/avito/android/spare_parts/SparePartsItemClickListener;", "itemClickListener", "", "format", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/avito/android/spare_parts/SparePartsItemClickListener;)Ljava/util/List;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "resourcesProvider", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/spare_parts/SparePartsResourceProvider;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsFormatterImpl implements SparePartsFormatter {
    public final AttributedTextFormatter a;
    public final SparePartsResourceProvider b;

    @Inject
    public SparePartsFormatterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull SparePartsResourceProvider sparePartsResourceProvider) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(sparePartsResourceProvider, "resourcesProvider");
        this.a = attributedTextFormatter;
        this.b = sparePartsResourceProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086 A[SYNTHETIC] */
    @Override // com.avito.android.spare_parts.SparePartsFormatter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.CharSequence> format(@org.jetbrains.annotations.NotNull android.content.Context r17, @org.jetbrains.annotations.Nullable java.util.List<com.avito.android.remote.models.SparePartsResponse.SparePartsGroup> r18, @org.jetbrains.annotations.Nullable java.util.List<com.avito.android.remote.models.SparePartsResponse.Specification> r19, @org.jetbrains.annotations.Nullable com.avito.android.spare_parts.SparePartsItemClickListener r20) {
        /*
        // Method dump skipped, instructions count: 283
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.spare_parts.SparePartsFormatterImpl.format(android.content.Context, java.util.List, java.util.List, com.avito.android.spare_parts.SparePartsItemClickListener):java.util.List");
    }
}
