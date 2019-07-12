package com.n0texpecterr0r.classdecoder.fieldinfo;

import com.n0texpecterr0r.classdecoder.AttributeFactory;
import com.n0texpecterr0r.classdecoder.attribute.AttributeInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldInfo {
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

    public static FieldInfo read(DataInputStream in) throws IOException {
        FieldInfo field = new FieldInfo();
        field.accessFlag = in.readShort();
        field.nameIndex = in.readShort();
        field.descriptorIndex = in.readShort();
        field.attributeCount = in.readShort();
        field.attributes = new AttributeInfo[field.attributeCount];
        for (int i = 0; i < field.attributeCount; i++) {
            field.attributes[i] = AttributeFactory.readAttribute(in);
        }
        return field;
    }
}
