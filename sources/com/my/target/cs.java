package com.my.target;

import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class cs extends cn {
    @NonNull
    public static final LruCache<String, String> c = new LruCache<>(10);
    @NonNull
    public final ArrayList<cg> b = new ArrayList<>();

    @NonNull
    public static LruCache<String, String> cf() {
        return c;
    }

    @NonNull
    public static cs cg() {
        return new cs();
    }

    public void a(@NonNull cg cgVar) {
        this.b.add(cgVar);
        c.put(cgVar.getId(), cgVar.getId());
    }

    @NonNull
    public List<cg> ca() {
        return new ArrayList(this.b);
    }

    @Nullable
    public cg ch() {
        if (this.b.size() > 0) {
            return this.b.get(0);
        }
        return null;
    }

    @Override // com.my.target.cn
    public int getBannersCount() {
        return this.b.size();
    }
}
