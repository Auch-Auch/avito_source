package androidx.constraintlayout.solver;

import a2.b.a.a.a;
import java.util.Arrays;
public class SolverVariable {
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public static int k = 1;
    public String a;
    public int b;
    public float[] c;
    public float computedValue;
    public float[] d;
    public Type e;
    public ArrayRow[] f;
    public int g;
    public boolean h;
    public int i;
    public int id;
    public boolean inGoal;
    public boolean isFinalValue;
    public float j;
    public int strength;
    public int usageInRowCount;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.b = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.c = new float[9];
        this.d = new float[9];
        this.f = new ArrayRow[16];
        this.g = 0;
        this.usageInRowCount = 0;
        this.h = false;
        this.i = -1;
        this.j = 0.0f;
        this.a = str;
        this.e = type;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i3 = this.g;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.f;
                if (i3 >= arrayRowArr.length) {
                    this.f = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f;
                int i4 = this.g;
                arrayRowArr2[i4] = arrayRow;
                this.g = i4 + 1;
                return;
            } else if (this.f[i2] != arrayRow) {
                i2++;
            } else {
                return;
            }
        }
    }

    public String getName() {
        return this.a;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i2 = this.g;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f[i3] == arrayRow) {
                while (i3 < i2 - 1) {
                    ArrayRow[] arrayRowArr = this.f;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.g--;
                return;
            }
            i3++;
        }
    }

    public void reset() {
        this.a = null;
        this.e = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.b = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.h = false;
        this.i = -1;
        this.j = 0.0f;
        int i2 = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f[i3] = null;
        }
        this.g = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.d, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f2) {
        this.computedValue = f2;
        this.isFinalValue = true;
        this.h = false;
        this.i = -1;
        this.j = 0.0f;
        int i2 = this.g;
        this.b = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f[i3].updateFromFinalVariable(linearSystem, this, false);
        }
        this.g = 0;
    }

    public void setName(String str) {
        this.a = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f2) {
        this.h = true;
        this.i = solverVariable.id;
        this.j = f2;
        int i2 = this.g;
        this.b = -1;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f[i3].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.g = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.e = type;
    }

    public String toString() {
        if (this.a != null) {
            StringBuilder L = a.L("");
            L.append(this.a);
            return L.toString();
        }
        StringBuilder L2 = a.L("");
        L2.append(this.id);
        return L2.toString();
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i2 = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f[i3].updateFromRow(linearSystem, arrayRow, false);
        }
        this.g = 0;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.b = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.c = new float[9];
        this.d = new float[9];
        this.f = new ArrayRow[16];
        this.g = 0;
        this.usageInRowCount = 0;
        this.h = false;
        this.i = -1;
        this.j = 0.0f;
        this.e = type;
    }
}
