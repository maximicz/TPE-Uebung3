
public class Binaerknoten {

		  private Object inhalt; 

		  private Binaerknoten linkesKind; 
		  private Binaerknoten rechtesKind; 

		  public Binaerknoten(Object inhalt) {
		    this.inhalt = inhalt; 
		  }

		  public Object inhalt() {
		    return inhalt; 
		  }

		  public Binaerknoten linkesKind() {
		    return linkesKind; 
		  }

		  public Binaerknoten rechtesKind() {
		    return rechtesKind; 
		  }

		  public void inhaltAendern(Object inhalt) {
		    this.inhalt = inhalt; 
		  }

		  public void linkesKindAendern(Binaerknoten knoten) {
		    linkesKind = knoten; 
		  }

		  public void rechtesKindAendern(Binaerknoten knoten) {
		    rechtesKind = knoten; 
		  }

		  public String toString() {
		    return inhalt.toString(); 
		  }

}
