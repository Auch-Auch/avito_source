package a2.a.a.q0;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import java.util.Objects;
public final class l<T> implements Consumer<DiffUtil.DiffResult> {
    public final /* synthetic */ ExtendedProfileViewImpl a;
    public final /* synthetic */ List b;
    public final /* synthetic */ ExtendedProfileTracker.TrackFlow c;

    public l(ExtendedProfileViewImpl extendedProfileViewImpl, List list, ExtendedProfileTracker.TrackFlow trackFlow) {
        this.a = extendedProfileViewImpl;
        this.b = list;
        this.c = trackFlow;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DiffUtil.DiffResult diffResult) {
        ExtendedProfileViewImpl.access$updateItems(this.a, this.b);
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.a.t;
        Objects.requireNonNull(simpleRecyclerAdapter, "null cannot be cast to non-null type androidx.recyclerview.widget.ListUpdateCallback");
        diffResult.dispatchUpdatesTo((ListUpdateCallback) simpleRecyclerAdapter);
        ExtendedProfileViewImpl.access$trackDraw(this.a, this.c);
    }
}
