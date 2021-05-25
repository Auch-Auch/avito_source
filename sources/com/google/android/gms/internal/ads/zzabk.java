package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.avito.android.lib.design.input.FormatterType;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzabk {
    private final Object lock;
    @VisibleForTesting
    public boolean zzcys;
    private final List<zzabi> zzcyt = new LinkedList();
    private final Map<String, String> zzcyu;
    @Nullable
    private zzabk zzcyv;

    public zzabk(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzcyu = linkedHashMap;
        this.lock = new Object();
        this.zzcys = true;
        linkedHashMap.put("action", str);
        linkedHashMap.put("ad_format", str2);
    }

    public final boolean zza(zzabi zzabi, long j, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzcyt.add(new zzabi(j, str, zzabi));
            }
        }
        return true;
    }

    public final void zzc(@Nullable zzabk zzabk) {
        synchronized (this.lock) {
            this.zzcyv = zzabk;
        }
    }

    @Nullable
    public final zzabi zzex(long j) {
        if (!this.zzcys) {
            return null;
        }
        return new zzabi(j, null, null);
    }

    public final void zzh(String str, String str2) {
        zzaba zzwd;
        if (this.zzcys && !TextUtils.isEmpty(str2) && (zzwd = zzp.zzkt().zzwd()) != null) {
            synchronized (this.lock) {
                zzabe zzcu = zzwd.zzcu(str);
                Map<String, String> map = this.zzcyu;
                map.put(str, zzcu.zzg(map.get(str), str2));
            }
        }
    }

    public final String zzrq() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.lock) {
            for (zzabi zzabi : this.zzcyt) {
                long time = zzabi.getTime();
                String zzrn = zzabi.zzrn();
                zzabi zzro = zzabi.zzro();
                if (zzro != null && time > 0) {
                    sb2.append(zzrn);
                    sb2.append(FormatterType.defaultDecimalSeparator);
                    sb2.append(time - zzro.getTime());
                    sb2.append(',');
                }
            }
            this.zzcyt.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    @VisibleForTesting
    public final Map<String, String> zzrr() {
        synchronized (this.lock) {
            zzaba zzwd = zzp.zzkt().zzwd();
            if (zzwd != null) {
                zzabk zzabk = this.zzcyv;
                if (zzabk != null) {
                    return zzwd.zza(this.zzcyu, zzabk.zzrr());
                }
            }
            return this.zzcyu;
        }
    }
}
