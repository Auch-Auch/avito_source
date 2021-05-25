package com.avito.android.messenger.map.search;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.messenger.analytics.MessengerGeoSearchLocationPick;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.avito.android.util.Keyboards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class GeoSearchFragment$bindView$$inlined$observeNotNull$3<T> implements Observer<T> {
    public final /* synthetic */ GeoSearchFragment a;

    public GeoSearchFragment$bindView$$inlined$observeNotNull$3(GeoSearchFragment geoSearchFragment) {
        this.a = geoSearchFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            T t2 = t;
            FragmentActivity activity = this.a.getActivity();
            if (activity != null) {
                activity.setResult(-1, new Intent().putExtra(GeoSearchFragmentKt.EXTRA_SELECTED_SUGGEST, new GeoSearchSuggest(t2.getLatitude(), t2.getLongitude(), t2.getKind(), t2.getTitle(), t2.getName(), t2.getDescription(), Boolean.valueOf(Intrinsics.areEqual(t2.getAddressType(), MessengerGeoSearchLocationPick.ITEM_SUGGEST)))));
                Keyboards.hideKeyboard(activity);
                activity.finish();
            }
        }
    }
}
