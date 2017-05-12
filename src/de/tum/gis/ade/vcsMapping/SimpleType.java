package de.tum.gis.ade.vcsMapping;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name="simpleType")
public enum SimpleType {

    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("integer")
    INTEGER("integer"),
    @XmlEnumValue("double")
    DOUBLE("double"),
    @XmlEnumValue("boolean")
    BOOLEAN("boolean"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("timestamp")
    TIMESTAMP("timestamp");
    
    private final String value;

    SimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SimpleType fromValue(String v) {
        for (SimpleType c: SimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
