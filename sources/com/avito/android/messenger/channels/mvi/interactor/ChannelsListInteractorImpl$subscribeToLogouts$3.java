package com.avito.android.messenger.channels.mvi.interactor;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelsListInteractorImpl$subscribeToLogouts$3 extends FunctionReferenceImpl implements Function1<CharSequence, Boolean> {
    public static final ChannelsListInteractorImpl$subscribeToLogouts$3 INSTANCE = new ChannelsListInteractorImpl$subscribeToLogouts$3();

    public ChannelsListInteractorImpl$subscribeToLogouts$3() {
        super(1, StringsKt.class, "isEmpty", "isEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
        return Boolean.valueOf(invoke((String) charSequence));
    }

    public final boolean invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        return str.length() == 0;
    }
}
