package a2.a.a.b2.e1;

import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<List<? extends EditProfileItem>, ProfileSavingResult.Failed> {
    public final /* synthetic */ Throwable a;

    public f(Throwable th) {
        this.a = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ProfileSavingResult.Failed apply(List<? extends EditProfileItem> list) {
        List<? extends EditProfileItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return new ProfileSavingResult.ItemsNotActual(this.a, list2);
    }
}
