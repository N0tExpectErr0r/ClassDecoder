package com.n0texpecterr0r.classdecoder.attribute;

import com.n0texpecterr0r.classdecoder.AttributeFactory;
import com.n0texpecterr0r.classdecoder.constantpool.CpInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class CodeAttribute extends AttributeInfo {
    private short maxStack;
    private short maxLocals;
    private int codeLength;
    private byte[] code;
    private short exceptionTableLength;
    private ExceptionInfo[] exceptionTable;
    private short attributeCount;
    private AttributeInfo[] attributeInfos;

    @Override
    public void read(DataInputStream in) throws IOException {
        maxStack = in.readShort();
        maxLocals = in.readShort();
        codeLength = in.readInt();
        code = new byte[codeLength];
        int len = in.read(code, 0, codeLength);
        if (len != codeLength) {
            throw new IOException("read Code failed");
        }

        exceptionTableLength = in.readShort();
        exceptionTable = new ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTable[i] = ExceptionInfo.read(in);
        }

        attributeCount = in.readShort();
        attributeInfos = new AttributeInfo[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
            attributeInfos[i] = AttributeFactory.readAttribute(in);
        }
    }
}
