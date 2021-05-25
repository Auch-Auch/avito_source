package a2.a.a.f1.h;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.in_app_calls.service.CallManagerService;
import io.reactivex.rxjava3.functions.Function;
public final class a<T, R> implements Function<String, Option<? extends CallManagerService.StartRequest.Dial>> {
    public final /* synthetic */ CallActivityRequest.Dial.NewCall a;

    public a(CallActivityRequest.Dial.NewCall newCall) {
        this.a = newCall;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Option<? extends CallManagerService.StartRequest.Dial> apply(String str) {
        return OptionKt.toOption(new CallManagerService.StartRequest.Dial(this.a.getCallUuid(), this.a.getRecipient(), this.a.getItem(), str, this.a.getScenario(), true));
    }
}
