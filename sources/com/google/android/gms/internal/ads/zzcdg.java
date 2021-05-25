package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
public final class zzcdg {
    public static final zzcdg zzfyr = new zzcdi().zzamk();
    @Nullable
    private final zzaex zzfyk;
    @Nullable
    private final zzaew zzfyl;
    @Nullable
    private final zzafl zzfym;
    @Nullable
    private final zzafk zzfyn;
    @Nullable
    private final zzaiz zzfyo;
    private final SimpleArrayMap<String, zzafd> zzfyp;
    private final SimpleArrayMap<String, zzafc> zzfyq;

    private zzcdg(zzcdi zzcdi) {
        this.zzfyk = zzcdi.zzfyk;
        this.zzfyl = zzcdi.zzfyl;
        this.zzfym = zzcdi.zzfym;
        this.zzfyp = new SimpleArrayMap<>(zzcdi.zzfyp);
        this.zzfyq = new SimpleArrayMap<>(zzcdi.zzfyq);
        this.zzfyn = zzcdi.zzfyn;
        this.zzfyo = zzcdi.zzfyo;
    }

    @Nullable
    public final zzaex zzamc() {
        return this.zzfyk;
    }

    @Nullable
    public final zzaew zzamd() {
        return this.zzfyl;
    }

    @Nullable
    public final zzafl zzame() {
        return this.zzfym;
    }

    @Nullable
    public final zzafk zzamf() {
        return this.zzfyn;
    }

    @Nullable
    public final zzaiz zzamg() {
        return this.zzfyo;
    }

    public final ArrayList<String> zzamh() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfym != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfyk != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzfyl != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfyp.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfyo != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzami() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfyp.size());
        for (int i = 0; i < this.zzfyp.size(); i++) {
            arrayList.add(this.zzfyp.keyAt(i));
        }
        return arrayList;
    }

    @Nullable
    public final zzafd zzgd(String str) {
        return this.zzfyp.get(str);
    }

    @Nullable
    public final zzafc zzge(String str) {
        return this.zzfyq.get(str);
    }
}
