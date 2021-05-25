package com.avito.android.serp;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.InlineFilters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/serp/SerpInlineFilters;", "Lcom/avito/android/serp/Serp;", "Lcom/avito/android/remote/model/search/InlineFilters;", "component1", "()Lcom/avito/android/remote/model/search/InlineFilters;", "inlineFilters", "copy", "(Lcom/avito/android/remote/model/search/InlineFilters;)Lcom/avito/android/serp/SerpInlineFilters;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFilters", "<init>", "(Lcom/avito/android/remote/model/search/InlineFilters;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpInlineFilters extends Serp {
    @Nullable
    public final InlineFilters a;

    public SerpInlineFilters(@Nullable InlineFilters inlineFilters) {
        super(null);
        this.a = inlineFilters;
    }

    public static /* synthetic */ SerpInlineFilters copy$default(SerpInlineFilters serpInlineFilters, InlineFilters inlineFilters, int i, Object obj) {
        if ((i & 1) != 0) {
            inlineFilters = serpInlineFilters.a;
        }
        return serpInlineFilters.copy(inlineFilters);
    }

    @Nullable
    public final InlineFilters component1() {
        return this.a;
    }

    @NotNull
    public final SerpInlineFilters copy(@Nullable InlineFilters inlineFilters) {
        return new SerpInlineFilters(inlineFilters);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SerpInlineFilters) && Intrinsics.areEqual(this.a, ((SerpInlineFilters) obj).a);
        }
        return true;
    }

    @Nullable
    public final InlineFilters getInlineFilters() {
        return this.a;
    }

    public int hashCode() {
        InlineFilters inlineFilters = this.a;
        if (inlineFilters != null) {
            return inlineFilters.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpInlineFilters(inlineFilters=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
