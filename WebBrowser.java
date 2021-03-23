package assign06;

import java.awt.List;
import java.net.URL;
import java.util.NoSuchElementException;

/**
 * webBrowser class for singlyLinkList
 * 
 * @author Junlin Su and Luan Xing.
 * @version March 7, 2021.
 */

public class WebBrowser<URL> {
	//two private instances of Stack
	private LinkedListStack<URL> forward;
	private LinkedListStack<URL> backward;
	
	//current instance
	private URL current_url = null;

	
	/**
	 * This constructor creates a new web browser with no previously-visited
	 * webpages and no webpages to visit next.
	 * 
	 */
	public WebBrowser() {
		current_url = null;
		forward = new LinkedListStack<URL>();
		backward = new LinkedListStack<URL>();

	}

	
	/**
	 * This constructor creates a new web browser with a preloaded history of visited webpages, 
	 * given as a list of URL (Links to an external site.) objects.  
	 * The first webpage in the list is the "current" page visited, 
	 * and the remaining webpages are ordered from most recently visited to least recently visited.
	 * 
	 * @param history
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		forward = new LinkedListStack<URL>();
		backward = new LinkedListStack<URL>();
		LinkedListStack<URL> stack = new LinkedListStack<URL>();
		for (URL page: history) {
			stack.push(page);
		}
		while (stack.size() > 0) {
			backward.push(stack.pop());

		}
		current_url = backward.pop();

	}
	
	
	/**
	 * This method simulates visiting a webpage, given as a URL.  
	 * Note that calling this method should clear the forward stack, 
	 * since there is no URL to visit next.
	 * 
	 * @param webpage
	 */
	

	public void visit(URL webpage) {
		if (current_url != null) {
			// Push into backward
			backward.push(current_url);
		}

		forward.clear();
		// Set curr_url to WEBPAGE
		current_url = webpage;
	}

	
/**
 * 
 * This method simulates using the back button, 
 * returning the URL visited.  
 * NoSuchElementException (Links to an external site.) 
 * is thrown if there is no previously-visited URL.
 * 
 * @return backward.pop()
 * @throws NoSuchElementException
 */
	public URL back() throws NoSuchElementException {
		if (backward == null || current_url == backward.peek()) {
			throw new NoSuchElementException();
		}
		// push current_url to the forward stack
		forward.push(current_url);
		// set current_url to top
		current_url = backward.peek();
		
		//return
		return backward.pop();

	}

	
	/**
	 * This method simulates using the forward button, returning the URL visited. 
	 * NoSuchElementException is thrown if there is no URL to visit next.
	 * 
	 * @return forward.pop()
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException {
		if (forward == null || current_url == forward.pop()) {
			throw new NoSuchElementException();
		}
		// push current to the back stack
		backward.push(current_url);
		// set current to top
		current_url = forward.peek();
		
		
		//return

		return forward.pop();
	}

	
	
/**
 * This method generates a history of URLs visited, 
 * as a list of URL objects ordered from most recently visited to least recently visited (including the "current" page visited), 
 * without altering subsequent behavior of this web browser. "Forward" links are not included. 
 * The behavior of the method must be O(N), where N is the number of URLs.
 * 
 * @return
 */
	public SinglyLinkedList<URL> history() {
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();
		LinkedListStack<URL> newStack = new LinkedListStack<URL>();
		int i = backward.size();
		
		//set int value
		int j = i;
		
		// create while loop
		while (j > 0) {
			newStack.push(backward.pop());
			j--;
		}

		//set int value
		int k = 0;
		
		// creat while loop
		while (k < i) {
			URL website = newStack.pop();
			history.insertFirst(website);
			
			backward.push(website);
			k++;
		}
		history.insertFirst(current_url);

		return history;

	}

}
