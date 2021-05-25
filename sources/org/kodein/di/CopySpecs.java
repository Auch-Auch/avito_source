package org.kodein.di;

import com.avito.android.remote.model.ProfileTab;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lorg/kodein/di/CopySpecs;", "Lorg/kodein/di/SearchSpecs;", "", "e", "Z", "getAll", "()Z", ProfileTab.ALL, "<init>", "(Z)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class CopySpecs extends SearchSpecs {
    public final boolean e;

    public CopySpecs(boolean z) {
        super(null, null, null, null, 15, null);
        this.e = z;
    }

    public final boolean getAll() {
        return this.e;
    }
}
