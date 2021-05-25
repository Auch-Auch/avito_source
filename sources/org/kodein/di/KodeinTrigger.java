package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R#\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lorg/kodein/di/KodeinTrigger;", "", "", "trigger", "()V", "", "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getProperties", "()Ljava/util/List;", "properties", "<init>", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinTrigger {
    @NotNull
    public final List<Lazy<?>> a = new ArrayList();

    @NotNull
    public final List<Lazy<?>> getProperties() {
        return this.a;
    }

    public final void trigger() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().getValue();
        }
    }
}
