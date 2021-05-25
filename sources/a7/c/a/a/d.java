package a7.c.a.a;

import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
public final class d extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, String> {
    public final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super(1);
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        String string;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        Intent intent = this.a.a.getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "this@SravniChatActivity.intent");
        Bundle extras = intent.getExtras();
        return (extras == null || (string = extras.getString("defaultUserPhoneForAuth")) == null) ? "" : string;
    }
}
