package com.avito.android.serp.adapter.snippet;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.serp.Snippet;
import com.avito.android.serp.adapter.SerpElementUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "", "Lcom/avito/android/remote/model/serp/Snippet;", "snippet", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "convert", "(Lcom/avito/android/remote/model/serp/Snippet;)Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "Impl", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetConverter$Impl;", "Lcom/avito/android/serp/adapter/snippet/SnippetConverter;", "Lcom/avito/android/remote/model/serp/Snippet;", "snippet", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "convert", "(Lcom/avito/android/remote/model/serp/Snippet;)Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "", AuthSource.SEND_ABUSE, "I", "columnsCount", "<init>", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SnippetConverter {
        public final int a;

        public Impl(int i) {
            this.a = i;
        }

        @Override // com.avito.android.serp.adapter.snippet.SnippetConverter
        @NotNull
        public SnippetItem convert(@NotNull Snippet snippet) {
            Intrinsics.checkNotNullParameter(snippet, "snippet");
            return new SnippetItem(SerpElementUtilsKt.getUniqueId(snippet.getUniqueId(), snippet.getId()), snippet.getId(), this.a, snippet.getAction(), snippet.getImage(), snippet.getText(), true, snippet.getAnalytics());
        }
    }

    @NotNull
    SnippetItem convert(@NotNull Snippet snippet);
}
