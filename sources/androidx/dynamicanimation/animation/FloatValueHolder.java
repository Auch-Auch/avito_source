package androidx.dynamicanimation.animation;
public final class FloatValueHolder {
    public float a = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.a;
    }

    public void setValue(float f) {
        this.a = f;
    }

    public FloatValueHolder(float f) {
        setValue(f);
    }
}
