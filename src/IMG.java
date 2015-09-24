
public class IMG {
  String Directory;
  IMG(){
	  Directory="aaaaaa ";
  }
  IMG(String img){
	  Directory = img;
  }
  
  public String BBimg(){
	 // String  BBcodeshow = "<p style=\"text-align: center;\"><img class=\"fr-fin\" alt=\"Image title\" src=\""+Directory+" \"width=\"300\"></p>";
	  String BBcodeshow ="[IMG]"+Directory+"[/IMG]";
	  return BBcodeshow;
  }
  public void show(){
	  System.out.println(BBimg());
  }
}
//<p style="text-align: center;"><img class="fr-fin" alt="Image title" src="http://img.cdn.ved.com.vn/web/lmht360/wp-content/uploads/2015/07/bang-cong-diem-456x400.jpg" width="300"></p>

//<p style="text-align: center;"><br></p>