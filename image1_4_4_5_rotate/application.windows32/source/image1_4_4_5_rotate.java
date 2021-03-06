import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class image1_4_4_5_rotate extends PApplet {

penrose penrose; // define objects

public void setup(){
  
  penrose = new penrose(135, 25, width/2, height/2, 0xffCCCCCC,PI/240); // generate object
  frameRate(60);
  delay(2000);
}

public void draw(){
  background(255);
  //penrose.move();
  //penrose.display();
  penrose.rot_display();
}
class penrose{
  // 属性
  float line_length, line_width; // 線の長さと幅
  //mathmatic constants
  float root_3 = sqrt(3);
  //out points
  float Cx, Cy;
  float LTx,LTy;
  float RTx,RTy;
  float LBx,LBy;
  float RBx,RBy;
  // coordinations
  float[][][] C = new float[3][4][2];
  // basic statics
  float half_width;
  float dia_long;
  // color
  int fillcolor;
  // rotate
  float rot;
  float vrot;
  
  // コンストラクタを定義
  penrose(float _line_length, float _line_width, float _Cx, float _Cy, int _fillcolor, float _vrot){
    // input of parameters of line
    line_length = _line_length;
    line_width = _line_width;
    // input of params on coordination of four v
    Cx = _Cx; Cy = _Cy;
    
    fillcolor = _fillcolor;
    
    rot = 0;
    vrot = _vrot;
  }
  
  // define a method for motion
  public void move(){
    Cx += 1;
    if(Cx > width) Cx = - (line_length + line_width/2);
  }
  
  // 表示するメソッドの定義
  public void display(){
    // basic vals
    half_width = line_width / 2;
    dia_long   = (line_width / 2) * root_3;
    //calculate
    LTx = Cx - (line_length + line_width)/2;
    LTy = Cy - ((line_length / 2)*root_3 + dia_long * 2) *2/3 + dia_long;
    RTx = LTx + line_length + line_width;  RTy = LTy;
    LBx = LTx;  LBy = LTy+(line_length / 2)*root_3 + dia_long;
    RBx = RTx;  RBy = LBy;
    float ABx = (LTx + RTx)/2;
    C[0][0][0] = ABx - half_width;
    C[0][1][0] = ABx + half_width;
    C[0][0][1] = LTy;  C[0][1][1] = LTy;
    C[0][2][0] = C[0][1][0];
    C[0][2][1] = LTy + dia_long * 2;
    C[0][3][0] = ABx;
    C[0][3][1] = C[0][2][1] + dia_long;
    //calculate left points
    C[1][0][0] = LBx;
    C[1][0][1] = LBy - dia_long;
    C[1][1][0] = LBx + half_width;
    C[1][1][1] = LBy;
    C[1][2][0] = LBx + line_width * 1.5f;
    C[1][2][1] = C[1][0][1] - dia_long;
    C[1][3][0] = C[1][2][0] + line_width;
    C[1][3][1] = C[1][2][1];
    //calculate right points
    C[2][0][0] = RBx - half_width;
    C[2][0][1] = RBy;
    C[2][1][0] = RBx;
    C[2][1][1] = RBy - dia_long;
    C[2][2][0] = RBx - line_width*2;
    C[2][2][1] = C[2][1][1];
    C[2][3][0] = C[2][2][0] - half_width;
    C[2][3][1] = C[2][2][1] - dia_long;
    
    
    fill(fillcolor);
    stroke(0xff000000);
    
    //point(LTx, LTy);
    //point(RTx, RTy);
    //point(LBx, LBy);
    //point(RBx, RBy);
    
    beginShape();
    vertex(C[0][1][0],C[0][1][1]);vertex(C[0][0][0],C[0][0][1]);vertex(C[1][0][0],C[1][0][1]);vertex(C[2][2][0],C[2][2][1]);vertex(C[2][3][0],C[2][3][1]);vertex(C[1][2][0],C[1][2][1]);
    endShape(CLOSE);
    beginShape();
    vertex(C[1][0][0],C[1][0][1]);vertex(C[1][1][0],C[1][1][1]);vertex(C[2][0][0],C[2][0][1]);vertex(C[0][2][0],C[0][2][1]);vertex(C[0][3][0],C[0][3][1]);vertex(C[2][2][0],C[2][2][1]);
    endShape(CLOSE);
    beginShape();
    vertex(C[2][0][0],C[2][0][1]);vertex(C[2][1][0],C[2][1][1]);vertex(C[0][1][0],C[0][1][1]);vertex(C[1][2][0],C[1][2][1]);vertex(C[1][3][0],C[1][3][1]);vertex(C[0][2][0],C[0][2][1]);
    endShape(CLOSE);
  }
  
  // rotate
  public void rot_display(){    
    translate(Cx,Cy);
    rotate(rot);
    // basic vals
    half_width = line_width / 2;
    dia_long   = (line_width / 2) * root_3;
    //calculate
    LTx = - (line_length + line_width)/2;
    LTy = - ((line_length / 2)*root_3 + dia_long * 2) *2/3 + dia_long;
    RTx = LTx + line_length + line_width;  RTy = LTy;
    LBx = LTx;  LBy = LTy+(line_length / 2)*root_3 + dia_long;
    RBx = RTx;  RBy = LBy;
    float ABx = (LTx + RTx)/2;
    C[0][0][0] = ABx - half_width;
    C[0][1][0] = ABx + half_width;
    C[0][0][1] = LTy;  C[0][1][1] = LTy;
    C[0][2][0] = C[0][1][0];
    C[0][2][1] = LTy + dia_long * 2;
    C[0][3][0] = ABx;
    C[0][3][1] = C[0][2][1] + dia_long;
    //calculate left points
    C[1][0][0] = LBx;
    C[1][0][1] = LBy - dia_long;
    C[1][1][0] = LBx + half_width;
    C[1][1][1] = LBy;
    C[1][2][0] = LBx + line_width * 1.5f;
    C[1][2][1] = C[1][0][1] - dia_long;
    C[1][3][0] = C[1][2][0] + line_width;
    C[1][3][1] = C[1][2][1];
    //calculate right points
    C[2][0][0] = RBx - half_width;
    C[2][0][1] = RBy;
    C[2][1][0] = RBx;
    C[2][1][1] = RBy - dia_long;
    C[2][2][0] = RBx - line_width*2;
    C[2][2][1] = C[2][1][1];
    C[2][3][0] = C[2][2][0] - half_width;
    C[2][3][1] = C[2][2][1] - dia_long;
    
    
    fill(fillcolor);
    stroke(0xff000000);
    
    //point(LTx, LTy);
    //point(RTx, RTy);
    //point(LBx, LBy);
    //point(RBx, RBy);
    
    beginShape();
    vertex(C[0][1][0],C[0][1][1]);vertex(C[0][0][0],C[0][0][1]);vertex(C[1][0][0],C[1][0][1]);vertex(C[2][2][0],C[2][2][1]);vertex(C[2][3][0],C[2][3][1]);vertex(C[1][2][0],C[1][2][1]);
    endShape(CLOSE);
    beginShape();
    vertex(C[1][0][0],C[1][0][1]);vertex(C[1][1][0],C[1][1][1]);vertex(C[2][0][0],C[2][0][1]);vertex(C[0][2][0],C[0][2][1]);vertex(C[0][3][0],C[0][3][1]);vertex(C[2][2][0],C[2][2][1]);
    endShape(CLOSE);
    beginShape();
    vertex(C[2][0][0],C[2][0][1]);vertex(C[2][1][0],C[2][1][1]);vertex(C[0][1][0],C[0][1][1]);vertex(C[1][2][0],C[1][2][1]);vertex(C[1][3][0],C[1][3][1]);vertex(C[0][2][0],C[0][2][1]);
    endShape(CLOSE);
    
    //ellipse(0,0,200,200);
    //point(0, 0);
    
    // rotate
    rot += vrot;
  }
}
  public void settings() {  size(200, 200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "image1_4_4_5_rotate" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
