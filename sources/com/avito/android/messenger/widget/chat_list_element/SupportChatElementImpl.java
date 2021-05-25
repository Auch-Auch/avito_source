package com.avito.android.messenger.widget.chat_list_element;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\u0013¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElementImpl;", "Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElement;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "hasNewIncomingUnreadMessages", "setHasNewUnreadMessage", "(Z)V", "Lcom/avito/android/remote/model/Image;", "image", "setChatIcon", "(Lcom/avito/android/remote/model/Image;)V", "Lkotlin/Function0;", "itemClickListener", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "rootView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "Lcom/facebook/drawee/view/SimpleDraweeView;", "supportChatAvatarView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "messageView", AuthSource.BOOKING_ORDER, "titleView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "newMessageIndicator", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChatElementImpl implements SupportChatElement {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final SimpleDraweeView d;
    public final ImageView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public SupportChatElementImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.messenger_support_chat_item_root);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.messenger_support_chat_item_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.messenger_support_chat_item_message);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.messenger_support_chat_icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.d = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(R.id.messenger_support_chat_new_message_indicator);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.e = (ImageView) findViewById5;
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
    public void setChatIcon(@Nullable Image image) {
        Picture pictureOf$default = AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null);
        Views.show(this.d);
        SimpleDraweeViewsKt.loadPicture$default(this.d, pictureOf$default, null, null, 6, null);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
    public void setHasNewUnreadMessage(boolean z) {
        if (z) {
            TextView textView = this.c;
            textView.setText(textView.getContext().getString(R.string.messenger_support_chat_message_new_msg));
            Views.show(this.e);
            return;
        }
        TextView textView2 = this.c;
        textView2.setText(textView2.getContext().getString(R.string.messenger_support_chat_message_happy_to_help));
        Views.hide(this.e);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
    public void setItemClickListener(@Nullable Function0<Unit> function0) {
        this.a.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }
}
