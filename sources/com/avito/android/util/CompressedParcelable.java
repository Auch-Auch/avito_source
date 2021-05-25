package com.avito.android.util;

import a2.a.a.n3.h;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u000b*\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/CompressedParcelable;", "Lcom/avito/android/util/BaseCompressedParcelable;", "Landroid/os/Parcelable;", "delegate", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeDelegateToParcel", "(Landroid/os/Parcelable;Landroid/os/Parcel;I)V", "P", "Ljava/lang/Class;", "clazz", "readDelegateFromParcel", "(Ljava/lang/Class;Landroid/os/Parcel;)Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public final class CompressedParcelable extends BaseCompressedParcelable<Parcelable> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CompressedParcelable> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/util/CompressedParcelable$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/util/CompressedParcelable;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CompressedParcelable> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CompressedParcelable invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return (CompressedParcelable) BaseCompressedParcelable.Companion.create(parcel2, h.a);
        }
    }

    public CompressedParcelable(byte[] bArr, boolean z, j jVar) {
        super(bArr, z);
    }

    public CompressedParcelable(@Nullable Parcelable parcelable) {
        super(parcelable);
    }

    @Override // com.avito.android.util.BaseCompressedParcelable
    @Nullable
    public <P extends Parcelable> Parcelable readDelegateFromParcel(@NotNull Class<P> cls, @NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return parcel.readParcelable(cls.getClassLoader());
    }

    public void writeDelegateToParcel(@NotNull Parcelable parcelable, @NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcelable, "delegate");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(parcelable, i);
    }
}
