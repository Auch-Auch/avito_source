package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001c\b\u0007\u0012\u0011\u0010\f\u001a\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\t0\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\t0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProviderProxy;", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetStateProvider;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "invalidate", "()V", "", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "providers", "<init>", "(Ljava/util/Set;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RichSnippetStateProviderProxy implements RichSnippetStateProvider {
    public final Set<RichSnippetStateProvider> a;

    @Inject
    public RichSnippetStateProviderProxy(@NotNull Set<RichSnippetStateProvider> set) {
        Intrinsics.checkNotNullParameter(set, "providers");
        this.a = set;
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    public void invalidate() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            kundle.putAll(it.next().onSaveState());
        }
        return kundle;
    }
}
