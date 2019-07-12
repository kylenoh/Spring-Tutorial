/**
 * July10WebServiceWebProviderLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tutorial.webProvider;

public class July10WebServiceWebProviderLocator extends org.apache.axis.client.Service implements tutorial.webProvider.July10WebServiceWebProvider {

    public July10WebServiceWebProviderLocator() {
    }


    public July10WebServiceWebProviderLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public July10WebServiceWebProviderLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for July10_webService_webProvider_Port
    private java.lang.String July10_webService_webProvider_Port_address = "http://192.168.31.80:5555/ws/July10.webService:webProvider/July10_webService_webProvider_Port";

    public java.lang.String getJuly10_webService_webProvider_PortAddress() {
        return July10_webService_webProvider_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String July10_webService_webProvider_PortWSDDServiceName = "July10_webService_webProvider_Port";

    public java.lang.String getJuly10_webService_webProvider_PortWSDDServiceName() {
        return July10_webService_webProvider_PortWSDDServiceName;
    }

    public void setJuly10_webService_webProvider_PortWSDDServiceName(java.lang.String name) {
        July10_webService_webProvider_PortWSDDServiceName = name;
    }

    public tutorial.webProvider.WebProvider_PortType getJuly10_webService_webProvider_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(July10_webService_webProvider_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJuly10_webService_webProvider_Port(endpoint);
    }

    public tutorial.webProvider.WebProvider_PortType getJuly10_webService_webProvider_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tutorial.webProvider.July10_webService_webProvider_BinderStub _stub = new tutorial.webProvider.July10_webService_webProvider_BinderStub(portAddress, this);
            _stub.setPortName(getJuly10_webService_webProvider_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJuly10_webService_webProvider_PortEndpointAddress(java.lang.String address) {
        July10_webService_webProvider_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tutorial.webProvider.WebProvider_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                tutorial.webProvider.July10_webService_webProvider_BinderStub _stub = new tutorial.webProvider.July10_webService_webProvider_BinderStub(new java.net.URL(July10_webService_webProvider_Port_address), this);
                _stub.setPortName(getJuly10_webService_webProvider_PortWSDDServiceName());
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
        if ("July10_webService_webProvider_Port".equals(inputPortName)) {
            return getJuly10_webService_webProvider_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DESKTOP-PJOU391/July10.webService/webProvider", "July10.webService.webProvider");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DESKTOP-PJOU391/July10.webService/webProvider", "July10_webService_webProvider_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("July10_webService_webProvider_Port".equals(portName)) {
            setJuly10_webService_webProvider_PortEndpointAddress(address);
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
