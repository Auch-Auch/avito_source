package l6.c.c;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class f implements g {
    @Override // l6.c.c.g
    @SuppressLint({"PackageManagerGetSignatures"})
    @Nullable
    public List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
        ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
        for (Signature signature : packageInfo.signatures) {
            byte[] r0 = AppCompatDelegateImpl.i.r0(signature);
            if (r0 == null) {
                return null;
            }
            arrayList.add(r0);
        }
        return arrayList;
    }

    @Override // l6.c.c.g
    public boolean b(String str, PackageManager packageManager, h hVar) throws IOException, PackageManager.NameNotFoundException {
        List<byte[]> a = a(str, packageManager);
        if (a == null) {
            return false;
        }
        return hVar.equals(h.a(str, a));
    }
}
