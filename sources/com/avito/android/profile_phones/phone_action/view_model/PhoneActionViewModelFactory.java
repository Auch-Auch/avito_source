package com.avito.android.profile_phones.phone_action.view_model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.profile_phones.phone_action.PhoneParcelableEntity;
import com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "d", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "phoneAction", "", AuthSource.BOOKING_ORDER, "I", "advertsCount", "", "Lcom/avito/android/profile_phones/phone_action/PhoneParcelableEntity;", "c", "Ljava/util/List;", "phonesForReplacement", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "e", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "resourceProvider", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "f", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "interactor", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;ILjava/util/List;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final int b;
    public final List<PhoneParcelableEntity> c;
    public final PhoneActionCode d;
    public final PhoneActionResourceProvider e;
    public final PhoneActionInteractor f;

    @Inject
    public PhoneActionViewModelFactory(@NotNull String str, int i, @NotNull List<PhoneParcelableEntity> list, @NotNull PhoneActionCode phoneActionCode, @NotNull PhoneActionResourceProvider phoneActionResourceProvider, @NotNull PhoneActionInteractor phoneActionInteractor) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "phonesForReplacement");
        Intrinsics.checkNotNullParameter(phoneActionCode, "phoneAction");
        Intrinsics.checkNotNullParameter(phoneActionResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(phoneActionInteractor, "interactor");
        this.a = str;
        this.b = i;
        this.c = list;
        this.d = phoneActionCode;
        this.e = phoneActionResourceProvider;
        this.f = phoneActionInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PhoneActionViewModelImpl.class)) {
            return new PhoneActionViewModelImpl(this.a, this.b, this.c, this.e, this.f, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
