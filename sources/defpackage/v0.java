package defpackage;

import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: v0  reason: default package */
public final class v0<T> implements Consumer<List<? extends String>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public v0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(List<? extends String> list) {
        int i = this.a;
        if (i == 0) {
            List<? extends String> list2 = list;
            FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl = ((FavoriteAdvertsListInteractorImpl.t) this.b).a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            FavoriteAdvertsListInteractorImpl.access$removeAdverts(favoriteAdvertsListInteractorImpl, list2);
        } else if (i == 1) {
            List<? extends String> list3 = list;
            FavoriteAdvertsListInteractorImpl favoriteAdvertsListInteractorImpl2 = ((FavoriteAdvertsListInteractorImpl.t) this.b).a;
            Intrinsics.checkNotNullExpressionValue(list3, "it");
            FavoriteAdvertsListInteractorImpl.access$reportRemovedFromFavorites(favoriteAdvertsListInteractorImpl2, list3, null);
        } else {
            throw null;
        }
    }
}
