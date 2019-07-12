package com.n0texpecterr0r.classdecoder.attribute;

import java.io.DataInputStream;
import java.io.IOException;

public abstract class AttributeInfo {
    protected short attributeNameIndex;
    protected int attributeLength;

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public abstract void read(DataInputStream in) throws IOException;
}
