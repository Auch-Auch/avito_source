package com.avito.android.messenger.conversation.chat_header;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00010B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b+\u0010/J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R*\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0013\u0010\u001c\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R.\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001d8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010(\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001d8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u00061"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ItemTitleAndPriceView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "h", "()V", "", "u", "Z", "updatePending", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "line1", "value", "r", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "singleLine", "t", "line2", "isBlank", "", VKApiConst.Q, "Ljava/lang/String;", "getPriceText", "()Ljava/lang/String;", "setPriceText", "(Ljava/lang/String;)V", "priceText", "p", "getTitleText", "setTitleText", "titleText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SavedState", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemTitleAndPriceView extends LinearLayoutCompat {
    @NotNull
    public String p;
    @Nullable
    public String q;
    public boolean r;
    public final TextView s;
    public final TextView t;
    public boolean u;

    public static final class a implements Runnable {
        public final /* synthetic */ ItemTitleAndPriceView a;

        public a(ItemTitleAndPriceView itemTitleAndPriceView) {
            this.a = itemTitleAndPriceView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.u = false;
            ItemTitleAndPriceView.access$updateUi(this.a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ItemTitleAndPriceView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final String access$truncateText(ItemTitleAndPriceView itemTitleAndPriceView, TextView textView, String str, float f, boolean z) {
        String str2;
        Objects.requireNonNull(itemTitleAndPriceView);
        int breakText = textView.getPaint().breakText(str, true, e.coerceAtLeast(f, 0.0f), null);
        if (z) {
            int coerceIn = e.coerceIn(breakText, 0, str.length() - 1);
            while (coerceIn >= 0 && !t6.y.a.isWhitespace(str.charAt(coerceIn))) {
                coerceIn--;
            }
            if (coerceIn < 0) {
                str2 = StringsKt___StringsKt.take(str, breakText);
            } else {
                str2 = StringsKt___StringsKt.take(str, coerceIn);
            }
        } else {
            str2 = StringsKt___StringsKt.take(str, breakText);
        }
        Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
        return StringsKt__StringsKt.trim(str2).toString();
    }

    public static final void access$updateUi(ItemTitleAndPriceView itemTitleAndPriceView) {
        String str = itemTitleAndPriceView.p;
        String str2 = itemTitleAndPriceView.q;
        boolean z = itemTitleAndPriceView.r;
        if (str2 == null || m.isBlank(str2)) {
            Views.hide(itemTitleAndPriceView.t);
            if (z) {
                itemTitleAndPriceView.s.setSingleLine(true);
                itemTitleAndPriceView.s.setMaxLines(1);
                TextViews.bindText(itemTitleAndPriceView.s, str, true);
                return;
            }
            itemTitleAndPriceView.s.setSingleLine(false);
            itemTitleAndPriceView.s.setMaxLines(2);
            TextViews.bindText(itemTitleAndPriceView.s, str, true);
            return;
        }
        String c3 = a2.b.a.a.a.c3("· ", str2);
        String L2 = a2.b.a.a.a.L2(str, ' ', c3);
        Views.hide(itemTitleAndPriceView.t);
        itemTitleAndPriceView.s.setSingleLine(true);
        itemTitleAndPriceView.s.setMaxLines(1);
        if (z) {
            TextViews.bindText(itemTitleAndPriceView.s, L2, true);
            Views.runOnPreDraw(itemTitleAndPriceView, new v5(0, itemTitleAndPriceView, c3, str));
            return;
        }
        TextViews.bindText(itemTitleAndPriceView.s, L2, true);
        Views.runOnPreDraw(itemTitleAndPriceView, new v5(1, itemTitleAndPriceView, str, c3));
    }

    @Nullable
    public final String getPriceText() {
        return this.q;
    }

    public final boolean getSingleLine() {
        return this.r;
    }

    @NotNull
    public final String getTitleText() {
        return this.p;
    }

    public final void h() {
        if (!this.u) {
            this.u = true;
            post(new a(this));
        }
    }

    public final boolean isBlank() {
        if (m.isBlank(this.p)) {
            String str = this.q;
            if (str == null || m.isBlank(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setTitleText(savedState.getTitleText());
            setPriceText(savedState.getPriceText());
            setSingleLine(savedState.getSingleLine());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setTitleText(this.p);
        savedState.setPriceText(this.q);
        savedState.setSingleLine(this.r);
        return savedState;
    }

    public final void setPriceText(@Nullable String str) {
        if (!Intrinsics.areEqual(str, this.q)) {
            this.q = str;
            h();
        }
    }

    public final void setSingleLine(boolean z) {
        if (z != this.r) {
            this.r = z;
            h();
        }
    }

    public final void setTitleText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        if (!Intrinsics.areEqual(str, this.p)) {
            this.p = str;
            h();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u0018¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ItemTitleAndPriceView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "toString", "()Ljava/lang/String;", "", "c", "Z", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "singleLine", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPriceText", "setPriceText", "(Ljava/lang/String;)V", "priceText", AuthSource.SEND_ABUSE, "getTitleText", "setTitleText", "titleText", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public String a;
        @Nullable
        public String b;
        public boolean c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ItemTitleAndPriceView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/messenger/conversation/chat_header/ItemTitleAndPriceView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2, null);
            }
        }

        public SavedState(@Nullable Parcelable parcelable) {
            super(parcelable);
            this.a = "";
        }

        @Nullable
        public final String getPriceText() {
            return this.b;
        }

        public final boolean getSingleLine() {
            return this.c;
        }

        @NotNull
        public final String getTitleText() {
            return this.a;
        }

        public final void setPriceText(@Nullable String str) {
            this.b = str;
        }

        public final void setSingleLine(boolean z) {
            this.c = z;
        }

        public final void setTitleText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ItemTitleAndPriceView.SavedState('");
            L.append(this.a);
            L.append("', '");
            L.append(this.b);
            L.append("', ");
            return a2.b.a.a.a.A(L, this.c, ')');
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            ParcelsKt.writeBool(parcel, this.c);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            String str = "";
            this.a = str;
            String readString = parcel.readString();
            this.a = readString != null ? readString : str;
            this.b = parcel.readString();
            this.c = ParcelsKt.readBool(parcel);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemTitleAndPriceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.p = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.messenger_item_title_with_price, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.line1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.line1)");
        this.s = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.line2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.line2)");
        this.t = (TextView) findViewById2;
    }
}
