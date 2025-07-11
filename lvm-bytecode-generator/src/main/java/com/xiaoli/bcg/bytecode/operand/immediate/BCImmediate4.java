package com.xiaoli.bcg.bytecode.operand.immediate;

import com.xiaoli.bcg.bytecode.BCVisitor;

import java.util.Objects;

public final class BCImmediate4 extends BCImmediate {
    public int value;

    public BCImmediate4(int value) {
        this(value, null);
    }

    public BCImmediate4(int value, String comment) {
        super(comment);
        this.value = value;
    }

    @Override
    public Object visit(BCVisitor visitor, Object additional) {
        return visitor.visitImmediate4(this, additional);
    }

    @Override
    public String toString() {
        return value + (comment != null ? "(" + comment + ")" : "");
    }

    @Override
    public byte[] toByteCode() {
        return new byte[]{(byte) value, (byte) (value >> 8), (byte) (value >> 16), (byte) (value >> 24)};
    }

    @Override
    public long getLength() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BCImmediate4 that)) return false;
        return value == that.value && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, comment);
    }
}
