package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "invalidate", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface RichSnippetStateProvider {
    void invalidate();

    @NotNull
    Kundle onSaveState();
}
