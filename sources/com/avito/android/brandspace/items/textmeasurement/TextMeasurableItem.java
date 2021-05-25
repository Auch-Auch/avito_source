package com.avito.android.brandspace.items.textmeasurement;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "", "", "getPrecalculatedTextHeight", "()I", "setPrecalculatedTextHeight", "(I)V", "precalculatedTextHeight", "getPrecalculatedMetricsHash", "setPrecalculatedMetricsHash", "precalculatedMetricsHash", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface TextMeasurableItem {
    int getPrecalculatedMetricsHash();

    int getPrecalculatedTextHeight();

    void setPrecalculatedMetricsHash(int i);

    void setPrecalculatedTextHeight(int i);
}
