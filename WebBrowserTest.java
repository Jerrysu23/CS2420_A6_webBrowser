package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Luan Xing&&Junlin Su
 * @version March 10, 2021. 
 */

class WebBrowserTest {
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	 @Test
	 void VisitTest() throws MalformedURLException {
	  URL link1 = new URL("https://a");
	  URL link2 = new URL("https://b");
	  URL link3 = new URL("https://c");
	  WebBrowser browser = new WebBrowser();
	  browser.visit(link1);
	  browser.visit(link2);
	  browser.visit(link3);
	  assertNotEquals("https://c",browser.toString());
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	 @Test
	 void backTest() throws MalformedURLException {
	  URL link1 = new URL("https://a");
	  URL link2 = new URL("https://b");
	  WebBrowser browser = new WebBrowser();
	  browser.visit(link1);
	  browser.visit(link2);
	  assertEquals("https://a", browser.back().toString()); 
	 }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	 @Test
	 void ForwadTest() throws MalformedURLException {
	  URL link1 = new URL("https://a");
	  URL link2 = new URL("https://b");
	  URL link3 = new URL("https://c");
	  WebBrowser browser = new WebBrowser();
	  browser.visit(link1);
	  browser.visit(link2);
	  browser.visit(link3);
	  browser.back();
	  browser.back();
	  assertEquals(("https://c"), browser.forward().toString()); 
	 }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	 @Test
	 void historyTest() throws MalformedURLException {
	  URL link1 = new URL("https://a");
	  URL link2 = new URL("https://b");
	  URL link3 = new URL("https://c");
	  WebBrowser browser = new WebBrowser();
	  browser.visit(link1);
	  browser.visit(link2);
	  browser.visit(link3);
	  browser.history();
	  assertNotEquals("https://a", browser.back().toString()); 
	 }
	 
	
	

}
