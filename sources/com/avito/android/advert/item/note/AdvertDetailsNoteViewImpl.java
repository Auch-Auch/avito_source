package com.avito.android.advert.item.note;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\u0013¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/note/AdvertDetailsNoteViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/note/AdvertDetailsNoteView;", "", VKAttachments.TYPE_NOTE, "", "updateNote", "(Ljava/lang/String;)V", "", "visible", "setContentVisible", "(Z)V", "hideBottomDivider", "()V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "text", "Landroid/view/View;", "w", "Landroid/view/View;", "botomDivider", "Lcom/jakewharton/rxrelay3/PublishRelay;", "s", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getEditNoteButtonClick", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "editNoteButtonClick", VKApiConst.VERSION, "content", "Lru/avito/component/button/ButtonImpl;", "u", "Lru/avito/component/button/ButtonImpl;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsNoteViewImpl extends BaseViewHolder implements AdvertDetailsNoteView {
    @NotNull
    public final PublishRelay<Unit> s;
    public final TextView t;
    public final ButtonImpl u;
    public final View v;
    public final View w;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsNoteViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsNoteViewImpl advertDetailsNoteViewImpl) {
            super(0);
            this.a = advertDetailsNoteViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay<Unit> editNoteButtonClick = this.a.getEditNoteButtonClick();
            Unit unit = Unit.INSTANCE;
            editNoteButtonClick.accept(unit);
            return unit;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsNoteViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.s = create;
        this.t = (TextView) view.findViewById(R.id.text);
        View findViewById = view.findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Button>(R.id.button)");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById);
        this.u = buttonImpl;
        this.v = view.findViewById(R.id.content);
        this.w = view.findViewById(R.id.bottom_divider);
        buttonImpl.setClickListener(new a(this));
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNoteView
    public void hideBottomDivider() {
        Views.hide(this.w);
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNoteView
    public void setContentVisible(boolean z) {
        Views.setVisible(this.v, z);
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNoteView
    public void updateNote(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, VKAttachments.TYPE_NOTE);
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "text");
        textView.setText(str);
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNoteView
    @NotNull
    public PublishRelay<Unit> getEditNoteButtonClick() {
        return this.s;
    }
}
