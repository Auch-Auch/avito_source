package com.avito.android.html_formatter.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B5\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0/¢\u0006\u0004\b7\u00108J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007Jq\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001bH\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b+\u0010$R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010)R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010)¨\u0006:"}, d2 = {"Lcom/avito/android/html_formatter/span/ListElementSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lcom/avito/android/html_formatter/span/HtmlSpan;", "", InternalConstsKt.FIRST_IMAGE, "", "getLeadingMargin", "(Z)I", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "paint", "x", "dir", "top", "baseline", "bottom", "", "text", Tracker.Events.CREATIVE_START, "end", "isFirstLine", "Landroid/text/Layout;", "layout", "", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "", "getBullet", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "bullet", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)I", "e", "I", "bulletLengthPenalty", "getType", "type", AuthSource.BOOKING_ORDER, "bulletLeftMargin", "", "f", "Ljava/util/List;", "bullets", "d", "bulletWidth", "c", "bulletRightMargin", "<init>", "(IIIILjava/util/List;)V", "CREATOR", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class ListElementSpan implements LeadingMarginSpan, HtmlSpan {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int LIST_ELEMENT_SPAN_TYPE = 100;
    public final int a = 100;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final List<String> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/html_formatter/span/ListElementSpan$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/html_formatter/span/ListElementSpan;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/html_formatter/span/ListElementSpan;", "", "size", "", "newArray", "(I)[Lcom/avito/android/html_formatter/span/ListElementSpan;", "LIST_ELEMENT_SPAN_TYPE", "I", "<init>", "()V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<ListElementSpan> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ListElementSpan createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            return new ListElementSpan(readInt, readInt2, readInt3, readInt4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ListElementSpan[] newArray(int i) {
            return new ListElementSpan[i];
        }
    }

    public ListElementSpan(int i, int i2, int i3, int i4, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "bullets");
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = list;
    }

    public final int a(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return str.length() + this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(@NotNull Canvas canvas, @NotNull Paint paint, int i, int i2, int i3, int i4, int i5, @Nullable CharSequence charSequence, int i6, int i7, boolean z, @NotNull Layout layout) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Objects.requireNonNull(charSequence, "null cannot be cast to non-null type android.text.Spanned");
        Spanned spanned = (Spanned) charSequence;
        int lineBaseline = layout.getLineBaseline(layout.getLineForOffset(spanned.getSpanStart(this)));
        String bullet = getBullet();
        int i8 = 0;
        boolean z2 = spanned.getSpanStart(this) == i6;
        for (String str : CollectionsKt___CollectionsKt.dropLast(this.f, 1)) {
            i8 += (a(str) * this.d) + this.b + this.c;
        }
        if (z2) {
            canvas.drawText(bullet, (float) (i8 + this.b), (float) lineBaseline, paint);
        }
    }

    @NotNull
    public final String getBullet() {
        if (this.f.isEmpty()) {
            return "";
        }
        return (String) CollectionsKt___CollectionsKt.last((List<? extends Object>) this.f);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return (a(getBullet()) * this.d) + this.b + this.c;
    }

    @Override // com.avito.android.html_formatter.span.HtmlSpan
    public int getType() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this.b);
        }
        if (parcel != null) {
            parcel.writeInt(this.c);
        }
        if (parcel != null) {
            parcel.writeInt(this.d);
        }
        if (parcel != null) {
            parcel.writeInt(this.e);
        }
        if (parcel != null) {
            parcel.writeStringList(this.f);
        }
    }
}
