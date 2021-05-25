package a2.r.a;

import androidx.fragment.app.FragmentManager;
import com.tbruyelle.rxpermissions3.RxPermissions;
import com.tbruyelle.rxpermissions3.RxPermissionsFragment;
import java.util.Objects;
public class e implements RxPermissions.Lazy<RxPermissionsFragment> {
    public RxPermissionsFragment a;
    public final /* synthetic */ FragmentManager b;
    public final /* synthetic */ RxPermissions c;

    public e(RxPermissions rxPermissions, FragmentManager fragmentManager) {
        this.c = rxPermissions;
        this.b = fragmentManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tbruyelle.rxpermissions3.RxPermissions.Lazy
    public RxPermissionsFragment get() {
        RxPermissionsFragment rxPermissionsFragment;
        synchronized (this) {
            if (this.a == null) {
                RxPermissions rxPermissions = this.c;
                FragmentManager fragmentManager = this.b;
                Object obj = RxPermissions.b;
                Objects.requireNonNull(rxPermissions);
                RxPermissionsFragment rxPermissionsFragment2 = (RxPermissionsFragment) fragmentManager.findFragmentByTag("RxPermissions");
                if (rxPermissionsFragment2 == null) {
                    rxPermissionsFragment2 = new RxPermissionsFragment();
                    fragmentManager.beginTransaction().add(rxPermissionsFragment2, "RxPermissions").commitNow();
                }
                this.a = rxPermissionsFragment2;
            }
            rxPermissionsFragment = this.a;
        }
        return rxPermissionsFragment;
    }
}
