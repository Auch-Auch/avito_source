package a2.j.h.a.c;

import java.util.ArrayDeque;
import java.util.Deque;
public final class j extends ThreadLocal<Deque<Runnable>> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Deque<Runnable> initialValue() {
        return new ArrayDeque();
    }
}
