/**
 * WebProvider_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tutorial.webProvider;

public interface WebProvider_PortType extends java.rmi.Remote {
    public void responseService(java.lang.String aa, java.lang.String bb, java.lang.String cc, javax.xml.rpc.holders.StringHolder message, tutorial.webProvider.holders.ResultsArrayHolder results) throws java.rmi.RemoteException;
}
