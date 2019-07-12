package com.n0texpecterr0r.classdecoder;

import com.n0texpecterr0r.classdecoder.constantpool.*;

import java.io.DataInputStream;
import java.io.IOException;

public class CpFactory {
    private static final byte TAG_CLASS = 7;
    private static final byte TAG_FILEDREF = 9;
    private static final byte TAG_METHODREF = 10;
    private static final byte TAG_INTERFACE_METHODREF = 11;
    private static final byte TAG_STRING = 8;
    private static final byte TAG_INTEGER = 3;
    private static final byte TAG_FLOAT = 4;
    private static final byte TAG_LONG = 5;
    private static final byte TAG_DOUBLE = 6;
    private static final byte TAG_NAME_AND_TYPE = 12;
    private static final byte TAG_UTF8 = 1;
    private static final byte TAG_METHOD_HANDLE = 15;
    private static final byte TAG_METHOD_TYPE = 16;
    private static final byte TAG_INVOKE_DYNAMIC = 18;

    public static CpInfo readCpInfo(DataInputStream in) throws IOException {
        byte tag = in.readByte();
        CpInfo result = null;
        switch (tag) {
            case TAG_CLASS:
                result = new ClazzInfo();
                break;
            case TAG_UTF8:
                result = new Utf8Info();
                break;
            case TAG_FILEDREF:
                result = new FieldRefInfo();
                break;
            case TAG_STRING:
                result = new StringInfo();
                break;
            case TAG_METHOD_TYPE:
                result = new MethodTypeInfo();
                break;
            case TAG_METHODREF:
                result = new MethodRefInfo();
                break;
            case TAG_NAME_AND_TYPE:
                result = new NameAndTypeInfo();
                break;
            case TAG_INTERFACE_METHODREF:
                result = new InterfaceMethodRefInfo();
                break;
            case TAG_LONG:
                result = new LongInfo();
                break;
            case TAG_INTEGER:
                result = new IntegerInfo();
                break;
            case TAG_DOUBLE:
                result = new DoubleInfo();
                break;
            case TAG_FLOAT:
                result = new FloatInfo();
                break;
        }
        if (result != null) {
            result.read(in);
            result.setTag(tag);
        }
        return result;
    }
}
