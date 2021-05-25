package a2.a.a.o1.i.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.lib.design.avito.R;
import com.avito.android.messenger.widget.HorizontalWrapContentViewContainer;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.ImageFitting;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
public final class a implements ChatListElement {
    public final ContextThemeWrapper a;
    public final SimpleDraweeView b;
    public final SimpleDraweeView c;
    public final View d;
    public final SimpleDraweeView e;
    public final SimpleDraweeView f;
    public final SimpleDraweeView g;
    public final ImageView h;
    public final HorizontalWrapContentViewContainer i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final b<String> r = new b<>(CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"печатает", "печатает .", "печатает ..", "печатает ..."}), new b(this), 300);
    public final Drawable s;
    public final View t;
    public final boolean u;

    /* renamed from: a2.a.a.o1.i.a.a$a  reason: collision with other inner class name */
    public static final class View$OnClickListenerC0006a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public View$OnClickListenerC0006a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ a a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(1);
            this.a = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.q.setText(str2);
            return Unit.INSTANCE;
        }
    }

    public a(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        this.u = z;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(view.getContext(), R.style.Theme_DesignSystem_Avito);
        this.a = contextThemeWrapper;
        View findViewById = view.findViewById(com.avito.android.messenger.R.id.item_image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(com.avito.android.messenger.R.id.system_image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.c = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.messenger.R.id.u2u_images);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.messenger.R.id.u2u_user_image);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.e = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(com.avito.android.messenger.R.id.u2u_interlocutor_image);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.f = (SimpleDraweeView) findViewById5;
        View findViewById6 = view.findViewById(com.avito.android.messenger.R.id.avatar);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.g = (SimpleDraweeView) findViewById6;
        View findViewById7 = view.findViewById(com.avito.android.messenger.R.id.online_status_indicator);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.h = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(com.avito.android.messenger.R.id.name_block);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.avito.android.messenger.widget.HorizontalWrapContentViewContainer");
        this.i = (HorizontalWrapContentViewContainer) findViewById8;
        View findViewById9 = view.findViewById(com.avito.android.messenger.R.id.chat_title);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById9;
        View findViewById10 = view.findViewById(com.avito.android.messenger.R.id.date);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById10;
        View findViewById11 = view.findViewById(com.avito.android.messenger.R.id.item_block);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.item_block)");
        this.l = findViewById11;
        View findViewById12 = view.findViewById(com.avito.android.messenger.R.id.item_name);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById12;
        View findViewById13 = view.findViewById(com.avito.android.messenger.R.id.price);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.widget.TextView");
        this.n = (TextView) findViewById13;
        View findViewById14 = view.findViewById(com.avito.android.messenger.R.id.last_message);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.widget.TextView");
        this.o = (TextView) findViewById14;
        View findViewById15 = view.findViewById(com.avito.android.messenger.R.id.item_delivery_status);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type android.widget.TextView");
        this.p = (TextView) findViewById15;
        View findViewById16 = view.findViewById(com.avito.android.messenger.R.id.is_typing);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.widget.TextView");
        this.q = (TextView) findViewById16;
        this.s = contextThemeWrapper.getDrawable(com.avito.android.messenger.R.drawable.img_item_placeholder_48_40);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setAvatarSource(@Nullable Picture picture) {
        SimpleDraweeView simpleDraweeView = this.g;
        if (picture != null) {
            simpleDraweeView.setVisibility(0);
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(picture).load();
            return;
        }
        simpleDraweeView.setVisibility(8);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setChatTitle(@Nullable String str) {
        this.j.setText(str);
        this.i.notifyTargetViewChanged();
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new View$OnClickListenerC0006a(function0));
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setDate(@Nullable String str) {
        this.k.setText(str);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setFeatureImage(@NotNull ChatListElement.FeatureImage featureImage) {
        Uri uri;
        Uri uri2;
        ImageFitting fit;
        Uri height;
        Intrinsics.checkNotNullParameter(featureImage, "featureImage");
        String str = null;
        Picture picture = null;
        str = null;
        if (featureImage instanceof ChatListElement.FeatureImage.Item) {
            Image image = ((ChatListElement.FeatureImage.Item) featureImage).getImage();
            if (image != null) {
                picture = AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null);
            }
            Views.hide(this.c);
            Views.hide(this.d);
            ((GenericDraweeHierarchy) this.b.getHierarchy()).setPlaceholderImage(this.s);
            SimpleDraweeViewsKt.loadPicture$default(this.b, picture, this.s, null, 4, null);
        } else if (featureImage instanceof ChatListElement.FeatureImage.System) {
            Image image2 = ((ChatListElement.FeatureImage.System) featureImage).getImage();
            SimplePicture simplePicture = (image2 == null || (fit = Images.fit(image2, this.c, 1.0f, 2.0f, 1)) == null || (height = fit.height()) == null) ? null : new SimplePicture(height);
            ((GenericDraweeHierarchy) this.b.getHierarchy()).setPlaceholderImage((Drawable) null);
            SimpleDraweeViewsKt.getRequestBuilder(this.b).clear();
            Views.show(this.c);
            SimpleDraweeViewsKt.loadPicture$default(this.c, simplePicture, null, null, 6, null);
        } else if (featureImage instanceof ChatListElement.FeatureImage.UserToUser) {
            ChatListElement.FeatureImage.UserToUser userToUser = (ChatListElement.FeatureImage.UserToUser) featureImage;
            Image userImage = userToUser.getUserImage();
            Picture pictureOf$default = userImage != null ? AvitoPictureKt.pictureOf$default(userImage, false, 0.0f, 0.0f, null, 28, null) : null;
            Image interlocutorImage = userToUser.getInterlocutorImage();
            Picture pictureOf$default2 = interlocutorImage != null ? AvitoPictureKt.pictureOf$default(interlocutorImage, false, 0.0f, 0.0f, null, 28, null) : null;
            ((GenericDraweeHierarchy) this.b.getHierarchy()).setPlaceholderImage((Drawable) null);
            SimpleDraweeViewsKt.getRequestBuilder(this.b).clear();
            Views.hide(this.c);
            Views.show(this.d);
            SimpleDraweeViewsKt.loadPicture$default(this.e, pictureOf$default, null, null, 6, null);
            SimpleDraweeView simpleDraweeView = this.e;
            simpleDraweeView.setTag((pictureOf$default == null || (uri2 = pictureOf$default.getUri(simpleDraweeView)) == null) ? null : uri2.toString());
            SimpleDraweeViewsKt.loadPicture$default(this.f, pictureOf$default2, null, null, 6, null);
            SimpleDraweeView simpleDraweeView2 = this.f;
            if (!(pictureOf$default2 == null || (uri = pictureOf$default2.getUri(simpleDraweeView2)) == null)) {
                str = uri.toString();
            }
            simpleDraweeView2.setTag(str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setInterlocutorOnline(boolean z) {
        Views.setVisible(this.h, z);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setIsActive(boolean z) {
        int i2;
        Resources resources = this.t.getResources();
        TypedValue typedValue = new TypedValue();
        if (!this.u || z) {
            i2 = com.avito.android.ui_components.R.dimen.active_alpha;
        } else {
            i2 = com.avito.android.ui_components.R.dimen.inactive_alpha;
        }
        resources.getValue(i2, typedValue, true);
        float f2 = typedValue.getFloat();
        for (View view : CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.b, this.g, this.j, this.k, this.m, this.n, this.o, this.p})) {
            view.setAlpha(f2);
        }
        this.t.setTag(Boolean.valueOf(z));
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setIsTyping(boolean z) {
        b<String> bVar = this.r;
        if (z) {
            this.o.setVisibility(4);
            this.q.setVisibility(0);
            int i2 = bVar.a;
            if (i2 == 0) {
                Function1<T, Unit> function1 = bVar.e;
                List<T> list = bVar.d;
                function1.invoke(list.get(i2 % list.size()));
                bVar.a++;
                bVar.b.postDelayed(bVar.c, bVar.f);
                return;
            }
            return;
        }
        bVar.b.removeCallbacks(bVar.c);
        bVar.a = 0;
        this.q.setVisibility(4);
        this.o.setVisibility(0);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setItemDeliveryStatus(@Nullable String str, @NotNull ChatListElement.ItemDeliveryStatusType itemDeliveryStatusType) {
        int i2;
        Intrinsics.checkNotNullParameter(itemDeliveryStatusType, "type");
        int ordinal = itemDeliveryStatusType.ordinal();
        if (ordinal == 0) {
            i2 = com.avito.android.lib.design.R.attr.orange;
        } else if (ordinal == 1) {
            i2 = com.avito.android.lib.design.R.attr.green;
        } else if (ordinal == 2) {
            i2 = com.avito.android.lib.design.R.attr.red;
        } else if (ordinal == 3) {
            this.p.setVisibility(8);
            return;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        TextView textView = this.p;
        textView.setVisibility(0);
        textView.setText((CharSequence) null);
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorByAttr = Contexts.getColorByAttr(context, i2);
        textView.setTextColor(colorByAttr);
        Drawable drawable = this.t.getContext().getDrawable(com.avito.android.ui_components.R.drawable.ic_delivery_16);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable != null ? DrawablesKt.wrapForTinting(drawable, colorByAttr) : null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setItemInfo(@Nullable String str, @Nullable String str2) {
        boolean z = false;
        if (str == null || m.isBlank(str)) {
            if (str2 == null || m.isBlank(str2)) {
                z = true;
            }
            if (z) {
                Views.hide(this.l);
                return;
            }
        }
        this.n.setText(str2);
        TextView textView = this.m;
        textView.getLayoutParams().width = (int) Math.ceil((double) textView.getPaint().measureText(str != null ? str : ""));
        textView.setText(str);
        Views.show(this.l);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01ac  */
    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLastMessage(@org.jetbrains.annotations.NotNull com.avito.android.messenger.widget.chat_list_element.ChatListElement.LastMessageType r11, @org.jetbrains.annotations.NotNull com.avito.android.messenger.channels.mvi.presenter.MessagePreview r12) {
        /*
        // Method dump skipped, instructions count: 438
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.o1.i.a.a.setLastMessage(com.avito.android.messenger.widget.chat_list_element.ChatListElement$LastMessageType, com.avito.android.messenger.channels.mvi.presenter.MessagePreview):void");
    }

    @Override // com.avito.android.messenger.widget.chat_list_element.ChatListElement
    public void setLongClickListener(@NotNull View.OnLongClickListener onLongClickListener) {
        Intrinsics.checkNotNullParameter(onLongClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnLongClickListener(onLongClickListener);
    }
}
