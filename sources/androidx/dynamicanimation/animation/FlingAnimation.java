package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    public final a m;

    public static final class a {
        public float a = -4.2f;
        public float b;
        public final DynamicAnimation.p c = new DynamicAnimation.p();

        public void a(float f) {
            this.b = f * 62.5f;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        a aVar = new a();
        this.m = aVar;
        aVar.a(b());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void e(float f) {
        this.m.b = f * 62.5f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d A[RETURN] */
    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(long r9) {
        /*
            r8 = this;
            androidx.dynamicanimation.animation.FlingAnimation$a r0 = r8.m
            float r1 = r8.b
            float r2 = r8.a
            androidx.dynamicanimation.animation.DynamicAnimation$p r3 = r0.c
            double r4 = (double) r2
            float r9 = (float) r9
            r10 = 1148846080(0x447a0000, float:1000.0)
            float r6 = r9 / r10
            float r7 = r0.a
            float r6 = r6 * r7
            double r6 = (double) r6
            double r6 = java.lang.Math.exp(r6)
            double r6 = r6 * r4
            float r4 = (float) r6
            r3.b = r4
            androidx.dynamicanimation.animation.DynamicAnimation$p r3 = r0.c
            float r4 = r0.a
            float r2 = r2 / r4
            float r1 = r1 - r2
            double r5 = (double) r1
            double r1 = (double) r2
            float r4 = r4 * r9
            float r4 = r4 / r10
            double r9 = (double) r4
            double r9 = java.lang.Math.exp(r9)
            double r9 = r9 * r1
            double r9 = r9 + r5
            float r9 = (float) r9
            r3.a = r9
            androidx.dynamicanimation.animation.DynamicAnimation$p r9 = r0.c
            float r10 = r9.a
            float r9 = r9.b
            float r9 = java.lang.Math.abs(r9)
            float r10 = r0.b
            r1 = 0
            r2 = 1
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0046
            r9 = 1
            goto L_0x0047
        L_0x0046:
            r9 = 0
        L_0x0047:
            if (r9 == 0) goto L_0x004e
            androidx.dynamicanimation.animation.DynamicAnimation$p r9 = r0.c
            r10 = 0
            r9.b = r10
        L_0x004e:
            androidx.dynamicanimation.animation.DynamicAnimation$p r9 = r0.c
            float r10 = r9.a
            r8.b = r10
            float r9 = r9.b
            r8.a = r9
            float r0 = r8.h
            int r3 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r3 >= 0) goto L_0x0061
            r8.b = r0
            return r2
        L_0x0061:
            float r3 = r8.g
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x006a
            r8.b = r3
            return r2
        L_0x006a:
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0089
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 <= 0) goto L_0x0089
            androidx.dynamicanimation.animation.FlingAnimation$a r10 = r8.m
            java.util.Objects.requireNonNull(r10)
            float r9 = java.lang.Math.abs(r9)
            float r10 = r10.b
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0083
            r9 = 1
            goto L_0x0084
        L_0x0083:
            r9 = 0
        L_0x0084:
            if (r9 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r9 = 0
            goto L_0x008a
        L_0x0089:
            r9 = 1
        L_0x008a:
            if (r9 == 0) goto L_0x008d
            return r2
        L_0x008d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.dynamicanimation.animation.FlingAnimation.f(long):boolean");
    }

    public float getFriction() {
        return this.m.a / -4.2f;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f > 0.0f) {
            this.m.a = f * -4.2f;
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f) {
        super.setMaxValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f) {
        super.setMinValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f) {
        super.setStartVelocity(f);
        return this;
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        a aVar = new a();
        this.m = aVar;
        aVar.a(b());
    }
}
