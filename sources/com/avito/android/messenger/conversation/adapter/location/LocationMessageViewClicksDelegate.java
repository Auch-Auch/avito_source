package com.avito.android.messenger.conversation.adapter.location;

import android.view.View;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewClicks;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageViewClicksDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewClicks;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "setLongClickListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "mapImage", "c", "Lkotlin/jvm/functions/Function0;", "messageClickListener", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "textBubble", "d", "messageLongClickListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LocationMessageViewClicksDelegate implements MessageViewClicks {
    public final SimpleDraweeView a;
    public final TextView b;
    public Function0<Unit> c;
    public Function0<Boolean> d;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                Function0 function0 = ((LocationMessageViewClicksDelegate) this.b).c;
                if (function0 != null) {
                    Unit unit = (Unit) function0.invoke();
                }
            } else if (i == 1) {
                Function0 function02 = ((LocationMessageViewClicksDelegate) this.b).c;
                if (function02 != null) {
                    Unit unit2 = (Unit) function02.invoke();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ LocationMessageViewClicksDelegate a;

        public b(LocationMessageViewClicksDelegate locationMessageViewClicksDelegate) {
            this.a = locationMessageViewClicksDelegate;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Boolean bool;
            Function0 function0 = this.a.d;
            if (function0 == null || (bool = (Boolean) function0.invoke()) == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public LocationMessageViewClicksDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.messenger_location_bubble_map_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…ocation_bubble_map_image)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.a = simpleDraweeView;
        View findViewById2 = view.findViewById(R.id.messenger_location_bubble_text_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…ocation_bubble_text_text)");
        TextView textView = (TextView) findViewById2;
        this.b = textView;
        simpleDraweeView.setOnClickListener(new a(0, this));
        textView.setOnClickListener(new a(1, this));
        textView.setOnLongClickListener(new b(this));
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = function0;
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
    public void setLongClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d = function0;
    }
}
