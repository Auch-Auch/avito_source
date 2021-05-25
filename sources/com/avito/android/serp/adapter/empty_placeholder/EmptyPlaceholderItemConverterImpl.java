package com.avito.android.serp.adapter.empty_placeholder;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvertEmptyPlaceholder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverterImpl;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemConverter;", "Lcom/avito/android/remote/model/SerpAdvertEmptyPlaceholder;", "entity", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "convert", "(Lcom/avito/android/remote/model/SerpAdvertEmptyPlaceholder;)Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "", AuthSource.SEND_ABUSE, "I", "columnsCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyPlaceholderItemConverterImpl implements EmptyPlaceholderItemConverter {
    public final int a;

    public EmptyPlaceholderItemConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemConverter
    @NotNull
    public EmptyPlaceholderItem convert(@NotNull SerpAdvertEmptyPlaceholder serpAdvertEmptyPlaceholder) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(serpAdvertEmptyPlaceholder, "entity");
        String title = serpAdvertEmptyPlaceholder.getTitle();
        long hashCode = (long) (title != null ? title.hashCode() : 0);
        String title2 = serpAdvertEmptyPlaceholder.getTitle();
        String str3 = title2 != null ? title2 : "";
        int i = this.a;
        String title3 = serpAdvertEmptyPlaceholder.getTitle();
        if (title3 != null) {
            str = title3;
        } else {
            str = "";
        }
        String subtitle = serpAdvertEmptyPlaceholder.getSubtitle();
        if (subtitle != null) {
            str2 = subtitle;
        } else {
            str2 = "";
        }
        return new EmptyPlaceholderItem(hashCode, str3, i, str, str2, serpAdvertEmptyPlaceholder.getActions());
    }
}
