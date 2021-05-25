package com.avito.android.profile.edit;

import a2.a.a.b2.e1.h;
import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.LocationInteractor;
import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.avatar.AvatarInteractor;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.item.AvatarItem;
import com.avito.android.profile.edit.refactoring.adapter.item.InputItem;
import com.avito.android.profile.edit.refactoring.adapter.item.LocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.PhoneInputItem;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.TextItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u0010>\u001a\u00020<\u0012\u0006\u0010D\u001a\u00020\u0002\u0012\u0006\u0010I\u001a\u00020G\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010;\u001a\u000208\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010%¢\u0006\u0004\bK\u0010LJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0015H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u0003H\u0001¢\u0006\u0004\b-\u0010\u0006J \u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00032\b\u0010.\u001a\u0004\u0018\u00010,H\u0001¢\u0006\u0004\b0\u00101J(\u00106\u001a\b\u0012\u0004\u0012\u00020,0\u00032\u0006\u00103\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000104H\u0001¢\u0006\u0004\b6\u00107R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010H¨\u0006M"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileInteractorImpl;", "Lcom/avito/android/profile/edit/EditProfileInteractor;", "Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/Profile;", "d", "()Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", AuthSource.BOOKING_ORDER, "()Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "c", "()Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "", "id", "", "title", "value", "Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;", AuthSource.SEND_ABUSE, "(JLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "loadItems", "items", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "saveItems", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/Location;", "location", "subLocationId", "Lcom/avito/android/profile/edit/EditProfileInteractor$LocationItems;", "updateLocation", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/NameIdEntity;", "getSubLocations", "()Ljava/util/List;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "needToSave", "()Z", "Lorg/funktionale/option/Option;", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "loadAvatar", "avatar", "", "updateAvatar", "(Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;)Lio/reactivex/Observable;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "wrapAvatar", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/profile/edit/LocationInteractor;", "Lcom/avito/android/profile/edit/LocationInteractor;", "locationInteractor", "Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "e", "Lcom/avito/android/profile/edit/EditProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "avatarInteractor", "Ljava/lang/String;", "phoneNumber", "Lcom/avito/android/profile/edit/SaveProfileInteractor;", "Lcom/avito/android/profile/edit/SaveProfileInteractor;", "saveProfileInteractor", "state", "<init>", "(Lcom/avito/android/profile/edit/LocationInteractor;Lcom/avito/android/profile/edit/avatar/AvatarInteractor;Lcom/avito/android/profile/edit/SaveProfileInteractor;Lcom/avito/android/profile/edit/EditProfileResourceProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditProfileInteractorImpl implements EditProfileInteractor, AvatarInteractor {
    public String a;
    public final LocationInteractor b;
    public final AvatarInteractor c;
    public final SaveProfileInteractor d;
    public final EditProfileResourceProvider e;
    public final SchedulersFactory f;

    public static final class a<T> implements Predicate<LocationInteractor.Event> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(LocationInteractor.Event event) {
            LocationInteractor.Event event2 = event;
            Intrinsics.checkNotNullParameter(event2, "event");
            if (!(event2 instanceof LocationInteractor.Event.Error)) {
                return event2 instanceof LocationInteractor.Event.Loaded;
            }
            throw new IllegalStateException();
        }
    }

    public static final class b<T, R> implements Function<LocationInteractor.Event, Profile> {
        public final /* synthetic */ EditProfileInteractorImpl a;

        public b(EditProfileInteractorImpl editProfileInteractorImpl) {
            this.a = editProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Profile apply(LocationInteractor.Event event) {
            Intrinsics.checkNotNullParameter(event, "it");
            Profile profile = this.a.b.getProfile();
            if (profile != null) {
                return profile;
            }
            throw new IllegalStateException();
        }
    }

    public static final class c extends Lambda implements Function1<ProfileSavingResult, Observable<ProfileSavingResult>> {
        public final /* synthetic */ EditProfileInteractorImpl a;
        public final /* synthetic */ AvatarItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(EditProfileInteractorImpl editProfileInteractorImpl, AvatarItem avatarItem) {
            super(1);
            this.a = editProfileInteractorImpl;
            this.b = avatarItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ProfileSavingResult> invoke(ProfileSavingResult profileSavingResult) {
            Intrinsics.checkNotNullParameter(profileSavingResult, "it");
            return EditProfileInteractorImpl.access$saveAvatarItem(this.a, this.b);
        }
    }

    public static final class d extends Lambda implements Function1<ProfileSavingResult, Observable<ProfileSavingResult>> {
        public final /* synthetic */ EditProfileInteractorImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(EditProfileInteractorImpl editProfileInteractorImpl) {
            super(1);
            this.a = editProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ProfileSavingResult> invoke(ProfileSavingResult profileSavingResult) {
            Intrinsics.checkNotNullParameter(profileSavingResult, "it");
            String str = this.a.a;
            Observable<ProfileSavingResult> just = Observable.just(str != null ? new ProfileSavingResult.PhoneNotConfirmed(str) : new ProfileSavingResult.Completed());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class e<T, R> implements Function<Throwable, ObservableSource<? extends ProfileSavingResult>> {
        public final /* synthetic */ EditProfileInteractorImpl a;
        public final /* synthetic */ AvatarItem b;

        public e(EditProfileInteractorImpl editProfileInteractorImpl, AvatarItem avatarItem) {
            this.a = editProfileInteractorImpl;
            this.b = avatarItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ProfileSavingResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            if (EditProfileInteractorImpl.access$isIncomplete(this.a)) {
                return EditProfileInteractorImpl.access$reloadItemsWithTargetAvatar(this.a, this.b).map(new a2.a.a.b2.e1.f(th2)).onErrorReturn(new a2.a.a.b2.e1.g(th2));
            }
            Observable just = Observable.just(new ProfileSavingResult.Failed(th2));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class f<T> implements Predicate<LocationInteractor.Event> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(LocationInteractor.Event event) {
            LocationInteractor.Event event2 = event;
            Intrinsics.checkNotNullParameter(event2, "event");
            if (!(event2 instanceof LocationInteractor.Event.Error)) {
                return event2 instanceof LocationInteractor.Event.Loaded;
            }
            throw new IllegalStateException("Location updating is failure ");
        }
    }

    public static final class g<T, R> implements Function<LocationInteractor.Event, EditProfileInteractor.LocationItems> {
        public final /* synthetic */ EditProfileInteractorImpl a;

        public g(EditProfileInteractorImpl editProfileInteractorImpl) {
            this.a = editProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public EditProfileInteractor.LocationItems apply(LocationInteractor.Event event) {
            Intrinsics.checkNotNullParameter(event, "it");
            return EditProfileInteractorImpl.access$createLocationItems(this.a);
        }
    }

    public EditProfileInteractorImpl(@NotNull LocationInteractor locationInteractor, @NotNull AvatarInteractor avatarInteractor, @NotNull SaveProfileInteractor saveProfileInteractor, @NotNull EditProfileResourceProvider editProfileResourceProvider, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(locationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(avatarInteractor, "avatarInteractor");
        Intrinsics.checkNotNullParameter(saveProfileInteractor, "saveProfileInteractor");
        Intrinsics.checkNotNullParameter(editProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.b = locationInteractor;
        this.c = avatarInteractor;
        this.d = saveProfileInteractor;
        this.e = editProfileResourceProvider;
        this.f = schedulersFactory;
        this.a = kundle != null ? kundle.getString("phone_number") : null;
    }

    public static final TextItem access$createDisclaimer(EditProfileInteractorImpl editProfileInteractorImpl) {
        Objects.requireNonNull(editProfileInteractorImpl);
        return new TextItem(8, editProfileInteractorImpl.e.getDisclaimer());
    }

    public static final EditProfileInteractor.LocationItems access$createLocationItems(EditProfileInteractorImpl editProfileInteractorImpl) {
        return new EditProfileInteractor.LocationItems(editProfileInteractorImpl.b(), editProfileInteractorImpl.c());
    }

    public static final boolean access$isIncomplete(EditProfileInteractorImpl editProfileInteractorImpl) {
        Profile profile = editProfileInteractorImpl.b.getProfile();
        if (profile != null) {
            return profile.isIncomplete();
        }
        return false;
    }

    public static final Observable access$reloadItemsWithTargetAvatar(EditProfileInteractorImpl editProfileInteractorImpl, AvatarItem avatarItem) {
        editProfileInteractorImpl.b.invalidate();
        Observable<Profile> d2 = editProfileInteractorImpl.d();
        Observable just = Observable.just(OptionKt.toOption(avatarItem != null ? avatarItem.getAvatar() : null));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        Observable map = Observable.zip(d2, just, new a2.a.a.b2.e1.a(editProfileInteractorImpl)).map(new a2.a.a.b2.e1.c(avatarItem));
        Intrinsics.checkNotNullExpressionValue(map, "loadItems(loadProfile(),… } ?: items\n            }");
        return map;
    }

    public static final Observable access$saveAvatarItem(EditProfileInteractorImpl editProfileInteractorImpl, AvatarItem avatarItem) {
        Objects.requireNonNull(editProfileInteractorImpl);
        if (avatarItem == null || !avatarItem.isChanged()) {
            Observable just = Observable.just(new ProfileSavingResult.Completed());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
        Observable<R> doOnNext = editProfileInteractorImpl.updateAvatar(avatarItem.getAvatar()).map(a2.a.a.b2.e1.d.a).doOnNext(new a2.a.a.b2.e1.e(avatarItem));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "updateAvatar(avatarItem.…rItem.isChanged = false }");
        return doOnNext;
    }

    public static final List access$toParameters(EditProfileInteractorImpl editProfileInteractorImpl, ProfileAvatar profileAvatar) {
        Objects.requireNonNull(editProfileInteractorImpl);
        return t6.n.d.listOf(new AvatarItem(3, profileAvatar, false, 4, null));
    }

    public final InputItem a(long j, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new InputItem(j, str, str2, false, 8, null);
    }

    public final LocationItem b() {
        return new LocationItem(1, this.b.getLocation(), false, 4, null);
    }

    public final SubLocationItem c() {
        if (this.b.getSubLocationType() == 0) {
            return null;
        }
        return new SubLocationItem(2, this.b.getSubLocationTitle(), this.b.getSubLocationType(), this.b.getSubLocation(), false, 16, null);
    }

    public final Observable<Profile> d() {
        Observable<R> map = this.b.updateProfileLocation().subscribeOn(this.f.io()).filter(a.a).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "locationInteractor.updat…IllegalStateException() }");
        return map;
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    @NotNull
    public List<NameIdEntity> getSubLocations() {
        return this.b.getSubLocations();
    }

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<Option<ProfileAvatar>> loadAvatar() {
        return this.c.loadAvatar();
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    @NotNull
    public Observable<List<EditProfileItem>> loadItems() {
        Observable<List<EditProfileItem>> zip = Observable.zip(d(), loadAvatar(), new a2.a.a.b2.e1.a(this));
        Intrinsics.checkNotNullExpressionValue(zip, "loadItems(loadProfile(), loadAvatar())");
        return zip;
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    public boolean needToSave() {
        Profile profile = this.b.getProfile();
        if ((profile != null ? profile.isIncomplete() : false) || this.a != null) {
            return true;
        }
        return false;
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("phone_number", this.a);
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    @NotNull
    public Observable<ProfileSavingResult> saveItems(@NotNull List<? extends EditProfileItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(TuplesKt.to(Long.valueOf(t.getId()), t));
        }
        Map<Long, ? extends EditProfileItem> map = r.toMap(arrayList);
        Object obj = map.get(3L);
        if (!(obj instanceof AvatarItem)) {
            obj = null;
        }
        AvatarItem avatarItem = (AvatarItem) obj;
        Observable<ProfileSavingResult> doOnNext = this.d.saveProfile(map).doOnNext(new h(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "doOnNext { result ->\n   …r\n            }\n        }");
        Observable<R> flatMap = doOnNext.flatMap(new a2.a.a.b2.e1.b(new c(this, avatarItem)));
        Intrinsics.checkNotNullExpressionValue(flatMap, "this.flatMap { result ->…)\n            }\n        }");
        Observable<R> flatMap2 = flatMap.flatMap(new a2.a.a.b2.e1.b(new d(this)));
        Intrinsics.checkNotNullExpressionValue(flatMap2, "this.flatMap { result ->…)\n            }\n        }");
        Observable<R> onErrorResumeNext = flatMap2.onErrorResumeNext(new e(this, avatarItem));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "saveProfileInteractor.sa…          }\n            }");
        return onErrorResumeNext;
    }

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<Unit> updateAvatar(@Nullable ProfileAvatar profileAvatar) {
        return this.c.updateAvatar(profileAvatar);
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor
    @NotNull
    public Observable<EditProfileInteractor.LocationItems> updateLocation(@Nullable Location location, @Nullable String str) {
        Observable<R> map = this.b.updateLocation(location, str).filter(f.a).map(new g(this));
        Intrinsics.checkNotNullExpressionValue(map, "locationInteractor.updat…{ createLocationItems() }");
        return map;
    }

    @Override // com.avito.android.profile.edit.EditProfileInteractor, com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<ProfileAvatar> wrapAvatar(@NotNull Uri uri, @Nullable Transformation transformation) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return this.c.wrapAvatar(uri, transformation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditProfileInteractorImpl(LocationInteractor locationInteractor, AvatarInteractor avatarInteractor, SaveProfileInteractor saveProfileInteractor, EditProfileResourceProvider editProfileResourceProvider, SchedulersFactory schedulersFactory, Kundle kundle, int i, j jVar) {
        this(locationInteractor, avatarInteractor, saveProfileInteractor, editProfileResourceProvider, schedulersFactory, (i & 32) != 0 ? null : kundle);
    }

    public static final List access$toParameters(EditProfileInteractorImpl editProfileInteractorImpl, Profile profile) {
        Objects.requireNonNull(editProfileInteractorImpl);
        ArrayList arrayList = new ArrayList();
        if (profile.getType().isCompany()) {
            arrayList.add(editProfileInteractorImpl.a(5, editProfileInteractorImpl.e.getCompanyNameTitle(), profile.getName()));
            arrayList.add(editProfileInteractorImpl.a(6, editProfileInteractorImpl.e.getContactNameTitle(), profile.getManager()));
        } else {
            arrayList.add(editProfileInteractorImpl.a(5, editProfileInteractorImpl.e.getUserNameTitle(), profile.getName()));
            if (profile.isIncomplete()) {
                String phone = profile.getPhone();
                String phoneNumberTitle = editProfileInteractorImpl.e.getPhoneNumberTitle();
                if (phone == null) {
                    phone = "";
                }
                arrayList.add(new PhoneInputItem(4, phoneNumberTitle, phone, false, 8, null));
                arrayList.add(editProfileInteractorImpl.a(7, editProfileInteractorImpl.e.getEmailTitle(), profile.getEmail()));
            }
        }
        return arrayList;
    }
}
