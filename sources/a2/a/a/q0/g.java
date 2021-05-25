package a2.a.a.q0;

import androidx.lifecycle.Observer;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Observer<Integer> {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public g(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.a.t;
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        simpleRecyclerAdapter.notifyItemChanged(num2.intValue());
    }
}
