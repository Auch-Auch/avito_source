package a2.a.a.q0;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import com.avito.android.extended_profile.adapter.ExtendedProfileDiffCallback;
import java.util.List;
import java.util.concurrent.Callable;
public final class j<V> implements Callable<DiffUtil.DiffResult> {
    public final /* synthetic */ ExtendedProfileViewImpl a;
    public final /* synthetic */ List b;

    public j(ExtendedProfileViewImpl extendedProfileViewImpl, List list) {
        this.a = extendedProfileViewImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public DiffUtil.DiffResult call() {
        return DiffUtil.calculateDiff(new ExtendedProfileDiffCallback(this.a.p, this.b));
    }
}
