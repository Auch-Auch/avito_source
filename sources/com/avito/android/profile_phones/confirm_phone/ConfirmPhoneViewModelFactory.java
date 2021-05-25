package com.avito.android.profile_phones.confirm_phone;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "d", "J", "timeout", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "phone", "", "e", "Z", "codeRequestNeeded", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "c", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "interactor", "", AuthSource.BOOKING_ORDER, "I", "codeLength", "<init>", "(Ljava/lang/String;ILcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;JZ)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmPhoneViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final int b;
    public final PhoneConfirmInteractor c;
    public final long d;
    public final boolean e;

    public ConfirmPhoneViewModelFactory(@NotNull String str, int i, @NotNull PhoneConfirmInteractor phoneConfirmInteractor, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(phoneConfirmInteractor, "interactor");
        this.a = str;
        this.b = i;
        this.c = phoneConfirmInteractor;
        this.d = j;
        this.e = z;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ConfirmPhoneViewModelImpl.class)) {
            return new ConfirmPhoneViewModelImpl(this.a, this.c, this.b, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
