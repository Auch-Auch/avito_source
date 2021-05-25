package a2.a.a.p2.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.service_subscription.subscription_new.PackageAttributeViewData;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionViewImpl;
import com.avito.android.util.Views;
import java.util.List;
public final class c implements View.OnClickListener {
    public final /* synthetic */ ServiceSubscriptionViewImpl a;
    public final /* synthetic */ PackageAttributeViewData.Monster b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ ViewGroup d;
    public final /* synthetic */ ViewGroup e;
    public final /* synthetic */ LayoutInflater f;
    public final /* synthetic */ List g;

    public c(ServiceSubscriptionViewImpl serviceSubscriptionViewImpl, PackageAttributeViewData.Monster monster, TextView textView, ViewGroup viewGroup, ViewGroup viewGroup2, LayoutInflater layoutInflater, List list) {
        this.a = serviceSubscriptionViewImpl;
        this.b = monster;
        this.c = textView;
        this.d = viewGroup;
        this.e = viewGroup2;
        this.f = layoutInflater;
        this.g = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PackageAttributeViewData.Monster monster = this.b;
        monster.setExpanded(!monster.isExpanded());
        Views.disable(this.c);
        ServiceSubscriptionViewImpl.access$animateMonsterPackageExpansion(this.a, this.e, this.g, this.a.a(this.d, this.e, this.f, this.b.getDetails()));
    }
}
