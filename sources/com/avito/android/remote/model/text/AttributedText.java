package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u0000 52\u00020\u0001:\u00015B\u001d\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b3\u00104J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u0011R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/text/AttributedText;", "Landroid/os/Parcelable;", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "linkClicks", "()Lio/reactivex/Observable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/text/Attribute;", "component2", "()Ljava/util/List;", "text", Navigation.ATTRIBUTES, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/text/AttributedText;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAttributes", "Ljava/lang/String;", "getText", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "onUrlClickListener", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "getOnUrlClickListener", "()Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "setOnUrlClickListener", "(Lcom/avito/android/deep_linking/links/OnUrlClickListener;)V", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "onDeepLinkClickListener", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "getOnDeepLinkClickListener", "()Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "setOnDeepLinkClickListener", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AttributedText implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AttributedText> CREATOR = Parcels.creator(AttributedText$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Attribute> attributes;
    @Nullable
    private OnDeepLinkClickListener onDeepLinkClickListener;
    @Nullable
    private OnUrlClickListener onUrlClickListener;
    @NotNull
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/text/AttributedText$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/text/AttributedText;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.text.Attribute> */
    /* JADX WARN: Multi-variable type inference failed */
    public AttributedText(@NotNull String str, @NotNull List<? extends Attribute> list) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, Navigation.ATTRIBUTES);
        this.text = str;
        this.attributes = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.text.AttributedText */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttributedText copy$default(AttributedText attributedText, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributedText.text;
        }
        if ((i & 2) != 0) {
            list = attributedText.attributes;
        }
        return attributedText.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final List<Attribute> component2() {
        return this.attributes;
    }

    @NotNull
    public final AttributedText copy(@NotNull String str, @NotNull List<? extends Attribute> list) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, Navigation.ATTRIBUTES);
        return new AttributedText(str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttributedText)) {
            return false;
        }
        AttributedText attributedText = (AttributedText) obj;
        return Intrinsics.areEqual(this.text, attributedText.text) && Intrinsics.areEqual(this.attributes, attributedText.attributes);
    }

    @NotNull
    public final List<Attribute> getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final OnDeepLinkClickListener getOnDeepLinkClickListener() {
        return this.onDeepLinkClickListener;
    }

    @Nullable
    public final OnUrlClickListener getOnUrlClickListener() {
        return this.onUrlClickListener;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Attribute> list = this.attributes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final Observable<DeepLink> linkClicks() {
        Observable<DeepLink> create = Observable.create(new AttributedText$linkClicks$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…Listener = listener\n    }");
        return create;
    }

    public final void setOnDeepLinkClickListener(@Nullable OnDeepLinkClickListener onDeepLinkClickListener2) {
        this.onDeepLinkClickListener = onDeepLinkClickListener2;
    }

    public final void setOnUrlClickListener(@Nullable OnUrlClickListener onUrlClickListener2) {
        this.onUrlClickListener = onUrlClickListener2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AttributedText(text=");
        L.append(this.text);
        L.append(", attributes=");
        return a.w(L, this.attributes, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.text);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.attributes, 0, 2, null);
    }
}
