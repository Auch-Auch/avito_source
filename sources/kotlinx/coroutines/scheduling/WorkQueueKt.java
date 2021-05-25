package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00038\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002\"\u0016\u0010\b\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\b\u0010\u0002¨\u0006\t"}, d2 = {"", "BUFFER_CAPACITY_BASE", "I", "", "TASK_STOLEN", "J", "NOTHING_TO_STEAL", "MASK", "BUFFER_CAPACITY", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class WorkQueueKt {
    public static final int BUFFER_CAPACITY = 128;
    public static final int BUFFER_CAPACITY_BASE = 7;
    public static final int MASK = 127;
    public static final long NOTHING_TO_STEAL = -2;
    public static final long TASK_STOLEN = -1;
}
