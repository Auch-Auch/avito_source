package com.avito.android.advert_core.contactbar;

import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.deep_linking.links.PhoneLink;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/advert_core/contactbar/PhoneActionData;", "getPhoneAction", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "categoryId", "Lcom/avito/android/calls_shared/AppCallScenario;", "scenario", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "getCallMethods", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/calls_shared/AppCallScenario;Lcom/avito/android/deep_linking/links/PhoneLink$Call;)Lio/reactivex/rxjava3/core/Single;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertContactsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single getCallMethods$default(AdvertContactsInteractor advertContactsInteractor, String str, String str2, AppCallScenario appCallScenario, PhoneLink.Call call, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    call = null;
                }
                return advertContactsInteractor.getCallMethods(str, str2, appCallScenario, call);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallMethods");
        }
    }

    @NotNull
    Single<CallMethods> getCallMethods(@NotNull String str, @NotNull String str2, @NotNull AppCallScenario appCallScenario, @Nullable PhoneLink.Call call);

    @NotNull
    Single<PhoneActionData> getPhoneAction(@NotNull String str);
}
