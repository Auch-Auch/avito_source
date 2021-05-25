package a2.a.a.n3;

import com.avito.android.util.CompressedParcelable;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function2<byte[], Boolean, CompressedParcelable> {
    public static final h a = new h();

    public h() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public CompressedParcelable invoke(byte[] bArr, Boolean bool) {
        byte[] bArr2 = bArr;
        boolean booleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(bArr2, Constants.MessagePayloadKeys.RAW_DATA);
        return new CompressedParcelable(bArr2, booleanValue, null);
    }
}
