import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.annotation.PostConstruct;


public class Demo {
	Link[] s = new Link[5];
	public void dc(){
		Scanner input = new Scanner(System.in);
		System.out.println("I am batman");
		for(int i=0;i<5;i++)
			s[i].URL = input.nextLine();
		
		System.out.println("Complete");
	}
	
	
public static void main(String[] args) throws IOException{
	PostGenerator pg = new PostGenerator(new URL("http://store.steampowered.com/app/370160/"),3,3);
	
	pg.GETFILE();
	//pg.GETtitle();
	//pg.ShowTitle();
	//pg.GETHeader_img();
	//pg.Header_img.show();
	//pg.INPUTlink();
	//System.out.println(pg.link[0].URL);
	//pg.GETimg();
    //System.out.println(pg.img[0].Directory);
	pg.GETtitle();
	pg.ShowTitle();
    pg.GETHeader_img();
	pg.Header_img.show();
	System.out.println("[HIDE]");

	pg.GETimg();
//	System.out.println("<p style=\"text-align: center;\"><br></p>");
	System.out.println("MINIMUM");
	pg.SHOWMINIUM();

	System.out.println("[IMG]http://img845.imageshack.us/img845/1405/downgx.png[/IMG]");
	System.out.println("[url][/url][/CENTER][/HIDE]" );

	
}
}
