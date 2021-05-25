package com.avito.android.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b*\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/util/Parcels;", "", "Landroid/os/Parcelable;", "T", "Lkotlin/Function1;", "Landroid/os/Parcel;", "Lkotlin/ExtensionFunctionType;", SDKConstants.PARAM_A2U_BODY, "Landroid/os/Parcelable$Creator;", "creator", "(Lkotlin/jvm/functions/Function1;)Landroid/os/Parcelable$Creator;", "", "value", "", "writeBool", "(Landroid/os/Parcel;Z)V", "readBool", "(Landroid/os/Parcel;)Z", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Parcels {
    @NotNull
    public static final Parcels INSTANCE = new Parcels();

    @JvmStatic
    @NotNull
    public static final <T extends Parcelable> Parcelable.Creator<T> creator(@NotNull Function1<? super Parcel, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, SDKConstants.PARAM_A2U_BODY);
        return new Parcelable.Creator<T>(function1) { // from class: com.avito.android.util.Parcels$creator$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public T createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "source");
                return (T) ((Parcelable) this.a.invoke(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public T[] newArray(int i) {
                return (T[]) ((Parcelable[]) new Object[i]);
            }
        };
    }

    @JvmStatic
    public static final boolean readBool(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$this$readBool");
        return parcel.readInt() == 1;
    }

    @JvmStatic
    public static final void writeBool(@NotNull Parcel parcel, boolean z) {
        Intrinsics.checkNotNullParameter(parcel, "$this$writeBool");
        parcel.writeInt(z ? 1 : 0);
    }
}
