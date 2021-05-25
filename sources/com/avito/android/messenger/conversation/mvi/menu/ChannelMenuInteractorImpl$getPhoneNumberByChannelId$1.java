package com.avito.android.messenger.conversation.mvi.menu;

import com.avito.android.remote.messenger.PhoneNumberResponse;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000b\u0010\u0002\u001a\u00070\u0000¢\u0006\u0002\b\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "api", "Lio/reactivex/SingleSource;", "Lcom/avito/android/remote/messenger/PhoneNumberResponse;", "kotlin.jvm.PlatformType", "apply", "(Lru/avito/messenger/api/AvitoMessengerApi;)Lio/reactivex/SingleSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1<T, R> implements Function<AvitoMessengerApi, SingleSource<? extends PhoneNumberResponse>> {
    public final /* synthetic */ String a;

    public ChannelMenuInteractorImpl$getPhoneNumberByChannelId$1(String str) {
        this.a = str;
    }

    public final SingleSource<? extends PhoneNumberResponse> apply(@NotNull AvitoMessengerApi avitoMessengerApi) {
        Intrinsics.checkNotNullParameter(avitoMessengerApi, "api");
        return avitoMessengerApi.getPhoneByChannelId(this.a);
    }
}
