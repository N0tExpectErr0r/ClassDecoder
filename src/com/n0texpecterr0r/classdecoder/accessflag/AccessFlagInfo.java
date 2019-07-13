package com.n0texpecterr0r.classdecoder.accessflag;

import java.io.DataInputStream;
import java.io.IOException;

public class AccessFlagInfo {
    public static final int TYPE_CLAZZ = 1;
    public static final int TYPE_FIELD = 2;
    public static final int TYPE_METHOD = 3;
    private int type;
    private short accessFlag;

    public AccessFlagInfo(int type) {
        this.type = type;
    }

    public void read(DataInputStream in) throws IOException {
        accessFlag = in.readShort();
    }

    @Override
    public String toString() {
        switch (type) {
            case TYPE_CLAZZ:
                return "\t" + handleClazzAccessFlag();
            case TYPE_FIELD:
                return "\t" + handleFieldAccessFlag();
            case TYPE_METHOD:
                return "\t" + handleMethodAccessFlag();
        }
        return "";
    }

    private String handleClazzAccessFlag() {
        StringBuilder sb = new StringBuilder();
        if (hasFlag(accessFlag, 0x0001)) {
            sb.append("ACC_PUBLIC, ");
        }
        if (hasFlag(accessFlag, 0x0010)) {
            sb.append("ACC_FINAL, ");
        }
        if (hasFlag(accessFlag, 0x0020)) {
            sb.append("ACC_SUPER, ");
        }
        if (hasFlag(accessFlag, 0x0200)) {
            sb.append("ACC_INTERFACE, ");
        }
        if (hasFlag(accessFlag, 0x0400)) {
            sb.append("ACC_ABSTRACT, ");
        }
        if (hasFlag(accessFlag, 0x1000)) {
            sb.append("ACC_SYNTHETIC, ");
        }
        if (hasFlag(accessFlag, 0x2000)) {
            sb.append("ACC_ANNOTATION, ");
        }
        if (hasFlag(accessFlag, 0x4000)) {
            sb.append("ACC_ENUM, ");
        }
        return sb.substring(0, sb.length()-2);
    }

    private String handleFieldAccessFlag() {
        StringBuilder sb = new StringBuilder();
        if (hasFlag(accessFlag, 0x0001)) {
            sb.append("ACC_PUBLIC, ");
        }
        if (hasFlag(accessFlag, 0x0002)) {
            sb.append("ACC_PRIVATE, ");
        }
        if (hasFlag(accessFlag, 0x0004)) {
            sb.append("ACC_PROTECTED, ");
        }
        if (hasFlag(accessFlag, 0x0008)) {
            sb.append("ACC_STATIC, ");
        }
        if (hasFlag(accessFlag, 0x0010)) {
            sb.append("ACC_FINAL, ");
        }
        if (hasFlag(accessFlag, 0x0040)) {
            sb.append("ACC_VOLATILE, ");
        }
        if (hasFlag(accessFlag, 0x0080)) {
            sb.append("ACC_TRANSIENT, ");
        }
        if (hasFlag(accessFlag, 0x1000)) {
            sb.append("ACC_SYNTHETIC, ");
        }
        if (hasFlag(accessFlag, 0x4000)) {
            sb.append("ACC_ENUM, ");
        }
        return sb.substring(0, sb.length()-2);
    }

    private String handleMethodAccessFlag() {
        StringBuilder sb = new StringBuilder();
        if (hasFlag(accessFlag, 0x0001)) {
            sb.append("ACC_PUBLIC, ");
        }
        if (hasFlag(accessFlag, 0x0002)) {
            sb.append("ACC_PRIVATE, ");
        }
        if (hasFlag(accessFlag, 0x0004)) {
            sb.append("ACC_PROTECTED, ");
        }
        if (hasFlag(accessFlag, 0x0008)) {
            sb.append("ACC_STATIC, ");
        }
        if (hasFlag(accessFlag, 0x0010)) {
            sb.append("ACC_FINAL, ");
        }
        if (hasFlag(accessFlag, 0x0020)) {
            sb.append("ACC_SYNCHRONIZED, ");
        }
        if (hasFlag(accessFlag, 0x0040)) {
            sb.append("ACC_BRIDGE, ");
        }
        if (hasFlag(accessFlag, 0x0080)) {
            sb.append("ACC_VARARGS, ");
        }
        if (hasFlag(accessFlag, 0x0100)) {
            sb.append("ACC_NATIVE， ");
        }
        if (hasFlag(accessFlag, 0x0400)) {
            sb.append("ACC_ABSTRACT, ");
        }
        if (hasFlag(accessFlag, 0x0800)) {
            sb.append("ACC_STRICT, ");
        }
        if (hasFlag(accessFlag, 0x1000)) {
            sb.append("ACC_SYNTHETIC, ");
        }
        return sb.substring(0, sb.length()-2);
    }

    private boolean hasFlag(short accessFlag, int flag) {
        return (accessFlag & flag) > 0;
    }
}
