package com.avito.android.profile.edit;

import a2.a.a.b2.e1.b0;
import a2.a.a.b2.e1.s;
import a2.a.a.b2.e1.t;
import a2.a.a.b2.e1.u;
import a2.a.a.b2.e1.w;
import a2.a.a.b2.e1.x;
import a2.a.a.b2.e1.y;
import a2.a.a.b2.e1.z;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.profile.edit.ProfileSavingResult;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.item.InputItem;
import com.avito.android.profile.edit.refactoring.adapter.item.LocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.PhoneInputItem;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Error;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.Profile;
import com.avito.android.util.AvitoResponseException;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UrlParams;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/profile/edit/SaveProfileInteractorImpl;", "Lcom/avito/android/profile/edit/SaveProfileInteractor;", "", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "items", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "saveProfile", "(Ljava/util/Map;)Lio/reactivex/Observable;", "itemId", "", AuthSource.SEND_ABUSE, "(Ljava/util/Map;J)Ljava/lang/String;", AuthSource.BOOKING_ORDER, "(Ljava/util/Map;)Ljava/lang/String;", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/SessionChangeTracker;", "c", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/profile/edit/LocationInteractor;", "d", "Lcom/avito/android/profile/edit/LocationInteractor;", "locationInteractor", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/profile/edit/LocationInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SaveProfileInteractorImpl implements SaveProfileInteractor {
    public final ProfileApi a;
    public final AccountStorageInteractor b;
    public final SessionChangeTracker c;
    public final LocationInteractor d;
    public final SchedulersFactory e;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends ProfileSavingResult>> {
        public final /* synthetic */ SaveProfileInteractorImpl a;

        public a(SaveProfileInteractorImpl saveProfileInteractorImpl) {
            this.a = saveProfileInteractorImpl;
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ProfileSavingResult> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            if (!(th2 instanceof AvitoResponseException)) {
                return Observables.toObservable(th2);
            }
            Observable just = Observable.just(new ProfileSavingResult.Invalidate(SaveProfileInteractorImpl.access$toErrors(this.a, (AvitoResponseException) th2)));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public SaveProfileInteractorImpl(@NotNull ProfileApi profileApi, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull LocationInteractor locationInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(locationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = accountStorageInteractor;
        this.c = sessionChangeTracker;
        this.d = locationInteractor;
        this.e = schedulersFactory;
    }

    public static final Observable access$checkPhoneNumber(SaveProfileInteractorImpl saveProfileInteractorImpl, String str) {
        Observable onErrorReturn = InteropKt.toV2(saveProfileInteractorImpl.a.checkPhoneNumber(str, false)).subscribeOn(saveProfileInteractorImpl.e.io()).map(s.a).onErrorReturn(t.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "profileApi.checkPhoneNum…t !is NotFoundException }");
        return onErrorReturn;
    }

    public static final String access$getDistrictValue(SaveProfileInteractorImpl saveProfileInteractorImpl, Map map) {
        NameIdEntity subLocation;
        Objects.requireNonNull(saveProfileInteractorImpl);
        Object obj = map.get(2L);
        if (!(obj instanceof SubLocationItem)) {
            obj = null;
        }
        SubLocationItem subLocationItem = (SubLocationItem) obj;
        if (subLocationItem == null || subLocationItem.getSubLocationType() != 4 || (subLocation = subLocationItem.getSubLocation()) == null) {
            return null;
        }
        return subLocation.getId();
    }

    public static final String access$getMetroValue(SaveProfileInteractorImpl saveProfileInteractorImpl, Map map) {
        NameIdEntity subLocation;
        Objects.requireNonNull(saveProfileInteractorImpl);
        Object obj = map.get(2L);
        if (!(obj instanceof SubLocationItem)) {
            obj = null;
        }
        SubLocationItem subLocationItem = (SubLocationItem) obj;
        if (subLocationItem == null || subLocationItem.getSubLocationType() != 1 || (subLocation = subLocationItem.getSubLocation()) == null) {
            return null;
        }
        return subLocation.getId();
    }

    public static final Map access$toErrors(SaveProfileInteractorImpl saveProfileInteractorImpl, AvitoResponseException avitoResponseException) {
        long j;
        Objects.requireNonNull(saveProfileInteractorImpl);
        Error error = avitoResponseException.getError();
        Intrinsics.checkNotNullExpressionValue(error, "error");
        if (error.code != 400) {
            return r.emptyMap();
        }
        Map<String, String> map = error.paramsMessages;
        if (map == null) {
            return r.emptyMap();
        }
        Intrinsics.checkNotNullExpressionValue(map, "error.paramsMessages ?: return mapOf()");
        Set<String> keySet = map.keySet();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(keySet, 10));
        for (T t : keySet) {
            String str = map.get(t);
            if (str == null) {
                str = "";
            }
            if (t != null) {
                switch (t.hashCode()) {
                    case 3373707:
                        if (t.equals("name")) {
                            j = 5;
                            continue;
                            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
                        }
                        break;
                    case 96619420:
                        if (t.equals("email")) {
                            j = 7;
                            continue;
                            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
                        }
                        break;
                    case 106642798:
                        if (t.equals("phone")) {
                            j = 4;
                            continue;
                            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
                        }
                        break;
                    case 835260333:
                        if (t.equals("manager")) {
                            j = 6;
                            continue;
                            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
                        }
                        break;
                    case 1541836720:
                        if (t.equals("locationId")) {
                            j = 1;
                            continue;
                            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
                        }
                        break;
                }
            }
            j = -1;
            arrayList.add(TuplesKt.to(Long.valueOf(j), str));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((Number) ((Pair) next).getFirst()).longValue() >= 0) {
                arrayList2.add(next);
            }
        }
        return r.toMap(arrayList2);
    }

    public final String a(Map<Long, ? extends EditProfileItem> map, long j) {
        Object obj = map.get(Long.valueOf(j));
        String str = null;
        if (!(obj instanceof InputItem)) {
            obj = null;
        }
        InputItem inputItem = (InputItem) obj;
        if (inputItem != null) {
            str = inputItem.getValue();
        }
        return str != null ? str : "";
    }

    public final String b(Map<Long, ? extends EditProfileItem> map) {
        Location location;
        Object obj = map.get(1L);
        String str = null;
        if (!(obj instanceof LocationItem)) {
            obj = null;
        }
        LocationItem locationItem = (LocationItem) obj;
        if (!(locationItem == null || (location = locationItem.getLocation()) == null)) {
            str = location.getId();
        }
        return str != null ? str : "";
    }

    @Override // com.avito.android.profile.edit.SaveProfileInteractor
    @NotNull
    public Observable<ProfileSavingResult> saveProfile(@NotNull Map<Long, ? extends EditProfileItem> map) {
        Observable observable;
        String str;
        Intrinsics.checkNotNullParameter(map, "items");
        Profile profile = this.d.getProfile();
        String str2 = "";
        Pair pair = null;
        String str3 = null;
        pair = null;
        String str4 = null;
        if (profile == null || !profile.isIncomplete()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String a3 = a(map, 5);
            linkedHashMap.put("name", a3);
            linkedHashMap.put("manager", a(map, 6));
            linkedHashMap.put("locationId", b(map));
            Object obj = map.get(2L);
            if (!(obj instanceof SubLocationItem)) {
                obj = null;
            }
            SubLocationItem subLocationItem = (SubLocationItem) obj;
            if (subLocationItem != null) {
                int subLocationType = subLocationItem.getSubLocationType();
                if (subLocationType == 1) {
                    str = UrlParams.METRO_ID;
                } else if (subLocationType == 2) {
                    str = UrlParams.DIRECTION_ID;
                } else if (subLocationType == 4) {
                    str = UrlParams.DISTRICT_ID;
                }
                NameIdEntity subLocation = subLocationItem.getSubLocation();
                if (subLocation != null) {
                    str4 = subLocation.getId();
                }
                if (str4 != null) {
                    str2 = str4;
                }
                pair = TuplesKt.to(str, str2);
            }
            if (pair != null) {
                String str5 = (String) linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            observable = InteropKt.toV2(this.a.editProfile(linkedHashMap)).subscribeOn(this.e.io()).map(z.a).flatMap(new b0(this, a3));
            Intrinsics.checkNotNullExpressionValue(observable, "profileApi.editProfile(p…bservable()\n            }");
        } else {
            Object obj2 = map.get(4L);
            if (!(obj2 instanceof PhoneInputItem)) {
                obj2 = null;
            }
            PhoneInputItem phoneInputItem = (PhoneInputItem) obj2;
            if (phoneInputItem != null) {
                str3 = phoneInputItem.getValue();
            }
            if (str3 != null) {
                str2 = str3;
            }
            observable = InteropKt.toV2(this.b.session()).firstOrError().flatMapObservable(new u(map, this, str2, true)).subscribeOn(this.e.io()).flatMap(new w(this, str2, true)).flatMap(new x(this, str2, true)).map(new y(this, str2, true));
            Intrinsics.checkNotNullExpressionValue(observable, "with(items) {\n          …              }\n        }");
        }
        Observable<ProfileSavingResult> onErrorResumeNext = observable.onErrorResumeNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "if (locationInteractor.g…)\n            }\n        }");
        return onErrorResumeNext;
    }
}
