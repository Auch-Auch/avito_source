package a2.a.a.a.e;

import com.avito.android.component.message_suggest_panel.MessageSuggestPanelImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MessageSuggestPanelImpl a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MessageSuggestPanelImpl messageSuggestPanelImpl, String str) {
        super(0);
        this.a = messageSuggestPanelImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.b.invoke(this.b);
        return Unit.INSTANCE;
    }
}
