package com.avito.android.messenger.conversation.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewStatusDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewStatus;", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "statusIcon", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewStatusDelegate implements MessageViewStatus {
    public final ImageView a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MessageDeliveryStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ MessageViewStatusDelegate a;
        public final /* synthetic */ View b;

        public a(MessageViewStatusDelegate messageViewStatusDelegate, View view) {
            this.a = messageViewStatusDelegate;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Resources resources = this.b.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            Views.extendTouchableArea(this.a.a, c.roundToInt(((float) 16) * resources.getDisplayMetrics().density));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public MessageViewStatusDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.message_status_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.message_status_icon)");
        this.a = (ImageView) findViewById;
        view.post(new a(this, view));
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
    public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
        Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
        int ordinal = messageDeliveryStatus.ordinal();
        if (ordinal == 0) {
            this.a.setImageResource(com.avito.android.ui_components.R.drawable.ic_msg_pending_16);
            Views.show(this.a);
        } else if (ordinal == 1) {
            this.a.setImageResource(com.avito.android.ui_components.R.drawable.ic_msg_delivered_16);
            Views.show(this.a);
        } else if (ordinal == 2) {
            this.a.setImageResource(com.avito.android.ui_components.R.drawable.ic_msg_read_16);
            Views.show(this.a);
        } else if (ordinal == 3) {
            this.a.setImageResource(com.avito.android.ui_components.R.drawable.ic_msg_error_16);
            Views.show(this.a);
        }
        this.a.setTag(messageDeliveryStatus);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
    public void setStatusClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnClickListener(new b(function0));
        this.a.setClickable(true);
    }
}
