package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfileInteractorImpl;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.item.LocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.TextItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.model.Profile;
import io.reactivex.functions.BiFunction;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
public final class a<T1, T2, R> implements BiFunction<Profile, Option<? extends ProfileAvatar>, List<? extends EditProfileItem>> {
    public final /* synthetic */ EditProfileInteractorImpl a;

    public a(EditProfileInteractorImpl editProfileInteractorImpl) {
        this.a = editProfileInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002b: APUT  
      (r0v3 com.avito.android.profile.edit.refactoring.adapter.EditProfileItem[])
      (1 ??[boolean, int, float, short, byte, char])
      (r2v4 com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem)
     */
    @Override // io.reactivex.functions.BiFunction
    public List<? extends EditProfileItem> apply(Profile profile, Option<? extends ProfileAvatar> option) {
        Profile profile2 = profile;
        Option<? extends ProfileAvatar> option2 = option;
        Intrinsics.checkNotNullParameter(profile2, "profile");
        Intrinsics.checkNotNullParameter(option2, "avatar");
        EditProfileItem[] editProfileItemArr = new EditProfileItem[2];
        LocationItem locationItem = this.a.b();
        Objects.requireNonNull(locationItem, "null cannot be cast to non-null type com.avito.android.profile.edit.refactoring.adapter.EditProfileItem");
        editProfileItemArr[0] = locationItem;
        SubLocationItem subLocationItem = this.a.c();
        if (!(subLocationItem instanceof EditProfileItem)) {
            subLocationItem = null;
        }
        editProfileItemArr[1] = subLocationItem;
        return CollectionsKt___CollectionsKt.plus((Collection<? extends TextItem>) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) EditProfileInteractorImpl.access$toParameters(this.a, (ProfileAvatar) option2.orNull()), (Iterable) EditProfileInteractorImpl.access$toParameters(this.a, profile2)), (Iterable) CollectionsKt___CollectionsKt.filterNotNull(CollectionsKt__CollectionsKt.listOf((Object[]) editProfileItemArr))), EditProfileInteractorImpl.access$createDisclaimer(this.a));
    }
}
