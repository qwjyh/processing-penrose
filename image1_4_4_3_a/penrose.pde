class penrose{
  // 属性
  float line_length, line_width; // 線の長さと幅
  //mathmatic constants
  float root_3 = sqrt(3);
  //out points
  float LTx,LTy;
  float RTx,RTy;
  float LBx,LBy;
  float RBx,RBy;
  //top points
  float Ax,Ay,Bx,By,Cx,Cy,Dx,Dy;
  //left points
  float Ex,Ey,Fx,Fy,Gx,Gy,Hx,Hy;
  //right points
  float Ix,Iy,Jx,Jy,Kx,Ky,Lx,Ly;
  // basic statics
  float half_width;
  float dia_long;
  // color
  color fillcolor;
  
  // コンストラクタを定義
  penrose(float _line_length, float _line_width, float _LTx, float _LTy, color _fillcolor){
    // input of parameters of line
    line_length = _line_length;
    line_width = _line_width;
    // input of params on coordination of four v
    LTx = _LTx; LTy = _LTy;
    RTx = LTy + line_length;  RTy = LTx;
    LBx = LTy;  LBy = 50+(line_length / 2)*root_3;
    RBx = RTx;  RBy =LBy;
    // basic statics
    half_width = line_width / 2;
    dia_long   = (line_width / 2) * root_3;
    
    fillcolor = _fillcolor;
  }
  
  // 表示するメソッドの定義
  void display(){
    //calculate top points
    float ABx = (LTx + RTx)/2;
    Ax = ABx - half_width;
    Bx = ABx + half_width;
    Ay = LTy;  By = LTy;
    Cx = Bx;
    Cy = LTy + line_width * root_3;
    Dx = ABx;
    Dy = Cy + dia_long;
    //calculate left points
    Ex = LTx;
    Ey = LBy - dia_long;
    Fx = LBx + half_width;
    Fy = LBy;
    Gx = LBx + line_width * 1.5;
    Gy = Ey - dia_long;
    Hx = Gx + line_width;
    Hy = Gy;
    //calculate right points
    Ix = RBx - half_width;
    Iy = RBy;
    Jx = RBx;
    Jy = RBy - dia_long;
    Kx = Ix - line_width * 1.5;
    Ky = Jy;
    Lx = Kx - half_width;
    Ly = Ky - dia_long;
    
    
    fill(fillcolor);
    stroke(#000000);
  
    beginShape();
    vertex(Bx,By);vertex(Ax,Ay);vertex(Ex,Ey);vertex(Kx,Ky);vertex(Lx,Ly);vertex(Gx,Gy);
    endShape(CLOSE);
    beginShape();
    vertex(Ex,Ey);vertex(Fx,Fy);vertex(Ix,Iy);vertex(Cx,Cy);vertex(Dx,Dy);vertex(Kx,Ky);
    endShape(CLOSE);
    beginShape();
    vertex(Ix,Iy);vertex(Jx,Jy);vertex(Bx,By);vertex(Gx,Gy);vertex(Hx,Hy);vertex(Cx,Cy);
    endShape(CLOSE);
  }
}
