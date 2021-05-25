package com.avito.android.messenger.conversation.adapter;

import android.view.View;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewClicksDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "message", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "messageClickListener", "c", "messageLongClickListener", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewClicksDelegate implements MessageViewClicks {
    public final View a;
    public Function0<Unit> b;
    public Function0<Boolean> c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MessageViewClicksDelegate a;

        public a(MessageViewClicksDelegate messageViewClicksDelegate) {
            this.a = messageViewClicksDelegate;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.b;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ MessageViewClicksDelegate a;

        public b(MessageViewClicksDelegate messageViewClicksDelegate) {
            this.a = messageViewClicksDelegate;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Boolean bool;
            Function0 function0 = this.a.c;
            if (function0 == null || (bool = (Boolean) function0.invoke()) == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public MessageViewClicksDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message)");
        this.a = findViewById;
        findViewById.setOnClickListener(new a(this));
        findViewById.setOnLongClickListener(new b(this));
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function0;
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = function0;
    }
}
