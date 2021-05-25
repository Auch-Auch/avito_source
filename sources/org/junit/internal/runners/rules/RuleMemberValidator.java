package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;
public class RuleMemberValidator {
    public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator CLASS_RULE_VALIDATOR;
    public static final RuleMemberValidator RULE_METHOD_VALIDATOR;
    public static final RuleMemberValidator RULE_VALIDATOR;
    public final Class<? extends Annotation> a;
    public final boolean b;
    public final List<k> c;

    public static class b {
        public final Class<? extends Annotation> a;
        public boolean b = false;
        public final List<k> c = new ArrayList();

        public b(Class cls, a aVar) {
            this.a = cls;
        }
    }

    public static final class c implements k {
        public c(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!Modifier.isPublic(frameworkMember.getDeclaringClass().getModifiers())) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must be declared in a public class."));
            }
        }
    }

    public static final class d implements k {
        public d(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.a(frameworkMember)) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    public static final class e implements k {
        public e(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            RuleMemberValidator ruleMemberValidator = RuleMemberValidator.CLASS_RULE_VALIDATOR;
            if (!TestRule.class.isAssignableFrom(frameworkMember.getType())) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must implement TestRule."));
            }
        }
    }

    public static final class f implements k {
        public f(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            RuleMemberValidator ruleMemberValidator = RuleMemberValidator.CLASS_RULE_VALIDATOR;
            boolean isAssignableFrom = MethodRule.class.isAssignableFrom(frameworkMember.getType());
            boolean z = frameworkMember.getAnnotation(ClassRule.class) != null;
            if (!frameworkMember.isStatic()) {
                return;
            }
            if (isAssignableFrom || !z) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, MethodRule.class.isAssignableFrom(frameworkMember.getType()) ? "must not be static." : "must not be static or it must be annotated with @ClassRule."));
            }
        }
    }

    public static final class g implements k {
        public g(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isPublic()) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must be public."));
            }
        }
    }

    public static final class h implements k {
        public h(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isStatic()) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must be static."));
            }
        }
    }

    public static final class i implements k {
        public i(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.a(frameworkMember)) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    public static final class j implements k {
        public j(a aVar) {
        }

        @Override // org.junit.internal.runners.rules.RuleMemberValidator.k
        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            RuleMemberValidator ruleMemberValidator = RuleMemberValidator.CLASS_RULE_VALIDATOR;
            if (!TestRule.class.isAssignableFrom(frameworkMember.getType())) {
                list.add(new x6.c.b.e.c.a(frameworkMember, cls, "must return an implementation of TestRule."));
            }
        }
    }

    public interface k {
        void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list);
    }

    static {
        b bVar = new b(ClassRule.class, null);
        bVar.c.add(new c(null));
        bVar.c.add(new h(null));
        bVar.c.add(new g(null));
        bVar.c.add(new e(null));
        CLASS_RULE_VALIDATOR = new RuleMemberValidator(bVar);
        b bVar2 = new b(Rule.class, null);
        bVar2.c.add(new f(null));
        bVar2.c.add(new g(null));
        bVar2.c.add(new d(null));
        RULE_VALIDATOR = new RuleMemberValidator(bVar2);
        b bVar3 = new b(ClassRule.class, null);
        bVar3.b = true;
        bVar3.c.add(new c(null));
        bVar3.c.add(new h(null));
        bVar3.c.add(new g(null));
        bVar3.c.add(new j(null));
        CLASS_RULE_METHOD_VALIDATOR = new RuleMemberValidator(bVar3);
        b bVar4 = new b(Rule.class, null);
        bVar4.b = true;
        bVar4.c.add(new f(null));
        bVar4.c.add(new g(null));
        bVar4.c.add(new i(null));
        RULE_METHOD_VALIDATOR = new RuleMemberValidator(bVar4);
    }

    public RuleMemberValidator(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public static boolean a(FrameworkMember frameworkMember) {
        return MethodRule.class.isAssignableFrom(frameworkMember.getType()) || TestRule.class.isAssignableFrom(frameworkMember.getType());
    }

    public void validate(TestClass testClass, List<Throwable> list) {
        for (FrameworkMember<?> frameworkMember : this.b ? testClass.getAnnotatedMethods(this.a) : testClass.getAnnotatedFields(this.a)) {
            for (k kVar : this.c) {
                kVar.a(frameworkMember, this.a, list);
            }
        }
    }
}
