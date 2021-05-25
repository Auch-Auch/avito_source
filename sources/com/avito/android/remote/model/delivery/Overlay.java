package com.avito.android.remote.model.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/delivery/Overlay;", "Landroid/os/Parcelable;", "<init>", "()V", "Label", "Lcom/avito/android/remote/model/delivery/Overlay$Label;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public abstract class Overlay implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/delivery/Overlay$Label;", "Lcom/avito/android/remote/model/delivery/Overlay;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Label extends Overlay {
        public static final Parcelable.Creator<Label> CREATOR = new Creator();
        @NotNull
        private final AttributedText text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Label> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Label createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Label((AttributedText) parcel.readParcelable(Label.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Label[] newArray(int i) {
                return new Label[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Label(@NotNull AttributedText attributedText) {
            super(null);
            Intrinsics.checkNotNullParameter(attributedText, "text");
            this.text = attributedText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final AttributedText getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.text, i);
        }
    }

    private Overlay() {
    }

    public /* synthetic */ Overlay(j jVar) {
        this();
    }
}
