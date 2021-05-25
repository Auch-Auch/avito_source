package com.avito.android.messenger.channels.mvi.common.v1;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v1/AbstractMviEvent;", "", "", "toString", "()Ljava/lang/String;", "", "eventId", "J", "getName", "name", "<init>", "(J)V", "mvi_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractMviEvent {
    @JvmField
    public final long eventId;

    public AbstractMviEvent(long j) {
        this.eventId = j;
    }

    @NotNull
    public abstract String getName();

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Event.");
        L.append(getName());
        return L.toString();
    }
}
