package com.avito.android.publish.residential_complex_search.adapter.title;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ResidentialComplexSuggest;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestItem;", "Lcom/avito/konveyor/blueprint/Item;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/ResidentialComplexSuggest;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "getResidentialComplexSuggest", "()Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "residentialComplexSuggest", "<init>", "(JLcom/avito/android/remote/model/ResidentialComplexSuggest;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSuggestItem implements Item {
    public final long a;
    @NotNull
    public final ResidentialComplexSuggest b;

    public ResidentialComplexSuggestItem(long j, @NotNull ResidentialComplexSuggest residentialComplexSuggest) {
        Intrinsics.checkNotNullParameter(residentialComplexSuggest, "residentialComplexSuggest");
        this.a = j;
        this.b = residentialComplexSuggest;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final ResidentialComplexSuggest getResidentialComplexSuggest() {
        return this.b;
    }
}
