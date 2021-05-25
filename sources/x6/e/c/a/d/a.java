package x6.e.c.a.d;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.spongycastle.util.Integers;
public class a {
    public static final Class a = ClassUtil.loadClass(a.class, "javax.crypto.spec.GCMParameterSpec");

    public static GCMParameters a(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        try {
            Class cls = a;
            return new GCMParameters((byte[]) cls.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]), ((Integer) cls.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue() / 8);
        } catch (Exception unused) {
            throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
        }
    }

    public static AlgorithmParameterSpec b(ASN1Primitive aSN1Primitive) throws InvalidParameterSpecException {
        try {
            GCMParameters instance = GCMParameters.getInstance(aSN1Primitive);
            return (AlgorithmParameterSpec) a.getConstructor(Integer.TYPE, byte[].class).newInstance(Integers.valueOf(instance.getIcvLen() * 8), instance.getNonce());
        } catch (NoSuchMethodException unused) {
            throw new InvalidParameterSpecException("No constructor found!");
        } catch (Exception e) {
            throw new InvalidParameterSpecException(a2.b.a.a.a.F2(e, a2.b.a.a.a.L("Construction failed: ")));
        }
    }

    public static boolean c() {
        return a != null;
    }

    public static boolean d(Class cls) {
        return a == cls;
    }

    public static boolean e(AlgorithmParameterSpec algorithmParameterSpec) {
        Class cls = a;
        return cls != null && cls.isInstance(algorithmParameterSpec);
    }
}
