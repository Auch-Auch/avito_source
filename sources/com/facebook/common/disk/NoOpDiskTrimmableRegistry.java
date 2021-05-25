package com.facebook.common.disk;

import javax.annotation.Nullable;
public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    @Nullable
    public static NoOpDiskTrimmableRegistry a;

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (a == null) {
                a = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = a;
        }
        return noOpDiskTrimmableRegistry;
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
    }
}
