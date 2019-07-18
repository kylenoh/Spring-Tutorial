package tutorial.webProvider;

public class WebProvider_PortTypeProxy implements tutorial.webProvider.WebProvider_PortType {
  private String _endpoint = null;
  private tutorial.webProvider.WebProvider_PortType webProvider_PortType = null;
  
  public WebProvider_PortTypeProxy() {
    _initWebProvider_PortTypeProxy();
  }
  
  public WebProvider_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebProvider_PortTypeProxy();
  }
  
  private void _initWebProvider_PortTypeProxy() {
    try {
      webProvider_PortType = (new tutorial.webProvider.BI_KIS_MonitorServiceWebProviderLocator()).getBI_KIS_Monitor_service_webProvider_Port();
      if (webProvider_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webProvider_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webProvider_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webProvider_PortType != null)
      ((javax.xml.rpc.Stub)webProvider_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tutorial.webProvider.WebProvider_PortType getWebProvider_PortType() {
    if (webProvider_PortType == null)
      _initWebProvider_PortTypeProxy();
    return webProvider_PortType;
  }
  
  public void requestMonitor(tutorial.webProvider.holders.ResultsArrayHolder results, javax.xml.rpc.holders.StringHolder msg) throws java.rmi.RemoteException{
    if (webProvider_PortType == null)
      _initWebProvider_PortTypeProxy();
    webProvider_PortType.requestMonitor(results, msg);
  }
  
  
}