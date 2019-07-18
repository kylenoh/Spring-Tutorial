/**
 * BI_KIS_MonitorServiceWebProvider.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tutorial.webProvider;

public interface BI_KIS_MonitorServiceWebProvider extends javax.xml.rpc.Service {
    public java.lang.String getBI_KIS_Monitor_service_webProvider_PortAddress();

    public tutorial.webProvider.WebProvider_PortType getBI_KIS_Monitor_service_webProvider_Port() throws javax.xml.rpc.ServiceException;

    public tutorial.webProvider.WebProvider_PortType getBI_KIS_Monitor_service_webProvider_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
