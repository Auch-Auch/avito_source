package a2.j.b.e.a.b;

import a2.b.a.a.a;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;
public final class e0 extends AssetPackLocation {
    public final int b;
    public final String c;
    public final String d;

    public e0(int i, String str, String str2) {
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    public final String assetsPath() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.b == assetPackLocation.packStorageMethod() && ((str = this.c) == null ? assetPackLocation.path() == null : str.equals(assetPackLocation.path()))) {
                String str2 = this.d;
                String assetsPath = assetPackLocation.assetsPath();
                if (str2 == null ? assetsPath == null : str2.equals(assetsPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.b ^ 1000003) * 1000003;
        String str = this.c;
        int i2 = 0;
        int hashCode = (i ^ (str != null ? str.hashCode() : 0)) * 1000003;
        String str2 = this.d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    @AssetPackStorageMethod
    public final int packStorageMethod() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    public final String path() {
        return this.c;
    }

    public final String toString() {
        int i = this.b;
        String str = this.c;
        String str2 = this.d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        return a.u(sb, ", assetsPath=", str2, "}");
    }
}
