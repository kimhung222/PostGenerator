import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Scanner;


public class PostGenerator {
	String title;
	IMG Header_img;
	int img_num  = 3;
    int link_num = 3;
    IMG[] img = new IMG[img_num];
    Link[] link = new Link[link_num];
    URL url;
    File HTMLfile;
    PostGenerator(URL url,int img_num,int link_num){
    	this.url = url;
    	this.img_num = img_num;
    	this.link_num = link_num;
    	this.HTMLfile = new File("temp.html");
    	//Link[] link = new Link[link_num];
        IMG[] img = new IMG[img_num];
    	
    }
	public static String STANDARDLIZE(String s){
		while(s.charAt(0)==' '){
			s = s.substring(1);
		}
		return s;
		
	}
    public static String EXTRACT(String source,String core){
    	String[] replacements ={"<li>","</li>","<br>","<ul class=\"bb_ul\">","<strong>","</br>","</strong>","</ul>","Supported"};
    	source = source.replace(core,"");
    	for(String replacement : replacements){
    		source= source.replace(replacement, "");
    	}
    	return STANDARDLIZE(source);
    }

    
    public void GETFILE() throws IOException{
    	String Currentline;
    	URLConnection conn = url.openConnection();
    	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	FileWriter fw = new FileWriter(HTMLfile.getAbsoluteFile());
    	BufferedWriter bw = new BufferedWriter(fw);
    	while((Currentline=br.readLine())!=null){
    		bw.write(Currentline);
    		bw.write("\n");
    	}
    	bw.close();
    	br.close();
    	fw.close();	
    }
    public String GETtitle() throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(this.HTMLfile));
    	String Currentline;
    	while((Currentline=br.readLine())!=null){
    		if(Currentline.contains("<title>")){
    				title =Currentline.substring(7,Currentline.length()-16);
    				break;
    		}
    	}
    	return title;
    }
    public void ShowTitle(){

    	System.out.println("[CENTER][CENTER][FONT=Book Antiqua][SIZE=4][B] ."+title+"[/B][/SIZE][/FONT][/CENTER]");
    }
    public IMG GETHeader_img() throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(this.HTMLfile));
    	String Currentline;
    	while((Currentline=br.readLine())!=null){
    		if(Currentline.contains("header.jpg")){
       	Header_img = new IMG((String) Currentline.subSequence(49, Currentline.length()-3));
    		}
    	}
    	br.close();
    	return Header_img;
    }
    // Check later
    public Link[] INPUTlink(){
    	Scanner input = new Scanner(System.in);
    	//Link[] link = new Link[link_num];
    	System.out.println("Link plz :");
    	for(int i=0;i<link_num;i++){
    		Link temp = new Link();
    		temp.URL = input.nextLine();
    		link[i] = temp;
    		if(link[i].URL.contains("4share")){
    			link[i].Type = "4SHAREVN";
    		}
    		if(link[i].URL.contains("fshare")){
    			link[i].Type = "FSHARE";
    		}
    		else{
    			System.out.println("Vui lòng nhập loại Link của link thứ "+i);
    			link[i].Type = input.nextLine();
    		}
    	}
    	return link;
    }
    public IMG[] GETimg() throws IOException{
    	//IMG[] img = new IMG[img_num];
    	String STANDARD = "http://cdn.akamai.steamstatic.com/steam/apps/" + url.toString().substring(34);
    	int count = 0;
    	BufferedReader br = new BufferedReader(new FileReader(this.HTMLfile));
    	String Currentline;
    	while((Currentline = br.readLine())!=null && count < 3){
    		IMG tem = new IMG();
    		if(Currentline.contains("highlight_strip_item highlight_strip_screenshot") ){
    			Currentline =(String) Currentline.substring(103,Currentline.length()-3);
    			tem.Directory = STANDARD + Currentline;
    			//img[count] = new IMG();
    			//img[count] = tem;
    			img[count] = tem;
    			//System.out.println("<p style=\"text-align: center;\"><img class=\"fr-fin\" alt=\"Image title\" src=\""+img[count].Directory+"\" width=\"300\"></p>");
    			System.out.println("[IMG]"+img[count].Directory+"[/IMG]");
    			count++;
    		}
    		
    	}
    	br.close();
    	
    	
    	return img;
    }
    public void SHOWMINIUM() throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(this.HTMLfile));
    	String Currentline;
    	while((Currentline=br.readLine())!= null){
    	//	String[] Syss ={"OS:","Processor:","Memory:","Graphics:","Hard Drive:"};
    		
    		
    		//String[] s =new String[4];
    		
    		if(Currentline.contains("OS:")){
    			System.out.println("OS: "+EXTRACT(Currentline,"OS:"));
    			//System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"OS:"+EXTRACT(Currentline,"OS:")+"</span></strong></p>");
    		
    		}
    		
    		if(Currentline.contains("Processor:")){
    			System.out.println("CPU: "+EXTRACT(Currentline,"Processor:"));
    			//System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"Processor:"+EXTRACT(Currentline,"Processor:")+"</span></strong></p>");
    		}
    		
    		if(Currentline.contains("Memory:")){
    			System.out.println("RAM: "+EXTRACT(Currentline,"Memory:"));
    			//System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"Memory: "+EXTRACT(Currentline,"Memory:")+"</span></strong></p>");
    		}
    		
    		if(Currentline.contains("Graphics:")){
    			System.out.println("Graphics: "+EXTRACT(Currentline,"Graphics:"));
    			//System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"GPU: "+EXTRACT(Currentline,"Graphics:")+"</span></strong></p>");
    		}
    		if(Currentline.contains("Hard Drive:") || Currentline.contains("Hard Disk Space:")){
    			System.out.println("HDD: "+EXTRACT(Currentline,"Hard Drive:"));
    			//System.out.println("<p style=\"text-align: center;\"><strong><span style=\"font-size: 20px;\">"+"HDD: "+EXTRACT(Currentline,"Hard Drive:")+"</span></strong></p>");
    			break;
    		}
    		
    	}
    	br.close();

    }
    
    
}
