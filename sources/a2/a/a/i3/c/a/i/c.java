package a2.a.a.i3.c.a.i;

import com.avito.android.user_adverts.SoaData;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModel;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Long, ObservableSource<? extends SoaData.Value>> {
    public final /* synthetic */ ProfileHeaderViewModel a;

    public c(ProfileHeaderViewModel profileHeaderViewModel) {
        this.a = profileHeaderViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends SoaData.Value> apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return this.a.x.getSoaInfo();
    }
}
