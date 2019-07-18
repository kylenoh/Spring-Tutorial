/**
 * BI_KIS_MonitorServiceWebProviderLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tutorial.webProvider;

public class BI_KIS_MonitorServiceWebProviderLocator extends org.apache.axis.client.Service implements tutorial.webProvider.BI_KIS_MonitorServiceWebProvider {

    public BI_KIS_MonitorServiceWebProviderLocator() {
    }


    public BI_KIS_MonitorServiceWebProviderLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BI_KIS_MonitorServiceWebProviderLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BI_KIS_Monitor_service_webProvider_Port
    private java.lang.String BI_KIS_Monitor_service_webProvider_Port_address = "http://192.168.31.81:5555/ws/BI_KIS_Monitor.service:webProvider/BI_KIS_Monitor_service_webProvider_Port";

    public java.lang.String getBI_KIS_Monitor_service_webProvider_PortAddress() {
        return BI_KIS_Monitor_service_webProvider_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BI_KIS_Monitor_service_webProvider_PortWSDDServiceName = "BI_KIS_Monitor_service_webProvider_Port";

    public java.lang.String getBI_KIS_Monitor_service_webProvider_PortWSDDServiceName() {
        return BI_KIS_Monitor_service_webProvider_PortWSDDServiceName;
    }

    public void setBI_KIS_Monitor_service_webProvider_PortWSDDServiceName(java.lang.String name) {
        BI_KIS_Monitor_service_webProvider_PortWSDDServiceName = name;
    }

    public tutorial.webProvider.WebProvider_PortType getBI_KIS_Monitor_service_webProvider_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BI_KIS_Monitor_service_webProvider_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBI_KIS_Monitor_service_webProvider_Port(endpoint);
    }

    public tutorial.webProvider.WebProvider_PortType getBI_KIS_Monitor_service_webProvider_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tutorial.webProvider.BI_KIS_Monitor_service_webProvider_BinderStub _stub = new tutorial.webProvider.BI_KIS_Monitor_service_webProvider_BinderStub(portAddress, this);
            _stub.setPortName(getBI_KIS_Monitor_service_webProvider_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBI_KIS_Monitor_service_webProvider_PortEndpointAddress(java.lang.String address) {
        BI_KIS_Monitor_service_webProvider_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tutorial.webProvider.WebProvider_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                tutorial.webProvider.BI_KIS_Monitor_service_webProvider_BinderStub _stub = new tutorial.webProvider.BI_KIS_Monitor_service_webProvider_BinderStub(new java.net.URL(BI_KIS_Monitor_service_webProvider_Port_address), this);
                _stub.setPortName(getBI_KIS_Monitor_service_webProvider_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BI_KIS_Monitor_service_webProvider_Port".equals(inputPortName)) {
            return getBI_KIS_Monitor_service_webProvider_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DESKTOP-5QA0ANM/BI_KIS_Monitor.service.webProvider", "BI_KIS_Monitor.service.webProvider");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DESKTOP-5QA0ANM/BI_KIS_Monitor.service.webProvider", "BI_KIS_Monitor_service_webProvider_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BI_KIS_Monitor_service_webProvider_Port".equals(portName)) {
            setBI_KIS_Monitor_service_webProvider_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
