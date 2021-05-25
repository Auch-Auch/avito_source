package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010 \u001a\n \u001a*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n \u001a*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001e\u0010&\u001a\n \u001a*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010(\u001a\n \u001a*\u0004\u0018\u00010\u001d0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001f¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemListSnippetViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/snippet/ItemListSnippetView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setTitle", "(Ljava/lang/String;)V", "setPrice", "setLocation", "Lcom/avito/android/remote/model/Image;", "image", "loadImage", "(Lcom/avito/android/remote/model/Image;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "y", "Lkotlin/jvm/functions/Function0;", "clickListener", "Landroid/graphics/drawable/Drawable;", "x", "Landroid/graphics/drawable/Drawable;", "placeholderImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "w", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "location", "u", "price", "Landroid/content/Context;", "s", "Landroid/content/Context;", "context", "t", "title", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemListSnippetViewImpl extends BaseViewHolder implements ItemListSnippetView {
    public final Context s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final SimpleDraweeView w;
    public final Drawable x;
    public Function0<Unit> y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ItemListSnippetViewImpl a;

        public a(ItemListSnippetViewImpl itemListSnippetViewImpl) {
            this.a = itemListSnippetViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.y;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemListSnippetViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        this.s = context;
        this.t = (TextView) view.findViewById(R.id.platform_items_list_snippet_title);
        this.u = (TextView) view.findViewById(R.id.platform_items_list_snippet_subtitle);
        this.v = (TextView) view.findViewById(R.id.platform_items_list_snippet_location);
        this.w = (SimpleDraweeView) view.findViewById(R.id.platform_items_list_snippet_image);
        this.x = context.getDrawable(R.drawable.ic_messenger_item_no_image);
        view.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView
    public void loadImage(@Nullable Image image) {
        Map<Size, Uri> variants;
        Set<Map.Entry<Size, Uri>> entrySet;
        T t2;
        SimpleDraweeView simpleDraweeView = this.w;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "this.image");
        Uri width = Images.fit$default(image, simpleDraweeView, 0.0f, 0.0f, 0, 14, null).width();
        if (width == null) {
            if (!(image == null || (variants = image.getVariants()) == null || (entrySet = variants.entrySet()) == null)) {
                Iterator<T> it = entrySet.iterator();
                if (!it.hasNext()) {
                    t2 = null;
                } else {
                    t2 = it.next();
                    if (it.hasNext()) {
                        int area = ((Size) t2.getKey()).area();
                        do {
                            T next = it.next();
                            int area2 = ((Size) next.getKey()).area();
                            if (area < area2) {
                                t2 = next;
                                area = area2;
                            }
                        } while (it.hasNext());
                    }
                }
                T t3 = t2;
                if (t3 != null) {
                    width = (Uri) t3.getValue();
                }
            }
            width = null;
        }
        if (width == null) {
            width = Uri.EMPTY;
        }
        SimpleDraweeView simpleDraweeView2 = this.w;
        Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "this.image");
        Intrinsics.checkNotNullExpressionValue(width, ShareConstants.MEDIA_URI);
        SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView2, new SimplePicture(width), this.x, null, 4, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ItemListSnippetView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView
    public void setLocation(@Nullable String str) {
        TextView textView = this.v;
        Intrinsics.checkNotNullExpressionValue(textView, "location");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = function0;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView
    public void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        TextView textView = this.u;
        Intrinsics.checkNotNullExpressionValue(textView, "price");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.snippet.ItemListSnippetView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        TextViews.bindText$default(textView, str, false, 2, null);
    }
}
