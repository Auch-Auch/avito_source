package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import l6.c.c.e;
import l6.c.c.f;
import l6.c.c.g;
import l6.c.c.h;
public final class Token {
    @NonNull
    public final h a;

    public Token(@NonNull h hVar) {
        this.a = hVar;
    }

    @Nullable
    public static Token create(@NonNull String str, @NonNull PackageManager packageManager) {
        List<byte[]> list;
        g gVar;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                gVar = new e();
            } else {
                gVar = new f();
            }
            list = gVar.a(str, packageManager);
        } catch (PackageManager.NameNotFoundException unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        try {
            return new Token(h.a(str, list));
        } catch (IOException unused2) {
            return null;
        }
    }

    @NonNull
    public static Token deserialize(@NonNull byte[] bArr) {
        return new Token(new h(bArr));
    }

    public boolean matches(@NonNull String str, @NonNull PackageManager packageManager) {
        g gVar;
        h hVar = this.a;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                gVar = new e();
            } else {
                gVar = new f();
            }
            return gVar.b(str, packageManager, hVar);
        } catch (PackageManager.NameNotFoundException | IOException unused) {
            return false;
        }
    }

    @NonNull
    public byte[] serialize() {
        byte[] bArr = this.a.a;
        return Arrays.copyOf(bArr, bArr.length);
    }
}
