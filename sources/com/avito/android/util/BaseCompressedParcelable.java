package com.avito.android.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\b&\u0018\u0000 %*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001%B\u0019\b\u0014\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010#B\u0013\b\u0014\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\"\u0010$J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0001\u0010\f*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0001\u0010\f*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/avito/android/util/BaseCompressedParcelable;", "", "T", "Landroid/os/Parcelable;", "delegate", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeDelegateToParcel", "(Ljava/lang/Object;Landroid/os/Parcel;I)V", "P", "Ljava/lang/Class;", "clazz", "readDelegateFromParcel", "(Ljava/lang/Class;Landroid/os/Parcel;)Ljava/lang/Object;", "restore", "(Ljava/lang/Class;)Ljava/lang/Object;", VKApiConst.OUT, "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "", "c", "Ljava/lang/Boolean;", "compressed", "", AuthSource.BOOKING_ORDER, "[B", Constants.MessagePayloadKeys.RAW_DATA, "<init>", "([BZ)V", "(Ljava/lang/Object;)V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseCompressedParcelable<T> implements Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public T a;
    public byte[] b;
    public Boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ?\u0010\n\u001a\u00028\u0001\"\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/util/BaseCompressedParcelable$Companion;", "", "Lcom/avito/android/util/BaseCompressedParcelable;", "T", "Landroid/os/Parcel;", "parcel", "Lkotlin/Function2;", "", "", "creator", "create", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function2;)Lcom/avito/android/util/BaseCompressedParcelable;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: ? super byte[] */
        @JvmStatic
        @NotNull
        public final <T extends BaseCompressedParcelable<?>> T create(@NotNull Parcel parcel, @NotNull Function2<? super byte[], ? super Boolean, ? extends T> function2) {
            Object obj;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Intrinsics.checkNotNullParameter(function2, "creator");
            boolean readBool = ParcelsKt.readBool(parcel);
            boolean readBool2 = readBool ? ParcelsKt.readBool(parcel) : false;
            if (readBool) {
                byte[] bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                obj = bArr;
            } else {
                obj = new byte[0];
            }
            return (T) ((BaseCompressedParcelable) function2.invoke(obj, Boolean.valueOf(readBool2)));
        }

        public Companion(j jVar) {
        }
    }

    public BaseCompressedParcelable(@NotNull byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, Constants.MessagePayloadKeys.RAW_DATA);
        this.b = bArr;
        this.c = Boolean.valueOf(z);
    }

    @JvmStatic
    @NotNull
    public static final <T extends BaseCompressedParcelable<?>> T create(@NotNull Parcel parcel, @NotNull Function2<? super byte[], ? super Boolean, ? extends T> function2) {
        return (T) Companion.create(parcel, function2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Nullable
    public abstract <P extends Parcelable> T readDelegateFromParcel(@NotNull Class<P> cls, @NotNull Parcel parcel);

    @Nullable
    public final <P extends Parcelable> T restore(@NotNull Class<P> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T t = this.a;
        if (t != null) {
            Objects.requireNonNull(t, "null cannot be cast to non-null type T");
            return t;
        }
        Boolean bool = this.c;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return null;
        }
        if (booleanValue) {
            try {
                bArr = BaseCompressedParcelableKt.decompress(bArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return readDelegateFromParcel(cls, obtain);
    }

    public abstract void writeDelegateToParcel(@NotNull T t, @NotNull Parcel parcel, int i);

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
        T t = this.a;
        if (t == null) {
            ParcelsKt.writeBool(parcel, false);
            return;
        }
        ParcelsKt.writeBool(parcel, true);
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        writeDelegateToParcel(t, obtain, i);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        Intrinsics.checkNotNullExpressionValue(marshall, "bytes");
        try {
            byte[] compress = BaseCompressedParcelableKt.compress(marshall);
            ParcelsKt.writeBool(parcel, true);
            parcel.writeInt(compress.length);
            parcel.writeByteArray(compress);
        } catch (Throwable unused) {
            ParcelsKt.writeBool(parcel, false);
            parcel.writeInt(marshall.length);
            parcel.writeByteArray(marshall);
        }
    }

    public BaseCompressedParcelable(@Nullable T t) {
        this.a = t;
    }
}
