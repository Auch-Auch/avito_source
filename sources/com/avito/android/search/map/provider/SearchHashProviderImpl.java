package com.avito.android.search.map.provider;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/search/map/provider/SearchHashProviderImpl;", "Lcom/avito/android/search/map/provider/SearchHashProvider;", "", "getSearchHash", "()Ljava/lang/String;", "getAndUpdateSearchHash", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "hash", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchHashProviderImpl implements SearchHashProvider {
    public String a = a.I2("UUID.randomUUID().toString()");

    @Override // com.avito.android.search.map.provider.SearchHashProvider
    @NotNull
    public String getAndUpdateSearchHash() {
        String I2 = a.I2("UUID.randomUUID().toString()");
        this.a = I2;
        return I2;
    }

    @Override // com.avito.android.search.map.provider.SearchHashProvider
    @NotNull
    public String getSearchHash() {
        return this.a;
    }
}
