package com.avito.android.messenger.conversation.mvi.menu;

import com.avito.android.remote.messenger.PhoneNumberResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelMenuInteractorImpl$getPhoneNumberByChannelId$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new ChannelMenuInteractorImpl$getPhoneNumberByChannelId$2();

    public ChannelMenuInteractorImpl$getPhoneNumberByChannelId$2() {
        super(PhoneNumberResponse.class, "phone", "getPhone()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    @Nullable
    public Object get(@Nullable Object obj) {
        return ((PhoneNumberResponse) obj).getPhone();
    }
}
