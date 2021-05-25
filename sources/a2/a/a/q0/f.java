package a2.a.a.q0;

import androidx.lifecycle.Observer;
import com.avito.android.extended_profile.DataChangeEvent;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
public final class f<T> implements Observer<DataChangeEvent> {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public f(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DataChangeEvent dataChangeEvent) {
        DataChangeEvent dataChangeEvent2 = dataChangeEvent;
        if (this.a.d.getAdapter() == null) {
            ExtendedProfileViewImpl.access$onStartDraw(this.a, dataChangeEvent2.getTrackFlow());
            ExtendedProfileViewImpl.access$updateItems(this.a, dataChangeEvent2.getData());
            this.a.d.setAdapter(this.a.t);
            ExtendedProfileViewImpl.access$trackDraw(this.a, dataChangeEvent2.getTrackFlow());
            return;
        }
        ExtendedProfileViewImpl.access$showItemsWithDiffUtil(this.a, dataChangeEvent2.getData(), dataChangeEvent2.getTrackFlow());
    }
}
