
public class Link {
String URL;
String Type;
Link(String url,String Type){
	this.URL = url;
	this.Type = Type;
}
Link(){
	this.URL = "";
	this.URL = "";
}
public String BBlink(){
	String BBcodeshow = "[URL]"+URL+"[/URL]";
	return BBcodeshow;
}
public void show(){
	System.out.println("[B]"+Type+"[/B]");
	System.out.println(BBlink());
}

}
