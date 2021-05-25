package com.avito.android.html_formatter;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.avito.android.html_formatter.span.HtmlSpan;
import com.avito.android.html_formatter.span.ListElementSpan;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u000b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u0010/\u001a\u00020\u0001¢\u0006\u0004\b2\u00103J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0016\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0018\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0001¢\u0006\u0004\b\u0018\u0010\u0017J \u0010\u0019\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u0017J\u0001\u0010\u001f\u001a(\u0012\f\u0012\n \u0014*\u0004\u0018\u00018\u00008\u0000 \u0014*\u0014\u0012\u000e\b\u0001\u0012\n \u0014*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u001e0\u001e\"\u0010\b\u0000\u0010\u001a*\n \u0014*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052*\u0010\u001d\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00018\u00008\u0000 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u001c0\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 JB\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052 \u0010\u001d\u001a\u001c\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013 \u0014*\b\u0012\u0002\b\u0003\u0018\u00010\u001c0\u001cH\u0001¢\u0006\u0004\b!\u0010\"J \u0010#\u001a\u00020\u00072\u000e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0001¢\u0006\u0004\b#\u0010$J8\u0010&\u001a\u00020\u00072\u000e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0001¢\u0006\u0004\b&\u0010'J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0001¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u000b¨\u00065"}, d2 = {"Lcom/avito/android/html_formatter/HtmlCharSequence;", "Landroid/text/Spannable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", FirebaseAnalytics.Param.INDEX, "", "get", "(I)C", "", "kotlin.jvm.PlatformType", "p0", "getSpanEnd", "(Ljava/lang/Object;)I", "getSpanFlags", "getSpanStart", "T", "p1", "Ljava/lang/Class;", "p2", "", "getSpans", "(IILjava/lang/Class;)[Ljava/lang/Object;", "nextSpanTransition", "(IILjava/lang/Class;)I", "removeSpan", "(Ljava/lang/Object;)V", "p3", "setSpan", "(Ljava/lang/Object;III)V", "startIndex", "endIndex", "", "subSequence", "(II)Ljava/lang/CharSequence;", AuthSource.SEND_ABUSE, "Landroid/text/Spannable;", "spannable", "getLength", "length", "<init>", "(Landroid/text/Spannable;)V", "CREATOR", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlCharSequence implements Spannable, Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    public final Spannable a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/html_formatter/HtmlCharSequence$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/html_formatter/HtmlCharSequence;", "", "size", "", "newArray", "(I)[Lcom/avito/android/html_formatter/HtmlCharSequence;", "<init>", "()V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<HtmlCharSequence> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public HtmlCharSequence createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SpannableString spannableString = new SpannableString((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            int readInt = parcel.readInt();
            if (readInt > 0) {
                Iterator it = new IntRange(1, readInt).iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    Objects.requireNonNull(HtmlCharSequence.CREATOR);
                    int readInt2 = parcel.readInt();
                    int readInt3 = parcel.readInt();
                    int readInt4 = parcel.readInt();
                    HtmlSpan htmlSpan = null;
                    if (parcel.readInt() == 100) {
                        htmlSpan = (HtmlSpan) parcel.readParcelable(ListElementSpan.class.getClassLoader());
                    }
                    if (htmlSpan != null) {
                        spannableString.setSpan(htmlSpan, readInt2, readInt3, readInt4);
                    }
                }
            }
            return new HtmlCharSequence(spannableString);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public HtmlCharSequence[] newArray(int i) {
            return new HtmlCharSequence[i];
        }
    }

    public HtmlCharSequence(@NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        this.a = spannable;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public char get(int i) {
        return this.a.charAt(i);
    }

    public int getLength() {
        return this.a.length();
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.a.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class<Object> cls) {
        return this.a.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        this.a.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        this.a.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    @NotNull
    public CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence, java.lang.Object
    @NotNull
    public String toString() {
        return this.a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        TextUtils.writeToParcel(this, parcel, i);
        HtmlSpan[] htmlSpanArr = (HtmlSpan[]) getSpans(0, length(), HtmlSpan.class);
        parcel.writeInt(htmlSpanArr.length);
        Intrinsics.checkNotNullExpressionValue(htmlSpanArr, "spans");
        for (HtmlSpan htmlSpan : htmlSpanArr) {
            Intrinsics.checkNotNullExpressionValue(htmlSpan, "it");
            parcel.writeInt(getSpanStart(htmlSpan));
            parcel.writeInt(getSpanEnd(htmlSpan));
            parcel.writeInt(getSpanFlags(htmlSpan));
            parcel.writeInt(htmlSpan.getType());
            parcel.writeParcelable(htmlSpan, i);
        }
    }
}
