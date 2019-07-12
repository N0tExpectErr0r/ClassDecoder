package attribute;

import constantpool.CpInfo;

import java.io.DataInputStream;

public abstract class AttributeInfo {
    private short attributeNameIndex;
    private int attributeLength;

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public String getAttributeName(CpInfo[] constantPool) {
        return "";
    }

    public abstract void read(DataInputStream in);
}
