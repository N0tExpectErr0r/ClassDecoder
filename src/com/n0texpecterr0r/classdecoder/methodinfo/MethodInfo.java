package com.n0texpecterr0r.classdecoder.methodinfo;

import com.n0texpecterr0r.classdecoder.AttributeFactory;
import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodInfo {
    private short accessFlag;
    private short nameIndex;
    private short descriptorIndex;
    private short attributeCount;
    private AttributeInfo[] attributes;

    public short getAccessFlag() {
        return accessFlag;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public static MethodInfo read(DataInputStream in) throws IOException {
        MethodInfo method = new MethodInfo();
        method.accessFlag = in.readShort();
        method.nameIndex = in.readShort();
        method.descriptorIndex = in.readShort();
        method.attributeCount = in.readShort();
        method.attributes = new AttributeInfo[method.attributeCount];
        for (int i = 0; i < method.attributeCount; i++) {
            method.attributes[i] = AttributeFactory.readAttribute(in);
        }
        return method;
    }
}
