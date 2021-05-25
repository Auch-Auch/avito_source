package com.avito.android.messenger.conversation.adapter.location;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.adapter.MessageViewDate;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider;
import com.avito.android.messenger.conversation.adapter.MessageViewGroupDividerDelegate;
import com.avito.android.messenger.conversation.adapter.OutgoingMessageView;
import com.avito.android.messenger.conversation.adapter.location.LocationMessageView;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/OutgoingMessageView;", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OutgoingLocationMessageView extends LocationMessageView, OutgoingMessageView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull OutgoingLocationMessageView outgoingLocationMessageView) {
            LocationMessageView.DefaultImpls.onUnbind(outgoingLocationMessageView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0001¢\u0006\u0004\b\u0015\u0010\u000eJ\u001e\u0010\u0016\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001f\u0010\u0014J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\b%\u0010#J\u0018\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000fH\u0001¢\u0006\u0004\b'\u0010\u0012R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010*¨\u00068"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageView$Impl;", "Lcom/avito/android/messenger/conversation/adapter/location/OutgoingLocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/location/LocationMessageView;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewDate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewGroupDivider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "status", "", "setStatus", "(Lcom/avito/android/component/message_status/MessageDeliveryStatus;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isIncoming", ServiceTypeKt.SERVICE_HIGHLIGHT, "(Z)V", "onUnbind", "()V", "setClickListener", "setLongClickListener", "Lcom/avito/android/image_loader/Picture;", "picture", "setMapImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "showCopiedText", "", Sort.DATE, "setDate", "(Ljava/lang/String;)V", "value", "setTime", "show", "showGroupDivider", "Landroid/widget/ImageView;", "u", "Landroid/widget/ImageView;", "textStatusIcon", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "textDateView", "t", "mapDateView", "s", "mapStatusIcon", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements OutgoingLocationMessageView, LocationMessageView, MessageViewDate, MessageViewGroupDivider {
        public final ImageView s;
        public final TextView t;
        public final ImageView u;
        public final TextView v;
        public final /* synthetic */ LocationMessageViewDelegate w;
        public final /* synthetic */ LocationMessageViewDateDelegate x;
        public final /* synthetic */ MessageViewGroupDividerDelegate y;

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
                    ((Function0) this.b).invoke();
                } else if (i == 1) {
                    ((Function0) this.b).invoke();
                } else if (i == 2) {
                    ((Function0) this.b).invoke();
                } else if (i == 3) {
                    ((Function0) this.b).invoke();
                } else {
                    throw null;
                }
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ View b;

            public b(Impl impl, View view) {
                this.a = impl;
                this.b = view;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Resources resources = this.b.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
                Views.extendTouchableArea(this.a.u, c.roundToInt(((float) 16) * resources.getDisplayMetrics().density));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.w = new LocationMessageViewDelegate(view);
            this.x = new LocationMessageViewDateDelegate(view);
            this.y = new MessageViewGroupDividerDelegate(view);
            View findViewById = view.findViewById(R.id.messenger_location_bubble_map_status_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…n_bubble_map_status_icon)");
            this.s = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.messenger_location_bubble_map_date);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…location_bubble_map_date)");
            this.t = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.messenger_location_bubble_text_status_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.m…_bubble_text_status_icon)");
            this.u = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.messenger_location_bubble_text_date);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.m…ocation_bubble_text_date)");
            this.v = (TextView) findViewById4;
            view.post(new b(this, view));
        }

        @Override // com.avito.android.messenger.conversation.adapter.Highlightable
        public void highlight(boolean z) {
            this.w.highlight(z);
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            this.w.onUnbind();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.w.setClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setDate(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, Sort.DATE);
            this.x.setDate(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewClicks
        public void setLongClickListener(@NotNull Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.w.setLongClickListener(function0);
        }

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void setMapImage(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            this.w.setMapImage(picture);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatus(@NotNull MessageDeliveryStatus messageDeliveryStatus) {
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            int ordinal = messageDeliveryStatus.ordinal();
            if (ordinal == 0) {
                ImageView imageView = this.s;
                int i = com.avito.android.ui_components.R.drawable.ic_msg_pending_16;
                imageView.setImageResource(i);
                Views.show(this.s);
                this.u.setImageResource(i);
                Views.show(this.u);
            } else if (ordinal == 1) {
                ImageView imageView2 = this.s;
                int i2 = com.avito.android.ui_components.R.drawable.ic_msg_delivered_16;
                imageView2.setImageResource(i2);
                Views.show(this.s);
                this.u.setImageResource(i2);
                Views.show(this.u);
            } else if (ordinal == 2) {
                ImageView imageView3 = this.s;
                int i3 = com.avito.android.ui_components.R.drawable.ic_msg_read_16;
                imageView3.setImageResource(i3);
                Views.show(this.s);
                this.u.setImageResource(i3);
                Views.show(this.u);
            } else if (ordinal == 3) {
                ImageView imageView4 = this.s;
                int i4 = com.avito.android.ui_components.R.drawable.ic_msg_error_16;
                imageView4.setImageResource(i4);
                Views.show(this.s);
                this.u.setImageResource(i4);
                Views.show(this.u);
            }
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewStatus
        public void setStatusClickListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.t.setOnClickListener(new a(0, function0));
            this.s.setOnClickListener(new a(1, function0));
            this.s.setClickable(true);
            this.v.setOnClickListener(new a(2, function0));
            this.u.setOnClickListener(new a(3, function0));
            this.u.setClickable(true);
        }

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void setText(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "text");
            this.w.setText(charSequence);
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewDate
        public void setTime(@Nullable String str) {
            this.x.setTime(str);
        }

        @Override // com.avito.android.messenger.conversation.adapter.location.LocationMessageView
        public void showCopiedText() {
            this.w.showCopiedText();
        }

        @Override // com.avito.android.messenger.conversation.adapter.MessageViewGroupDivider
        public void showGroupDivider(boolean z) {
            this.y.showGroupDivider(z);
        }
    }
}
