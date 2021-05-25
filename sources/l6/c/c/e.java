package l6.c.c;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(28)
public class e implements g {
    @Override // l6.c.c.g
    @Nullable
    public List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
        ArrayList arrayList = new ArrayList();
        SigningInfo signingInfo = packageInfo.signingInfo;
        if (signingInfo.hasMultipleSigners()) {
            for (Signature signature : signingInfo.getApkContentsSigners()) {
                arrayList.add(AppCompatDelegateImpl.i.r0(signature));
            }
        } else {
            arrayList.add(AppCompatDelegateImpl.i.r0(signingInfo.getSigningCertificateHistory()[0]));
        }
        return arrayList;
    }

    @Override // l6.c.c.g
    public boolean b(String str, PackageManager packageManager, h hVar) throws PackageManager.NameNotFoundException, IOException {
        List<byte[]> a = a(str, packageManager);
        if (((ArrayList) a).size() != 1) {
            return hVar.equals(h.a(str, a));
        }
        hVar.b();
        String str2 = hVar.b;
        if (str2 == null) {
            throw new IllegalStateException();
        } else if (!str2.equals(str)) {
            return false;
        } else {
            hVar.b();
            List<byte[]> list = hVar.c;
            if (list != null) {
                return packageManager.hasSigningCertificate(str, Arrays.copyOf(list.get(0), hVar.c.get(0).length), 1);
            }
            throw new IllegalStateException();
        }
    }
}
