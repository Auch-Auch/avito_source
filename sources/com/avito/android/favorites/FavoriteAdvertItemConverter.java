package com.avito.android.favorites;

import com.avito.android.favorite.FavoriteModel;
import com.avito.android.remote.model.FavoriteAdvert;
import com.avito.android.remote.model.References;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "", "", "Lcom/avito/android/remote/model/FavoriteAdvert;", "adverts", "Lcom/avito/android/remote/model/References;", "references", "Lcom/avito/android/favorite/FavoriteModel;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/References;)Ljava/util/List;", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertItemConverter {
    @NotNull
    List<FavoriteModel> convert(@NotNull List<FavoriteAdvert> list, @Nullable References references);
}
