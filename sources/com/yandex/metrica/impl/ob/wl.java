package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.vy;
public abstract class wl<T extends vy> implements wj<T> {
    @Nullable
    private acn a;

    public void a(@NonNull Uri.Builder builder, @NonNull T t) {
        acn acn = this.a;
        if (acn != null && acn.a() == aco.AES_RSA) {
            builder.appendQueryParameter("encrypted_request", "1");
        }
    }

    public void a(@NonNull acn acn) {
        this.a = acn;
    }

    public void a(@Nullable String str, @Nullable String str2, @NonNull Uri.Builder builder) {
        if (str != null && str.contains("source") && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter("commit_hash", str2);
        }
    }
}
