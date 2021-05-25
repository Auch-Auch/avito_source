package com.avito.android.publish.residential_complex_search.adapter.button;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/button/ResidentialComplexButtonItem;", "Lcom/avito/konveyor/blueprint/Item;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexButtonItem implements Item {
    public final long a;

    public ResidentialComplexButtonItem(long j) {
        this.a = j;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }
}
