package com.avito.android.profile_phones.phones_list;

import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.PhonesList;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/PhonesListInteractorImpl;", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "getPhonesList", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", "converter", "<init>", "(Lcom/avito/android/profile_phones/phones_list/PhonesConverter;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesListInteractorImpl implements PhonesListInteractor {
    public final PhonesConverter a;
    public final ProfileApi b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<PhonesList, List<? extends PhoneListItem>> {
        public final /* synthetic */ PhonesListInteractorImpl a;

        public a(PhonesListInteractorImpl phonesListInteractorImpl) {
            this.a = phonesListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends PhoneListItem> apply(PhonesList phonesList) {
            return this.a.a.convert(phonesList.getPhones());
        }
    }

    @Inject
    public PhonesListInteractorImpl(@NotNull PhonesConverter phonesConverter, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(phonesConverter, "converter");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = phonesConverter;
        this.b = profileApi;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.profile_phones.phones_list.PhonesListInteractor
    @NotNull
    public Single<List<PhoneListItem>> getPhonesList() {
        Single<R> flatMap = this.b.getProfilePhones().flatMap(PhonesListInteractorImpl$getPhonesList$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        return a2.b.a.a.a.e2(this.c, flatMap.map(new a(this)), "profileApi.getProfilePho…scribeOn(schedulers.io())");
    }
}
