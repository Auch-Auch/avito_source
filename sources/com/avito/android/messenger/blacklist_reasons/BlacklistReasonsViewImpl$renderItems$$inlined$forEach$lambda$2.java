package com.avito.android.messenger.blacklist_reasons;

import android.view.View;
import kotlin.Metadata;
import ru.avito.messenger.api.entity.BlacklistReasons;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/avito/android/messenger/blacklist_reasons/BlacklistReasonsViewImpl$renderItems$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BlacklistReasonsViewImpl$renderItems$$inlined$forEach$lambda$2 implements View.OnClickListener {
    public final /* synthetic */ BlacklistReasons.Reason a;
    public final /* synthetic */ BlacklistReasonsViewImpl b;

    public BlacklistReasonsViewImpl$renderItems$$inlined$forEach$lambda$2(BlacklistReasons.Reason reason, BlacklistReasonsViewImpl blacklistReasonsViewImpl) {
        this.a = reason;
        this.b = blacklistReasonsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.getReasonSelections().accept(Long.valueOf(this.a.getId()));
    }
}
