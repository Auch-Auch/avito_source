package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HeaderElement;
import com.avito.android.serp.adapter.header.HeaderItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/HeaderElementConverterImpl;", "Lcom/avito/android/serp/adapter/HeaderElementConverter;", "Lcom/avito/android/remote/model/HeaderElement;", "serpElement", "Lcom/avito/android/serp/adapter/header/HeaderItem;", "convert", "(Lcom/avito/android/remote/model/HeaderElement;)Lcom/avito/android/serp/adapter/header/HeaderItem;", "", AuthSource.SEND_ABUSE, "I", "columnCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderElementConverterImpl implements HeaderElementConverter {
    public final int a;

    public HeaderElementConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.serp.adapter.HeaderElementConverter
    @NotNull
    public HeaderItem convert(@NotNull HeaderElement headerElement) {
        Intrinsics.checkNotNullParameter(headerElement, "serpElement");
        return new HeaderItem(headerElement.getText(), headerElement.getText(), headerElement.getDescriptions(), SerpViewType.SINGLE, this.a);
    }
}
