package com.avito.android.messenger.conversation.adapter;

import android.view.View;
import android.widget.ImageView;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatarDelegate;", "Lcom/avito/android/messenger/conversation/adapter/MessageViewAvatar;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAvatarClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "avatar", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageViewAvatarDelegate implements MessageViewAvatar {
    public final ImageView a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public MessageViewAvatarDelegate(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (ImageView) view.findViewById(R.id.message_avatar);
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
    public void setAvatar(@Nullable Picture picture) {
        ImageView imageView = this.a;
        if (imageView != null) {
            if (picture != null) {
                Views.show(imageView);
                ImageView imageView2 = this.a;
                if (imageView2 instanceof SimpleDraweeView) {
                    a2.b.a.a.a.L0((SimpleDraweeView) imageView2, picture);
                    return;
                }
                this.a.setImageURI(picture.getUri(imageView2));
                return;
            }
            Views.conceal(imageView);
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.MessageViewAvatar
    public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setOnClickListener(new a(function0));
        }
    }
}
