package x6.c.b.e.c;

import java.lang.annotation.Annotation;
import org.junit.runners.model.FrameworkMember;
public class a extends Exception {
    private static final long serialVersionUID = 3176511008672645574L;

    public a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, String str) {
        super(String.format("The @%s '%s' %s", cls.getSimpleName(), frameworkMember.getName(), str));
    }
}
