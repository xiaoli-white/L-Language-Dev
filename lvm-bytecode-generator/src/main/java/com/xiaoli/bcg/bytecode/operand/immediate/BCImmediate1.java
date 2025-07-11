package com.xiaoli.bcg.bytecode.operand.immediate;

import com.xiaoli.bcg.bytecode.BCVisitor;

import java.util.Objects;

public final class BCImmediate1 extends BCImmediate {
    public byte value;

    public BCImmediate1(byte value) {
        this(value, null);
    }

    public BCImmediate1(byte value, String comment) {
        super(comment);
        this.value = value;
    }

    @Override
    public Object visit(BCVisitor visitor, Object additional) {
        return visitor.visitImmediate1(this, additional);
    }

    @Override
    public String toString() {
        return value + (comment != null ? "(" + comment + ")" : "");
    }

    @Override
    public byte[] toByteCode() {
        return new byte[]{value};
    }

    @Override
    public long getLength() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BCImmediate1 that)) return false;
        return value == that.value && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, comment);
    }
}
