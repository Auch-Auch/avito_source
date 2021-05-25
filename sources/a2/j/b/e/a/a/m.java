package a2.j.b.e.a.a;

import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.install.model.AppUpdateType;
public final class m extends AppUpdateOptions {
    public final int a;
    public final boolean b;

    public /* synthetic */ m(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean a() {
        return this.b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    @AppUpdateType
    public final int appUpdateType() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            if (this.a == appUpdateOptions.appUpdateType() && this.b == appUpdateOptions.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ (!this.b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.a;
        boolean z = this.b;
        StringBuilder sb = new StringBuilder(68);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowClearStorage=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
