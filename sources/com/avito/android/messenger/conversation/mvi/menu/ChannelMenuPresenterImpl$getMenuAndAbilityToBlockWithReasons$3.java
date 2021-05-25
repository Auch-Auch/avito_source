package com.avito.android.messenger.conversation.mvi.menu;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", FirebaseAnalytics.Param.INDEX, "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelMenuPresenterImpl$getMenuAndAbilityToBlockWithReasons$3 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ List a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelMenuPresenterImpl$getMenuAndAbilityToBlockWithReasons$3(List list) {
        super(1);
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((Function0) this.a.get(i)).invoke();
    }
}
