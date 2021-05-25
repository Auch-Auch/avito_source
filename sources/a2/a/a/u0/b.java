package a2.a.a.u0;

import android.view.View;
import com.avito.android.fees.PackageFeeFragment;
import com.avito.android.remote.model.OwnedPackage;
public final class b implements View.OnClickListener {
    public final /* synthetic */ PackageFeeFragment a;
    public final /* synthetic */ OwnedPackage b;

    public b(PackageFeeFragment packageFeeFragment, OwnedPackage ownedPackage) {
        this.a = packageFeeFragment;
        this.b = ownedPackage;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getPackageFeePresenter().apply(this.b.getId());
    }
}
