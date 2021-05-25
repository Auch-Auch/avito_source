package a2.a.a.f.x.t;

import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserItem;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserViewImpl;
public final class h implements View.OnClickListener {
    public final /* synthetic */ PhoneChooserItem.Phone a;
    public final /* synthetic */ PhoneChooserViewImpl b;

    public h(PhoneChooserItem.Phone phone, PhoneChooserViewImpl phoneChooserViewImpl) {
        this.a = phone;
        this.b = phoneChooserViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PhoneChooserView.Listener listener = this.b.getListener();
        if (listener != null) {
            listener.onPhoneClicked(this.a);
        }
    }
}
