/**
 * Results.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tutorial.webProvider;

public class Results  implements java.io.Serializable {
    private java.lang.String GUBUN;

    private java.lang.String DATA1;

    private java.lang.String DATA2;

    private java.lang.String DATA3;

    private java.lang.String DATA4;

    private java.lang.String DATA5;

    public Results() {
    }

    public Results(
           java.lang.String GUBUN,
           java.lang.String DATA1,
           java.lang.String DATA2,
           java.lang.String DATA3,
           java.lang.String DATA4,
           java.lang.String DATA5) {
           this.GUBUN = GUBUN;
           this.DATA1 = DATA1;
           this.DATA2 = DATA2;
           this.DATA3 = DATA3;
           this.DATA4 = DATA4;
           this.DATA5 = DATA5;
    }


    /**
     * Gets the GUBUN value for this Results.
     * 
     * @return GUBUN
     */
    public java.lang.String getGUBUN() {
        return GUBUN;
    }


    /**
     * Sets the GUBUN value for this Results.
     * 
     * @param GUBUN
     */
    public void setGUBUN(java.lang.String GUBUN) {
        this.GUBUN = GUBUN;
    }


    /**
     * Gets the DATA1 value for this Results.
     * 
     * @return DATA1
     */
    public java.lang.String getDATA1() {
        return DATA1;
    }


    /**
     * Sets the DATA1 value for this Results.
     * 
     * @param DATA1
     */
    public void setDATA1(java.lang.String DATA1) {
        this.DATA1 = DATA1;
    }


    /**
     * Gets the DATA2 value for this Results.
     * 
     * @return DATA2
     */
    public java.lang.String getDATA2() {
        return DATA2;
    }


    /**
     * Sets the DATA2 value for this Results.
     * 
     * @param DATA2
     */
    public void setDATA2(java.lang.String DATA2) {
        this.DATA2 = DATA2;
    }


    /**
     * Gets the DATA3 value for this Results.
     * 
     * @return DATA3
     */
    public java.lang.String getDATA3() {
        return DATA3;
    }


    /**
     * Sets the DATA3 value for this Results.
     * 
     * @param DATA3
     */
    public void setDATA3(java.lang.String DATA3) {
        this.DATA3 = DATA3;
    }


    /**
     * Gets the DATA4 value for this Results.
     * 
     * @return DATA4
     */
    public java.lang.String getDATA4() {
        return DATA4;
    }


    /**
     * Sets the DATA4 value for this Results.
     * 
     * @param DATA4
     */
    public void setDATA4(java.lang.String DATA4) {
        this.DATA4 = DATA4;
    }


    /**
     * Gets the DATA5 value for this Results.
     * 
     * @return DATA5
     */
    public java.lang.String getDATA5() {
        return DATA5;
    }


    /**
     * Sets the DATA5 value for this Results.
     * 
     * @param DATA5
     */
    public void setDATA5(java.lang.String DATA5) {
        this.DATA5 = DATA5;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Results)) return false;
        Results other = (Results) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GUBUN==null && other.getGUBUN()==null) || 
             (this.GUBUN!=null &&
              this.GUBUN.equals(other.getGUBUN()))) &&
            ((this.DATA1==null && other.getDATA1()==null) || 
             (this.DATA1!=null &&
              this.DATA1.equals(other.getDATA1()))) &&
            ((this.DATA2==null && other.getDATA2()==null) || 
             (this.DATA2!=null &&
              this.DATA2.equals(other.getDATA2()))) &&
            ((this.DATA3==null && other.getDATA3()==null) || 
             (this.DATA3!=null &&
              this.DATA3.equals(other.getDATA3()))) &&
            ((this.DATA4==null && other.getDATA4()==null) || 
             (this.DATA4!=null &&
              this.DATA4.equals(other.getDATA4()))) &&
            ((this.DATA5==null && other.getDATA5()==null) || 
             (this.DATA5!=null &&
              this.DATA5.equals(other.getDATA5())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getGUBUN() != null) {
            _hashCode += getGUBUN().hashCode();
        }
        if (getDATA1() != null) {
            _hashCode += getDATA1().hashCode();
        }
        if (getDATA2() != null) {
            _hashCode += getDATA2().hashCode();
        }
        if (getDATA3() != null) {
            _hashCode += getDATA3().hashCode();
        }
        if (getDATA4() != null) {
            _hashCode += getDATA4().hashCode();
        }
        if (getDATA5() != null) {
            _hashCode += getDATA5().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Results.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://DESKTOP-5QA0ANM/BI_KIS_Monitor.service.webProvider", "results"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GUBUN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GUBUN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATA1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATA2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATA3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATA4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DATA5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
