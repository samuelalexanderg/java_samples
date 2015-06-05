package os.browsermob;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.ProxyServer;

public class ProxySample {
	public static void main(String[] args) {
		ProxyServer server = new ProxyServer(4444);
		server.seleniumProxy()
		BrowserMobProxy proxy = new BrowserMobProxyServer(7070);
	    System.out.println(proxy.getPort());
	    proxy.start(7070);
	    System.out.println("Che");
	}
}
