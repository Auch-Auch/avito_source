package a2.a.a.u0;

import android.view.View;
import com.avito.android.fees.PackageFeeFragment;
import com.avito.android.fees.PackageFeeListener;
import com.avito.android.remote.model.AdvertFeesEntity;
import java.util.List;
public final class a implements View.OnClickListener {
    public final /* synthetic */ PackageFeeFragment a;
    public final /* synthetic */ AdvertFeesEntity b;
    public final /* synthetic */ List c;

    public a(PackageFeeFragment packageFeeFragment, AdvertFeesEntity advertFeesEntity, List list) {
        this.a = packageFeeFragment;
        this.b = advertFeesEntity;
        this.c = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PackageFeeListener packageFeeListener = this.a.f;
        if (packageFeeListener != null) {
            packageFeeListener.onPackageSelected(this.b, this.c);
        }
    }
}
