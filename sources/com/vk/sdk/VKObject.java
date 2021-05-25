package com.vk.sdk;

import java.util.HashMap;
import java.util.Random;
public class VKObject {
    public static final HashMap<Long, VKObject> b = new HashMap<>();
    public long a = 0;

    public static VKObject getRegisteredObject(long j) {
        return b.get(Long.valueOf(j));
    }

    public long registerObject() {
        if (b.containsKey(Long.valueOf(this.a))) {
            return this.a;
        }
        Random random = new Random();
        while (true) {
            long nextLong = random.nextLong();
            HashMap<Long, VKObject> hashMap = b;
            if (!hashMap.containsKey(Long.valueOf(nextLong)) && nextLong != 0) {
                hashMap.put(Long.valueOf(nextLong), this);
                this.a = nextLong;
                return nextLong;
            }
        }
    }

    public void unregisterObject() {
        b.remove(Long.valueOf(this.a));
        this.a = 0;
    }
}
