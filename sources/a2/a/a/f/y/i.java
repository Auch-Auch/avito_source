package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.favorite.FavoriteActionSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ EditAdvertNotePresenterImpl a;

    public i(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl) {
        this.a = editAdvertNotePresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "isFavorite");
        if (bool2.booleanValue()) {
            return Single.just(Boolean.FALSE);
        }
        return this.a.j.toggleFavoriteStatus(this.a.f, new FavoriteActionSource.Item(null, false), bool2.booleanValue()).map(new h(true));
    }
}
