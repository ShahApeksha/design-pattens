interface MediaPlayer{
 public void play(String type, String fileName);
}
class MediaAdapter implements MediaPlayer{
 AdvancedMediaPlayer adaptee = new AdvancedMediaPlayer();
 public void play(String type, String fileName){
 if(type.equalsIgnoreCase("mp3"))
 adaptee.playMp3(fileName);
 else if(type.equalsIgnoreCase("mp4"))
 adaptee.playMp4(fileName);
 else if(type.equalsIgnoreCase("avi"))
 adaptee.playAvi(fileName);
 else if(type.equalsIgnoreCase("vlc"))
 adaptee.playvlc(fileName);
 else 
 System.out.println("File format not supported!! of type " + type);
 }
}
class AdvancedMediaPlayer{
 public void playMp3(String fileName){
 System.out.println("Playing mp3 file " + fileName);
 }
 public void playMp4(String fileName){
 System.out.println("Playing mp4 file " + fileName);
 }
 public void playAvi(String fileName){
 System.out.println("Playing avi file " + fileName);
 }
 public void playvlc(String fileName){
 System.out.println("Playing vlc file " + fileName);
 }
}
class BasicMediaPlayer implements MediaPlayer{
 MediaAdapter md = new MediaAdapter();
 public void play(String type, String fileName){
 md.play(type, fileName);
 }
}
//Client
class AdapterPatternDemo{
 public static void main(String[] args){
 MediaPlayer mp = new BasicMediaPlayer();
 mp.play("vlc", "music1.vlc");
 mp.play("mp3", "music2.mp3");
 }
}
