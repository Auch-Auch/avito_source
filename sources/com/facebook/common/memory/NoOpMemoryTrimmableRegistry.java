package com.facebook.common.memory;
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    public static NoOpMemoryTrimmableRegistry a;

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        synchronized (NoOpMemoryTrimmableRegistry.class) {
            if (a == null) {
                a = new NoOpMemoryTrimmableRegistry();
            }
            noOpMemoryTrimmableRegistry = a;
        }
        return noOpMemoryTrimmableRegistry;
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
    }
}
